package com.studentapp.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	private static volatile PropertyReader propertyInstance;
	private PropertyReader() {

	}
	
	public static synchronized PropertyReader getInstance() {
		
		if(propertyInstance==null) {
		
			propertyInstance = new PropertyReader();
		}
		
		return propertyInstance;
	}
	
	/**
	 * @param properyName
	 * @return
	 */
	public String getProperty(String properyName) {
		Properties prop = new Properties();
		
		try {
		InputStream inputStream = getClass()
			.getClassLoader()
			.getResourceAsStream("application.properties");
		prop.load(inputStream);
		
		if(prop.getProperty(properyName) != null) {
			return prop.getProperty(properyName);
		}
		}catch(Exception e) {
			System.out.println("property not found");
		}
	
		return null;
	}
	
}
