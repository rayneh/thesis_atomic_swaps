package swaps;

import swaps.parties.Alice;
import swaps.parties.Bob;
import swaps.parties.Carol;

public class Digraph {
    private Alice alice;
    private Bob bob;
    private Carol carol;

    public Digraph(Alice alice, Bob bob, Carol carol) {
        this.alice = alice;
        this.bob = bob;
        this.carol = carol;
    }

    public void triggerPath(String path) {
        switch (path) {
            case "AB":
                this.alicePublishContractOnAltCoinChain();
                break;
            case "BA":
                this.bobPublishContractOnBtcChain();
                break;
            case "CC":
                this.carolPublishContractOnCarTitleChain();
                break;
            case "AC":
                this.aliceClaimCarTitle();
                break;
            case "CA":
                this.carolClaimBtc();
                break;
            case "BB":
                this.bobClaimAltCoin();
                break;
            default:
                System.out.println("PATH UNKNOWN");
                break;
        }
    }

    public void alicePublishContractOnAltCoinChain() {
        //TODO: alice publishes contract on alt-coin chain and locks her funds!
    }

    public void bobPublishContractOnBtcChain() {
        //TODO: bob publishes contract on btc chain and locks his funds!
    }

    public void carolPublishContractOnCarTitleChain() {
        //TODO: carol publishes contract on car title chains and locks her funds!
    }

    public void aliceClaimCarTitle() {
        //TODO: alice claims the car title and sends secret to carol!
    }

    public void carolClaimBtc() {
        //TODO:  carol claims the bitcoin and sends secret to bob!
    }

    public void bobClaimAltCoin() {
        //TODO: bob claims the alt coins and swap finished!
    }
}
