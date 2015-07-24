package com.experimental.labs.dev;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

import java.security.Provider;

public class PuppetMaster {

    /*private List <Puppet> toys = new ArrayList<Puppet>();

    //Constructor
    public PuppetMaster () {
	toys.add(new Karasu());
	toys.add(new Kuroari());
	toys.add(new Sanshouo());
    }

    @Override
    public String toString(){
	String ret = "";
	for (Puppet p : toys){
 	    ret += p.toString();
	}
	return ret;
    }

    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );

	//PuppetMaster controller = new PuppetMaster();
	//System.out.println(controller.toString());

	System.out.println("<--------  SEC Testing ---------------->");
	
	String good = goodHash("12345");
        String bad = badHash("12345");

        System.out.println(String.format("%s (len=%d) != %s (len=%d)", good, good.length(), bad, bad.length()));
    }*/

    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception {
        String good = goodHash("12345");
        //String bad = badHash("12345");

        //System.out.println(String.format("%s (len=%d) != %s (len=%d)", good, good.length(), bad, bad.length()));

        //For the hash ABC the 5th byte become weaker because of the trailing 0 being trim (06 -> 6)
        //Actual      : ..0679.. => ..679..
        //Collision 1 : ..6709.. => ..679..
        //Actual      : ..7D06.. => ..7D6..
        //Collision 2 : ..07D6.. => ..7D6..


        //Note : Not a realistic code sample (no encryption occurs)

	
		Cipher.getInstance("AES/CBC/NoPadding");
		Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		Cipher.getInstance("AES/ECB/NoPadding", "IBMJCE");
		Cipher.getInstance("AES/ECB/PKCS5Padding", new DummyProvider());
		Cipher.getInstance("DES/CBC/NoPadding", new DummyProvider());
		Cipher.getInstance("DES/CBC/PKCS5Padding");
		Cipher.getInstance("DES/ECB/NoPadding");
		Cipher.getInstance("DES/ECB/PKCS5Padding");
		Cipher.getInstance("DESede/CBC/NoPadding");
		Cipher.getInstance("DESede/CBC/PKCS5Padding");
		Cipher.getInstance("DESede/ECB/NoPadding");
		Cipher.getInstance("DESede/ECB/PKCS5Padding");
		Cipher.getInstance("RSA/ECB/PKCS1Padding");
		Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
		Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
		Cipher.getInstance("RC2/ECB/PKCS5Padding");
		Cipher.getInstance("ARCFOUR/ECB/NOPADDING");
		Cipher.getInstance("RSA"); //Just to test a cipher with a different format in the input
	
	

    }



    public static String goodHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] resultBytes = md.digest(password.getBytes("UTF-8"));

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : resultBytes) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }

/*    public static String badHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] resultBytes = md.digest(password.getBytes("UTF-8"));

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : resultBytes) {
            stringBuilder.append(Integer.toHexString(b & 0xFF));
        }

        return stringBuilder.toString();
    }*/



    /**
     * Sun provider are at risk to be remove. This dummy provider will
     * be easier to maintain.
     */
    static class DummyProvider extends Provider {

        protected DummyProvider() {
            super("dummy", 1.0, "");
        }
    }


}
