package org.mcknight.wicker.test.mock;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class WickerMock {
	public static <T> T mock(Class<T> clazz) {
		ClassLoader classLoader = new ClassLoader() {
		};
		InvocationHandler invocationHandler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return null;
	}	
	
}
