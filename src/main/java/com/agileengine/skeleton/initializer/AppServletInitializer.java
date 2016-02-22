package com.agileengine.skeleton.initializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.agileengine.skeleton.config.ContextConfig;
import com.agileengine.skeleton.config.WebAppConfig;

public class AppServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String MAPPING_URL = "/";

    private static final String TMP_FILE_STORAGE = "/tmp";
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024;
    private static final long MAX_REQUEST_SIZE = 20 * 1024 * 1024;
    private static final int FILE_SIZE_THRESHOLD = 0;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ContextConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebAppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { MAPPING_URL };
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(getMultipartConfigElement());
    }

    private MultipartConfigElement getMultipartConfigElement() {
        return new MultipartConfigElement(TMP_FILE_STORAGE, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
    }

}
