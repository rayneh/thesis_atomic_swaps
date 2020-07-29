package swaps;

import java.io.IOException;
import java.math.BigDecimal;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.utils.Convert;

public class EthNode {
    private Web3j web3j;
    private String host;
    private String port;
    private String name;

    EthNode(String name, String host, String port) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.web3j = Web3j.build(new HttpService(this.host + ":" + this.port));
    }

    EthBlockNumber getBlockNumber() throws IOException{
        return web3j.ethBlockNumber().send();
    }

    String getName() {
        return this.name;
    }

    Web3j getWeb3j() {
        return this.web3j;
    }

    BigDecimal ethGetBalanceToken(String address) throws IOException {
        return Convert.fromWei(String.valueOf(web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST).send().getBalance()), Convert.Unit.ETHER);
    }

    public String getCurrentBlock() throws IOException {
        EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().send();
        return ethBlockNumber.getBlockNumber().toString();
    }
}
