package org.gradle.test09;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"org/gradle/test09/beans.xml");

		System.out.println("[�ν��Ͻ� ���͸� �޼��� Ȱ��]-------------------------");

		SimpleDateFormat dateFormat = (SimpleDateFormat) ctx.getBean("dateFormat");
		
		Tire hankookTire = (Tire) ctx.getBean("hankookTire");
		System.out.println(hankookTire.getMaker());
		System.out.println(dateFormat.format(hankookTire.getCreatedDate()));
		
		System.out.println("-------------------------");
		//�ڹ� �ڵ�� ����
		SimpleDateFormat dateFormat1 =new SimpleDateFormat("yyyy-MM-dd");	
		ParsePosition pos = new ParsePosition(0);
		Tire kumhoTire = new Tire();
		kumhoTire.maker="kumhoTire";
		kumhoTire.createdDate = dateFormat1.parse("2014-6-15", pos);
		System.out.println(kumhoTire.getMaker());
		System.out.println(dateFormat1.format(kumhoTire.getCreatedDate()));
		
		ctx.close();
	}
}
