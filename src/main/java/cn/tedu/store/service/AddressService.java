package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;

@Service
public class AddressService implements IAddressService{
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
	public void addAddress(Address address) {
		//1.setDistrict
		String pCode=address.getRecvProvince();
		String cCode=address.getRecvCity();
		String aCode=address.getRecvArea();
		String pName=dictMapper.getProvinceByCode(pCode);
		String cName=dictMapper.getCityByCode(cCode);
		String aName=dictMapper.getAreaByCode(aCode);
		
		address.setRecvDistrict(pName+cName+aName);
		//2.setIsDefault
		List<Address> listA=addressMapper.getAddressByUid(address.getUid());
		int n=listA.size();
		if(n>0) {
			address.setIsDefault(0);
		}else {
			address.setIsDefault(1);
		}
		addressMapper.insert(address);
		
	}
	public List<Address> getAllAddessByUid(Integer uid) {
		
		return addressMapper.getAddressByUid(uid);
	}

}
