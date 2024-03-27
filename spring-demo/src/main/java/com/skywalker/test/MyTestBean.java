package com.skywalker.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class MyTestBean {
	private String name;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){return this.name;}

	public void testBean(){
		System.out.println("myTestBean:888888");
	}
}
class MyTestBeanTest {
	public static void main(String[] args) {
		System.out.println(1);
		DefaultListableBeanFactory context = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
		reader.loadBeanDefinitions(new ClassPathResource("bean.xml"));
		MyTestBean myTestBean = context.getBean("myTestBean",MyTestBean.class);
		myTestBean.setName("ada");
		System.out.println(myTestBean.getName());
		MyTestBean myTestBean2 = context.getBean("myTestBean",MyTestBean.class);
		myTestBean2.setName("ada666");
		System.out.println(myTestBean.getName());
		System.out.println(myTestBean == myTestBean2);
		MyTestBean myTestBean3 = new MyTestBean();
		MyTestBean myTestBean4 = new MyTestBean();
		System.out.println(myTestBean3 == myTestBean4);
		myTestBean.testBean();

	}
}


