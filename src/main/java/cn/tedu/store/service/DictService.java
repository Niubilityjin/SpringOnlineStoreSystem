package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;
@Service                                                                                                                                          
public class DictService implements IDictService{
	
	@Resource
	private DictMapper dictMapper;
	
	public List<Province> getProvinces() {
		// TODO Auto-generated method stub
		return dictMapper.getProvinces();
	}

	public List<City> getCities(String provinceCode) {
		// TODO Auto-generated method stub
		return dictMapper.getCities(provinceCode);
	}

	public List<Area> getAreas(String cityCode) {
		// TODO Auto-generated method stub
		return dictMapper.getAreas(cityCode);
	}

}
