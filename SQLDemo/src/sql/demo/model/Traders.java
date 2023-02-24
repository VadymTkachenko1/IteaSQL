package sql.demo.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Traders extends BaseModel {
    private String name;
    private int sfreqTick;
    private BigDecimal cash;
    private int tradingMethod;
    private int changeProbability;
    private String about;

    public Traders() {
    }

    public Traders(String name, int sfreqTick, BigDecimal cash, int tradingMethod, int changeProbability, String about) {
        this.name = name;
        this.sfreqTick = sfreqTick;
        this.cash = cash;
        this.tradingMethod = tradingMethod;
        this.changeProbability = changeProbability;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSfreqTick() {
        return sfreqTick;
    }

    public void setSfreqTick(int sfreqTick) {
        this.sfreqTick = sfreqTick;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public int getTradingMethod() {
        return tradingMethod;
    }

    public void setTradingMethod(int tradingMethod) {
        this.tradingMethod = tradingMethod;
    }

    public int getChangeProbability() {
        return changeProbability;
    }

    public void setChangeProbability(int changeProbability) {
        this.changeProbability = changeProbability;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Traders traders = (Traders) o;
        return sfreqTick == traders.sfreqTick && tradingMethod == traders.tradingMethod
                && changeProbability == traders.changeProbability
                && Objects.equals(name, traders.name)
                && Objects.equals(cash, traders.cash)
                && Objects.equals(about, traders.about);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sfreqTick, cash, tradingMethod, changeProbability, about);
    }
}
