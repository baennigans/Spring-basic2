package kr.ac.kopo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {

	private Map<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<>();
		Properties prop = new Properties();

		try {
			InputStream is = new FileInputStream("C:\\Users\\User\\eclipse-Spring\\MVC-Spring\\src\\bean.properties");
			prop.load(is);

			Set<Object> keys = prop.keySet();
			for (Object key : keys) {
				String className = prop.getProperty(key.toString());
				System.out.println(key + " : " + className);

				System.out.println("className : " + className);
				Class<?> clz = Class.forName(className);
				Constructor<?> constructor = clz.getConstructor();

				mappings.put(key.toString(), (Controller) constructor.newInstance());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public HandlerMapping(String propLoc) {
		mappings = new HashMap<>();
		Properties prop = new Properties();

		try {
			InputStream is = new FileInputStream(propLoc);
			prop.load(is);

			Set<Object> keys = prop.keySet();
			for (Object key : keys) {
				String className = prop.getProperty(key.toString());
				System.out.println(key + " : " + className);

				Class<?> clz = Class.forName(className);
				Constructor<?> constructor = clz.getConstructor();

				mappings.put(key.toString(), (Controller) constructor.newInstance());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Controller getController(String uri) {

		return mappings.get(uri);
	}
}
