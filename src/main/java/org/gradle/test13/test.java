package org.gradle.test13;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"org/gradle/test13/beans.xml");

		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1.getEngine());

		ctx.close();
	}
}
