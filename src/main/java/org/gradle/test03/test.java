package org.gradle.test03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"org/gradle/test03/beans.xml");

		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println("bean 이름:" + name);

			for (String alias : ctx.getAliases(name)) {
				System.out.println("bean 이름:" + name + "	alias 이름:" + alias);
			}

			System.out.println("bean 이름:" + name + "	Score 내용:"
					+ (Score) ctx.getBean(name));
		}

		Score score1 = (Score) ctx.getBean("score1");
		System.out.println(score1);

		Score score2 = (Score) ctx.getBean("score2");
		System.out.println(score2);
		
		ctx.close();
	}
}
