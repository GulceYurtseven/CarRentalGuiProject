package GuiHw;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//ClientManager.java 												Author: Ber�an G�lce Yurtseven ID: 21997330
//																	e-mail: gulceyurtseven@gmail.com
//M��terileri client_id dosyas�na yaz�lmas�n� sa�lar. ClientInterface den miras al�r
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ClientManager implements ClientInterface {//m��terilerin Client t�r�nde bir arraylistte tutar
	@Override
	public void addClient(ArrayList<Client> clientArray) {
		try {
			FileWriter file1Wr = new FileWriter("client_id.txt",true);
			for(Client client2 : clientArray) {
				String s = "id:" + client2.getId() + "  \t" + //b�t�n bir sat�r� string s tuttu
						"Name: " + client2.getName() + "  \t" + 
						"Pay: " + client2.getPay()+ "  \t" + 
						"Pick Up Location: " + client2.getPickUpLocation() + " \t" + 
						"Return Location: "+ client2.getReturnLocation() + "  \t" + 
						"Rent Counter: " + client2.getRentCounter() + "\n";
				file1Wr.write(s);//dosyaya yazma
				System.out.println("client dosyas� yaz�ld�");
			}
			file1Wr.close();//dosyay� kapatma
		}
		catch (IOException e) {//exception
			System.out.println(e.getMessage() + "client dosyas�na yaz�lamad�");
		}	
	}
}