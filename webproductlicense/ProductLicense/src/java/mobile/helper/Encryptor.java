/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobile.helper;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


/**
 * Usage:
 * <pre>
 * String crypto = SimpleCrypto.encrypt(masterpassword, cleartext)
 * ...
 * String cleartext = SimpleCrypto.decrypt(masterpassword, crypto)
 * </pre>
 * @author ferenc.hechler
 * @author Doguhan Uluca
 */
public class Encryptor {
     public static String encrypt(String key, String initVector, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            System.out.println("encrypted string: "
                    + Base64.encodeBase64(encrypted));

            return Base64.encodeBase64(encrypted).toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

           // byte[] original = cipher.doFinal(Base64.decodeBase64(base64Data)
byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted.getBytes()));
            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        String key = "Bar12345Bar12345"; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV
System.out.println(decrypt(key,initVector,"RfYSZKaaB3S9BMWbXDDNp5S1a8Zl7AZLNFxLGUtMVZEPICEotCXIaLGvuT8cxxJYV5JeAGoiehI+JTAI1YWUVG7xT8RLdv2TsZkDBUhARnR7gWs17Ls3y+iIWALrwZ8RGGy3VqDKYcBvkBwTi14UMw=="));
   
//lePrqW6fNiIH5vuZhCs0Gw0cs8gK903XFl+8KYhtKFsQwX98MIajAm+MwKv3SZMovGNRn7KYWMknqVVJLBIq6W/u6VEBjvUc+GMBt74q+QyHICczdJVaz7waInr6xy5d

System.out.println(decrypt(key, initVector,
                encrypt(key, initVector, "Hello World")));
    }
}
