/*
 * Copyright 2019 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package check;

import check.soliditywrappers.Abi2Check;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class RootBc extends AbstractBlockchain {
  static final Logger LOG = LogManager.getLogger(RootBc.class);

  static final String ROOT_BLOCKCHAIN_ID = "1F";
  static final String ROOT_URI = "http://127.0.0.1:8310/";
  // Have the polling interval equal to the block time.
  private static final String POLLING_INTERVAL = "2000";


  Abi2Check abi2CheckContract;

  long crossBlockchainTransactionTimeout = 0;

  public RootBc(Credentials credentials) throws IOException {
    this(credentials, ROOT_BLOCKCHAIN_ID, ROOT_URI, DynamicGasProvider.Strategy.FREE.toString(), POLLING_INTERVAL);
  }

  public RootBc(Credentials credentials, String bcId, String uri, String gasPriceStrategy, String blockPeriod) throws IOException {
    super(credentials, bcId, uri, gasPriceStrategy, blockPeriod);
  }

  public void deployContracts() throws Exception {
    LOG.info("Deploy Root Blockchain Contracts");
    this.abi2CheckContract = Abi2Check.deploy(this.web3j, this.tm, this.gasProvider).send();
    LOG.info(" Abi2Check Contract: {}", this.abi2CheckContract.getContractAddress());
  }



  // TODO fails because web3j isn't creating the correct function signature.
  public void checkArrayArray() throws Exception {
    List<List<BigInteger>> _param = new ArrayList<>();
    List<BigInteger> l1 = new ArrayList<>();
    l1.add(BigInteger.valueOf(0x11));
    List<BigInteger> l2 = new ArrayList<>();
    l2.add(BigInteger.valueOf(0x21));
    l2.add(BigInteger.valueOf(0x22));
    List<BigInteger> l3 = new ArrayList<>();
    l3.add(BigInteger.valueOf(0x31));
    l3.add(BigInteger.valueOf(0x32));

    _param.add(l1);
    checkArrayArray(_param);
    _param.add(l2);
    checkArrayArray(_param);
    _param.add(l3);
    checkArrayArray(_param);
  }

  public void checkArrayArray(List<List<BigInteger>> _param) throws Exception {
//    public void checkAstro1(List<CrossBlockchainControl.Astro> _param) throws Exception {
    LOG.info("Call astro with: {}", this.abi2CheckContract.getRLP_arrayArray(_param));

    TransactionReceipt txR;
    try {
      txR = this.abi2CheckContract.arrayArray(_param).send();
      if (!txR.isStatusOK()) {
        throw new Error("Astro transaction failed");
      }
    } catch (TransactionException ex) {
      LOG.error("Revert Reason: {}", ex.getTransactionReceipt().get().getRevertReason());
      throw new Exception(ex);
    }

    LOG.info("AstroDump Events");
    List<Abi2Check.AstroDumpEventResponse> dumpEventResponses = this.abi2CheckContract.getAstroDumpEvents(txR);
    for (Abi2Check.AstroDumpEventResponse dumpEventResponse : dumpEventResponses) {
      LOG.info("  Event:");
      LOG.info("   1: 0x{}", dumpEventResponse._val1.toString(16));
      LOG.info("   2: 0x{}", dumpEventResponse._val2.toString(16));
      LOG.info("   3: 0x{}", dumpEventResponse._val3.toString(16));
      LOG.info("   4: 0x{}", dumpEventResponse._val4.toString(16));
    }

  }


  public void checkStructWithArray() throws Exception {

    BigInteger v1 = BigInteger.valueOf(0x10);
    List<BigInteger> l1 = new ArrayList<>();
    l1.add(BigInteger.valueOf(0x11));
    BigInteger v2 = BigInteger.valueOf(0x20);
    List<BigInteger> l2 = new ArrayList<>();
    l2.add(BigInteger.valueOf(0x21));
    l2.add(BigInteger.valueOf(0x22));
    BigInteger v3 = BigInteger.valueOf(0x30);
    List<BigInteger> l3 = new ArrayList<>();
    l3.add(BigInteger.valueOf(0x31));
    l3.add(BigInteger.valueOf(0x32));
    l3.add(BigInteger.valueOf(0x33));

    checkStructWithArray1(new Abi2Check.Astro(v1, l1));
    checkStructWithArray1(new Abi2Check.Astro(v2, l2));
    checkStructWithArray1(new Abi2Check.Astro(v3, l3));
  }

  public void checkStructWithArray1(Abi2Check.Astro _param) throws Exception {
//    public void checkAstro1(List<CrossBlockchainControl.Astro> _param) throws Exception {
    LOG.info("Call astro with: {}", this.abi2CheckContract.getRLP_structWithArray(_param));

    TransactionReceipt txR;
    try {
      txR = this.abi2CheckContract.structWithArray(_param).send();
      if (!txR.isStatusOK()) {
        throw new Error("Astro transaction failed");
      }
    } catch (TransactionException ex) {
      LOG.error("Revert Reason: {}", ex.getTransactionReceipt().get().getRevertReason());
      throw new Exception(ex);
    }

    LOG.info("AstroDump Events");
    List<Abi2Check.AstroDumpEventResponse> dumpEventResponses = this.abi2CheckContract.getAstroDumpEvents(txR);
    for (Abi2Check.AstroDumpEventResponse dumpEventResponse : dumpEventResponses) {
      LOG.info("  Event:");
      LOG.info("   1: 0x{}", dumpEventResponse._val1.toString(16));
      LOG.info("   2: 0x{}", dumpEventResponse._val2.toString(16));
      LOG.info("   3: 0x{}", dumpEventResponse._val3.toString(16));
      LOG.info("   4: 0x{}", dumpEventResponse._val4.toString(16));
    }

  }





  public void checkProcessSignedEvent() throws Exception {
    BigInteger blockchainId1 = BigInteger.valueOf(0x123456);
    String cbcAddress1 = "0x1122334455667788990011223344556677889900";
    byte[] eventSignature1 = new byte[32];
    eventSignature1[1] = 0x17;
    byte[] eventParams1 = new byte[100];
    for (int i = 0; i < eventParams1.length; i++) {
      eventParams1[i] = (byte) i;
    }
    List<String> signerAddresses1 = new ArrayList<>();
    String sAddress1 = "0x1122334455667788990011223344556677889910";
    String sAddress2 = "0x1122334455667788990011223344556677889911";
    String sAddress3 = "0x1122334455667788990011223344556677889912";
    signerAddresses1.add(sAddress1);
    signerAddresses1.add(sAddress2);
    signerAddresses1.add(sAddress3);
    List<byte[]> sigRs1 = new ArrayList<>();
    byte[] sigR1 = new byte[32];
    sigR1[0] = 0x22;
    sigRs1.add(sigR1);
    sigR1[0] = 0x23;
    sigRs1.add(sigR1);
    sigR1[0] = 0x24;
    sigRs1.add(sigR1);
    List<byte[]> sigSs1 = new ArrayList<>();
    byte[] sigS1 = new byte[32];
    sigS1[0] = 0x32;
    sigSs1.add(sigS1);
    sigS1[0] = 0x33;
    sigSs1.add(sigS1);
    sigS1[0] = 0x34;
    sigSs1.add(sigS1);
    List<BigInteger> sigVs1 = new ArrayList<>();
    sigVs1.add(BigInteger.valueOf(0x41));
    sigVs1.add(BigInteger.valueOf(0x42));
    sigVs1.add(BigInteger.valueOf(0x43));

    Abi2Check.SignedEvent param1 = new Abi2Check.SignedEvent(
        blockchainId1, cbcAddress1, eventSignature1, eventParams1,
        signerAddresses1, sigRs1, sigSs1, sigVs1);


    checkProcessSignedEvent1(param1);
  }

//  public void checkProcessSignedEvent1(Abi2Check.SignedEvent _param1, Abi2Check.SignedEvent _param2) throws Exception {
  public void checkProcessSignedEvent1(Abi2Check.SignedEvent _param1) throws Exception {
    LOG.info("Call processSignedEvent with: {}", this.abi2CheckContract.getRLP_processSignedEvent(_param1));

    TransactionReceipt txR;
    try {
//      txR = this.abi2CheckContract.processSignedEvent(_param1, _param2).send();
      txR = this.abi2CheckContract.processSignedEvent(_param1).send();
      if (!txR.isStatusOK()) {
        throw new Error("Astro transaction failed");
      }
    } catch (TransactionException ex) {
      LOG.error("Revert Reason: {}", ex.getTransactionReceipt().get().getRevertReason());
      throw new Exception(ex);
    }

    LOG.info("AstroDump Events");
    List<Abi2Check.AstroDumpEventResponse> dumpEventResponses = this.abi2CheckContract.getAstroDumpEvents(txR);
    for (Abi2Check.AstroDumpEventResponse dumpEventResponse : dumpEventResponses) {
      LOG.info("  Event:");
      LOG.info("   1: 0x{}", dumpEventResponse._val1.toString(16));
      LOG.info("   2: 0x{}", dumpEventResponse._val2.toString(16));
      LOG.info("   3: 0x{}", dumpEventResponse._val3.toString(16));
      LOG.info("   4: 0x{}", dumpEventResponse._val4.toString(16));
    }

    LOG.info("ProcessSignedEvent Events");
    List<Abi2Check.ProcessSignedEventEventResponse> processSignedEventResponses = this.abi2CheckContract.getProcessSignedEventEvents(txR);
    for (Abi2Check.ProcessSignedEventEventResponse processSignedEventResponse : processSignedEventResponses) {
      LOG.info("  Event:");
      LOG.info("   BlockchainId:   0x{}", processSignedEventResponse.blockchainId.toString(16));
      LOG.info("   CbcContract:    0x{}", processSignedEventResponse.cbcContract);
      LOG.info("   EventSignature: 0x{}", new BigInteger(1, processSignedEventResponse.eventSignature).toString(16));
      LOG.info("   EventParams:    0x{}", new BigInteger(1, processSignedEventResponse.eventParameters).toString(16));
      LOG.info("   Signer:         0x{}", processSignedEventResponse.signers);
      LOG.info("   SigS:           0x{}", new BigInteger(1, processSignedEventResponse.sigS).toString(16));
      LOG.info("   SigR:           0x{}", new BigInteger(1, processSignedEventResponse.sigR).toString(16));
      LOG.info("   SigV:           0x{}", processSignedEventResponse.sigV.toString(16));
    }
  }
}
