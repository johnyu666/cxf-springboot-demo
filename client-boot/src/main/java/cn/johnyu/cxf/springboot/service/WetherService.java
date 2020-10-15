package cn.johnyu.cxf.springboot.service;

import javax.jws.WebService;

@WebService
public interface WetherService {
    String findCityByZipcode(String zipcode);
}