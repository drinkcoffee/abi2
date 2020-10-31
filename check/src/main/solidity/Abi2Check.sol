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
pragma solidity >=0.7.1;
pragma experimental ABIEncoderV2;

contract Abi2Check  {
    event Dump(uint256 _val1, bytes32 _val2, address _val3, bytes _val4);
    event AstroDump(uint256 _val1, uint256 _val2, uint256 _val3, uint256 _val4);

    struct Astro {
        uint256 val1;
        uint256[] val2;
    }

//function astro(Astro[] calldata _param) external {
    function arrayArray(uint256[][] calldata _param) external {
        emit AstroDump(_param.length, 0, 0, 1);
        for (uint256 i = 0; (i < _param.length) && (i < 5); i++) {
            emit AstroDump(i, _param[i].length, 0, 2);
//emit AstroDump(i, _param[i].val1, 0, 2);


//            emit AstroDump(i, _param[i].val1, _param[i].val2.length, 2);
//            for (uint256 j = 0; (j < _param[i].val2.length) && (i < 5); j++) {
//                emit AstroDump(i, _param[i].val1, _param[i].val2[j], 3);
//            }
        }
    }

    function structWithArray(Astro calldata _param) external {
        emit AstroDump(_param.val1, _param.val2.length, 0, 2);
        for (uint256 j = 0; (j < _param.val2.length); j++) {
            emit AstroDump(j, _param.val2[j], 0, 3);
        }
    }


    struct SignedEvent {
        uint256 blockchainId;
        address cbcContract;
        bytes32 eventSignature;
        bytes eventParameters;
        address[] signers;
        bytes32[] sigR;
        bytes32[] sigS;
        uint8[] sigV;
    }

    event ProcessSignedEvent(uint256 blockchainId, address cbcContract, bytes32 eventSignature, bytes eventParameters,
        address signers, bytes32 sigR, bytes32 sigS, uint8 sigV);

//    function processSignedEvent(SignedEvent calldata _e1, SignedEvent calldata _e2) external {
    function processSignedEvent(SignedEvent calldata _e1) external {
        emit AstroDump(1, 0, 0, 0);
        emit ProcessSignedEvent(_e1.blockchainId, address(0), bytes32(0), bytes(""),
            address(0), bytes32(0), bytes32(0), uint8(0));
//        emit AstroDump(2, _e1.signers.length, _e1.sigR.length, _e1.sigS.length);
//        emit AstroDump(2, 0, 0, _e1.sigV.length);
//        emit ProcessSignedEvent(_e1.blockchainId, _e1.cbcContract, _e1.eventSignature, _e1.eventParameters,
//            address(0), bytes32(0), bytes32(0), uint8(0));
//        for (uint256 i = 0; i < _e1.signers.length; i++) {
//            emit ProcessSignedEvent(3, address(0), bytes32(0), bytes(""),
//                _e1.signers[i], _e1.sigR[i], _e1.sigS[i], _e1.sigV[i]);
//        }
    }


}