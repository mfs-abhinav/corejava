package com.abhi.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

public class GenSign {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException,
			InvalidKeySpecException, SignatureException, UnsupportedEncodingException {
		final String entity = "PRINTERQ";
		
		
		 KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		

		// Generate the key pair
		final KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(512);
		final KeyPair keyPair = kpg.genKeyPair();

		// Generate the signature
		final Signature sig = Signature.getInstance("SHA1WithRSA");
		sig.initSign(KeyFactory.getInstance("RSA")
				.generatePrivate(new PKCS8EncodedKeySpec(keyPair.getPrivate().getEncoded())));
		sig.update(entity.getBytes("UTF8"));
		byte[] signatureBytes = sig.sign();
		final String signature = Base64.getEncoder().encodeToString(signatureBytes);

		// The Signature
		System.out.println(signature);

		// The Public key - base64 encoded
		System.out.println(DatatypeConverter.printBase64Binary(keyPair.getPublic().getEncoded()));

		// The Private key - base64 encoded
		System.out.println(DatatypeConverter.printBase64Binary(keyPair.getPrivate().getEncoded()));

	}

}
