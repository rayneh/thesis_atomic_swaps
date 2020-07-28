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
    private static final String BINARY = "608060405234801561001057600080fd5b506040516106c93803806106c9833981810160405260a081101561003357600080fd5b8151602083015160408085018051915193959294830192918464010000000082111561005e57600080fd5b90830190602082018581111561007357600080fd5b825186602082028301116401000000008211171561009057600080fd5b82525081516020918201928201910280838360005b838110156100bd5781810151838201526020016100a5565b50505050905001604052602001805160405193929190846401000000008211156100e657600080fd5b9083019060208201858111156100fb57600080fd5b825186602082028301116401000000008211171561011857600080fd5b82525081516020918201928201910280838360005b8381101561014557818101518382015260200161012d565b505050509190910160405250602090810151600080546001600160a01b03808b166001600160a01b03199283161790925560018054928a1692909116919091179055855190935061019c92506002918601906101ec565b5081516101b09060039060208501906101ec565b50600581905560408051606081018252600080825260208201819052918101919091526101e1906004906003610237565b505050505050610306565b828054828255906000526020600020908101928215610227579160200282015b8281111561022757825182559160200191906001019061020c565b506102339291506102d8565b5090565b82805482825590600052602060002090601f016020900481019282156102cc5791602002820160005b8382111561029d57835183826101000a81548160ff0219169083151502179055509260200192600101602081600001049283019260010302610260565b80156102ca5782816101000a81549060ff021916905560010160208160000104928301926001030261029d565b505b506102339291506102ed565b5b8082111561023357600081556001016102d9565b5b8082111561023357805460ff191681556001016102ee565b6103b4806103156000396000f3fe60806040526004361061004a5760003560e01c8063278ecde11461004f5780634e71d92d1461007b57806366f9a5081461009057806372abc8b714610098578063e0f2c8db146100d6575b600080fd5b34801561005b57600080fd5b506100796004803603602081101561007257600080fd5b503561010c565b005b34801561008757600080fd5b50610079610182565b610079610288565b3480156100a457600080fd5b506100c2600480360360208110156100bb57600080fd5b50356102b2565b604080519115158252519081900360200190f35b3480156100e257600080fd5b50610079600480360360608110156100f957600080fd5b50803590602081013590604001356102e8565b6000546001600160a01b0316331461012357600080fd5b600260038154811061013157fe5b906000526020600020015481111561017f57600080546040516001600160a01b03909116914780156108fc02929091818181858888f1935050505015801561017d573d6000803e3d6000fd5b505b50565b6001546001600160a01b0316331461019957600080fd5b60046000815481106101a757fe5b90600052602060002090602091828204019190069054906101000a900460ff1615156001151514801561020b575060046001815481106101e357fe5b90600052602060002090602091828204019190069054906101000a900460ff16151560011515145b80156102485750600460028154811061022057fe5b90600052602060002090602091828204019190069054906101000a900460ff16151560011515145b15610286576001546040516001600160a01b03909116904780156108fc02916000818181858888f1935050505015801561017f573d6000803e3d6000fd5b565b34670de0b6b3a76400001480156102a957506000546001600160a01b031633145b61028657600080fd5b6000600482815481106102c157fe5b90600052602060002090602091828204019190069054906101000a900460ff169050919050565b6001546001600160a01b031633146102ff57600080fd5b6002838154811061030c57fe5b90600052602060002001548110801561033b5750816003848154811061032e57fe5b9060005260206000200154145b156103795760016004848154811061034f57fe5b90600052602060002090602091828204019190066101000a81548160ff0219169083151502179055505b50505056fea2646970667358221220b8659bf5bbbcf2415f6c297f00e7775cf2708861cf7111be13d02dae30a130bf64736f6c634300060c0033";

    public static final String FUNC_CLAIM = "claim";

    public static final String FUNC_ISUNLOCKED = "isUnlocked";

    public static final String FUNC_LOCKETHER = "lockEther";

    public static final String FUNC_REFUND = "refund";

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

    public RemoteCall<TransactionReceipt> claim() {
        final Function function = new Function(
                FUNC_CLAIM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> isUnlocked(BigInteger i) {
        final Function function = new Function(
                FUNC_ISUNLOCKED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> lockEther() {
        final Function function = new Function(
                FUNC_LOCKETHER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> refund(BigInteger timeNow) {
        final Function function = new Function(
                FUNC_REFUND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(timeNow)), 
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
