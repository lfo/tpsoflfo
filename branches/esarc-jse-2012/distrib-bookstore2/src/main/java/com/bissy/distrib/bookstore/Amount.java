package com.bissy.distrib.bookstore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Montant pouvant représenter un prix .
 * @author lfo
 */
public class Amount implements Serializable {

    /**
     * Lites des devises acceptées.
     */
    public enum CurrencyEnum {

        /**
         * euro
         */
        EURO("€", "EUR"),
        /**
         * dollar
         */
        US_DOLLAR("$", "USD"),
        /**
         * livre sterling anglaise
         */
        POUND_STERLING("£", "GBP");
        private String symbol;
        private String code;

        CurrencyEnum(String symbol, String code) {
            this.symbol = symbol;
            this.code = code;
        }

        /**
         *
         * @return
         */
        public String getSymbol() {
            return symbol;
        }

		public String getCode() {
			return code;
		}
		
    }

    /**
     *
     * @param value
     * @param currency
     */
    public Amount(BigDecimal value, CurrencyEnum currency) {
        this.value = value;
        this.currency = currency;
    }
    private BigDecimal value;
    private CurrencyEnum currency;

    /**
     *
     * @return
     */
    public CurrencyEnum getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency
     */
    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    /**
     *
     * @return
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     *
     * @param amountValue
     */
    public void setValue(BigDecimal amountValue) {
        this.value = amountValue;
    }

    @Override
    public String toString() {
        return String.format("%s %s", getValue(), getCurrency().getSymbol());
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
}
