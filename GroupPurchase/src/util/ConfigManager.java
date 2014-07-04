package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigManager {
	private static String CONFIGPATH = "config/config.xml";
	
	private static Document doc;
	
	public static String getValue(String key){
		if( doc == null ) doc = loadXML(CONFIGPATH);
		
		Element root = doc.getRootElement();
		Element e = root.element(key);
		
		if( e!=null ){
			return e.getText();
		}else{
			return null;
		}
	}
	
	
	/**
	 * 读取指定的配置文件
	 * @param string 配置文件的文件名
	 * @return
	 */
	private static Document loadXML(String path) {
		try {
			InputStream inputStream = new FileInputStream(new File(path));
			
			Document document = new SAXReader().read(inputStream);  
			
			return document;
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}   
		
		return null;
	}
}
