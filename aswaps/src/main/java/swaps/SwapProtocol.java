package swaps;


import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import swaps.parties.Alice;
import swaps.parties.Bob;
import swaps.parties.Carol;

import java.io.IOException;
import java.util.Optional;

public class SwapProtocol {
    Alice alice = new Alice();
    Bob bob = new Bob();
    Carol carol = new Carol();
    Wallet bitcoinPool = new Wallet("src\\wallets\\BtcChain(Alice)-PoolAccount-UTC--2020-05-31T08-09-53.604775500Z--6ec4922fcffd90b36aa7104c506064b4a9988a90", "pwd", "alice");
    Wallet altCoinPool = new Wallet("src\\wallets\\AltCoinChain(Bob)-PoolAccount-UTC--2020-05-31T08-12-34.964616200Z--2193259b178623345225272dd075717fcacc704e", "pwd", "bob");
    Wallet carTitlePool = new Wallet("src\\wallets\\CarTitleChain(Carol)-PoolAccount-UTC--2020-05-31T08-13-29.296892300Z--6392e91df60c5bc2ca09670cd4173e05a0e04833", "pwd", "carol");

    SwapProtocol() {
        this.init();
    }

    void init() {

        try {
            System.out.println("      -");
            System.out.println("Token Pool Bitcoin(alice) chain: " + bitcoinPool.getBalance("0x6ec4922fcffd90b36aa7104c506064b4a9988a90"));
            System.out.println("Token Pool AltCoin(bob) chain: " + altCoinPool.getBalance("0x2193259b178623345225272dd075717fcacc704e"));
            System.out.println("Token Pool CarTitle(carol) chain: " + carTitlePool.getBalance("0x6392e91df60c5bc2ca09670cd4173e05a0e04833"));
            System.out.println("      -");
            alice.getBalanceOnCarTitleChain();
            alice.getBalanceOnAltCoinChain();
            System.out.println("      -");
            bob.getBalanceOnCarTitleChain();
            bob.getBalanceOnAltCoinChain();
            System.out.println("      -");
            carol.getBalanceOnAltCoinChain();
            carol.getBalanceOnCarTitleChain();
            System.out.println("      -");

            //alice.getAltCoinWallet().getNonce(alice.addressAltCoinWallet);
            System.out.println(alice.getAltCoinWallet().getNonce(alice.addressAltCoinWallet)); //PRINT NONCE
            System.out.println(alice.getAltCoinWallet().convertToWei("1")); //amount to send

            //testaddress   ->    "0x01d091a2bcce9fcc71d1e4c8d83113ca9d150e26"
            System.out.println("SENDING FUNDS TO TEST ADDRESS");
            String tx = bitcoinPool.sendEtherTransaction(bitcoinPool.getNonce("0x6ec4922fcffd90b36aa7104c506064b4a9988a90"), bitcoinPool.gasPrice("1"), bitcoinPool.gasLimit(21000L), "0x01d091a2bcce9fcc71d1e4c8d83113ca9d150e26", "1");
            System.out.println(tx);
            System.out.println(bitcoinPool.getBalance("0x01d091a2bcce9fcc71d1e4c8d83113ca9d150e26"));

            // Wait for transaction to be mined
            Optional<TransactionReceipt> transactionReceipt = null;
            do {
                EthGetTransactionReceipt ethGetTransactionReceiptResp = this.bitcoinPool.getWeb3j().ethGetTransactionReceipt(tx).send();
                transactionReceipt = ethGetTransactionReceiptResp.getTransactionReceipt();

                Thread.sleep(3000); // Retry after 3 sec
            } while(!transactionReceipt.isPresent());

            System.out.println(bitcoinPool.getBalance("0x01d091a2bcce9fcc71d1e4c8d83113ca9d150e26"));

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    void prepareTrade() {
        try {
            // alice gets 1 alt coin!
            // bob gets one BTC!
            // carol gets one car title!
            System.out.println(bitcoinPool.getBalance("0x01d091a2bcce9fcc71d1e4c8d83113ca9d150e26"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
