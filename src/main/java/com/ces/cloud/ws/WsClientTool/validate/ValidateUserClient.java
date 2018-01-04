package com.ces.cloud.ws.WsClientTool.validate;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import com.ces.cloud.ws.WsClientTool.util.HttpClientTool;
import com.ces.cloud.ws.WsClientTool.util.SecurityTool;

public class ValidateUserClient {
	private static String baseApp = "http://luopc.shunde.gov.cn/appapi/";
	
	private static String loginUrl = baseApp + "pages/ValidateUser/addUser.do";
	
	private static String validateTokenUrl = baseApp + "pages/ValidateUser/validate.do";
	
	
	
	@Test
	public void addUser() {	
		List<NameValuePair> params = new ArrayList<NameValuePair>();		
		params.add(new BasicNameValuePair("userName", "SDHF_USER"));  
		params.add(new BasicNameValuePair("userPasswd", "SDHF_1101CENTER"));
		String data = HttpClientTool.post(loginUrl,params);
		System.out.println(data);
		//ca8a8181824c50535c014c77d846893bcd
	}
	
	@Test
	public void validate() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		String userName = SecurityTool.getBASE64("SDHF_USER");
		String passWord = SecurityTool.getBASE64("SDHF_1101CENTER");
		System.out.println(userName + "|------|" + passWord);
		params.add(new BasicNameValuePair("username", userName));
		params.add(new BasicNameValuePair("password", passWord));  
		String data = HttpClientTool.post(validateTokenUrl,params);
		System.out.println(data);
		
	}
	
	@Test
	public void test(){
		String name = SecurityTool.getFromBASE64("5bm/5L+h6YCa5L+h");
		System.out.println(name);
	}

}
