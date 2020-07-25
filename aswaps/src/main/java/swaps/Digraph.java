package swaps;

import swaps.parties.Alice;
import swaps.parties.Bob;
import swaps.parties.Carol;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Digraph {
    private Alice alice;
    private Bob bob;
    private Carol carol;
    private String[] hashLocks;
    private Long[] timeLocks;
    private TimeLock timeLock;

    public Digraph(Alice alice, Bob bob, Carol carol) {
        this.alice = alice;
        this.bob = bob;
        this.carol = carol;
    }

    public void init() throws IOException {
        System.out.println("generating hashlock array...");
        this.hashLocks = new String[3];
        hashLocks[0] = alice.getHashLockObject().getEncodedHashLockWithCurrentBlockAppended(alice.getCurrentAltCoinBlock());
        hashLocks[1] = alice.getHashLockObject().getEncodedHashLockWithCurrentBlockAppended(bob.getCurrentBitcoinBlock());
        hashLocks[2] = alice.getHashLockObject().getEncodedHashLockWithCurrentBlockAppended(carol.getCurrentCarTitleBlock());
        System.out.println("HASHLOCK ARRAY -> " + hashLocks[0] + " " + hashLocks[1] + " " + hashLocks[2]);

        System.out.println("generating timelock array...");
        this.timeLock = new TimeLock(2L, 3L);
        this.timeLocks = timeLock.getTimeLockArray();
        System.out.println("TIMELOCK ARRAY -> " + timeLocks[0] + " " + timeLocks[1] + " " + timeLocks[2]);
    }

    public void triggerPath(String path) throws Exception {
        switch (path) {
            case "AB":
                this.alicePublishContractOnAltCoinChain();
                break;
            case "BA":
                this.bobPublishContractOnBtcChain();
                break;
            case "CC":
                this.carolPublishContractOnCarTitleChain();
                break;
            case "AC":
                this.aliceClaimCarTitle();
                break;
            case "CA":
                this.carolClaimBtc();
                break;
            case "BB":
                this.bobClaimAltCoin();
                break;
            default:
                System.out.println("PATH UNKNOWN");
                break;
        }
    }

    public void alicePublishContractOnAltCoinChain() throws Exception {
        //TODO: alice publishes contract on alt-coin chain and locks her funds!

        // String _party, String _counterParty, List<BigInteger> _timeLock, List<byte[]> _hashLock, BigInteger _start
        this.alice.deploySwapContractOnAltCoinChain(this.alice.getAddressAltCoinWallet(), this.bob.addressAltCoinWallet, SwapUtils.convertLongArrayToBigIntegerList(this.timeLocks), SwapUtils.convertStringArrayToByteArrayList(this.hashLocks), this.timeLock.getStartAsBigInteger());
    }

    public void bobPublishContractOnBtcChain() {
        //TODO: bob publishes contract on btc chain and locks his funds!
    }

    public void carolPublishContractOnCarTitleChain() {
        //TODO: carol publishes contract on car title chains and locks her funds!
    }

    public void aliceClaimCarTitle() {
        //TODO: alice claims the car title and sends secret to carol!
    }

    public void carolClaimBtc() {
        //TODO:  carol claims the bitcoin and sends secret to bob!
    }

    public void bobClaimAltCoin() {
        //TODO: bob claims the alt coins and swap finished!
    }
}
