Alice, Bob and Carol:
geth --datadir .test init genesis.json
confirm coinbase -> eth.coinbase

Alice:
personal.newAccount()   ->    "0x6ec4922fcffd90b36aa7104c506064b4a9988a90" - pwd
miner.setEtherbase(eth.accounts[0])
geth --identity Alice --rpc --rpcport 8081 --rpccorsdomain "*" --datadir .test --port 30304 --nodiscover --rpcapi "eth,net,web3" --ipcdisable --networkid 33 console
- alice acc on Bob's chain -> "0xae0ec7ecb5ff61c77744fe400545727142200018" - pwd
- alice acc on Carol's chain -> "0x760f1bf21f63e7c9bff23060ca13bd8c42fa85df" - pwd
another_acc -> "0x45821fef02ef3811573a73f3990168d0d373acdf" - pwd


Bob:
personal.newAccount()   ->    "0x2193259b178623345225272dd075717fcacc704e" - pwd
miner.setEtherbase(eth.accounts[0])
geth --identity Bob --rpc --rpcport 8082 --rpccorsdomain "*" --datadir .test --port 30305 --nodiscover --rpcapi "eth,net,web3" --ipcdisable --networkid 34 console

Carol:
personal.newAccount()   ->    "0x6392e91df60c5bc2ca09670cd4173e05a0e04833" - pwd
miner.setEtherbase(eth.accounts[0])
geth --identity Carol --rpc --rpcport 8083 --rpccorsdomain "*" --datadir .test --port 30306 --nodiscover --rpcapi "eth,net,web3" --ipcdisable --networkid 35 console