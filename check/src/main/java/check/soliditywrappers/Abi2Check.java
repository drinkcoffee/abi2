package check.soliditywrappers;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
 * <p>Generated with web3j version 4.7.0-SNAPSHOT.
 */
@SuppressWarnings("rawtypes")
public class Abi2Check extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610315806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c80631f92c32c1461003b57806329c5334f14610050575b600080fd5b61004e610049366004610217565b610063565b005b61004e61005e3660046101a8565b61010c565b6000805160206102c083398151915281356100816020840184610271565b604051610095939250600090600290610256565b60405180910390a160005b6100ad6020830183610271565b9050811015610108576000805160206102c0833981519152816100d36020850185610271565b848181106100dd57fe5b90506020020135600060036040516100f89493929190610256565b60405180910390a16001016100a0565b5050565b6040516000805160206102c0833981519152906101329083906000908190600190610256565b60405180910390a160005b818110801561014c5750600581105b156101a3576000805160206102c08339815191528184848481811061016d57fe5b905060200281019061017f9190610271565b604051610193939250600090600290610256565b60405180910390a160010161013d565b505050565b600080602083850312156101ba578182fd5b823567ffffffffffffffff808211156101d1578384fd5b818501915085601f8301126101e4578384fd5b8135818111156101f2578485fd5b8660208083028501011115610205578485fd5b60209290920196919550909350505050565b600060208284031215610228578081fd5b813567ffffffffffffffff81111561023e578182fd5b82016040818503121561024f578182fd5b9392505050565b93845260208401929092526040830152606082015260800190565b6000808335601e19843603018112610287578283fd5b83018035915067ffffffffffffffff8211156102a1578283fd5b60209081019250810236038213156102b857600080fd5b925092905056fee5b286ee80c4f7811cec734b866242d61e30147d0b204f87684a2418d138d78fa264697066735822122044a63b5ba4d160b13bc082626415f6b24f94257ef498c0031016d82f10ed52de64736f6c63430007040033";

    public static final String FUNC_ARRAYARRAY = "arrayArray";

    public static final String FUNC_STRUCTWITHARRAY = "structWithArray";

    public static final Event ASTRODUMP_EVENT = new Event("AstroDump", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event DUMP_EVENT = new Event("Dump", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    @Deprecated
    protected Abi2Check(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Abi2Check(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Abi2Check(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Abi2Check(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AstroDumpEventResponse> getAstroDumpEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ASTRODUMP_EVENT, transactionReceipt);
        ArrayList<AstroDumpEventResponse> responses = new ArrayList<AstroDumpEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AstroDumpEventResponse typedResponse = new AstroDumpEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._val1 = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._val2 = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._val3 = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._val4 = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AstroDumpEventResponse> astroDumpEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AstroDumpEventResponse>() {
            @Override
            public AstroDumpEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ASTRODUMP_EVENT, log);
                AstroDumpEventResponse typedResponse = new AstroDumpEventResponse();
                typedResponse.log = log;
                typedResponse._val1 = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._val2 = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._val3 = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._val4 = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AstroDumpEventResponse> astroDumpEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ASTRODUMP_EVENT));
        return astroDumpEventFlowable(filter);
    }

    public List<DumpEventResponse> getDumpEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DUMP_EVENT, transactionReceipt);
        ArrayList<DumpEventResponse> responses = new ArrayList<DumpEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DumpEventResponse typedResponse = new DumpEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._val1 = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._val2 = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._val3 = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._val4 = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DumpEventResponse> dumpEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DumpEventResponse>() {
            @Override
            public DumpEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DUMP_EVENT, log);
                DumpEventResponse typedResponse = new DumpEventResponse();
                typedResponse.log = log;
                typedResponse._val1 = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._val2 = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._val3 = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._val4 = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DumpEventResponse> dumpEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DUMP_EVENT));
        return dumpEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> arrayArray(List<List<BigInteger>> _param) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ARRAYARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicArray>(
                        org.web3j.abi.datatypes.DynamicArray.class,
                        org.web3j.abi.Utils.typeMap(_param, org.web3j.abi.datatypes.DynamicArray.class,
                org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public String getRLP_arrayArray(List<List<BigInteger>> _param) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ARRAYARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicArray>(
                        org.web3j.abi.datatypes.DynamicArray.class,
                        org.web3j.abi.Utils.typeMap(_param, org.web3j.abi.datatypes.DynamicArray.class,
                org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return org.web3j.abi.FunctionEncoder.encode(function);
    }

    public RemoteFunctionCall<TransactionReceipt> structWithArray(Astro _param) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_STRUCTWITHARRAY, 
                Arrays.<Type>asList(_param), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public String getRLP_structWithArray(Astro _param) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_STRUCTWITHARRAY, 
                Arrays.<Type>asList(_param), 
                Collections.<TypeReference<?>>emptyList());
        return org.web3j.abi.FunctionEncoder.encode(function);
    }

    @Deprecated
    public static Abi2Check load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Abi2Check(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Abi2Check load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Abi2Check(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Abi2Check load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Abi2Check(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Abi2Check load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Abi2Check(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Abi2Check> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Abi2Check.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Abi2Check> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Abi2Check.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Abi2Check> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Abi2Check.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Abi2Check> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Abi2Check.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class Astro extends DynamicStruct {
        public BigInteger val1;

        public List<BigInteger> val2;

        public Astro(BigInteger val1, List<BigInteger> val2) {
            super(new org.web3j.abi.datatypes.generated.Uint256(val1),new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(org.web3j.abi.datatypes.generated.Uint256.class, org.web3j.abi.Utils.convertTo_uint256(val2)));
            this.val1 = val1;
            this.val2 = val2;
        }

        public Astro(Uint256 val1, DynamicArray<Uint256> val2) {
            super(val1,val2);
            this.val1 = val1.getValue();
            this.val2 = new java.util.ArrayList<>();;
            for (org.web3j.abi.datatypes.generated.Uint256 z: val2.getValue()) {;
            this.val2.add(z.getValue());;
            };
        }
    }

    public static class AstroDumpEventResponse extends BaseEventResponse {
        public BigInteger _val1;

        public BigInteger _val2;

        public BigInteger _val3;

        public BigInteger _val4;
    }

    public static class DumpEventResponse extends BaseEventResponse {
        public BigInteger _val1;

        public byte[] _val2;

        public String _val3;

        public byte[] _val4;
    }
}
