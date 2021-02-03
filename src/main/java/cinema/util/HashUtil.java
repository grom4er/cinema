package cinema.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HashUtil {
    private static final String CODE = "SHA-512";

    public static byte[] getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static String hashPassword(String password, byte[] salt) {
        String hashedPasswordString = "";
        try {
            MessageDigest md = MessageDigest.getInstance(CODE);
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            for (byte hash : hashedPassword) {
                hashedPasswordString += hash;
            }
            md.update(salt);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Can't find algorithm", e);
        }
        return hashedPasswordString;
    }
}
