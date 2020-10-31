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
import org.web3j.abi.datatypes.generated.Uint8;
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
    public static final String BINARY = "608060405234801561001057600080fd5b506104a7806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80631f92c32c1461004657806329c5334f1461005b578063dfc503741461006e575b600080fd5b6100596100543660046102b8565b610081565b005b610059610069366004610249565b61012a565b61005961007c3660046102f7565b6101c6565b600080516020610452833981519152813561009f6020840184610403565b6040516100b3939250600090600290610344565b60405180910390a160005b6100cb6020830183610403565b905081101561012657600080516020610452833981519152816100f16020850185610403565b848181106100fb57fe5b90506020020135600060036040516101169493929190610344565b60405180910390a16001016100be565b5050565b604051600080516020610452833981519152906101509083906000908190600190610344565b60405180910390a160005b818110801561016a5750600581105b156101c1576000805160206104528339815191528184848481811061018b57fe5b905060200281019061019d9190610403565b6040516101b1939250600090600290610344565b60405180910390a160010161015b565b505050565b600080516020610452833981519152600160008060006040516101ec9493929190610344565b60405180910390a160408051602081018252600080825291517f30f1763492c53379c96b984afe887914a7047a205c9ade5abd51ad9634e7733d9261023e92853592829190829081908190819061035f565b60405180910390a150565b6000806020838503121561025b578182fd5b823567ffffffffffffffff80821115610272578384fd5b818501915085601f830112610285578384fd5b813581811115610293578485fd5b86602080830285010111156102a6578485fd5b60209290920196919550909350505050565b6000602082840312156102c9578081fd5b813567ffffffffffffffff8111156102df578182fd5b8201604081850312156102f0578182fd5b9392505050565b600060208284031215610308578081fd5b813567ffffffffffffffff81111561031e578182fd5b820161010081850312156102f0578182fd5b6001600160a01b03169052565b60ff169052565b93845260208401929092526040830152606082015260800190565b60006101008a8352602060018060a01b038b1681850152896040850152816060850152885180838601528392505b808310156103ac5789830182015185840161012001529181019161038d565b808311156103be578361012082870101525b601f01601f191684016101200192506103dd9150506080830187610330565b8460a08301528360c08301526103f660e083018461033d565b9998505050505050505050565b6000808335601e19843603018112610419578283fd5b83018035915067ffffffffffffffff821115610433578283fd5b602090810192508102360382131561044a57600080fd5b925092905056fee5b286ee80c4f7811cec734b866242d61e30147d0b204f87684a2418d138d78fa26469706673582212204642d595a0e6d9f18901bdbabe416b6d8efc64f7a0a6f9e104fdb708f8154b5f64736f6c63430007040033";

    public static final String FUNC_ARRAYARRAY = "arrayArray";

    public static final String FUNC_PROCESSSIGNEDEVENT = "processSignedEvent";

    public static final String FUNC_STRUCTWITHARRAY = "structWithArray";

    public static final Event ASTRODUMP_EVENT = new Event("AstroDump", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event DUMP_EVENT = new Event("Dump", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event PROCESSSIGNEDEVENT_EVENT = new Event("ProcessSignedEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint8>() {}));
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

    public List<ProcessSignedEventEventResponse> getProcessSignedEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PROCESSSIGNEDEVENT_EVENT, transactionReceipt);
        ArrayList<ProcessSignedEventEventResponse> responses = new ArrayList<ProcessSignedEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProcessSignedEventEventResponse typedResponse = new ProcessSignedEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.blockchainId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.cbcContract = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.eventSignature = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.eventParameters = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.signers = (String) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.sigR = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.sigS = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.sigV = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ProcessSignedEventEventResponse> processSignedEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ProcessSignedEventEventResponse>() {
            @Override
            public ProcessSignedEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PROCESSSIGNEDEVENT_EVENT, log);
                ProcessSignedEventEventResponse typedResponse = new ProcessSignedEventEventResponse();
                typedResponse.log = log;
                typedResponse.blockchainId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.cbcContract = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.eventSignature = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.eventParameters = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.signers = (String) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.sigR = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.sigS = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.sigV = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProcessSignedEventEventResponse> processSignedEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROCESSSIGNEDEVENT_EVENT));
        return processSignedEventEventFlowable(filter);
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

    public RemoteFunctionCall<TransactionReceipt> processSignedEvent(SignedEvent _e1) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PROCESSSIGNEDEVENT, 
                Arrays.<Type>asList(_e1), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public String getRLP_processSignedEvent(SignedEvent _e1) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PROCESSSIGNEDEVENT, 
                Arrays.<Type>asList(_e1), 
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

    public static class SignedEvent extends DynamicStruct {
        public BigInteger blockchainId;

        public String cbcContract;

        public byte[] eventSignature;

        public byte[] eventParameters;

        public List<String> signers;

        public List<byte[]> sigR;

        public List<byte[]> sigS;

        public List<BigInteger> sigV;

        public SignedEvent(BigInteger blockchainId, String cbcContract, byte[] eventSignature, byte[] eventParameters, List<String> signers, List<byte[]> sigR, List<byte[]> sigS, List<BigInteger> sigV) {
            super(new org.web3j.abi.datatypes.generated.Uint256(blockchainId),new org.web3j.abi.datatypes.Address(cbcContract),new org.web3j.abi.datatypes.generated.Bytes32(eventSignature),new org.web3j.abi.datatypes.DynamicBytes(eventParameters),new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(org.web3j.abi.datatypes.Address.class, org.web3j.abi.Utils.convertTo_address(signers)),new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(org.web3j.abi.datatypes.generated.Bytes32.class, org.web3j.abi.Utils.convertTo_bytes32(sigR)),new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(org.web3j.abi.datatypes.generated.Bytes32.class, org.web3j.abi.Utils.convertTo_bytes32(sigS)),new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint8>(org.web3j.abi.datatypes.generated.Uint8.class, org.web3j.abi.Utils.convertTo_uint8(sigV)));
            this.blockchainId = blockchainId;
            this.cbcContract = cbcContract;
            this.eventSignature = eventSignature;
            this.eventParameters = eventParameters;
            this.signers = signers;
            this.sigR = sigR;
            this.sigS = sigS;
            this.sigV = sigV;
        }

        public SignedEvent(Uint256 blockchainId, Address cbcContract, Bytes32 eventSignature, DynamicBytes eventParameters, DynamicArray<Address> signers, DynamicArray<Bytes32> sigR, DynamicArray<Bytes32> sigS, DynamicArray<Uint8> sigV) {
            super(blockchainId,cbcContract,eventSignature,eventParameters,signers,sigR,sigS,sigV);
            this.blockchainId = blockchainId.getValue();
            this.cbcContract = cbcContract.getValue();
            this.eventSignature = eventSignature.getValue();
            this.eventParameters = eventParameters.getValue();
            this.signers = new java.util.ArrayList<>();;
            for (org.web3j.abi.datatypes.Address z: signers.getValue()) {;
            this.signers.add(z.getValue());;
            };
            this.sigR = new java.util.ArrayList<>();;
            for (org.web3j.abi.datatypes.generated.Bytes32 z: sigR.getValue()) {;
            this.sigR.add(z.getValue());;
            };
            this.sigS = new java.util.ArrayList<>();;
            for (org.web3j.abi.datatypes.generated.Bytes32 z: sigS.getValue()) {;
            this.sigS.add(z.getValue());;
            };
            this.sigV = new java.util.ArrayList<>();;
            for (org.web3j.abi.datatypes.generated.Uint8 z: sigV.getValue()) {;
            this.sigV.add(z.getValue());;
            };
        }
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

    public static class ProcessSignedEventEventResponse extends BaseEventResponse {
        public BigInteger blockchainId;

        public String cbcContract;

        public byte[] eventSignature;

        public byte[] eventParameters;

        public String signers;

        public byte[] sigR;

        public byte[] sigS;

        public BigInteger sigV;
    }
}
