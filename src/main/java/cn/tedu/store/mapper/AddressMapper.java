package cn.tedu.store.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
		void insert(Address address);
		List<Address> getAddressByUid(Integer Uid);
}
