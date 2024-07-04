package com.example.SoapExample.Configuration;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {


    @Bean
//    @SuppressWarnings({"rawtypes","unchecked"})
    public ServletRegistrationBean<?> messageDispatcherServlet(ApplicationContext context)
    {
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return  new ServletRegistrationBean<>(servlet,"/allServices/");
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema)
    {
        DefaultWsdl11Definition defaultWsdl11Definition=new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("allServiceSoapHttp");
        defaultWsdl11Definition.setLocationUri("/allServices");
        defaultWsdl11Definition.setTargetNamespace("com.example.SoapExample/allapis");
        defaultWsdl11Definition.setSchema(schema);
        return defaultWsdl11Definition;
    }


    @Bean
    public XsdSchema employeesSchema()
    {
        return  new SimpleXsdSchema(new ClassPathResource("employees.xsd"));
    }
}
