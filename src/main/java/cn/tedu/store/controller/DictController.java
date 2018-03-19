package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.DictService;

@Controller
@RequestMapping("/dict")
public class DictController {
	@Resource
	DictService dictService;
	@RequestMapping("/showProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> showProvince(){
		ResponseResult<List<Province>> rr;
		List<Province> Listp=dictService.getProvinces();
		rr=new ResponseResult<List<Province>>(1,"获取数据成功",Listp);
		
		
		return rr;
		
	}
	@RequestMapping("/showCity.do")
	@ResponseBody
	public ResponseResult<List<City>> showCity(String provinceCode){
		ResponseResult<List<City>> rr;
		List<City> Listc=dictService.getCities(provinceCode);
		rr=new ResponseResult<List<City>>(1,"获取数据成功",Listc);
		
		
		return rr;
		
	}
	@RequestMapping("/showArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> showArea(String cityCode){
		ResponseResult<List<Area>> rr;
		List<Area> Lista=dictService.getAreas(cityCode);
		rr=new ResponseResult<List<Area>>(1,"获取数据成功",Lista);
		
		
		return rr;
		
	}
}
