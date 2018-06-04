/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobile.helper;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
import java.util.logging.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
/**
 *
 * @author wtccuser
 */
public class RijndaelCrypt {
 
    public static final String TAG = "YourAppName";
 private static String TRANSFORMATION = "AES/CBC/PKCS5PADDING";
   // private static String TRANSFORMATION = "AES/CBC/PKCS7Padding";
    private static String ALGORITHM = "AES";
    private static String DIGEST = "MD5";
     
    private static Cipher _cipher;
    private static SecretKey _password;
    private static IvParameterSpec _IVParamSpec;
     
    //16-byte private key
    private static byte[] IV = "ThisIsUrPassword".getBytes();
     
     
    /**
     Constructor
     @password Public key
      
    */
    public RijndaelCrypt(String password) {
 
        try {
             
            //Encode digest
            MessageDigest digest;           
            digest = MessageDigest.getInstance(DIGEST);            
            _password = new SecretKeySpec(digest.digest(password.getBytes()), ALGORITHM);
             
            //Initialize objects
            _cipher = Cipher.getInstance(TRANSFORMATION);
            _IVParamSpec = new IvParameterSpec(IV);
             
        } catch (NoSuchAlgorithmException e) {
           System.err.println("No such algorithm " + e.getMessage());
        } catch (NoSuchPaddingException e) {
             System.err.println("No such padding PKCS7 " + e.getMessage());
            //Log.e(TAG, "No such padding PKCS7", e);
        }              
    }
 
    /**
    Encryptor.
 
    @text String to be encrypted
    @return Base64 encrypted text
 
    */
    public String encrypt(byte[] text) {
         
        byte[] encryptedData;
         
        try {
             
            _cipher.init(Cipher.ENCRYPT_MODE, _password, _IVParamSpec);
            encryptedData = _cipher.doFinal(text);
             
        } catch (InvalidKeyException e) {
           System.err.println("Invalid key  (invalid encoding, wrong length, uninitialized, etc)." + e.getMessage());
            return null;
        } catch (InvalidAlgorithmParameterException e) {
           System.err.println("Invalid or inappropriate algorithm parameters for " +  e.getMessage());
            return null;
        } catch (IllegalBlockSizeException e) {
           System.err.println("The length of data provided to a block cipher is incorrect" +e.getMessage());
            return null;
        } catch (BadPaddingException e) {
          System.err.println("The input data but the data is not padded properly." +e.getMessage());
            return null;
        }               
       //String test =  Base64.getEncoder().encodeToString(encryptedData);
       String test =  Base64.encodeBase64String(encryptedData);
        return test;
         
    }
     public static void main(String args[]) {
         String key = "Bar12345Bar12345";
         RijndaelCrypt crypt = new RijndaelCrypt(key);
         String encrypt = crypt.encrypt("test".getBytes());
         String decr = crypt.decrypt(encrypt);
         //DmmMF17AaibIBBfXH/gPEw==
         //DmmMF17AaibIBBfXH/gPEw==
         System.out.println(encrypt);
         System.out.println(decr);
     }
    /**
    Decryptor.
 
    @text Base64 string to be decrypted
    @return decrypted text
 
    */   
    public String decrypt(String text) {
 
        try {
            _cipher.init(Cipher.DECRYPT_MODE, _password, _IVParamSpec);
             
            //byte[] decodedValue = Base64.getDecoder().decode(text.getBytes());
             byte[] decodedValue = Base64.decodeBase64(text.getBytes());
          
            
            byte[] decryptedVal = _cipher.doFinal(decodedValue);
            return new String(decryptedVal);            
             
             
        } catch (InvalidKeyException e) {
            //Log.e(TAG, "Invalid key  (invalid encoding, wrong length, uninitialized, etc).", e);
            return null;
        } catch (InvalidAlgorithmParameterException e) {
            //Log.e(TAG, "Invalid or inappropriate algorithm parameters for " + ALGORITHM, e);
            return null;
        } catch (IllegalBlockSizeException e) {
            //Log.e(TAG, "The length of data provided to a block cipher is incorrect", e);
            return null;
        } catch (BadPaddingException e) {
            //Log.e(TAG, "The input data but the data is not padded properly.", e);
            return null;
        }               
         
    }
     
}
