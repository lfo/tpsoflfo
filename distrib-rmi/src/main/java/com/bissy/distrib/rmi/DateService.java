package com.bissy.distrib.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface DateService extends Remote {

    public Date getOfficialDate() throws RemoteException;

}
