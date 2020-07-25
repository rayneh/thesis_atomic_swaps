package swaps.parties;

import swaps.Wallet;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Carol {
    Wallet bitcoinWallet;
    Wallet carTitleWallet;

    public String addressBitcoinWallet;
    public String addressCarTitleWallet;

    private String[] blockNumbersAtContractCreation;

    public Carol() {
        this.setWallets();

    }

    private void setWallets() {
        this.addressBitcoinWallet = "0x077bc08522af19a8be72d4295cafea44f747ed59";
        this.bitcoinWallet = new swaps.Wallet("src\\wallets\\Carol-wallet-on-bitcoin-chainUTC--2020-07-13T17-49-53.915922300Z--077bc08522af19a8be72d4295cafea44f747ed59", "pwd", "alice");
        System.out.println("Connected to Carol's wallet on bitcoin Chain.");
        System.out.println("  -");

        this.addressCarTitleWallet = "0x7ae905991c9e3cddba17557f5174b43da20d164b"; //   0x3a47996e234c792fa54960b096a2f7e88fbeddb8
        this.carTitleWallet = new swaps.Wallet("src\\wallets\\Carol-wallet-on-car-title-chainUTC--2020-07-13T17-51-24.731787200Z--7ae905991c9e3cddba17557f5174b43da20d164b", "pwd", "carol");
        System.out.println("Connected to Carol's wallet on car Title Chain.");
        System.out.println("  -");

    }

    public void getBalanceOnBitCoinChain() throws IOException {
        System.out.println("Carol balance on bitcoin blockchain: " + this.bitcoinWallet.getBalance(this.addressBitcoinWallet));
    }

    public void getBalanceOnCarTitleChain() throws IOException {
        System.out.println("Carol balance on car title blockchain: " + this.carTitleWallet.getBalance(this.addressCarTitleWallet));
    }

    public Wallet getBitcoinWallet() {
        return this.bitcoinWallet;
    }

    public Wallet getCarTitleWallet() {
        return this.carTitleWallet;
    }

    public String getAddressCarTitleWallet() {
        return this.addressCarTitleWallet;
    }

    public String getAddressBitcoinWallet() {
        return this.addressBitcoinWallet;
    }

    public String getCurrentCarTitleBlock() throws IOException {
        return this.carTitleWallet.getCurrentBlock();
    }

    public void setBlockNumbers(String[] blockNumbers) {
        this.blockNumbersAtContractCreation = blockNumbers;
    }

    public String deploySwapContractOnCarTitleChain(String _party, String _counterParty, List<BigInteger> _timeLock, List<byte[]> _hashLock, BigInteger _start) throws Exception {
        return this.carTitleWallet.deploySwapContract(_party, _counterParty, _timeLock, _hashLock, _start);
    }
}
