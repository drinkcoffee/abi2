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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.web3j.crypto.Credentials;

public class Main {
  static final Logger LOG = LogManager.getLogger(Main.class);

  public static void main(String[] args) throws Exception {
    LOG.info("Started");
    Credentials creds;
    RootBc rootBlockchain;

    switch (args.length) {
      case 1:
        PropertiesLoader propsLoader = new PropertiesLoader(args[0]);
        creds = propsLoader.getCredentials();
        String bcId = propsLoader.getProperty("ROOT_BC_ID");
        LOG.info(" ROOT_BC_ID: {}", bcId);
        String uri = propsLoader.getProperty("ROOT_URI");
        LOG.info(" ROOT_URI: {}", uri);
        String gasPriceStrategy = propsLoader.getProperty("ROOT_GAS");
        LOG.info(" ROOT_GAS: {}", gasPriceStrategy);
        String blockPeriod = propsLoader.getProperty("ROOT_PERIOD");
        LOG.info(" ROOT_PERIOD: {}", blockPeriod);
        rootBlockchain = new RootBc(creds, bcId, uri, gasPriceStrategy, blockPeriod);
        break;
      default:
        LOG.info("Usage: <properties file name>");
        return;
    }


    rootBlockchain.deployContracts();

    // TODO fails because web3j isn't encoding the correct function signature.
    // rootBlockchain.checkArrayArray();

    // This works
    //rootBlockchain.checkStructWithArray();

    // This does not work. Problems either with the encoding by Web3J or the decode EVM byte code generated
    // by the Solidity compiler.
    rootBlockchain.checkProcessSignedEvent();

    rootBlockchain.shutdown();
  }
}
