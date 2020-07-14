package swaps;

import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Wallet {
    private final String path;
    private final String password;
    private EthNode ethNode;
    private Web3jApi web3jApi;
    private Connector connector;
    private final String chain;
    private Credentials credentials;

    public Wallet(String path, String password, String chain) {
        this.path = path;
        this.password = password;
        this.chain = chain;
        this.connector = new Connector();

        this.connect();

        this.web3jApi = new Web3jApi(this.ethNode);

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

            this.credentials = WalletUtils.loadCredentials(this.password, this.path);

            // Get the account address
            String accountAddress = this.credentials.getAddress();

            // Get the unencrypted private key into hexadecimal
            String privateKey = this.credentials.getEcKeyPair().getPrivateKey().toString(16);

            System.out.println("acc address " + accountAddress);
            System.out.println("priv key " + privateKey);

            EthGetTransactionCount ethGetTransactionCount = this.ethNode.getWeb3j().ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
            BigInteger nonce =  ethGetTransactionCount.getTransactionCount();

        } catch (CipherException | IOException e) {
            e.printStackTrace();
        }
    }

    public Web3j getWeb3j() {
        return this.ethNode.getWeb3j();
    }

    public BigDecimal getBalance(String address) throws IOException {
        return this.web3jApi.ethGetBalanceToken(address);
    }

    public BigInteger getNonce(String address) throws IOException {
        EthGetTransactionCount ethGetTransactionCount = this.ethNode.getWeb3j().ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).send();
        return ethGetTransactionCount.getTransactionCount();
    }

    public BigInteger convertToWei(String ether) {
        return Convert.toWei(ether, Convert.Unit.ETHER).toBigInteger();
    }

    public BigInteger gasLimit(Long value) {
        return BigInteger.valueOf(value);
    }

    public BigInteger gasPrice(String ether) {
        return Convert.toWei(ether, Convert.Unit.GWEI).toBigInteger();
    }

    public RawTransaction createEtherTransaction(BigInteger nonce, BigInteger gasPrice, BigInteger gasLimit, String recipientAddress, String value) {
        return RawTransaction.createEtherTransaction(nonce, gasPrice, gasLimit, recipientAddress, this.convertToWei(value));
    }

    public String sendEtherTransaction(BigInteger nonce, BigInteger gasPrice, BigInteger gasLimit, String recipientAddress, String value) throws IOException{
        RawTransaction rawTransaction = RawTransaction.createEtherTransaction(nonce, gasPrice, gasLimit, recipientAddress, this.convertToWei(value));
        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, this.credentials);
        String hexValue = Numeric.toHexString(signedMessage);

        EthSendTransaction ethSendTransaction = this.ethNode.getWeb3j().ethSendRawTransaction(hexValue).send();

        return ethSendTransaction.getTransactionHash();
    }


}
