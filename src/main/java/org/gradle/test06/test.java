package org.gradle.test06;

import java.util.Map.Entry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"org/gradle/test06/beans.xml");

		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println("bean 이름:" + name);

			for (String alias : ctx.getAliases(name)) {
				System.out.println("bean 이름:" + name + "	alias 이름:" + alias);
			}

			System.out.println("bean 이름:" + name + "	내용:"
					+ ctx.getBean(name));
		}

		//프로퍼티
		System.out.println("[Propoerties 타입]---------------------");
		Tire spareTire = (Tire) ctx.getBean("spareTire");
		for (Entry<Object,Object> entry : spareTire.getSpec().entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		//프로퍼티(맵)
		System.out.println("[Map 타입]---------------------");
		Car car1 = (Car) ctx.getBean("car1");
		for (Entry<String,Object> entry : car1.getOptions().entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		//factory-method(static)
		Tire t1 = (Tire) ctx.getBean("hankookTire");
		Tire t2 = (Tire) ctx.getBean("kumhoTire");
		Tire t3 = (Tire) ctx.getBean("hankookTire");
		
		System.out.println("t1-->" + t1.toString());
		System.out.println("t2-->" + t2.toString());
		System.out.println("t3-->" + t3.toString());
		
		if (t1 != t2) {
			System.out.println("t1 != t2");
		}
		
		if (t1 == t3) {
			System.out.println("t1 == t3");
		}
		
		//factory-bean(non static)
		Tire _t1 = (Tire) ctx.getBean("hankookTireFactory");
		Tire _t2 = (Tire) ctx.getBean("kumhoTireFactory");
		Tire _t3 = (Tire) ctx.getBean("hankookTireFactory");
		
		System.out.println("_t1-->" + _t1.toString());
		System.out.println("_t2-->" + _t2.toString());
		System.out.println("_t3-->" + _t3.toString());
		
		if (_t1 != _t2) {
			System.out.println("_t1 != _t2");
		}
		
		if (_t1 == _t3) {
			System.out.println("_t1 == _t3");
		}
		
		//AbstractFactoryBean
		Tire bean1 = (Tire) ctx.getBean("hankookTireBean");
		Tire bean2 = (Tire) ctx.getBean("kumhoTireBean");
		Tire bean3 = (Tire) ctx.getBean("hankookTireBean");
		
		System.out.println("bean1-->" + bean1.toString());
		System.out.println("bean2-->" + bean2.toString());
		System.out.println("bean3-->" + bean3.toString());
		
		if (bean1 != bean2) {
			System.out.println("bean1 != bean2");
		}
		
		if (bean1 == bean3) {
			System.out.println("bean1 == bean3");
		}
		
		ctx.close();
	}
}
