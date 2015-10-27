package org.gradle.test07;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"org/gradle/test07/beans.xml");

		/*DI*/
		Car car1 = (Car) ctx.getBean("car1");
		System.out.println("car1.model : " + car1.model);
		System.out.println("car1.engine : " + car1.engine);
		
		/*DL*/
		Car car3 = (Car) ctx.getBean("car3");
		Engine engine3 = (Engine) ctx.getBean("engine3");
		car3.model = "sonata";
		car3.engine = engine3;
		System.out.println("car3.model : " + car3.model);
		System.out.println("car3.engine : " + car3.engine);
		
		ctx.close();
	}
}
