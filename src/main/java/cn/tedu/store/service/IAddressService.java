package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface IAddressService {
	void addAddress(Address address);
	public List<Address> getAllAddessByUid(Integer uid);
	void updateDefault(Integer Uid,Integer id);
	Address getAddressById(Integer id);
}
