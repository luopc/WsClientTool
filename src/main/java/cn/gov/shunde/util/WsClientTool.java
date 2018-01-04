package cn.gov.shunde.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.soap.SOAPException;

import org.apache.axis.message.SOAPHeaderElement;

public class WsClientTool {
	
	
	/**
	 * 调用webservice所需要的消息头
	 * @param userName 用户名
	 * @param userPwd 密码
	 * @return
	 */
	public static SOAPHeaderElement getSoapHead(String userName,String userPwd) {
		SOAPHeaderElement soapHeaderElement = new SOAPHeaderElement("", "CustomHeader");			
		try {
			// 输入用户名、密码
			
			soapHeaderElement.addChildElement("userName").setValue(userName);
			soapHeaderElement.addChildElement("userPassWord").setValue(getMD5Str(userPwd));
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		return soapHeaderElement;
		
	}
	

	 /**
	  * 
	  * @param str 需要加密的字串
	  * @return 加密后的字串
	  */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}

}
