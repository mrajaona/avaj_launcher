package avaj.simulator;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

import java.security.NoSuchAlgorithmException;

class Md5 {

    static String decrypt(String messageDigest) {
        String secret;

        return (messageDigest);
    }

    static String encrypt(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(message.getBytes());
            String myHash = DatatypeConverter.printHexBinary(md.digest()).toUpperCase();

            return (myHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(System.out);
            return (null);
        }
    }

}