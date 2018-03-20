import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;

public class Addresstest {
	@Test
	public void testAddress() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService dm=ac.getBean("addressService",IAddressService.class);
		AddressMapper am=ac.getBean("addressMapper",AddressMapper.class);
		Address address=new Address();
		address.setRecvName("qingaaa");
		address.setRecvProvince("110000");
		address.setRecvCity("110100");
		address.setRecvArea("110150");
		address.setRecvAddr("fff61");
		address.setRecvPhone("hhh21");
		address.setUid(2);
		dm.addAddress(address);
		ac.close();
	}
	@Test
	public void testGetAddress() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AddressMapper dm=ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(dm.getAddressByUid(9));
	}
	@Test
	public void testgetaddressService() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService dm=ac.getBean("addressService",IAddressService.class);
		System.out.println(dm.getAllAddessByUid(9));
	}
	
}
