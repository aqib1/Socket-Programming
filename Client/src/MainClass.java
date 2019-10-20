import java.io.IOException;

public class MainClass {
public static void main(String[] args) {
	ClientClass clientClass=null;
	try {
		clientClass = new ClientClass();
		clientClass.settingUpStreams();
		clientClass.sendMessage();
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		try {
			clientClass.closeStreams();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
}
