package org.gradle.test01;



import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("org/gradle/test01/beans.xml");
		
		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println("bean 이름:" + name);
			
			for (String alias : ctx.getAliases(name)) {
				System.out.println("bean 이름:" + name + "	alias 이름:" + alias);
			}
			
			System.out.println("bean 이름:" + name + "	Score 내용:" + (Score)ctx.getBean(name));
		}
		
		Score score = (Score)ctx.getBean("score");
		Score score2 = (Score) ctx.getBean("score2");
		Score score3 = (Score) ctx.getBean("score3");
		Score score4 = (Score) ctx.getBean("score4");
		Score scoreOk = (Score) ctx.getBean("score-ok!");
		
		if (score == score2) System.out.println("score == score2");
		if (score2 == score3) System.out.println("score2 == score3");
		if (score3 == score4) System.out.println("score3 == score4");
		if (score4 == scoreOk) System.out.println("score4 == scoreOk");
		
		ctx.close();
	}
}
