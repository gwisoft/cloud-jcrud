package org.jcrud.client.consumer;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class HttpClientTest extends TestCase{

	public static Logger logger = LoggerFactory.getLogger(HttpClientTest.class);
	
	public void testGetConsumer(){
		String uri = "http://127.0.0.1:8080/test/2";
		while(true){
			get(uri);
		}
		
	}
	
	public void atestGetZuul(){
		String uri = "http://127.0.0.1:8761/techouse/usersystem/test/2";
		while(true){
			get(uri);
		}
	}
	
	public void get(String uri){
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		CloseableHttpResponse response=null;
		Long failCount = 0L;
		Long successCount = 0L;
		while(true){
			try {
					response = httpclient.execute(httpGet);
					
					if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
						HttpEntity httpEntity = response.getEntity();
						String result = EntityUtils.toString(response.getEntity());
						successCount++;
					}else{
						failCount++;
					}
					
					logger.info("----------------------------调用成功次数（ " + successCount + "）--------------------");
					logger.error("----------------------------调用失败次数（ " + failCount + "）--------------------");
					Thread.sleep(1000L);
				
				
			} catch (ClientProtocolException e) {
				logger.error("", e);
			} catch (IOException e) {
				logger.error("", e);
			} catch(InterruptedException e){
				logger.error("", e);
			}
		}
	}
}
