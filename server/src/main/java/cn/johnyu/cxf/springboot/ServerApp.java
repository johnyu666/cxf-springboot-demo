package cn.johnyu.cxf.springboot;

import cn.johnyu.cxf.springboot.service.WetherService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

@SpringBootApplication
public class ServerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerApp.class);
    }
    @Resource
    private Bus bus;
    @Resource
    private WetherService wetherService;

    @Bean
    public Endpoint WetherEndpoint(){
        Endpoint endpoint= new EndpointImpl(bus,wetherService);
        endpoint.publish("/wether");
        return endpoint;
    }
}
