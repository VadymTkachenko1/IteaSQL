package sql.demo.model;

import java.util.Objects;

public class TraderShareActions extends BaseModel {
    private int operation;
    private Traders trader;
    private ShareRates shareRate;
    private long amount;

    public TraderShareActions() {
    }

    public TraderShareActions(int operation, Traders trader, ShareRates shareRate, long amount) {
        this.operation = operation;
        this.trader = trader;
        this.shareRate = shareRate;
        this.amount = amount;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public Traders getTrader() {
        return trader;
    }

    public void setTrader(Traders trader) {
        this.trader = trader;
    }

    public ShareRates getShareRate() {
        return shareRate;
    }

    public void setShareRate(ShareRates shareRate) {
        this.shareRate = shareRate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraderShareActions that = (TraderShareActions) o;
        return operation == that.operation
                && amount == that.amount
                && Objects.equals(trader, that.trader)
                && Objects.equals(shareRate, that.shareRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, trader, shareRate, amount);
    }
}
