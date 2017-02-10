package com.lj.redwine.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lj.redwine.pojo.Address;
import com.lj.redwine.service.AddressService;

@Controller  
@RequestMapping("/address")  
public class AddressController {
	@Resource
	AddressService addressService;
	
	@RequestMapping(value="/listAddress", method=RequestMethod.GET)
	public String findAllAddress(HttpServletRequest request, Model model) {//显示所有用户地址
		List<Address> addressList = addressService.findAllAddress();
		model.addAttribute("addressList", addressList);
		return "address/listAddress";
	}
	
	@RequestMapping(value="/addAddress")
	@ResponseBody
	public String addAddress(HttpServletRequest request, int id, @RequestParam Map<String, String> map) {//添加地址
		Address address = new Address();
		address.setConsignee(map.get("consignee"));
		address.setGender(map.get("gender"));
		address.setConsignee_phone(map.get("consignee_phone"));
		address.setLocation_address(map.get("location_address"));
		address.setDetail_address(map.get("detail_address"));
		address.setUser_delete(0);
		address.setUser_id(id);
		if (addressService.addAddress(address)) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	@RequestMapping(value="/listAddressByUserId",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String findAddressByUserId(HttpServletRequest request,int id) {//通过用户id查询地址
		List<Address> addressList = addressService.queryAddressByUserId(id);
		return JSON.toJSONString(addressList);
	}
	
	@RequestMapping(value="/deleteAddress")
	@ResponseBody
	public String deleteAddress(HttpServletRequest request,int id) {//删除地址
		Address address = addressService.queryAddressById(id);
		address.setUser_delete(1);
		if (addressService.deleteAddress(address)) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	@RequestMapping(value="/editAddress")
	@ResponseBody
	public String updateAddress(HttpServletRequest request, @RequestParam Map<String, String> map) {//修改地址信息
		Address address = addressService.queryAddressById(Integer.parseInt(map.get("address_id")));
		address.setConsignee(map.get("consignee"));
		address.setConsignee_phone(map.get("consignee_phone"));
		address.setDetail_address(map.get("detail_address"));
		address.setGender(map.get("gender"));
		address.setLocation_address(map.get("location_address"));
		if (addressService.updateAddress(address)) {
			return "success";
		} else {
			return "fail";
		}
	}
}
