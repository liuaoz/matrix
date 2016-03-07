

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

	private Logger logger;

	public Log(Class<?> paramClass) {
		logger = LoggerFactory.getLogger(paramClass);
	}

	public static Log getLogger(Class<?> paramClass) {
		return new Log(paramClass);
	}

	public void d(String message) {
		logger.debug(message);
	}

	public void i(String message) {
		logger.info(message);
	}

	public void e(String message) {
		logger.error(message);
	}

	public void w(String message) {
		logger.warn(message);
	}

	public void e(String message, Throwable e) {
		logger.error(message, e);
	}

}
