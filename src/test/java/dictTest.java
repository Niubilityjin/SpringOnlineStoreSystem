import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.service.DictService;

public class dictTest {
	@Test
	public void testGetProvince() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		DictMapper dm=ac.getBean("dictMapper",DictMapper.class);
		List<Province> listP=dm.getProvinces();
		List<City> listC=dm.getCities("110000");
		//System.out.println(listC);
		List<Area> listA=dm.getAreas("110100");
		
		System.out.println(dm.getProvinceByCode("110000"));
		ac.close();
	
	}
	@Test
	public void testDictService() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		DictService ds=ac.getBean("dictService",DictService.class);
		//System.out.println(ds.getAreas("110100"));
		//System.out.println(ds.getCities("110000"));
		System.out.println(ds.getProvinces());
	}
}
