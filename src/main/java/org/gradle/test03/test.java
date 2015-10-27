package org.gradle.test03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"org/gradle/test03/beans.xml");

		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println("bean �̸�:" + name);

			for (String alias : ctx.getAliases(name)) {
				System.out.println("bean �̸�:" + name + "	alias �̸�:" + alias);
			}

			System.out.println("bean �̸�:" + name + "	Score ����:"
					+ (Score) ctx.getBean(name));
		}

		Score score1 = (Score) ctx.getBean("score1");
		System.out.println(score1);

		Score score2 = (Score) ctx.getBean("score2");
		System.out.println(score2);
		
		ctx.close();
	}
}
