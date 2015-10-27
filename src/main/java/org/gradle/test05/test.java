package org.gradle.test05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"org/gradle/test05/beans.xml");

		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println("bean 이름:" + name);

			for (String alias : ctx.getAliases(name)) {
				System.out.println("bean 이름:" + name + "	alias 이름:" + alias);
			}

			System.out.println("bean 이름:" + name + "	내용:"
					+ ctx.getBean(name));
		}

		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1);
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
		
		Engine engine = car1.engine;
		engine.cc = 3000;
		
		System.out.println(car1);
		System.out.println(car2);
		
		ctx.close();
	}
}
