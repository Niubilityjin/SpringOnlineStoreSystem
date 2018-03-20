import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;

public class Addresstest {
	@Test
	public void testAddress() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AddressMapper dm=ac.getBean("addressMapper",AddressMapper.class);
		Address address=new Address();
		address.setRecvName("aaa");
		address.setRecvProvince("bbb");
		address.setRecvCity("ccc");
		address.setRecvArea("ddd");
		address.setRecvDistrict("eee");
		address.setRecvAddr("fff");
		address.setRecvPhone("hhh");
		dm.insert(address);
		ac.close();
		
	}
}
