package cn.johnyu.cxf.springboot;

import cn.johnyu.cxf.springboot.service.WetherService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientBootApp {
    public static void main(String[] args) {
      ApplicationContext context= SpringApplication.run(ClientBootApp.class);
      WetherService ws=context.getBean(WetherService.class);
      String ss=ws.findCityByZipcode("111");
        System.out.println(ss);
    }

    @Bean
    public WetherService createWetherService(){
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:9003/services/wether?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(WetherService.class);
        WetherService ws=(WetherService) jaxWsProxyFactoryBean.create();
        return ws;
    }
}
