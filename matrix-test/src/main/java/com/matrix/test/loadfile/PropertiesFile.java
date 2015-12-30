package com.matrix.test.loadfile;

import java.util.Locale;

/**
 * 功能：加载属性文件
 * @author matrix
 * @date 2015年11月18日
 * @since 
 */
public class PropertiesFile extends BaseProperties{
	private static final String PROP_FILE = "/rock.properties";

	public PropertiesFile() {
		loads(PROP_FILE);
	}
	
	public Locale getLocale() {
    	Locale locale;
    	String setting = getProperty("locale");
    	
    	if (setting == "") {
    		locale = Locale.getDefault();
    	} else {
	    	try {
				locale = new Locale(setting);
			} catch (Exception e) {
				locale = Locale.getDefault();
			}
    	}
    	
    	return locale;
	}

}
