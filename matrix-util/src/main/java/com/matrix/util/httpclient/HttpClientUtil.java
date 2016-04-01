package com.matrix.util.httpclient;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能：http客户端请求
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月11日
 */
public class HttpClientUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	private static final int socketTimeOut = 15000;
	private static final int connectTimeOut = 15000;
	private static final int requestTimeOut = 15000;
	private static final Boolean setTimeOut = true;

	private HttpClientUtil() {
	}

	private static CloseableHttpClient httpClient = null;

	@SuppressWarnings("unused")
	private static CloseableHttpClient getHttpClient() {

		if (httpClient != null) {
			return httpClient;
		}

		RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory> create();

		ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();

		registryBuilder.register("http", plainSF);
		// 指定信任密钥存储对象和链接套接字工厂
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());

			// 信任任何链接
			TrustStrategy anyTrustStrategy = new TrustStrategy() {

				@Override
				public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
					return true;
				}
			};

			SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy)
					.build();

			LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext,
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			registryBuilder.register("https", sslSF);

		} catch (KeyStoreException e) {
			throw new RuntimeException(e);
		} catch (KeyManagementException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		Registry<ConnectionSocketFactory> registry = registryBuilder.build();

		// 设置连接管理器
		PoolingHttpClientConnectionManager connManger = new PoolingHttpClientConnectionManager(registry);

//		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeOut)
//				.setConnectionRequestTimeout(connectTimeOut).setConnectionRequestTimeout(requestTimeOut).build();

		httpClient = HttpClientBuilder.create().setConnectionManager(connManger).build();

		return httpClient;

	}

}
