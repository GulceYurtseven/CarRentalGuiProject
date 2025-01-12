package GuiHw;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//Test.java 												Author: Berþan Gülce Yurtseven ID: 21997330
//																	e-mail: gulceyurtseven@gmail.com
//Main
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import java.io.IOException;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		
		Gui gui;//gui nin çaðrýldýðý yer
		try {
			gui = new Gui();	
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gui.setTitle("Rent a Car");//gui baþlýðý
			gui.setSize(880, 450); //gui boyutu
			gui.setResizable(false);// gui büyütülebilmesi == false
			gui.setVisible(true); // görünür hale getirme
	    
		} catch (IOException e) {// exception
			System.out.println(e.getMessage() + "Uygulama Baþlatýlamadý");
		} 
	}
}
