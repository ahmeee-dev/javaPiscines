package app;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Program {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
	DataSource ds = context.getBean("driverManagerDataSource", DriverManagerDataSource.class);
}
