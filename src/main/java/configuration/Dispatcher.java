package configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan({"controller","dao","model","service"})
 class webConfigure extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //System.out.println("inside resource resolver :  Maker DIspatcher");
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver myviewResolver() {
        //System.out.println("inside view resolver :  Maker DIspatcher");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource(); //child class of MessageSource
        source.setBasename("messageCodes"); //property file
        return source;
    }

    @Bean(name="dataSource")
    public DataSource getDataSource()
    {
        DriverManagerDataSource dt=new DriverManagerDataSource();
        dt.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dt.setUrl("jdbc:oracle:thin:localhost:1521:orcl");
        dt.setUsername("sh");
        dt.setPassword("sh");
        return dt;
    }

};

@Configuration
@ComponentScan({"controller","dao","model","service"})
class rootConfigure {

}

public class Dispatcher extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
       // System.out.println("root config : md");
        return new Class[] { rootConfigure.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //System.out.println("web config : md");
        return new Class[]{ webConfigure.class };
    }

    @Override
    protected String[] getServletMappings() {
       // System.out.println("servlet mapping : md");
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx= new AnnotationConfigWebApplicationContext();

        ctx.register(webConfigure.class);
        ctx.setServletContext(container);
        //container.addListener(new ContextLoaderListener(ctx));

        ServletRegistration.Dynamic servlet = container.addServlet("Dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
