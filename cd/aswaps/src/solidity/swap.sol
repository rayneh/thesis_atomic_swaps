pragma solidity ^0.6.0;

contract Swap {
    address party;
    address counterParty;
    uint[] timeLock;
    string[] hashLocks;
    bool[] unlocked;
    uint start;

    function Swap(address _party, address _counterParty, uint[] _timeLock, string[] _hashLock, uint start) {
        party = _party;
        counterParty = _counterParty;
        timeLock = _timeLock;
        hashLocks = _hashLock;
        unlocked[] = [false, false, false];
    }

    function unlock(int i, string hashLock, uint now) {             // TODO: MB add sig after first test  AND isPath not needed, since digraph is implemented offchain
        require (msg.sender == counterParty);

        if (now < timeLock[i] && hashLocks[i] == hashLock) {                                        // DONE: if ( now < start + (diam(digraph) + |path|)*triangle && hashlock[i] == H(s) && isPath(path, digraph, leader[i], counterparty) && verifySigs(sig, s , path) ) {unlocked[i] = true}
            unlocked[i] = true;
        }
    }

    function isUnlocked(int i) public returns (bool) {
        return unlocked[i];
    }

    function lockEther() public payable {
        require (msg.value == 1 && msg.sender == party);
    }

    function refund(uint now) {
        require (msg.sender == party);

        if (now > timeLock) {                                                                       // DONE: if ( any hashlock unlocked and timed out ) {transer asset to party; halt;}
            party.transfer(address(this).balance);
        }
    }

    function claim() {
        require (msg.sender == counterParty);

        if (unlocked[0] == true && unlocked[1] == true && unlocked[2] == true) {                    //DONE: if (every hashlock unlocked) {transfer asset to counterparty; halt;}
            counterParty.transfer(address(this).balance);
        }
    }
}