package gefest.rest.config;

import gefest.rest.MyLogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterBeanConfig {
    @Bean
    public FilterRegistrationBean requestMemeFilter() {
        MyLogFilter myLogFilter=new MyLogFilter();
        final FilterRegistrationBean reg = new FilterRegistrationBean(myLogFilter);
        reg.addUrlPatterns("/*");
        reg.setOrder(1); //defines filter execution order
        return reg;
    }
}
