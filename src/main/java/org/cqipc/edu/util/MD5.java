package org.cqipc.edu.util;

import org.springframework.util.DigestUtils;

public class MD5 {
 
 
	public static String getMd5(String message){
		String md5 = DigestUtils.md5DigestAsHex(message.getBytes());
		return md5;
	}
}
