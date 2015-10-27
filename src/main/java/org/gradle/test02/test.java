package org.gradle.test02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"org/gradle/test02/beans.xml");

		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println("bean 이름:" + name);

			for (String alias : ctx.getAliases(name)) {
				System.out.println("bean 이름:" + name + "	alias 이름:" + alias);
			}

			System.out.println("bean 이름:" + name + "	Score 내용:"
					+ (Score) ctx.getBean(name));
		}

		System.out.println("[익명 빈 꺼내기]");
		Score score1 = (Score) ctx.getBean("org.gradle.test02.Score");
		Score score2 = (Score) ctx.getBean("org.gradle.test02.Score#0");
		if (score1 == score2) System.out.println("score == score#0");
		
		Score score3 = (Score) ctx.getBean("org.gradle.test02.Score#1");
		if (score1 != score3) System.out.println("score != score#1");
		
		System.out.println("[클래스 타입으로 빈 꺼내기]");
		/*Score score4 = (Score) ctx.getBean(org.gradle.test02.Score.class);
		if (score1 == score4) System.out.println("score1 == score4");*/
		
		ctx.close();
	}
}
