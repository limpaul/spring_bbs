package com.board.www.bbs.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.board.www.bbs.dao.BbsDao;
import com.board.www.bbs.dao.UserDao;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.board.www.bbs.controller",
								"com.board.www.bbs.service", 
								"com.board.www.bbs.repository",
								"com.board.www.bbs.dao",				
								})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // url 요청이 ex) /resources/css 로 들어왔을 떄 
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
    // default servlet handler를 사용하게 합니다.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
   
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main");
    }
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    @Bean
    public DriverManagerDataSource dataSource() {
    	DriverManagerDataSource dm = new DriverManagerDataSource();
    	dm.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	dm.setUrl("jdbc:mysql://localhost:3306/bbs");
    	dm.setUsername("root");
    	dm.setPassword("1234");
    	return dm;
    }
    @Bean
    public JdbcTemplate template() {
    	return new JdbcTemplate(dataSource());
    }
    
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
    	PathMatchingResourcePatternResolver pmrr = new PathMatchingResourcePatternResolver();
    	SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
    	sfb.setDataSource(dataSource());
    	sfb.setConfigLocation(pmrr.getResource("classpath:/mybatis/mybatis-config.xml"));
    	sfb.setMapperLocations(pmrr.getResources("classpath:/mybatis/mapper/*.xml"));
    	return sfb.getObject();
    }
    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
    	return new SqlSessionTemplate(sqlSessionFactory());
    }
   
}