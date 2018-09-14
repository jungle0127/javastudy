package com.rest.awareinterface;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import com.rest.autowiredmap.MapProvider;
@Component
public class BeanNameAwareDemo implements MapProvider, BeanNameAware,BeanFactoryAware{
	private String name;
	@Override
	public void setBeanName(String name) {
		this.name = name;
	}
	@Override
	public void config() {
		System.out.println(this.name);
		
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}
	
	

}
