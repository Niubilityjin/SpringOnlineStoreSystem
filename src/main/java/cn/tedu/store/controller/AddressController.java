package cn.tedu.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	@Resource
	private IAddressService adService;
	/**
	 * 显示addressAdmin页面
	 * @return
	 */
	
	
	@RequestMapping("/Address.do")
	public String add(
			@RequestParam("receiverName") String  recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddr,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag,
			HttpSession session) {
		Address address = new Address();
		System.out.println("777777"+recvName);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddr(recvAddr);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		address.setUid(getUid(session));
		System.out.println("UIDDD"+getUid(session));
		session.setAttribute("address", address);
		adService.addAddress(address);
		return "redirect:../address/showAddress.do";
}
	@RequestMapping("/showAddress.do")
	public String showAddress(HttpSession session,Map<String, List<Address>> map) {
		List<Address> list=adService.getAllAddessByUid(getUid(session));
		map.put("listAddress", list);
		System.out.println(list);
		return "addressAdmin";
		
	}
	@RequestMapping("/setDefault.do")
	public String setDefault(Integer id,HttpSession session) {
		adService.updateDefault(this.getUid(session), id);
		return "redirect:../address/showAddress.do";
	}
	@RequestMapping("/getAddress.do")
	@ResponseBody
	public ResponseResult<Address> getAddress(Integer id){
		ResponseResult<Address> rr;
		Address address=adService.getAddressById(id);
		System.out.println("从service层返回的"+address);
		if(address!=null) {
			rr=new ResponseResult<Address>(1, "数据提取成功", address);
		}else {
			rr=new ResponseResult<Address>(0, "数据提取失败", address);
		}
		
		
		return rr;
	}
}
