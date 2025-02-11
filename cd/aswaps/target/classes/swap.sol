pragma solidity >=0.4.25;

contract Swap {
    address payable party;
    address payable counterParty;
    uint[] timeLock;
    bytes32[] hashLocks;
    bool[] unlocked;
    uint start;

    constructor(address payable _party,
                address payable _counterParty,
                uint[] memory _timeLock,
                bytes32[] memory _hashLock,
                uint _start) public {
        party = _party;
        counterParty = _counterParty;
        timeLock = _timeLock;
        hashLocks = _hashLock;
        start = _start;
        unlocked = [false, false, false];
    }

    function unlock(uint _i, bytes32 _hashLock, uint _timeNow) public {                                                                                          // TODO: MB add sig after first test  AND isPath not needed, since digraph is implemented offchain
        require (msg.sender == counterParty);

        if (_timeNow < timeLock[_i] && hashLocks[_i] == _hashLock) {                                                                                            // DONE: if ( now < start + (diam(digraph) + |path|)*triangle && hashlock[i] == H(s) && isPath(path, digraph, leader[i], counterparty) && verifySigs(sig, s , path) ) {unlocked[i] = true}
            unlocked[_i] = true;
        }
    }

    function isUnlocked(uint _i) public view returns (bool) {
        return unlocked[_i];
    }

    function lockEther() public payable {
        require (msg.value == 1000000000000000000 && msg.sender == party);                                                                                               // msg.value == 1 &&    == value of wei //TODO: MB not needed!!!
    }

    function refund(uint _timeNow) public {
        require (msg.sender == party);

        if (_timeNow > timeLock[3]) {                                                                                                                                    // DONE: if ( any hashlock unlocked and timed out ) {transer asset to party; halt;}
            party.transfer(address(this).balance);
        }
    }

    function claim() public payable {
        require (msg.sender == counterParty);

        if (unlocked[0] == true && unlocked[1] == true && unlocked[2] == true) {                                                                                        //DONE: if (every hashlock unlocked) {transfer asset to counterparty; halt;}
            counterParty.transfer(address(this).balance);
        }

    }

}
