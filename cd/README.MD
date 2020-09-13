This is the readme for the swap prototype. It comes with the chain states and wallets used during implementation. Since wallets and addresses are hard coded please follow the instructions to run the prototype.
Running without prerequirements will result in a crash!

1. 	install geth: https://geth.ethereum.org/docs/install-and-build/installing-geth
2. 	add geth to system variables
3. 	open folder /chains/Alice in new console
3.1	run "geth --identity Alice --rpc --rpcport 8081 --rpccorsdomain "*" --datadir .test --port 30304 --nodiscover --rpcapi "eth,net,web3" --ipcdisable --networkid 33 console"
3.2 	in the geth js terminal type "miner.start();" and hit enter
4.	open folder /chains/Bob in new console
4.1	run "geth --identity Bob --rpc --rpcport 8082 --rpccorsdomain "*" --datadir .test --port 30305 --nodiscover --rpcapi "eth,net,web3" --ipcdisable --networkid 34 console"
4.2 	in the geth js terminal type "miner.start();" and hit enter
5.	open folder /chains/Carol in new console
5.1	run "geth --identity Carol --rpc --rpcport 8083 --rpccorsdomain "*" --datadir .test --port 30306 --nodiscover --rpcapi "eth,net,web3" --ipcdisable --networkid 35 console"
5.2 	in the geth js terminal type "miner.start();" and hit enter
6.	when all three chains are running and mining its time to start the prototype
7.	download intellij: https://www.jetbrains.com/de-de/idea/download/
8.	open folder awsaps as project in intellij
9. 	run class App



