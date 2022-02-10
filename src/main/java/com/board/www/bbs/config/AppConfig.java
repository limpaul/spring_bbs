package com.board.www.bbs.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.board.www.bbs.controller.ApiController;
import com.board.www.bbs.dao.BbsDao;
import com.board.www.bbs.dao.UserDao;

@Configuration
public class AppConfig {
	@Bean
	public UserDao userDao() {
		return new UserDao();
	}

	@Bean
	public BbsDao bbsDao() {
		return new BbsDao();
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
	public SqlSessionFactory sqlSessionFactory() throws Exception {
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
	
	
	///////////////
	
}
