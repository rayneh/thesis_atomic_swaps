package swaps.parties;

import swaps.Wallet;


public class Alice {
//needs address on alt-coin chain (bob) and wallet on car chain (carol)
    Wallet carTitleWallet;
    Wallet altCoinWallet;

    String addressCarTitleWallet;
    String addressAltCoinWallet;

    public Alice() {
        this.setWallets();

    }

    private void setWallets() {
        this.addressAltCoinWallet = "0x57becfba1b949dab42be6f632a0b7d9e74f01a9e";
        this.altCoinWallet = new swaps.Wallet("src\\wallets\\Alice-wallet-on-alt-coin-chainUTC--2020-07-11T20-43-15.816875500Z--57becfba1b949dab42be6f632a0b7d9e74f01a9e", "pwd", "bob");
        
        this.addressCarTitleWallet = "0xfb22d6e6a5f3c76e58c9013601ca52e4b262ff73";
        this.carTitleWallet = new swaps.Wallet("src\\wallets\\Alice-wallet-on-car-title-chainUTC--2020-07-11T20-52-54.397544500Z--fb22d6e6a5f3c76e58c9013601ca52e4b262ff73", "pwd", "carol");
    }


}
