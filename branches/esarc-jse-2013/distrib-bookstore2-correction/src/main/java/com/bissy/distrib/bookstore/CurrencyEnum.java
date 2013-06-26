package com.bissy.distrib.bookstore;

import java.io.Serializable;

public enum CurrencyEnum implements Serializable{
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
	