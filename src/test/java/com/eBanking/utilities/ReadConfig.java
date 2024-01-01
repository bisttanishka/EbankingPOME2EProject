package com.eBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public ReadConfig() {

		File scr = new File("./Configuration/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(scr);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("Exception is"+ e.getMessage());
		}

	}

	public String getURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}

	public String getUsername() {
		String uname = prop.getProperty("username");
		return uname;
	}

	public String getPassword() {
		String pwd = prop.getProperty("password");
		return pwd;
	}

}
