package org.mcknight.wicker.test.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.mcknight.wicker.logger.Log;
import org.mcknight.wicker.logger.LogBuilder;

public class TestRunner {
	private Log log;
	public TestRunner() {
		log = new LogBuilder().toStandardError().toStandardOut().build();
	}
	public void hasTests(Class<?> clazz) {
		Object testClassInstance = null;
		Method[] methods = clazz.getMethods();
		for(Method method : methods) {
			if(method.isAnnotationPresent(WickerTest.class)) {
				if(testClassInstance == null) {
					try {
						Constructor<?> constructor = clazz.getConstructor(new Class<?>[0]);					
						testClassInstance = constructor.newInstance();
						method.invoke(testClassInstance);
					} catch(InvocationTargetException e) {
						log.error(e.getMessage());
					} catch(NoSuchMethodException e) {
						log.error(e.getMessage());
					} catch(IllegalAccessException e) {
						log.error(e.getMessage());
					} catch(InstantiationException e) {
						log.error(e.getMessage());
					}
				}
				runTest(method, testClassInstance);
			}
		}
	}
	
	private void runTest(Method method, Object obj) {		
		try {
			method.invoke(obj, new Object[0]);
		} catch(Exception e) {
			
		}
	}
}
