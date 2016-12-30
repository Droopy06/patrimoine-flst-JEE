package patrimoine;

/**
 * Created by LAMOOT Alexandre on 07/11/15.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/patrimoine/index").setViewName("patrimoine/index::content");
        registry.addViewController("/patrimoine/PartialPages/_head").setViewName("patrimoine/PartialPages/_head::content");
        registry.addViewController("/patrimoine/PartialPages/_header").setViewName("patrimoine/PartialPages/_header::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_home").setViewName("patrimoine/PartialPages/Contents/_home::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_import").setViewName("patrimoine/PartialPages/Contents/_import::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_export").setViewName("patrimoine/PartialPages/Contents/_export::content");
    }
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    /*@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/resources/patrimoine");
        resolver.setSuffix(".html");
        return resolver;
    }*/

    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/resources/patrimoine");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("LEGACYHTML5");
        resolver.setCacheable(false);
        return resolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }
}
