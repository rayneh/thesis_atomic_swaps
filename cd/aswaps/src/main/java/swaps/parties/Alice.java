package swaps.parties;

import swaps.HashLock;
import swaps.Wallet;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public class Alice {
    private Wallet carTitleWallet;
    private Wallet altCoinWallet;

    public String addressCarTitleWallet;
    public String addressAltCoinWallet;

    private String secret;
    private HashLock hashLock;

    private String[] blockNumbersAtContractCreation;

    public Alice() throws NoSuchAlgorithmException {
        this.setWallets();
        this.secret = "secret";
        this.hashLock = new HashLock(this.secret);
    }

    private void setWallets() {
        this.addressAltCoinWallet = "0x57becfba1b949dab42be6f632a0b7d9e74f01a9e";
        this.altCoinWallet = new swaps.Wallet("src\\wallets\\Alice-wallet-on-alt-coin-chainUTC--2020-07-11T20-43-15.816875500Z--57becfba1b949dab42be6f632a0b7d9e74f01a9e", "pwd", "bob");
        System.out.println("Connected to Alice's wallet on alt-coin Chain.");
        System.out.println("  -");

        this.addressCarTitleWallet = "0xfb22d6e6a5f3c76e58c9013601ca52e4b262ff73";
        this.carTitleWallet = new swaps.Wallet("src\\wallets\\Alice-wallet-on-car-title-chainUTC--2020-07-11T20-52-54.397544500Z--fb22d6e6a5f3c76e58c9013601ca52e4b262ff73", "pwd", "carol");
        System.out.println("Connected to Alice's wallet on car-title Chain.");
        System.out.println("  -");
    }

    public void getBalanceOnCarTitleChain() throws IOException {
        System.out.println("Alice balance on car title blockchain: " + this.carTitleWallet.getBalance(this.addressCarTitleWallet));
    }

    public void getBalanceOnAltCoinChain() throws IOException {
        System.out.println("Alice balance on alt coin blockchain: " + this.altCoinWallet.getBalance(this.addressAltCoinWallet));
    }

    public Wallet getCarTitleWallet() {
        return this.carTitleWallet;
    }

    public Wallet getAltCoinWallet() {
        return this.altCoinWallet;
    }

    public String getAddressAltCoinWallet() {
        return this.addressAltCoinWallet;
    }

    public String getAddressCarTitleWallet() {
        return this.addressCarTitleWallet;
    }

    public String getHashLock() {
        return this.hashLock.getHashLock();
    }

    public String getHashLockAsHex() {
        return this.hashLock.getHashLockAsHex();
    }

    public byte[] getHashLockAsByteArray() {
        return this.hashLock.getHashLockAsByteArray();
    }

    public String getEncodedHash() {
        return this.hashLock.getEncodedHashLock();
    }

    public String getCurrentAltCoinBlock() throws IOException {
        return this.altCoinWallet.getCurrentBlock();
    }

    public HashLock getHashLockObject() {
        return this.hashLock;
    }

    public void setBlockNumbers(String[] blockNumbers) {
        this.blockNumbersAtContractCreation = blockNumbers;
    }

    public String deploySwapContractOnAltCoinChain(String _party, String _counterParty, List<BigInteger> _timeLock, List<byte[]> _hashLock, BigInteger _start) throws Exception {
        return this.altCoinWallet.deploySwapContract(_party, _counterParty, _timeLock, _hashLock, _start);
    }

}
