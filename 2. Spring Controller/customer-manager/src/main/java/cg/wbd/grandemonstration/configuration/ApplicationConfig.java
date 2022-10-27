package cg.wbd.grandemonstration.configuration;

import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("cg.wbd.grandemonstration")
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/templates/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public CustomerService customerService() {
        return new SimpleCustomerServiceImpl();
    }
}