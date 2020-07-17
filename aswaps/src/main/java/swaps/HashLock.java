package swaps;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashLock {
    private final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

    public HashLock(String secret) throws NoSuchAlgorithmException {
        this.messageDigest.update(secret.getBytes());
    }

    public String getHashLock() {
        return new String(messageDigest.digest());
    }
}
