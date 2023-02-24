package io.n0sense.myexam.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MySpringWebInitializr implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) {
        System.out.println(">>>>>>>>>> Spring Web Initializr is now loading... <<<<<<<<<<");
        // 创建一个Java配置类Context。如果想用XML配置文件，就改用XmlWebApplicationContext，
        // 然后调用setConfigLocation()
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(MySpringConfiguration.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

        ServletRegistration.Dynamic myDispatcherServlet
                = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        myDispatcherServlet.setLoadOnStartup(1);
        myDispatcherServlet.addMapping("/");

        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        FilterRegistration.Dynamic encodingContext
                = servletContext.addFilter("characterEncodingFilter", encodingFilter);
        encodingContext.setInitParameter("encoding", "UTF-8");
        encodingContext.setInitParameter("forceEncoding", "true");
        encodingContext.addMappingForUrlPatterns(null, true, "/*");
    }
}
