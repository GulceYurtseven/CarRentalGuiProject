package GuiHw;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//ClientManager.java 												Author: Berþan Gülce Yurtseven ID: 21997330
//																	e-mail: gulceyurtseven@gmail.com
//Müþterileri client_id dosyasýna yazýlmasýný saðlar. ClientInterface den miras alýr
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ClientManager implements ClientInterface {//müþterilerin Client türünde bir arraylistte tutar
	@Override
	public void addClient(ArrayList<Client> clientArray) {
		try {
			FileWriter file1Wr = new FileWriter("client_id.txt",true);
			for(Client client2 : clientArray) {
				String s = "id:" + client2.getId() + "  \t" + //bütün bir satýrý string s tuttu
						"Name: " + client2.getName() + "  \t" + 
						"Pay: " + client2.getPay()+ "  \t" + 
						"Pick Up Location: " + client2.getPickUpLocation() + " \t" + 
						"Return Location: "+ client2.getReturnLocation() + "  \t" + 
						"Rent Counter: " + client2.getRentCounter() + "\n";
				file1Wr.write(s);//dosyaya yazma
				System.out.println("client dosyasý yazýldý");
			}
			file1Wr.close();//dosyayý kapatma
		}
		catch (IOException e) {//exception
			System.out.println(e.getMessage() + "client dosyasýna yazýlamadý");
		}	
	}
}