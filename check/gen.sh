#!/usr/bin/env bash
set -e
rm -rf build

HERE=check
BUILDDIR=$HERE/build
CONTRACTSDIR=$HERE/src/main/solidity
OUTPUTDIR=$HERE/src/main/java
PACKAGE=check.soliditywrappers

#WEB3J=web3j
WEB3J=../web3j-rlp/codegen/build/distributions/codegen-4.7.0-SNAPSHOT/bin/codegen


# compiling one file also compiles its dependendencies. We use overwrite to avoid the related warnings.
solc $CONTRACTSDIR/Abi2Check.sol --allow-paths . --bin --abi --hashes --optimize -o $BUILDDIR --overwrite
# ls -al $BUILDDIR

$WEB3J solidity generate -a=$BUILDDIR/Abi2Check.abi -b=$BUILDDIR/Abi2Check.bin -o=$OUTPUTDIR -p=$PACKAGE



