//package com.onedirect.todo.configuration;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//public class DbConfig {
//    private String DRIVER = "com.mysql.cj.jdbc.Driver";
//
//    private String PASSWORD = "password";
//
//    private String URL = "jdbc:mysql://localhost:3306/todo-list";
//
//    private String USERNAME = "root";
//
//    private String DIALECT = "org.hibernate.dialect.MySQL5InnoDBDialect";
//
//    private String SHOW_SQL = "true";
//
//    private String HBM2DDL_AUTO = "none";
//
//    private String PACKAGES_TO_SCAN = "com";
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(DRIVER);
//        dataSource.setUrl(URL);
//        dataSource.setUsername(USERNAME);
//        dataSource.setPassword(PASSWORD);
//        return dataSource;
//    }
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.put("hibernate.dialect", DIALECT);
//        hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
//        hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
//        sessionFactory.setHibernateProperties(hibernateProperties);
//
//        return sessionFactory;
//    }
//
//    @Bean
//    public HibernateTransactionManager transactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan("com.onedirect.todo.entities");
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        return em;
//    }
//}
//
