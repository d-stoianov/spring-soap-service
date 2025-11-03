package spring.soap.service;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    // Goods
    @Bean(name = "goods")
    public DefaultWsdl11Definition goodsWsdl(XsdSchema goodsSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("GoodsPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
        wsdl.setSchema(goodsSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema goodsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("goods.xsd"));
    }

    // Categories
    @Bean(name = "categories")
    public DefaultWsdl11Definition categoriesWsdl(XsdSchema categoriesSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("CategoriesPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://spring.io/guides/gs-producing-web-service/categories");
        wsdl.setSchema(categoriesSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema categoriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("categories.xsd"));
    }
}
