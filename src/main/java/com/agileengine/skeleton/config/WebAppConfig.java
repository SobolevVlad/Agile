package com.agileengine.skeleton.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.agileengine.skeleton.controller"})
public class WebAppConfig extends WebMvcConfigurerAdapter {

    private static final String I18N_PROPERTY_NAME = "messages";

    private static final String VIEW_PREFIX = "/WEB-INF/views/";
    private static final String VIEW_SUFIX = ".jsp";

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(VIEW_PREFIX);
        viewResolver.setSuffix(VIEW_SUFIX);
        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(I18N_PROPERTY_NAME);
        return messageSource;
    }

    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver resolver() {
        return new StandardServletMultipartResolver();
    }

}