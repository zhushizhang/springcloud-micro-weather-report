package com.supcon.cloud.Util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlBuilder {
	/**
	 * 
	* @Title: xmlStrToObject 
	* @Description: 讲xml转为制定的POJO
	* @param @param clazz
	* @param @param xmlStr
	* @param @return
	* @param @throws Exception    
	* @return Object 
	* @author zhushizhang   
	* @throws
	 */
	public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception{ 
		Object xmlObject = null;
		Reader reader = null;
		JAXBContext context = JAXBContext.newInstance(clazz);
		 Unmarshaller  unmarshaller = context.createUnmarshaller();
		 reader = new StringReader(xmlStr);
		 try {
			 xmlObject = unmarshaller.unmarshal(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 if(null !=reader){
			 reader.close();
		 }
		return xmlObject;
	}
}
