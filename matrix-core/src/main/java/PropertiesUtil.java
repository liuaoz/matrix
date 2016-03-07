

import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class PropertiesUtil {

	private static final String PROP_FILE = "/rock.properties";

	private static final Log LOG = Log.getLogger(PropertiesUtil.class);
	private Properties props = null;

	public synchronized void loads(String filename) {
		if (props == null) {
			InputStream is = PropertiesUtil.class.getResourceAsStream(filename);
			props = new Properties();
			try {
				props.load(is);
			} catch (Exception e) {
				LOG.e("Cannot load the properties from " + filename + ".");
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

	public PropertiesUtil() {
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
