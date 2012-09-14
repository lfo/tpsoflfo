package com.bissy.distrib.rmi.server;

import com.bissy.distrib.rmi.DateService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class DateServiceRemoteImpl extends UnicastRemoteObject implements DateService {

    public DateServiceRemoteImpl() throws RemoteException {
    }

    public Date getOfficialDate() throws RemoteException {
    	Date officialDate = new Date();
    	System.out.println("Service return : "+officialDate);
        return officialDate;
    }
}
