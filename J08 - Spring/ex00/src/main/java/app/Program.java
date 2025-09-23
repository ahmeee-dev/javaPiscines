package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Repositories.Printer;

public class Program {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Printer printer = context.getBean("PrinterWithPrefix", Printer.class);
		printer.print("Vediamo");
	}
}
