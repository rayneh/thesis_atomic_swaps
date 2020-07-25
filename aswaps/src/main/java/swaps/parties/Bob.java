package swaps.parties;

import swaps.Wallet;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Bob {
    Wallet bitcoinWallet;
    Wallet altCoinWallet;

    public String addressBitcoinWallet;
    public String addressAltCoinWallet;

    private String[] blockNumbersAtContractCreation;

    public Bob() {
        this.setWallets();

    }

    private void setWallets() {
        this.addressBitcoinWallet = "0x7c679de841d0394fea20b2e0c538189e4c602b0a";
        this.bitcoinWallet = new swaps.Wallet("src\\wallets\\Bob-wallet-on-bitcoin-chainUTC--2020-07-13T17-14-25.725628000Z--7c679de841d0394fea20b2e0c538189e4c602b0a", "pwd", "alice");
        System.out.println("Connected to Bob's wallet on bitcoin Chain.");
        System.out.println("  -");

        this.addressAltCoinWallet = "0x3a47996e234c792fa54960b096a2f7e88fbeddb8";
        this.altCoinWallet = new swaps.Wallet("src\\wallets\\Bob-wallet-on-alt-coin-chainUTC--2020-07-13T17-10-05.858381800Z--3a47996e234c792fa54960b096a2f7e88fbeddb8", "pwd", "bob");
        System.out.println("Connected to Bob's wallet on alt-coin Chain.");
        System.out.println("  -");

    }

    public void getBalanceOnCarTitleChain() throws IOException {
        System.out.println("Bob balance on bitcoin blockchain: " + this.bitcoinWallet.getBalance(this.addressBitcoinWallet));
    }

    public void getBalanceOnAltCoinChain() throws IOException {
        System.out.println("Bob balance on alt coin blockchain: " + this.altCoinWallet.getBalance(this.addressAltCoinWallet));
    }

    public Wallet getBitcoinWallet() {
        return this.bitcoinWallet;
    }

    public Wallet getAltCoinWallet() {
        return this.altCoinWallet;
    }

    public String getAddressAltCoinWallet() {
        return this.addressAltCoinWallet;
    }

    public String getAddressBitcoinWallet() {
        return this.addressBitcoinWallet;
    }

    public String getCurrentBitcoinBlock() throws IOException {
        return this.bitcoinWallet.getCurrentBlock();
    }

    public void setBlockNumbers(String[] blockNumbers) {
        this.blockNumbersAtContractCreation = blockNumbers;
    }

    public String deploySwapContractOnBitCoinChain(String _party, String _counterParty, List<BigInteger> _timeLock, List<byte[]> _hashLock, BigInteger _start) throws Exception {
        return this.bitcoinWallet.deploySwapContract(_party, _counterParty, _timeLock, _hashLock, _start);
    }
}
