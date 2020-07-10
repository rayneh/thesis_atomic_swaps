package swaps;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;

import java.io.IOException;
import java.math.BigInteger;
import java.security.PrivateKey;

public class SwapProtocol {
    EthNode alice;
    EthNode bob;
    EthNode carol;

    Web3jApi aliceApi;
    Web3jApi bobApi;
    Web3jApi carolApi;

    SwapProtocol() {
        this.init();
    }

    void init() {
        this.connect();

        try {

            System.out.println("Alice Chain block numbger: " + this.aliceApi.getBlockNumber());
            System.out.println("Alice Main Acc wei: " + this.aliceApi.ethGetBalance("0x6ec4922fcffd90b36aa7104c506064b4a9988a90"));
            System.out.println("Alice Main AccEther: " + this.aliceApi.ethGetBalanceToken("0x6ec4922fcffd90b36aa7104c506064b4a9988a90"));

            System.out.println("Bob Chain block numbger: " + this.bobApi.getBlockNumber());
            System.out.println("Bob Main Acc wei: " + this.bobApi.ethGetBalance("0x2193259b178623345225272dd075717fcacc704e"));
            System.out.println("Bob Main Acc Ether: " + this.bobApi.ethGetBalanceToken("0x2193259b178623345225272dd075717fcacc704e"));

            System.out.println("Carol Chain block numbger: " + this.carolApi.getBlockNumber());
            System.out.println("Carol Main Acc wei: " + this.carolApi.ethGetBalance("0x6392e91df60c5bc2ca09670cd4173e05a0e04833"));
            System.out.println("Carol Main Acc Ether: " + this.carolApi.ethGetBalanceToken("0x6392e91df60c5bc2ca09670cd4173e05a0e04833"));


        } catch(IOException io) {
            io.printStackTrace();
        }

        this.walletTest();

    }

    void walletTest() {         //te
        try {
            String walletPassword = "pwd";
            String wallet = "src\\chains\\BtcChain(Alice)-PoolAccount-UTC--2020-05-31T08-09-53.604775500Z--6ec4922fcffd90b36aa7104c506064b4a9988a90";

            // Load the JSON encryted wallet
            Credentials credentials = WalletUtils.loadCredentials(walletPassword, wallet);

            // Get the account address
            String accountAddress = credentials.getAddress();

            // Get the unencrypted private key into hexadecimal
            String privateKey = credentials.getEcKeyPair().getPrivateKey().toString(16);

            System.out.println("acc address " + accountAddress);
            System.out.println("priv key " + privateKey);

            EthGetTransactionCount ethGetTransactionCount = this.alice.getWeb3j().ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
            BigInteger nonce =  ethGetTransactionCount.getTransactionCount();

        } catch (CipherException | IOException e) {
            e.printStackTrace();
        }
    }

    void connect() {
        Connector connector = new Connector();
        this.alice = connector.getAlice();
        this.bob = connector.getBob();
        this.carol = connector.getCarol();

        this.aliceApi = new Web3jApi(this.alice);
        this.bobApi = new Web3jApi(this.bob);
        this.carolApi = new Web3jApi(this.carol);
    }

    //void getPrivateKey

}
