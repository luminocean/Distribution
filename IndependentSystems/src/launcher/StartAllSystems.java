package launcher;

import message.MessageReceiver;

public class StartAllSystems {

	public static void main(String[] args) {
		new BankLauncher().launch();
		
		new MessageReceiver().run();
	}

}
