package swaps;

import org.web3j.protocol.core.methods.response.EthBlockNumber;

public class Connector {
    private EthNode alice;
    private EthNode bob;
    private EthNode carol;

    Connector () {
        this.init();
    }

    void init() {
        this.alice = new EthNode("Alice", "http://127.0.0.1", "8081");
        this.bob = new EthNode("Bob", "http://localhost", "8082");
        this.carol = new EthNode("Carol", "http://localhost", "8083");
    }

    EthNode getAlice() {
        return this.alice;
    }

    EthNode getBob()
    {
        return this.bob;
    }

    EthNode getCarol() {
        return this.carol;
    }

}
