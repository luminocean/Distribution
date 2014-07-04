package rmitest;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote{
	public void say(String msg) throws RemoteException;
}
