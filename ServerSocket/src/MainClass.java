import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		ServerClass serverClass=null;
		try {
			serverClass= new ServerClass();
			serverClass.waitingForTheClient();
			serverClass.settingUpStreams();
			serverClass.recieveMessage();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				serverClass.closeStreams();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}	

}
