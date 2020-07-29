package swaps;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.response.PollingTransactionReceiptProcessor;
import org.web3j.tx.response.TransactionReceiptProcessor;
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
        contracts[0] = this.alice.deploySwapContractOnAltCoinChain(this.alice.getAddressAltCoinWallet(), this.bob.addressAltCoinWallet, this.convertLongArrayToBigIntegerList(this.timeLocks), this.hashLocks, this.timeLock.getStartAsBigInteger());
        System.out.println("alice's contract address on alt coin chain: " + contracts[0]);

        String transactionReceipt = this.alice.getAltCoinWallet().sendEtherTransaction(this.alice.getAltCoinWallet().getNonce(this.alice.addressAltCoinWallet),
                this.alice.getAltCoinWallet().gasPrice("1"),
                this.alice.getAltCoinWallet().gasLimit(21000L),
                contracts[0], "1");

        this.alice.getAltCoinWallet().waitForTransactionToBeMined(transactionReceipt);

        System.out.println("sent funds to contract, TX: " + transactionReceipt);
    }

    public void bobPublishContractOnBtcChain() throws Exception {
        System.out.println("bob is deploying contract on bitcoin chain: ");
        contracts[1] = this.bob.deploySwapContractOnBitCoinChain(this.bob.addressBitcoinWallet, this.carol.addressBitcoinWallet, this.convertLongArrayToBigIntegerList(this.timeLocks), this.hashLocks, this.timeLock.getStartAsBigInteger());
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
        contracts[2] = this.carol.deploySwapContractOnCarTitleChain(this.carol.addressCarTitleWallet, this.alice.addressCarTitleWallet, this.convertLongArrayToBigIntegerList(this.timeLocks), this.hashLocks, this.timeLock.getStartAsBigInteger());
        System.out.println("carol's contract address on car title chain: " + contracts[2]);

        String transactionReceipt = this.carol.getCarTitleWallet().sendEtherTransaction(this.carol.getCarTitleWallet().getNonce(this.carol.addressCarTitleWallet),
                this.carol.getCarTitleWallet().gasPrice("1"),
                this.carol.getCarTitleWallet().gasLimit(21000L),
                contracts[2], "1");

        this.carol.getCarTitleWallet().waitForTransactionToBeMined(transactionReceipt);
        System.out.println("sent funds to contract, TX: " + transactionReceipt);
    }

    public void aliceClaimCarTitle() throws Exception {
        System.out.println("alice unlocking car title contract ...");

        Swap swap = this.alice.getCarTitleWallet().getSwapInstance(contracts[2]);
        swap.unlock(BigInteger.valueOf(0L), hashLocks.get(0), BigInteger.valueOf(timeLocks[0])).send();
        swap = this.alice.getCarTitleWallet().getSwapInstance(contracts[2]);
        swap.unlock(BigInteger.valueOf(1L), hashLocks.get(1), BigInteger.valueOf(timeLocks[1])).send();
        swap = this.alice.getCarTitleWallet().getSwapInstance(contracts[2]);
        swap.unlock(BigInteger.valueOf(2L), hashLocks.get(2), BigInteger.valueOf(timeLocks[2])).send();

        System.out.println("BALANCE CONTRACT ADDRESS -> car title chain: " + this.alice.getCarTitleWallet().getBalance(contracts[2]));

        swap = this.alice.getCarTitleWallet().getSwapInstance(contracts[2]);         //TODO: claim works, as internal transaction tho, which is not visible on the balance!!

        String txHash = swap.claim().send().getTransactionHash();
        TransactionReceiptProcessor receiptProcessor = new PollingTransactionReceiptProcessor(this.alice.getCarTitleWallet().getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY, TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

        TransactionReceipt txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
        System.out.println("alice called claim() function to claim car title: " + txReceipt.toString());

        this.pools.sendCarTitle(this.alice.addressCarTitleWallet);
    }

    public void carolClaimBtc() throws Exception {
        System.out.println("carol unlocking bitcoin contract ...");

        Swap swap = this.carol.getBitcoinWallet().getSwapInstance(contracts[1]);
        swap.unlock(BigInteger.valueOf(0L), hashLocks.get(0), BigInteger.valueOf(timeLocks[0])).send();
        swap = this.carol.getBitcoinWallet().getSwapInstance(contracts[1]);
        swap.unlock(BigInteger.valueOf(1L), hashLocks.get(1), BigInteger.valueOf(timeLocks[1])).send();
        swap = this.carol.getBitcoinWallet().getSwapInstance(contracts[1]);
        swap.unlock(BigInteger.valueOf(2L), hashLocks.get(2), BigInteger.valueOf(timeLocks[2])).send();

        System.out.println("BALANCE CONTRACT ADDRESS -> bit coin chain: " + this.carol.getBitcoinWallet().getBalance(contracts[1]));

        swap = this.carol.getBitcoinWallet().getSwapInstance(contracts[1]);         //TODO: claim works, as internal transaction tho, which is not visible on the balance!!

        String txHash = swap.claim().send().getTransactionHash();

        TransactionReceiptProcessor receiptProcessor = new PollingTransactionReceiptProcessor(this.carol.getBitcoinWallet().getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY, TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

        TransactionReceipt txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
        System.out.println("carol called claim() function to claim btc: " + txReceipt.toString());

        this.pools.sendBitCoin(this.carol.addressBitcoinWallet);
    }

    public void bobClaimAltCoin() throws Exception {
        System.out.println("bob unlocking alt coin contract ...");

        Swap swap = this.bob.getAltCoinWallet().getSwapInstance(contracts[0]);
        swap.unlock(BigInteger.valueOf(0L), hashLocks.get(0), BigInteger.valueOf(timeLocks[0])).send();
        swap = this.bob.getAltCoinWallet().getSwapInstance(contracts[0]);
        swap.unlock(BigInteger.valueOf(1L), hashLocks.get(1), BigInteger.valueOf(timeLocks[1])).send();
        swap = this.bob.getAltCoinWallet().getSwapInstance(contracts[0]);
        swap.unlock(BigInteger.valueOf(2L), hashLocks.get(2), BigInteger.valueOf(timeLocks[2])).send();

        System.out.println("BALANCE CONTRACT ADDRESS -> alt coin chain: " + this.bob.getAltCoinWallet().getBalance(contracts[0]));

        swap = this.bob.getAltCoinWallet().getSwapInstance(contracts[0]);       //TODO: claim works, as internal transaction tho, which is not visible on the balance!!

        String txHash = swap.claim().send().getTransactionHash();

        TransactionReceiptProcessor receiptProcessor = new PollingTransactionReceiptProcessor(this.bob.getAltCoinWallet().getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY, TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

        TransactionReceipt txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
        System.out.println("bob called claim() function to claim altcoin: " + txReceipt.toString());

        this.pools.sendAltCoin(this.bob.addressAltCoinWallet);
    }

    public void printBalances() throws IOException {
        System.out.println("      -");
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

    public List<BigInteger> convertLongArrayToBigIntegerList(Long[] data) {
        List<BigInteger> list = new ArrayList<>(data.length);

        for(long num : data) {
            list.add(BigInteger.valueOf(num));
        }

        return list;
    }
}
