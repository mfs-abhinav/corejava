package com.abhi.crypto;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

class Crypto {
	private final static int SALT_SIZE = 20;
	final static String rngAlgorithm = "SHA1PRNG";
	
	public Crypto(){
		
	};

	public String createSalt() {
		byte[] salt = new byte[SALT_SIZE];
		SecureRandom random = null;
		try {
			random = SecureRandom.getInstance(rngAlgorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Invalid algorithm for SecureRandom class");
		}
		random.nextBytes(salt);

		return DatatypeConverter.printBase64Binary(salt);
	}

	public String getHashUsingPBK(String password, String salt) {
		// 64,000 iterations recommended by OWASP
		// affects the output value, don't change unless you feel like rehashing
		// everybody's password
		int iterations = 64000;
		// key length set by security team
		int keyLength = 128;
		try {
			PBEKeySpec spec = new PBEKeySpec(password.toCharArray(),
					salt.getBytes(), iterations, keyLength);
			SecretKeyFactory factory = SecretKeyFactory
					.getInstance("PBKDF2WithHmacSHA1");
			SecretKey key = factory.generateSecret(spec);
			
			System.out.println(key);
			System.out.println(key.getEncoded());
			
			spec.clearPassword();
			String hash = DatatypeConverter.printBase64Binary(key.getEncoded());

			return hash;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Exception creating password hash");
		}
	}

}


public class CryptoService {

	public static void main(String[] args) {
		Crypto obj = new Crypto();
		
		String hashPass = obj.getHashUsingPBK("password4", "A/NAK7EahV0yL2PTUoahLCPk6+Y=");
		
		System.out.println(hashPass);

	}

}
