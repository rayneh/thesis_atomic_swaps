package swaps;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.utils.Convert;
import swaps.contracts.generated.Swap;
import swaps.parties.Alice;
import swaps.parties.Bob;
import swaps.parties.Carol;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Digraph {
    private Alice alice;
    private Bob bob;
    private Carol carol;
    private List<byte[]> hashLocks;
    private Long[] timeLocks;
    private TimeLock timeLock;
    private Pools pools;
    private String[] contracts = new String[3];
    private Swap[] swaps = new Swap[3];

    public Digraph(Alice alice, Bob bob, Carol carol) {
        this.alice = alice;
        this.bob = bob;
        this.carol = carol;
        this.pools = new Pools();
    }

    public void init() throws IOException {
        System.out.println("generating hashlock array...");
        this.hashLocks = new ArrayList<>();
        hashLocks.add(alice.getHashLockObject().getHashLockAsByteArrayWithCurrentBlockAppended(alice.getCurrentAltCoinBlock()));
        hashLocks.add(alice.getHashLockObject().getHashLockAsByteArrayWithCurrentBlockAppended(bob.getCurrentBitcoinBlock()));
        hashLocks.add(alice.getHashLockObject().getHashLockAsByteArrayWithCurrentBlockAppended(carol.getCurrentCarTitleBlock()));

        System.out.println("HASHLOCK ARRAY -> " + hashLocks.toString());

        System.out.println("generating timelock array...");
        this.timeLock = new TimeLock(5L, 10L);
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
        System.out.println("alice is deploying contract on alt coin chain: ");
        // String _party, String _counterParty, List<BigInteger> _timeLock, List<byte[]> _hashLock, BigInteger _start
        contracts[0] = this.alice.deploySwapContractOnAltCoinChain(this.alice.getAddressAltCoinWallet(), this.bob.addressAltCoinWallet, SwapUtils.convertLongArrayToBigIntegerList(this.timeLocks), this.hashLocks, this.timeLock.getStartAsBigInteger());
        System.out.println("alice's contract address on alt coin chain: " + contracts[0]);
        //altCoinPool.sendEtherTransaction(altCoinPool.getNonce("0x2193259b178623345225272dd075717fcacc704e"), altCoinPool.gasPrice("1"), altCoinPool.gasLimit(21000L), alice.addressAltCoinWallet, "1");

        String transactionReceipt = this.alice.getAltCoinWallet().sendEtherTransaction(this.alice.getAltCoinWallet().getNonce(this.alice.addressAltCoinWallet),
                this.alice.getAltCoinWallet().gasPrice("1"),
                this.alice.getAltCoinWallet().gasLimit(21000L),
                contracts[0], "1");

        //swaps[0] = this.alice.getAltCoinWallet().getSwapInstance(contracts[0]);       //BAD, doesnt send 1 ether!!!
        //TransactionReceipt receipts = swaps[0].lockEther().send();      //Convert.toWei("1", Convert.Unit.ETHER).toBigInteger()


        this.alice.getAltCoinWallet().waitForTransactionToBeMined(transactionReceipt);

        System.out.println("sent funds to contract, TX: " + transactionReceipt);
    }

    public void bobPublishContractOnBtcChain() throws Exception {
        System.out.println("bob is deploying contract on bitcoin chain: ");
        contracts[1] = this.bob.deploySwapContractOnBitCoinChain(this.bob.addressBitcoinWallet, this.carol.addressBitcoinWallet, SwapUtils.convertLongArrayToBigIntegerList(this.timeLocks), this.hashLocks, this.timeLock.getStartAsBigInteger());
        System.out.println("bob's contract address on bitcoin chain: " + contracts[1]);

        String transactionReceipt = this.bob.getBitcoinWallet().sendEtherTransaction(this.bob.getBitcoinWallet().getNonce(this.bob.addressBitcoinWallet),
                this.bob.getBitcoinWallet().gasPrice("1"),
                this.bob.getBitcoinWallet().gasLimit(21000L),
                contracts[1], "1");

        this.bob.getBitcoinWallet().waitForTransactionToBeMined(transactionReceipt);
        System.out.println("sent funds to contract, TX: " + transactionReceipt);
    }

    public void carolPublishContractOnCarTitleChain() throws Exception {
        System.out.println("carol is deploying contract on car title chain: ");
        contracts[2] = this.carol.deploySwapContractOnCarTitleChain(this.carol.addressCarTitleWallet, this.alice.addressCarTitleWallet, SwapUtils.convertLongArrayToBigIntegerList(this.timeLocks), this.hashLocks, this.timeLock.getStartAsBigInteger());
        System.out.println("carol's contract address on car title chain: " + contracts[2]);

        String transactionReceipt = this.carol.getCarTitleWallet().sendEtherTransaction(this.carol.getCarTitleWallet().getNonce(this.carol.addressCarTitleWallet),
                this.carol.getCarTitleWallet().gasPrice("1"),
                this.carol.getCarTitleWallet().gasLimit(21000L),
                contracts[2], "1");

        this.carol.getCarTitleWallet().waitForTransactionToBeMined(transactionReceipt);
        System.out.println("sent funds to contract, TX: " + transactionReceipt);
    }

    public void aliceUnlockArcs() throws Exception {
        //TODO: unlock hashlocks and timelocks here!!       //TODO: alice gets new swap instance of carol's contract, then unlocks and claims!!

        //swaps[0].unlock(BigInteger.valueOf(0L), hashLocks.get(0), BigInteger.valueOf(timeLocks[0])).send();
        //swaps[0].unlock(BigInteger.valueOf(1L), hashLocks.get(1), BigInteger.valueOf(timeLocks[1])).send();
        //swaps[0].unlock(BigInteger.valueOf(2L), hashLocks.get(2), BigInteger.valueOf(timeLocks[2])).send();


        //swaps[0].claim().send();

        Swap swap = this.alice.getCarTitleWallet().getSwapInstance(contracts[2]);
        swap.unlock(BigInteger.valueOf(0L), hashLocks.get(0), BigInteger.valueOf(timeLocks[0])).send();
        swap = this.alice.getCarTitleWallet().getSwapInstance(contracts[2]);
        swap.unlock(BigInteger.valueOf(1L), hashLocks.get(1), BigInteger.valueOf(timeLocks[1])).send();
        swap = this.alice.getCarTitleWallet().getSwapInstance(contracts[2]);
        swap.unlock(BigInteger.valueOf(2L), hashLocks.get(2), BigInteger.valueOf(timeLocks[2])).send(); //TODO: try to get balance of contarcts address


        //swap = this.alice.getCarTitleWallet().getSwapInstance(contracts[2]);
        //System.out.println(swap.isUnlocked(BigInteger.valueOf(0L)).send());
        //System.out.println(swap.isUnlocked(BigInteger.valueOf(1L)).send());
        //System.out.println(swap.isUnlocked(BigInteger.valueOf(2L)).send());
        swap = this.alice.getCarTitleWallet().getSwapInstance(contracts[2]);
        swap.claim().send();    //TODO: claim doesnt work yet!!


    }

    public void bobUnlockArcs() throws Exception {
        //TODO: unlock hashlocks and timelocks here!!
    }

    public void carolUnlockArcs() throws Exception {
        //TODO: unlock hashlocks and timelocks here!!
    }

    public void aliceClaimCarTitle() throws Exception {
        //TODO: alice claims the car title and sends secret to carol! Also unlock witht he hashlocks!
        this.aliceUnlockArcs();
    }

    public void bobClaimAltCoin() throws Exception {
        //TODO: bob claims the alt coins and swap finished! Also unlock witht he hashlocks!
        this.bobUnlockArcs();
    }

    public void carolClaimBtc() throws Exception {
        //TODO:  carol claims the bitcoin and sends secret to bob! Also unlock witht he hashlocks!
        this.carolUnlockArcs();
    }

    public void updateSwapInstances() {
        System.out.println("updating swap instances ...");

        //swaps[0] = this.pools.getAltCoinPool().getSwapInstance(contracts[0]);
        swaps[0] = this.alice.getAltCoinWallet().getSwapInstance(contracts[0]);
        //swaps[1] = this.pools.getBitcoinPool().getSwapInstance(contracts[1]);
        swaps[1] = this.bob.getBitcoinWallet().getSwapInstance(contracts[1]);
        //swaps[2] = this.pools.getCarTitlePool().getSwapInstance(contracts[2]);
        swaps[2] = this.carol.getCarTitleWallet().getSwapInstance(contracts[2]);

        System.out.println("updated instances: " + swaps[0].toString() + swaps[1].toString() + swaps[2].toString());
    }

    public void printBalances() throws IOException {
        alice.getBalanceOnCarTitleChain();
        alice.getBalanceOnAltCoinChain();
        System.out.println("      -");
        bob.getBalanceOnCarTitleChain();
        bob.getBalanceOnAltCoinChain();
        System.out.println("      -");
        carol.getBalanceOnBitCoinChain();
        carol.getBalanceOnCarTitleChain();
        System.out.println("      -");
    }

    public Pools getPools() {
        return this.pools;
    }
}
