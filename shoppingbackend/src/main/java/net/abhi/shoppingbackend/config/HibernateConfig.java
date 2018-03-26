package net.abhi.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configurable
@ComponentScan(basePackages={"net.abhi.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	// Change the below based on the DBMs you choose
	private final static String DATABASE_URL="jdbc:mysql://localhost:3306/onlineshopping";
	private final static String DATABASE_DRIVER="com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME="root";
	private final static String DATABASE_PASSWORD="root";
	
	//DataSource bean will be available
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource =new BasicDataSource();
		//providing database connection  information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	//sessionFactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder builder= new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.abhi.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}
	
	
	//All the Hibernate Properties will be returned in this method
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		// TODO Auto-generated method stub
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibenate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	} 
	//Transaction Manager Bean
@Bean
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
	HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	return transactionManager;
	
}
}
