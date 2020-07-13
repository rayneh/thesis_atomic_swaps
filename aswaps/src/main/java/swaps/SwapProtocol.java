package swaps;


import swaps.parties.Alice;

public class SwapProtocol {

    SwapProtocol() {
        this.init();
    }

    void init() {
        //Pool on BTC/alice chain
        Alice alice = new Alice();
        Wallet wallet = new Wallet("src\\wallets\\BtcChain(Alice)-PoolAccount-UTC--2020-05-31T08-09-53.604775500Z--6ec4922fcffd90b36aa7104c506064b4a9988a90", "pwd", "alice");

    }


}
