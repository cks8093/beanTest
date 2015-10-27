package org.gradle.test11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"org/gradle/test11/beans.xml");

		Car car1 = (Car) ctx.getBean("car1");

		System.out.println(car1);

		ctx.close();
	}
}
