package lancher;

public class StartAll {

	public static void main(String[] args) {
		new ServerLauncher().launch();
		
		new ClientLauncher().launch();
	}
}
