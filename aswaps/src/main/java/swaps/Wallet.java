package swaps;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;

import java.io.IOException;
import java.math.BigInteger;

public class Wallet {
    private final String path;
    private final String password;
    private EthNode ethNode;
    private Web3jApi web3jApi;
    private Connector connector;
    private final String chain;

    public Wallet(String path, String password, String chain) {
        this.path = path;
        this.password = password;
        this.chain = chain;
        this.connector = new Connector();

        this.connect();
        this.openWallet();
    }

    private void connect() {
        switch (this.chain) {
            case "alice": {
                this.ethNode = this.connector.getAlice();
                break;
            }
            case "bob": {
                this.ethNode = this.connector.getBob();
                break;
            }
            case "carol": {
                this.ethNode = this.connector.getCarol();
                break;
            }
            default: {
                System.out.println("ERROR");
                break;
            }
        }
    }

    private void openWallet() {
        try {
            String walletPassword = this.password;
            String wallet = this.path;

            // Load the JSON encryted wallet
            Credentials credentials = WalletUtils.loadCredentials(walletPassword, wallet);

            // Get the account address
            String accountAddress = credentials.getAddress();

            // Get the unencrypted private key into hexadecimal
            String privateKey = credentials.getEcKeyPair().getPrivateKey().toString(16);

            System.out.println("acc address " + accountAddress);
            System.out.println("priv key " + privateKey);

            EthGetTransactionCount ethGetTransactionCount = this.ethNode.getWeb3j().ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
            BigInteger nonce =  ethGetTransactionCount.getTransactionCount();

        } catch (CipherException | IOException e) {
            e.printStackTrace();
        }
    }
}
