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

}