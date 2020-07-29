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
    private static final String BINARY = "608060405234801561001057600080fd5b506040516106bc3803806106bc833981810160405260a081101561003357600080fd5b8151602083015160408085018051915193959294830192918464010000000082111561005e57600080fd5b90830190602082018581111561007357600080fd5b825186602082028301116401000000008211171561009057600080fd5b82525081516020918201928201910280838360005b838110156100bd5781810151838201526020016100a5565b50505050905001604052602001805160405193929190846401000000008211156100e657600080fd5b9083019060208201858111156100fb57600080fd5b825186602082028301116401000000008211171561011857600080fd5b82525081516020918201928201910280838360005b8381101561014557818101518382015260200161012d565b505050509190910160405250602090810151600080546001600160a01b03808b166001600160a01b03199283161790925560018054928a1692909116919091179055855190935061019c92506002918601906101ec565b5081516101b09060039060208501906101ec565b50600581905560408051606081018252600080825260208201819052918101919091526101e1906004906003610237565b505050505050610306565b828054828255906000526020600020908101928215610227579160200282015b8281111561022757825182559160200191906001019061020c565b506102339291506102d8565b5090565b82805482825590600052602060002090601f016020900481019282156102cc5791602002820160005b8382111561029d57835183826101000a81548160ff0219169083151502179055509260200192600101602081600001049283019260010302610260565b80156102ca5782816101000a81549060ff021916905560010160208160000104928301926001030261029d565b505b506102339291506102ed565b5b8082111561023357600081556001016102d9565b5b8082111561023357805460ff191681556001016102ee565b6103a7806103156000396000f3fe60806040526004361061004a5760003560e01c8063278ecde11461004f5780634e71d92d1461007b57806366f9a5081461008357806372abc8b71461008b578063e0f2c8db146100c9575b600080fd5b34801561005b57600080fd5b506100796004803603602081101561007257600080fd5b50356100ff565b005b610079610175565b61007961027b565b34801561009757600080fd5b506100b5600480360360208110156100ae57600080fd5b50356102a5565b604080519115158252519081900360200190f35b3480156100d557600080fd5b50610079600480360360608110156100ec57600080fd5b50803590602081013590604001356102db565b6000546001600160a01b0316331461011657600080fd5b600260038154811061012457fe5b906000526020600020015481111561017257600080546040516001600160a01b03909116914780156108fc02929091818181858888f19350505050158015610170573d6000803e3d6000fd5b505b50565b6001546001600160a01b0316331461018c57600080fd5b600460008154811061019a57fe5b90600052602060002090602091828204019190069054906101000a900460ff161515600115151480156101fe575060046001815481106101d657fe5b90600052602060002090602091828204019190069054906101000a900460ff16151560011515145b801561023b5750600460028154811061021357fe5b90600052602060002090602091828204019190069054906101000a900460ff16151560011515145b15610279576001546040516001600160a01b03909116904780156108fc02916000818181858888f19350505050158015610172573d6000803e3d6000fd5b565b34670de0b6b3a764000014801561029c57506000546001600160a01b031633145b61027957600080fd5b6000600482815481106102b457fe5b90600052602060002090602091828204019190069054906101000a900460ff169050919050565b6001546001600160a01b031633146102f257600080fd5b600283815481106102ff57fe5b90600052602060002001548110801561032e5750816003848154811061032157fe5b9060005260206000200154145b1561036c5760016004848154811061034257fe5b90600052602060002090602091828204019190066101000a81548160ff0219169083151502179055505b50505056fea26469706673582212206bdbc23be0f98aef31d59e26c0b2f74169d5cc10b767e2fd40800d8bdaf4c65864736f6c634300060c0033";

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

    public RemoteCall<TransactionReceipt> isUnlocked(BigInteger _i) {
        final Function function = new Function(
                FUNC_ISUNLOCKED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_i)), 
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

    public RemoteCall<TransactionReceipt> refund(BigInteger _timeNow) {
        final Function function = new Function(
                FUNC_REFUND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_timeNow)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> unlock(BigInteger _i, byte[] _hashLock, BigInteger _timeNow) {
        final Function function = new Function(
                FUNC_UNLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_i), 
                new org.web3j.abi.datatypes.generated.Bytes32(_hashLock), 
                new org.web3j.abi.datatypes.generated.Uint256(_timeNow)), 
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
