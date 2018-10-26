package avaj.simulator;

import avaj.elements.aircraft.AircraftFactory;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

import java.security.NoSuchAlgorithmException;

class Md5 {

    private static final Map<String, String> md5AircraftHashes = initMd5AircraftHashes();
    private static final Map<String, String> initMd5AircraftHashes() {
        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put(encrypt(AircraftFactory.JETPLANE), AircraftFactory.JETPLANE);
        hashMap.put(encrypt(AircraftFactory.HELICOPTER), AircraftFactory.HELICOPTER);
        hashMap.put(encrypt(AircraftFactory.BALOON), AircraftFactory.BALOON);

        return (Collections.unmodifiableMap(hashMap));
    }

    private static final Map<String, String> md5NumericHashes = initMd5NumericHashes();
    private static final Map<String, String> initMd5NumericHashes() {
        HashMap<String, String> hashMap = new HashMap<String, String>();

        return (Collections.unmodifiableMap(hashMap));
    }

    static String decrypt(String messageDigest) {
        String secret;

        /*
        if (hashed)
            return (res);
        */

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