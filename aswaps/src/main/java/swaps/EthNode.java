package swaps;

import java.io.IOException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

public class EthNode {
    private Web3j web3j;
    private String host;
    private String port;
    private String name;

    EthNode(String name, String host, String port) {
        this.name = name;
        this.host = host;
        this.port = port;
        System.out.println("Connecting to Node ... " + name);
        this.web3j = Web3j.build(new HttpService(this.host + ":" + this.port));
        System.out.println("Successfuly connected to " + name);
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
}
