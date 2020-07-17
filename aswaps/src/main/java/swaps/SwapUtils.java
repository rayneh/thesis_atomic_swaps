package swaps;

import java.security.MessageDigest;

public final class SwapUtils {
    public static boolean isMessageDigestByteEqual(byte[] one, byte[] two) {
        return MessageDigest.isEqual(one, two);
    }
}
