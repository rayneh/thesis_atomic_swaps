package swaps.contracts.generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class Swap extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516106323803806106328339810160409081528151602080840151928401516060850151608086015160008054600160a060020a03808816600160a060020a0319928316179092556001805492891692909116919091179055918601805194969094910192610087916002918601906100d7565b50815161009b906003906020850190610122565b50600581905560408051606081018252600080825260208201819052918101919091526100cc90600490600361015f565b50505050505061023b565b828054828255906000526020600020908101928215610112579160200282015b828111156101125782518255916020019190600101906100f7565b5061011e929150610200565b5090565b828054828255906000526020600020908101928215610112579160200282015b828111156101125782518255602090920191600190910190610142565b82805482825590600052602060002090601f016020900481019282156101f45791602002820160005b838211156101c557835183826101000a81548160ff0219169083151502179055509260200192600101602081600001049283019260010302610188565b80156101f25782816101000a81549060ff02191690556001016020816000010492830192600103026101c5565b505b5061011e92915061021d565b61021a91905b8082111561011e5760008155600101610206565b90565b61021a91905b8082111561011e57805460ff19168155600101610223565b6103e88061024a6000396000f30060806040526004361061006c5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663278ecde181146100715780634e71d92d1461008b57806366f9a508146100a057806372abc8b7146100a8578063e0f2c8db146100d4575b600080fd5b34801561007d57600080fd5b506100896004356100f2565b005b34801561009757600080fd5b50610089610184565b6100896102a8565b3480156100b457600080fd5b506100c06004356102da565b604080519115158252519081900360200190f35b3480156100e057600080fd5b50610089600435602435604435610312565b60005473ffffffffffffffffffffffffffffffffffffffff16331461011657600080fd5b60028054600390811061012557fe5b9060005260206000200154811115610181576000805460405173ffffffffffffffffffffffffffffffffffffffff90911691303180156108fc02929091818181858888f1935050505015801561017f573d6000803e3d6000fd5b505b50565b60015473ffffffffffffffffffffffffffffffffffffffff1633146101a857600080fd5b6004805460009081106101b757fe5b90600052602060002090602091828204019190069054906101000a900460ff1615156001151514801561021c57506004805460019081106101f457fe5b90600052602060002090602091828204019190069054906101000a900460ff16151560011515145b801561025a575060048054600290811061023257fe5b90600052602060002090602091828204019190069054906101000a900460ff16151560011515145b156102a65760015460405173ffffffffffffffffffffffffffffffffffffffff90911690303180156108fc02916000818181858888f19350505050158015610181573d6000803e3d6000fd5b565b3460011480156102cf575060005473ffffffffffffffffffffffffffffffffffffffff1633145b15156102a657600080fd5b60006004828154811015156102eb57fe5b90600052602060002090602091828204019190069054906101000a900460ff169050919050565b60015473ffffffffffffffffffffffffffffffffffffffff16331461033657600080fd5b600280548490811061034457fe5b9060005260206000200154811080156103775750600380548391908590811061036957fe5b600091825260209091200154145b156103b757600160048481548110151561038d57fe5b90600052602060002090602091828204019190066101000a81548160ff0219169083151502179055505b5050505600a165627a7a7230582089606bd0553d0cac82e874b9e2fd6121ea32d890ccec0661bb58611bb7f4e9ea0029";

    public static final String FUNC_REFUND = "refund";

    public static final String FUNC_CLAIM = "claim";

    public static final String FUNC_LOCKETHER = "lockEther";

    public static final String FUNC_ISUNLOCKED = "isUnlocked";

    public static final String FUNC_UNLOCK = "unlock";

    @Deprecated
    protected Swap(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Swap(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Swap(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Swap(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> refund(BigInteger timeNow) {
        final Function function = new Function(
                FUNC_REFUND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(timeNow)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> claim() {
        final Function function = new Function(
                FUNC_CLAIM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> lockEther(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_LOCKETHER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> isUnlocked(BigInteger i) {
        final Function function = new Function(
                FUNC_ISUNLOCKED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> unlock(BigInteger i, byte[] hashLock, BigInteger timeNow) {
        final Function function = new Function(
                FUNC_UNLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(i), 
                new org.web3j.abi.datatypes.generated.Bytes32(hashLock), 
                new org.web3j.abi.datatypes.generated.Uint256(timeNow)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Swap load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Swap(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Swap load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Swap(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Swap load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Swap(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Swap load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Swap(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Swap> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _party, String _counterParty, List<BigInteger> _timeLock, List<byte[]> _hashLock, BigInteger _start) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_party), 
                new org.web3j.abi.datatypes.Address(_counterParty), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_timeLock, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_hashLock, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_start)));
        return deployRemoteCall(Swap.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Swap> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _party, String _counterParty, List<BigInteger> _timeLock, List<byte[]> _hashLock, BigInteger _start) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_party), 
                new org.web3j.abi.datatypes.Address(_counterParty), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_timeLock, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_hashLock, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_start)));
        return deployRemoteCall(Swap.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Swap> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _party, String _counterParty, List<BigInteger> _timeLock, List<byte[]> _hashLock, BigInteger _start) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_party), 
                new org.web3j.abi.datatypes.Address(_counterParty), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_timeLock, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_hashLock, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_start)));
        return deployRemoteCall(Swap.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Swap> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _party, String _counterParty, List<BigInteger> _timeLock, List<byte[]> _hashLock, BigInteger _start) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_party), 
                new org.web3j.abi.datatypes.Address(_counterParty), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_timeLock, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_hashLock, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_start)));
        return deployRemoteCall(Swap.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
