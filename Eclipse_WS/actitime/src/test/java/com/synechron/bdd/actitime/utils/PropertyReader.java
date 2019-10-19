package com.synechron.bdd.actitime.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader
{
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(getApplicationUrl());
		System.out.println(getGoogleUrl());
		System.out.println(getFormyUrl());
		System.out.println(getMaxTimeOut());
		System.out.println(getBrowerType());
		System.out.println(getUserName());
		System.out.println(getPassword());
		
	}

	private static Properties getPropertyObj() throws FileNotFoundException, IOException {
		File file = new File("data\\global.properties");
		FileInputStream fis = new FileInputStream(file);
		
		Properties props =  new Properties();
		props.load(fis);
		return props;
	}
	
	public static String getApplicationUrl()
	{
		Properties props = null;
		try {
			props = getPropertyObj();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.getProperty("url");
	}
	
	public static String getGoogleUrl()
	{
		Properties props = null;
		try {
			props = getPropertyObj();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.getProperty("googleUrl");
	}
	
	public static String getFormyUrl()
	{
		Properties props = null;
		try {
			props = getPropertyObj();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.getProperty("formyUrl");
	}
	
	public static String getUserName()
	{
		Properties props = null;
		try {
			props = getPropertyObj();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.getProperty("username");
	}

	
	public static String getPassword()
	{
		Properties props = null;
		try {
			props = getPropertyObj();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.getProperty("password");
	}
	
	public static String getBrowerType()
	{
		Properties props = null;
		try {
			props = getPropertyObj();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.getProperty("browser");
	}
	public static String getMaxTimeOut()
	{
		Properties props = null;
		try {
			props = getPropertyObj();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.getProperty("timeout");
	}
}
