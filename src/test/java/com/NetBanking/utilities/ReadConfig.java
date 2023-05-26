package com.NetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	public ReadConfig()  {
		super();
		// TODO Auto-generated constructor stub
		File src = new File(System.getProperty("user.dir")+"//Configurations//config.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public String getURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	public String getUsername() {
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword(){
		String password = prop.getProperty("password");
		return password;
	}
		
		public String getWrongUsername(){
			String wrongUsername = prop.getProperty("wrongUsername");
			return wrongUsername;
	}

	

	
	
}
