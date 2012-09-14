package com.bissy.distrib.change;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.bissy.distrib.bookstore.Amount;
import com.bissy.distrib.bookstore.CurrencyEnum;

public interface ChangeService extends Remote {

    public final static String SERVICE_URL = "rmi://changeService";

    /**
     * Cette méthode permet d'obtenir le change d'une montant (amount) dans une 
     * nouvelle monnaie (Currency)  
     * @param price le montant dont on veut obtenir le change
     * @param currency la monnaie dans laquelle le change doit être obtenu.
     * @return le montant dans le nouveau change.
     */
    public Amount getChange(Amount amount, CurrencyEnum currency) throws RemoteException;
}
