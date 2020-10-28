# ABI2 Encoding Check

This repo contains code to check the support for ABI2 by Web3J and Solidity. 

The directories:
* check: Solidity and Java code.
* gradle: build system related files.
* scripts: Scripts to set-up and run Hyperledger Besu.

## Building
This repo relies on a special version of Web3J. To create this:
* Clone the repo to the directory ./LTACFC/..  : git clone https://github.com/drinkcoffee/web3j-rlp
* cd ../web3j-rlp
* ./gradlew build
* cd codegen/build/distributions
* tar xvf codegen-4.7.0-SNAPSHOT.tar


The runner in check (abi2/check/src/main/java/check/Main.java) relies on a properties file of the form:

PRIVATE_KEY=40000000000ad044fb60865556ead3961456349a242b3a4b8a00000000000001

//ROOT_BC_ID=4
//ROOT_URI=https://rinkeby.infura.io/v3/4000000000000000000000124e8fae13
//ROOT_GAS=HIGHEST
//ROOT_PERIOD=15000

ROOT_BC_ID=1F
ROOT_URI=http://127.0.0.1:8310/
ROOT_GAS=FREE
ROOT_PERIOD=2000


