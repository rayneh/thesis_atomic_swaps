package swaps;

import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.utils.Convert;
import swaps.EthNode;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Web3jApi {
    private EthNode node;

    Web3jApi(EthNode node) {
        this.node = node;
    }

    String getName() {
        return this.node.getName();
    }

    BigInteger getBlockNumber() throws IOException {
        EthBlockNumber ethBlockNumber = this.node.getBlockNumber();
        return ethBlockNumber.getBlockNumber();
    }

    BigInteger ethGetBalance(String address) throws IOException {
        return node.getWeb3j().ethGetBalance(address, DefaultBlockParameterName.LATEST).send().getBalance();
    }

    BigDecimal ethGetBalanceToken(String address) throws IOException {
        return Convert.fromWei(String.valueOf(node.getWeb3j().ethGetBalance(address, DefaultBlockParameterName.LATEST).send().getBalance()), Convert.Unit.ETHER);
    }
}
