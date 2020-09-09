package swaps;

import java.io.IOException;

public class Evaluation {
    private Pools pools;
    private Wallet tps;
    private String tpsAddress = "0x0454ad757f4769e1648ba6ca6a8504134e32e9fe";

    Evaluation () {
        this.pools = new Pools();
        this.init();
    }

    void init() {
        this.tps = new Wallet("src\\wallets\\TPS-TestWallet-UTC--2020-09-09T14-34-51.286833900Z--0454ad757f4769e1648ba6ca6a8504134e32e9fe", "1234", "alice");
    }

    void runTPS() {
        long startTime = System.nanoTime();

        try {
            for( int i = 0; i < 10 ; i++ ) {
                this.pools.sendBitCoin(tpsAddress);
            }

            System.out.println("new balance: " + this.tps.getBalance(this.tpsAddress));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime() - startTime;
        System.out.println("time to send 10 transactions in nanos: " + endTime);

    }
}
