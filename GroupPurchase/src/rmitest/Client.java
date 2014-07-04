package rmitest;

import java.rmi.Naming;

public class Client {

	public static void main(String[] args) throws Exception{
		Server server = (Server) Naming.lookup("rmi://:1099/sss");
		
		server.say("You Know Who!");
	}

}
