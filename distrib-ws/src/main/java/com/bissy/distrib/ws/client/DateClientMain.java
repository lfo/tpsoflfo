package com.bissy.distrib.ws.client;

import com.bissy.distrib.ws.DateService;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 *
 * @author lforet
 */
public class DateClientMain {
    
    
    public static void main(String... args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());
        factory.setServiceClass(DateService.class);
        factory.setAddress("http://localhost:9000/dateService");
        DateService dateService = (DateService) factory.create();      
        System.out.println("Date du serveur :"+  dateService.getOfficialDate());
    }
}
