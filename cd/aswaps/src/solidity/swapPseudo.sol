pragma solidity ^0.5.6;

contract Swap {
    Asset asset;    //asset
    Digraph digraph;
    address[] leaders;
    address party;
    address counterParty;
    uint[] timeLock;
    uint[] hashLock;
    bool[] unlocked;
    uint start;

    function Swap(Asset _asset, Digraph _digraph, address[] _leaders, address _party, address _counterParty, uint[] _timeLock, uint[] _hashLock, uint start) {
        asset = _asset;
        party = _party;
        counterParty = _counterParty;
        timeLock = _timeLock;
        hashLock = _hashLock;
        unlocked = [false, false, false];
    }

    function unlock(int i, uint s, Path path, Sig sig) {
        require (msg.sender == counterParty);

        //if ( now < start + (diam(digraph) + |path|)*triangle && hashlock[i] == H(s) && isPath(path, digraph, leader[i], counterparty) && verifySigs(sig, s , path) ) {unlocked[i] = true}
    }

    function refund() {
        require (msg.sender == party);

        //if ( any hashlock unlocked and timed out ) {transer asset to party; halt;}
    }

    function claim() {
        require (msg.sender == counterParty);

        //if (every hashlock unlocked) {transfer asset to counterparty; halt;}
    }
}