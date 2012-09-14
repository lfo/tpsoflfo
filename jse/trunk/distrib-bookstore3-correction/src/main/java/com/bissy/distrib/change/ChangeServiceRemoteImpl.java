package com.bissy.distrib.change;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.bissy.distrib.bookstore.Amount;
import com.bissy.distrib.bookstore.Amount.CurrencyEnum;

public class ChangeServiceRemoteImpl extends UnicastRemoteObject implements ChangeService {

    public ChangeServiceRemoteImpl() throws RemoteException {
    }

    public Amount getChange(Amount amount, CurrencyEnum currency) throws RemoteException {
        try {
            float taux = YahooCurrencyConverter.convert(amount.getCurrency().getCode(), currency.getCode());
            BigDecimal newValue = amount.getValue().multiply(new BigDecimal(taux));
            return new Amount(newValue, currency);
        } catch (Exception e) {
            throw new RemoteException(e.getMessage(), e);
        }
    }
}
