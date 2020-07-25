package swaps;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SwapUtils {
    public static boolean isMessageDigestByteEqual(byte[] one, byte[] two) {
        return MessageDigest.isEqual(one, two);
    }

    public static List<BigInteger> convertLongArrayToBigIntegerList(Long[] data) {
        List<BigInteger> list = new ArrayList<>(data.length);

        for(long num : data) {
            list.add(BigInteger.valueOf(num));
        }

        return list;
    }

    public static List<byte[]> convertStringArrayToByteArrayList(String[] data) {
        List<byte[]> bytes = new ArrayList<>(32);  // data.length

        for(String s : data) {
            bytes.add(s.getBytes());
        }

        for(byte[] b : bytes) {
            System.out.println(b.length);
        }

        return bytes;
    }
}
