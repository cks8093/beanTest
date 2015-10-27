package org.gradle.test14;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"org/gradle/test14/beans.xml");

		Car car = (Car) ctx.getBean("car");

		Engine engine = (Engine) ctx.getBean("engine");
		engine.setMaker("Hyundai");
		engine.setCc(1997);

		if (car != null) {
			System.out.println("car != null");
		}

		if (engine != null) {
			System.out.println("engine != null");
		}

		System.out.println(car);

		ctx.close();
	}
}
