package swaps;

import java.util.Date;

public class TimeLock {
    private Date start;
    private Date timeToDeployContracts;
    private Date timeToSendFunds;

    public TimeLock() {
        this.start = new Date();
    }

    public Date getStart() {
        return this.start;
    }
}
