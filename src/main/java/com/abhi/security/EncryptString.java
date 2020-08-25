package com.abhi.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.TimeZone;

public class EncryptString {
	
	public static void main(String [] args) throws NoSuchAlgorithmException {

		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyHHmm");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String currentUTCDateTime = sdf.format(new Date());
		
		String message = "secret" + currentUTCDateTime;
		MessageDigest md = MessageDigest.getInstance( "SHA-384" );

		
		byte[] digest = md.digest(message.getBytes());
		String encryptedMessage = Base64.getEncoder().encodeToString(digest);
		
		
		System.out.println(message);
		System.out.println(encryptedMessage);
	}

}
