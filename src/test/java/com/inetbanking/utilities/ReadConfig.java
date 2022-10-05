package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration\\config.properties");
		try {
			FileInputStream Fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(Fis);
		} catch (Exception e) {
			System.out.println("Exception is :" +e.getMessage());
			
		}
	}

	
	public String getApplicationURL() {
		String Url = pro.getProperty("baseURL");
		return Url;
	}
	
	public String getusername() {
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getpassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getchromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getfirefoxpath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}


