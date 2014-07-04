package rmitest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements Server{

	protected ServerImpl() throws RemoteException {
		super();
	}

	@Override
	public void say(String msg) {
		System.out.println("Saying...."+msg);
	}
	
}
