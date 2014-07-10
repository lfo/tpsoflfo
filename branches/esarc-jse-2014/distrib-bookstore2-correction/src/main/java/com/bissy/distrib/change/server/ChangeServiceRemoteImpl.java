package com.bissy.distrib.change.server;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.bissy.distrib.bookstore.Amount;
import com.bissy.distrib.bookstore.CurrencyEnum;
import com.bissy.distrib.change.ChangeService;

public class ChangeServiceRemoteImpl extends UnicastRemoteObject implements ChangeService {

    private static final long serialVersionUID = 1L;

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
