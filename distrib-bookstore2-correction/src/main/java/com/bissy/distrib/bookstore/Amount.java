package com.bissy.distrib.bookstore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Amount implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BigDecimal value;
	private CurrencyEnum currency;

	public Amount() {}
	
	public Amount(BigDecimal prix,CurrencyEnum devise) {
		this.value = prix;
		this.currency = devise;
	}
	
	public CurrencyEnum getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEnum currencyEnum) {
		this.currency = currencyEnum;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	
    public static Amount parse(String raw) {
        String[] tokens = raw.split(" ");
        BigDecimal value = new BigDecimal(tokens[0]);
        CurrencyEnum currency = null;
        for (CurrencyEnum cur : CurrencyEnum.values()) {
            if (cur.getSymbol().equals(tokens[1])) {
                currency = cur;
                break;
            }
        }
        return new Amount(value, currency);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object object) {
       boolean toReturn = object != null && (object instanceof Amount) ;
       BigDecimal bd1 = ((Amount) object).getValue().setScale(0,RoundingMode.DOWN);
       BigDecimal bd2 = getValue().setScale(0,RoundingMode.DOWN);
       System.out.println(bd1+" "+bd2);
       toReturn = toReturn && bd1.equals(bd2) &&
                ((Amount) object).getCurrency().equals(getCurrency());
       return toReturn;
    }
    

    @Override
    public String toString() {
        return String.format("%s %s", getValue(), getCurrency().getSymbol());
    }
}
