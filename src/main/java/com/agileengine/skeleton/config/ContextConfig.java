package com.agileengine.skeleton.config;

import com.agileengine.skeleton.connector.FileConnector;
import com.agileengine.skeleton.connector.OrderConnector;
import com.agileengine.skeleton.dto.OrderDto;
import com.agileengine.skeleton.model.Order;
import com.agileengine.skeleton.translator.OrderTranslator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = {"com.agileengine.skeleton"})
public class ContextConfig {

    @Autowired
    @Qualifier("orderConnector")
    private OrderConnector connector;

    @Autowired
    @Qualifier("fileConnector")
    private FileConnector fileConnector;

    @PostConstruct
    public void loadData() {
        List<OrderDto> orderDtos = fileConnector.loadData("C:\\Users\\admin\\Downloads\\AgileEngineSkeleton\\data.csv");
        List<Order> orderses = new ArrayList<>();
        for (OrderDto dto : orderDtos) {
            Order destination = new Order();
            OrderTranslator.fromDto(dto, destination);
            orderses.add(destination);
        }
        connector.insertValues(orderses);
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        dataSource.setUrl("jdbc:hsqldb:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);

        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        sessionFactory.setHibernateProperties(props);

        sessionFactory.setAnnotatedClasses(Order.class);

        return sessionFactory;
    }

    @Autowired
    @Bean(name = "txManager")
    public DataSourceTransactionManager txManager(DataSource dataSource) {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource);
        return txManager;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        return mapper;
    }
}