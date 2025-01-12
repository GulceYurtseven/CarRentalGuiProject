package GuiHw;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//Test.java 												Author: Ber�an G�lce Yurtseven ID: 21997330
//																	e-mail: gulceyurtseven@gmail.com
//Main
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import java.io.IOException;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		
		Gui gui;//gui nin �a�r�ld��� yer
		try {
			gui = new Gui();	
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gui.setTitle("Rent a Car");//gui ba�l���
			gui.setSize(880, 450); //gui boyutu
			gui.setResizable(false);// gui b�y�t�lebilmesi == false
			gui.setVisible(true); // g�r�n�r hale getirme
	    
		} catch (IOException e) {// exception
			System.out.println(e.getMessage() + "Uygulama Ba�lat�lamad�");
		} 
	}
}
