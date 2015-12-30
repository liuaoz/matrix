package com.matrix.test.loadfile;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能：
 * @author matrix
 * @date 2015年11月18日
 * @since 
 */
public class BaseProperties {
	 private static final Logger LOG = LoggerFactory.getLogger(BaseProperties.class);
	    private Properties props = null;

	    public synchronized void loads(String filename) {
	        if (props == null) {
	            InputStream is = BaseProperties.class.getResourceAsStream(filename);
	            props = new Properties();
	            try {
	                props.load(is);
	            } catch (Exception e) {
	                LOG.debug("Cannot load the properties from " + filename + ".");
	            }
	        }
	    }
	    
	    public String getProperty(String key) {
	        String value;
	        
	        try {
	            value = props.getProperty(key);
	        } catch (Exception e) {
	            value = "";
	        }
	        
	        if (value == null || value.length() == 0) {
	            value = "";
	        }
	        
	        return value;
	    }
	    
	    public Properties getProps() {
	        return props;
	    }
}
