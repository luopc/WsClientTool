package cn.gov.shunde;



import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import cn.gov.shunde.data.impl.DataQueryserviceImplServiceSoapBindingStub;
import cn.gov.shunde.util.WsClientTool;

public class ServiceQueryDemo {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		String address = "http://localhost/webservice/server/web-query?wsdl";		
		DataQueryserviceImplServiceSoapBindingStub stub = new DataQueryserviceImplServiceSoapBindingStub(
				new java.net.URL(address),
				new org.apache.axis.client.Service());
		stub.setHeader(WsClientTool.getSoapHead("张三", "123"));
		
		/**
		 * 开始调用服务
		 */
		Map<String, Object> params = new HashMap<String, Object>();		
		params.put("pageNum", 1);
		params.put("pageSize", 10);
		params.put("fileType", new String[] {"date","number","string"});
		params.put("IdCard", "440623196211162023");
		params.put("name", "谭恩杰");		
		String paramsStr = JSON.toJSONString(params);
		
//		String out = stub.query("108", "0", paramsStr);
		String out = stub.fileList("108");
		System.out.println(out);
	}

}
