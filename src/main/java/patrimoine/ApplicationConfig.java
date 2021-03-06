package patrimoine;

/**
 * Created by LAMOOT Alexandre on 07/11/15.
 */
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
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
        registry.addViewController("/patrimoine/PartialPages/_admin_header").setViewName("patrimoine/PartialPages/_admin_header::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_home").setViewName("patrimoine/PartialPages/Contents/_home::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_import").setViewName("patrimoine/PartialPages/Contents/_import::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_export").setViewName("patrimoine/PartialPages/Contents/_export::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_admin-login").setViewName("patrimoine/PartialPages/Contents/_admin-login::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_admin_home").setViewName("patrimoine/PartialPages/Contents/_admin_home::content");
        registry.addViewController("/patrimoine/PartialPages/_admin_hautFooter").setViewName("patrimoine/PartialPages/_admin_hautFooter::content");
        registry.addViewController("/patrimoine/PartialPages/_admin_modals_home").setViewName("patrimoine/PartialPages/_admin_modals_home::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_admin_collections").setViewName("patrimoine/PartialPages/Contents/_admin_collections::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_admin_collection").setViewName("patrimoine/PartialPages/Contents/_admin_collection::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_admin_object").setViewName("patrimoine/PartialPages/Contents/_admin_object::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_admin_events").setViewName("patrimoine/PartialPages/Contents/_admin_events::content");
        registry.addViewController("/patrimoine/PartialPages/Contents/_admin_event").setViewName("patrimoine/PartialPages/Contents/_admin_event::content");
    }
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
                container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403.html"));
                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"));
            }
        };
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
