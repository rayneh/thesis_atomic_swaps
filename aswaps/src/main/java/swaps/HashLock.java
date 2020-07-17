package swaps;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class HashLock {
    private final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    private final String secret;

    public HashLock(String secret) throws NoSuchAlgorithmException {
        this.secret = secret;
        this.messageDigest.update(this.secret.getBytes(StandardCharsets.UTF_8));
    }

    public String getHashLock() {
        return new String(this.messageDigest.digest());
    }

    public String getHashLockAsStringArray() {
        return Arrays.toString(this.messageDigest.digest());
    }

    public String getHashLockAsHex() {
        return org.apache.commons.codec.digest.DigestUtils.sha256Hex(new String(this.messageDigest.digest()));
    }

    public byte[] getHashLockAsByteArray() {
        return messageDigest.digest(this.secret.getBytes(StandardCharsets.UTF_8));
    }

    public boolean isByteArrayEqual(byte[] one, byte[] two) {
        return MessageDigest.isEqual(one, two);
    }

    public String getEncodedHashLock() {
        return Base64.getEncoder().encodeToString(this.getHashLockAsByteArray());
    }
}
