package cn.johnyu.cxf.springboot;

import cn.johnyu.cxf.springboot.service.WetherService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class ClientApp {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:9003/services/wether?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(WetherService.class);
        WetherService ws=(WetherService) jaxWsProxyFactoryBean.create();
        String rs=ws.findCityByZipcode("1111");
        System.out.println(rs);
    }
}
