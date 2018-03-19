package cn.tedu.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	/**
	 * 显示addressAdmin页面
	 * @return
	 */
	@RequestMapping("/showAddress.do")
	public String showAddress() {
		return "addressAdmin";
	}
}
