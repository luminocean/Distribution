package util;

import java.util.Enumeration;

public class Logger {
	public static void log(SideType sourceSide, String msg, Object sourceObject){
		System.out.println(sourceSide+" : "+msg+" ["+sourceObject.getClass()+"]");
	}
}
