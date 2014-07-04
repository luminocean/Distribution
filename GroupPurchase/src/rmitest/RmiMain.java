package rmitest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiMain {

	public static void main(String[] args) throws Exception{
		Server server = new ServerImpl();

		LocateRegistry.createRegistry(1099);
		
		Naming.rebind("rmi://:1099/sss", server);
	}

}
