package swaps;

import swaps.parties.Alice;
import swaps.parties.Bob;
import swaps.parties.Carol;
import java.util.Arrays;


public class SwapProtocol {
    Alice alice;
    Bob bob = new Bob();
    Carol carol = new Carol();

    Digraph digraph;

    SwapProtocol() {
        this.init();
    }

    void init() {

        try {
            this.alice = new Alice();

            /*System.out.println("h = H(s): " + alice.getHashLockAsHex());
            System.out.println("h = H(s): " + alice.getHashLockAsHex());

            System.out.println("h = H(s): " + Arrays.toString(alice.getHashLockAsByteArray()));
            System.out.println("h = H(s): " + Arrays.toString(alice.getHashLockAsByteArray()));

            System.out.println("h = H(s) -> encoded: " + alice.getEncodedHash());
            System.out.println("h = H(s) -> encoded: " + alice.getEncodedHash());

            System.out.println(SwapUtils.isMessageDigestByteEqual(alice.getHashLockAsByteArray(), alice.getHashLockAsByteArray()));

            TimeLock timeLock = new TimeLock(2L, 3L);
            System.out.println("start time: " + timeLock.getStartInMilliSeconds());
            System.out.println("time contracts: " + timeLock.getTimeToDeployContractsInMilliSeconds());
            System.out.println("time funds: " + timeLock.getTimeToSendFundsInMilliSeconds());
            System.out.println("time now: " + timeLock.getTimeNowInMilliSeconds());

            Long[] timeLocks = timeLock.getTimeLockArray();
            System.out.println("TIMELOCK ARRAY -> " + timeLocks[0] + " " + timeLocks[1] + " " + timeLocks[2]);*/
            //alice.getAltCoinWallet().getNonce(alice.addressAltCoinWallet);
            //System.out.println(alice.getAltCoinWallet().getNonce(alice.addressAltCoinWallet)); //PRINT NONCE
            //System.out.println(alice.getAltCoinWallet().convertToWei("1")); //amount to send

            //testaddress   ->    "0x01d091a2bcce9fcc71d1e4c8d83113ca9d150e26"
            //System.out.println("SENDING FUNDS TO TEST ADDRESS");
            //String tx = bitcoinPool.sendEtherTransaction(bitcoinPool.getNonce("0x6ec4922fcffd90b36aa7104c506064b4a9988a90"), bitcoinPool.gasPrice("1"), bitcoinPool.gasLimit(21000L), "0x01d091a2bcce9fcc71d1e4c8d83113ca9d150e26", "1");
            //System.out.println(tx);
            //System.out.println(bitcoinPool.getBalance("0x01d091a2bcce9fcc71d1e4c8d83113ca9d150e26"));



            /*System.out.println("current alt-coin block: " + alice.getCurrentAltCoinBlock());
            System.out.println("current bitcoin block: " + bob.getCurrentBitcoinBlock());
            System.out.println("current car title block: " + carol.getCurrentCarTitleBlock());

            System.out.println("hashlock[0] encoded: " + alice.getHashLockObject().getEncodedHashLockWithCurrentBlockAppended(alice.getCurrentAltCoinBlock()));
            System.out.println("hashlock[1] encoded: " + alice.getHashLockObject().getEncodedHashLockWithCurrentBlockAppended(bob.getCurrentBitcoinBlock()));
            System.out.println("hashlock[2] encoded: " + alice.getHashLockObject().getEncodedHashLockWithCurrentBlockAppended(carol.getCurrentCarTitleBlock()));

            String[] hashLocks = new String[3];         // hashlock array for contracts
            hashLocks[0] = alice.getHashLockObject().getEncodedHashLockWithCurrentBlockAppended(alice.getCurrentAltCoinBlock());
            hashLocks[1] = alice.getHashLockObject().getEncodedHashLockWithCurrentBlockAppended(bob.getCurrentBitcoinBlock());
            hashLocks[2] = alice.getHashLockObject().getEncodedHashLockWithCurrentBlockAppended(carol.getCurrentCarTitleBlock());

            System.out.println("HASHLOCK ARRAY -> " + hashLocks[0] + " " + hashLocks[1] + " " + hashLocks[2]);*/

            // creating hashlock with wrong secret
            //HashLock hashLock = new HashLock("iaaaa");
            //System.out.println("hashlock[0] with wrong secret: " + hashLock.getEncodedHashLockWithCurrentBlockAppended(alice.getCurrentAltCoinBlock()));


            System.out.println("init..");
            this.digraph = new Digraph(alice, bob, carol);

            this.digraph.getPools().printPoolBalances();
            this.digraph.printBalances();

            this.digraph.getPools().prepareTrade(alice, bob, carol);      //TODO: prepares trade! only run once before the swap
            this.digraph.printBalances();

            this.digraph.init();
            this.digraph.triggerPath("AB");
            this.digraph.triggerPath("BA");
            this.digraph.triggerPath("CC");

            this.digraph.printBalances();

            this.digraph.triggerPath("AC");
            this.digraph.triggerPath("CA");
            this.digraph.triggerPath("BB");

            this.digraph.printBalances();





        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
