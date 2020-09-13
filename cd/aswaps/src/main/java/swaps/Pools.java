package swaps;

import swaps.parties.Alice;
import swaps.parties.Bob;
import swaps.parties.Carol;

import java.io.IOException;

public class Pools {
    private Wallet bitcoinPool = new Wallet("src\\wallets\\BtcChain(Alice)-PoolAccount-UTC--2020-05-31T08-09-53.604775500Z--6ec4922fcffd90b36aa7104c506064b4a9988a90", "pwd", "alice");
    private Wallet altCoinPool = new Wallet("src\\wallets\\AltCoinChain(Bob)-PoolAccount-UTC--2020-05-31T08-12-34.964616200Z--2193259b178623345225272dd075717fcacc704e", "pwd", "bob");
    private Wallet carTitlePool = new Wallet("src\\wallets\\CarTitleChain(Carol)-PoolAccount-UTC--2020-05-31T08-13-29.296892300Z--6392e91df60c5bc2ca09670cd4173e05a0e04833", "pwd", "carol");

    public Pools() {

    }

    public Wallet getBitcoinPool() {
        return this.bitcoinPool;
    }

    public Wallet getAltCoinPool() {
        return this.altCoinPool;
    }

    public Wallet getCarTitlePool() {
        return this.carTitlePool;
    }

    public void prepareTrade(Alice alice, Bob bob, Carol carol) {
        try {
            System.out.println("preparing trade ...");
            String tx = altCoinPool.sendEtherTransaction(altCoinPool.getNonce("0x2193259b178623345225272dd075717fcacc704e"), altCoinPool.gasPrice("1"), altCoinPool.gasLimit(21000L), alice.addressAltCoinWallet, "1");
            String tx1 = bitcoinPool.sendEtherTransaction(bitcoinPool.getNonce("0x6ec4922fcffd90b36aa7104c506064b4a9988a90"), bitcoinPool.gasPrice("1"), bitcoinPool.gasLimit(21000L), bob.addressBitcoinWallet, "1");
            String tx2 = carTitlePool.sendEtherTransaction(carTitlePool.getNonce("0x6392e91df60c5bc2ca09670cd4173e05a0e04833"), carTitlePool.gasPrice("1"), carTitlePool.gasLimit(21000L), carol.addressCarTitleWallet, "1");

            altCoinPool.waitForTransactionToBeMined(tx);
            bitcoinPool.waitForTransactionToBeMined(tx1);
            carTitlePool.waitForTransactionToBeMined(tx2);

            /*String tx3 = altCoinPool.sendEtherTransaction(altCoinPool.getNonce("0x2193259b178623345225272dd075717fcacc704e"), altCoinPool.gasPrice("1"), altCoinPool.gasLimit(21000L), bob.addressAltCoinWallet, "1");
            String tx4 = bitcoinPool.sendEtherTransaction(bitcoinPool.getNonce("0x6ec4922fcffd90b36aa7104c506064b4a9988a90"), bitcoinPool.gasPrice("1"), bitcoinPool.gasLimit(21000L), carol.addressBitcoinWallet, "1");
            String tx5 = carTitlePool.sendEtherTransaction(carTitlePool.getNonce("0x6392e91df60c5bc2ca09670cd4173e05a0e04833"), carTitlePool.gasPrice("1"), carTitlePool.gasLimit(21000L), alice.addressCarTitleWallet, "1");

            altCoinPool.waitForTransactionToBeMined(tx3);
            bitcoinPool.waitForTransactionToBeMined(tx4);
            carTitlePool.waitForTransactionToBeMined(tx5);*/ //TODO: only needed once for gas

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String sendCarTitle(String address) throws IOException, InterruptedException {
        String tx = carTitlePool.sendEtherTransaction(carTitlePool.getNonce("0x6392e91df60c5bc2ca09670cd4173e05a0e04833"), carTitlePool.gasPrice("1"), carTitlePool.gasLimit(23000L), address, "1");
        carTitlePool.waitForTransactionToBeMined(tx);

        return tx;
    }

    public String sendAltCoin(String address) throws IOException, InterruptedException {
        String tx = altCoinPool.sendEtherTransaction(altCoinPool.getNonce("0x2193259b178623345225272dd075717fcacc704e"), altCoinPool.gasPrice("1"), altCoinPool.gasLimit(23000L), address, "1");
        altCoinPool.waitForTransactionToBeMined(tx);

        return tx;
    }

    public String sendBitCoin(String address) throws IOException, InterruptedException {
        String tx = bitcoinPool.sendEtherTransaction(bitcoinPool.getNonce("0x6ec4922fcffd90b36aa7104c506064b4a9988a90"), bitcoinPool.gasPrice("1"), bitcoinPool.gasLimit(23000L), address, "1");
        bitcoinPool.waitForTransactionToBeMined(tx);

        return tx;
    }

    public void printPoolBalances() throws IOException {
        System.out.println("      -");
        System.out.println("Token Pool Bitcoin(alice) chain: " + bitcoinPool.getBalance("0x6ec4922fcffd90b36aa7104c506064b4a9988a90"));
        System.out.println("Token Pool AltCoin(bob) chain: " + altCoinPool.getBalance("0x2193259b178623345225272dd075717fcacc704e"));
        System.out.println("Token Pool CarTitle(carol) chain: " + carTitlePool.getBalance("0x6392e91df60c5bc2ca09670cd4173e05a0e04833"));
        System.out.println("      -");
    }
}
