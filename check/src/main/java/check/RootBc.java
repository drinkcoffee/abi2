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
}
