package cn.johnyu.cxf.springboot.service.impl;

import cn.johnyu.cxf.springboot.service.WetherService;
import org.springframework.stereotype.Service;

@Service
public class WetherServiceImpl implements WetherService {

    @Override
    public String findCityByZipcode(String zipcode) {
        return "city:"+zipcode;
    }
}
