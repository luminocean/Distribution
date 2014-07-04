package lancher;

public class StartAll {

	public static void main(String[] args) {
		new SystemLauncher().launch();
		
		new ClientLauncher().launch();
	}
}
