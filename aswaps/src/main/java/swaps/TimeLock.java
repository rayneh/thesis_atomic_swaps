package swaps;

import java.math.BigInteger;
import java.util.Date;

public class TimeLock {
    private final Date start;
    private final Date timeToDeployContracts;
    private final Date timeToSendFunds;
    private final Long startInMilliSeconds;
    static final long ONE_MINUTE_IN_MILLIS = 60000; //millisecs
    private final long limitForSendingFundsInMinutes;

    public TimeLock(Long limitForContractDeploymentInMinutes, Long limitForSendingFundsInMinutes) {
        this.start = new Date();
        this.startInMilliSeconds = start.getTime();
        this.timeToDeployContracts = new Date(startInMilliSeconds + (limitForContractDeploymentInMinutes * ONE_MINUTE_IN_MILLIS));
        this.timeToSendFunds = new Date(this.getTimeToDeployContractsInMilliSeconds() + (limitForSendingFundsInMinutes * ONE_MINUTE_IN_MILLIS));
        this.limitForSendingFundsInMinutes = limitForSendingFundsInMinutes;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getTimeToDeployContracts() {
        return this.timeToDeployContracts;
    }

    public Date getTimeToSendFunds() {
        return this.timeToSendFunds;
    }

    public Long getStartInMilliSeconds() {
        return this.startInMilliSeconds;
    }

    public Long getTimeToDeployContractsInMilliSeconds() {
        return this.timeToDeployContracts.getTime();
    }

    public Long getTimeToSendFundsInMilliSeconds() {
        return this.timeToSendFunds.getTime();
    }

    public Long getTimeNowInMilliSeconds() {
        return new Date().getTime();
    }

    public Long[] getTimeLockArray() {
        Long[] timeLocks = new Long[3];
        long oneLimitUnit = this.limitForSendingFundsInMinutes / 3;
        timeLocks[0] = new Date(this.getTimeToDeployContractsInMilliSeconds() + (oneLimitUnit * ONE_MINUTE_IN_MILLIS)).getTime();
        timeLocks[1] = new Date(this.getTimeToDeployContractsInMilliSeconds() + (oneLimitUnit * ONE_MINUTE_IN_MILLIS) * 2).getTime();
        timeLocks[2] = new Date(this.getTimeToDeployContractsInMilliSeconds() + (oneLimitUnit * ONE_MINUTE_IN_MILLIS) * 3).getTime();

        return timeLocks;
    }

    public BigInteger getStartAsBigInteger() {
        return BigInteger.valueOf(this.getStartInMilliSeconds());
    }

    /*public void setLimitForContractDeployment(Long limitForContractDeploymentInMinutes) {
        this.timeToDeployContracts = new Date(startInMilliSeconds + (limitForContractDeploymentInMinutes * ONE_MINUTE_IN_MILLIS));
    }

    public void setLimitForSendingFunds(Long limitForSendingFundsInMinutes) {
        this.timeToSendFunds = new Date(startInMilliSeconds + (limitForSendingFundsInMinutes * ONE_MINUTE_IN_MILLIS));
    }*/
}
