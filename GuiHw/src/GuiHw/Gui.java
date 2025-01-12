package GuiHw;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//Gui.java 												Author: Ber�an G�lce Yurtseven ID: 21997330
//																	e-mail: gulceyurtseven@gmail.com
//Gui tasar�mn�n yap�ld��� class
//JFrame ve ActionListenerdan miras al�r
//rezervasyon i�lemi, fatura olu�turma,reservation dosyas� olu�turma i�lemleri burada yap�l�r.
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.IOException;

public class Gui extends JFrame{
	private final JLabel label1 = new JLabel("Id: ");
	private final JLabel label2 = new JLabel("Name: ");
	private final JLabel label4 = new JLabel("Pick Up Location: ");
	private final JLabel label5 = new JLabel("Return Location: ");
	private final JLabel label6 = new JLabel("Pay: ");
	private final JLabel spaceLabel = new JLabel("------------------------------------");//guinin daha d�zenli g�r�nmesi i�i labellar
	private final JLabel spaceLabel2 = new JLabel("-----------------------------------");  
	private final JLabel spaceLabel3 = new JLabel("-----------------------------------"); 
	                                                                                                     
	private final JLabel label9 = new JLabel("Free Features:");
	private final JLabel label0 = new JLabel("Paid Features:");
	
	private final JTextField idTtext = new JTextField(10);
	private final JTextField nameText = new JTextField(10);
	private final JTextField pickUpLocationText = new JTextField(10);
	private final JTextField returnLocationText = new JTextField(10);
	private final JTextField payText = new JTextField(10);
	private final JTextField plateText = new JTextField("Plate",10);
	private final JTextField gearTypeText = new JTextField("Gear Type",10);
	private final JTextField fuelTypeText = new JTextField("Fuel Type",10);
	private final JTextField vehicleGroupText = new JTextField("Vehicle",10);
	private final JTextField pickUpDateText = new JTextField("Pick Up Date",10);
	private final JTextField returnDateText = new JTextField("Return Date",10);
	
	private final JButton resButton = new JButton("Reservation");//butonlar
	private final JButton invoiceButton = new JButton("Invoice");
	private final JButton fileButton = new JButton("File");
	private final JButton clearButton = new JButton("Clear");

	private final JCheckBox roofrackJCheckBox = new JCheckBox("Roof Rack(+100)");//�cretli se�enekler i�in heckboxlar
	private final JCheckBox trailerJCheckBox = new JCheckBox("Trailer(+200)");
	private final JCheckBox snowchainsJCheckBox = new JCheckBox("Snow Chains(+150)");
	private final JCheckBox navigationJCheckBox = new JCheckBox("Navigatios(+120)");
	private final JCheckBox childseatsJCheckBox = new JCheckBox("Child Seats(+110)");
	
	private final JRadioButton automaticTransmissionRadioButton = new JRadioButton("Automatic Transmission");//�ctersiz se�enekler i�in radiobuttonlar
	private final JRadioButton manualTransmissionRadioButton = new JRadioButton("Manual Transmission");
	private final JRadioButton twoDoorsRadioButton = new JRadioButton("Two Doors");
	private final JRadioButton fourDoorsRadioButton = new JRadioButton("Four Doors");
	private final JRadioButton smokerCarRadioButton = new JRadioButton("Smoker Car");
	private final JRadioButton nonsmokerCarRadioButton = new JRadioButton("Nonsmoker Car");
	private ButtonGroup radioGroup, radioGroup2, radioGroup3; 
	
	private final JTextArea invoiceTextArea = new JTextArea("Invoice",10,20);//fatura i�in textarea
	
	private int rentCar1Counter = 0;//her araban�n ka� defa kiraland���n� tutan counter lar
	private int rentCar2Counter = 0;
	private int rentCar3Counter = 0;
	private int rentCar4Counter = 0;
	
	String[] cars = {"BMW", "Ford", "Toyota", "Volvo"};//arabalar
	JComboBox carsComboBox = new JComboBox(cars);//arablar� gui de g�steren combobx
	
	CalculatedNoOfDays d = new CalculatedNoOfDays();//iki tarih aras� g�n hesab� i�in
	
	public Gui() throws IOException {
		ArrayList <Client> clientArray = new ArrayList<>();//m��terilerin tutulaca�� array
		ArrayList <Car> carArray = new ArrayList<>();//arablar�n tutulaca�� array
		
		Car car1= new Car("06-BD-2829", "Otomatik", "Benzin", "V tipi motor", 0 , pickUpDateText.getText() , returnDateText.getText());
    	Car car2 = new Car("78-ED-078", "Manuel", "Benzin", "A tipi motor", 0 , " ", " ");
    	Car car3= new Car("01-ABC-1021", "Otomatik", "Benzin", "B tipi motor", 0 , " ", " ");
    	Car car4 = new Car("13-AC-0890", "Otomatik", "Dizel", "C tipi motor", 0 , " ", " ");
		 
    	//gui tasar�m�
		//client
		setLayout(new FlowLayout());
		add(label1);
		add(idTtext);
		add(label2);
		add(nameText);
		add(label4);
		add(pickUpLocationText);
		add(label5);
		add(returnLocationText);
		add(label6);
		add(payText);
		payText.setEditable(false);

		//car	
		add(carsComboBox);
		add(plateText);
		plateText.setEditable(false);
		add(gearTypeText);
		gearTypeText.setEditable(false);
		add(fuelTypeText);
		fuelTypeText.setEditable(false);
		add(vehicleGroupText);
		vehicleGroupText.setEditable(false);
		add(pickUpDateText);
		add(returnDateText);
		
		add(spaceLabel);
		add(label9);
		add(automaticTransmissionRadioButton);
		add(manualTransmissionRadioButton);
		add(fourDoorsRadioButton);
		add(twoDoorsRadioButton);
		add(smokerCarRadioButton);
		add(nonsmokerCarRadioButton);
	
		radioGroup = new ButtonGroup(); // create ButtonGroup
	      radioGroup.add(automaticTransmissionRadioButton);
	      radioGroup.add(manualTransmissionRadioButton);
	    radioGroup2 = new ButtonGroup();  
	      radioGroup2.add(fourDoorsRadioButton);
	      radioGroup2.add(twoDoorsRadioButton);
	    radioGroup3 = new ButtonGroup();
	      radioGroup3.add(smokerCarRadioButton);
	      radioGroup3.add(nonsmokerCarRadioButton);
	     
	    add(label0);
	    add(roofrackJCheckBox);
	    add(navigationJCheckBox);
	    add(snowchainsJCheckBox);
	    add(childseatsJCheckBox);
	    add(trailerJCheckBox);
	    add(spaceLabel2);
		
		add(resButton);
		add(invoiceButton);
		add(fileButton);
		add(clearButton);
		add(spaceLabel3);
		
		add(invoiceTextArea);
		invoiceTextArea.setEditable(false);	
		
		ClientInterface a = new ClientManager();//ClientManager i�indeki methoda ula�mak i�in
		CarInterface b = new CarManager();//CarManager i�indeki methoda ula�mak i�in
		
		clearButton.addActionListener( new ActionListener() { // anonymous inner class starts here
			public void actionPerformed(ActionEvent e) {//clear butonu gui yi temizler
				idTtext.setText("");
				nameText.setText("");
				pickUpLocationText.setText("");
				returnLocationText.setText("");
				payText.setText("");
				
				manualTransmissionRadioButton.setEnabled(true);
				automaticTransmissionRadioButton.setEnabled(true);
				fourDoorsRadioButton.setEnabled(true);
				twoDoorsRadioButton.setEnabled(true);
				smokerCarRadioButton.setEnabled(true);
				nonsmokerCarRadioButton.setEnabled(true);
				
				radioGroup.clearSelection();
				radioGroup2.clearSelection();
				radioGroup3.clearSelection();
				
				invoiceTextArea.setText("");
				
				carsComboBox.setSelectedIndex(-1);
				
				plateText.setText("Plate");
				gearTypeText.setText("Gear Type");
				fuelTypeText.setText("Fuel Type");
				vehicleGroupText.setText("Vehicle Group");
				pickUpDateText.setText("Pick Up Date");
				returnDateText.setText("Return Date");
							
				roofrackJCheckBox.setSelected(false);
				childseatsJCheckBox.setSelected(false);
				navigationJCheckBox.setSelected(false);
				snowchainsJCheckBox.setSelected(false);
				trailerJCheckBox.setSelected(false);
				
				}
			}
		);
		fileButton.addActionListener( new ActionListener() { // anonymous inner class starts here
			public void actionPerformed(ActionEvent e) {//client dosyas� olu�turma
				a.addClient(clientArray);
				}
			}
		);				
		resButton.addActionListener( new ActionListener() { // anonymous inner class starts here
			public void actionPerformed(ActionEvent e) {
				
				String idString = idTtext.getText();// girilen id yi integer a �evirme
				int id = Integer.parseInt(idString);
				int rentCounter = 1;//m��terilerin ka� defa rezervasyon yapt�klar�n� tutan counter
				
				for(Client client1: clientArray) {
					if(Integer.parseInt(idTtext.getText()) == client1.getId()) {
						rentCounter++;
						client1.setRentCounter(rentCounter);//counter �n Client class �na g�derildi�i yer
					} 
				}

				Client client = new Client(id,nameText.getText(),rentCounter ,pickUpLocationText.getText(),returnLocationText.getText(),Integer.parseInt(payText.getText()));
				clientArray.add(client);
				pay(client);//�cret hesab�
				//System.out.println("i = " + rentCounter);

				
				if(carsComboBox.getSelectedItem() == "BMW") {
					try {
						rentCar1Counter++;
						
						car1.setRentCounter(rentCar1Counter);//araban�n ka� kere kiraland���n� Car calss�na g�nderir					
						car1.setPickUpDate(pickUpDateText.getText());//yaz�lan tarihleri Car class�na g�nderme
						car1.setReturnDate(returnDateText.getText());
						carArray.add(car1);//arabay� arrayliste ekler
						b.addCar(carArray);//arabay� car_plate e ekler
						carArray.remove(car1);// ayn� nesne bir den �ok kullan�laca��ndan, �nceki verilen bilgileir kaybetmemk ad�na arraydan bu eleman� siler					
						
						FileWriter file1Wr = new FileWriter("reservation.txt",true);
						String s = "Client id:" + client.getId() + "\t" + 
								"Gear Type: " + car1.getGearType() + "\t" + 
								"Fuel Type: " + car1.getFuelType() + "\t" + 
								"Vehicle Group: " + car1.getVehicleGroup() + "\t" + 
								"Pick Up Location: " + client.getPickUpLocation() + "\t" +  
								"Pick Up Date: " + car1.getPickUpDate() + "\t" + 
								"Return Location: " + client.getReturnLocation() + "\t" + 
								"Return Date: " +car1.getReturnDate() + "\n";
						   file1Wr.write(s);
						System.out.println("reservation car1");
						file1Wr.close();
					}catch (IOException e1) {//exception
						System.out.println(e1.getMessage()+"Reservation dosyas� olu�turulamad�");
					}
				}
				if(carsComboBox.getSelectedItem() == "Ford") {
					try {
						rentCar2Counter++;			
						car2.setRentCounter(rentCar2Counter);//araban�n ka� kere kiraland���n� Car calss�na g�nderir
						
						car2.setPickUpDate(pickUpDateText.getText());//yaz�lan tarihleri Car class�na g�nderme
						car2.setReturnDate(returnDateText.getText());
						carArray.add(car2);//arabay� arrayliste ekler
						b.addCar(carArray);//arabay� car_plate e ekler
						carArray.remove(car2);// ayn� nesne bir den �ok kullan�laca��ndan, �nceki verilen bilgileir kaybetmemk ad�na arraydan bu eleman� siler		
						
						FileWriter file1Wr = new FileWriter("reservation.txt",true);
						String s = "Client id:" + client.getId() + "\t" + 
								"Gear Type: " + car2.getGearType() + "\t" + 
								"Fuel Type: " + car2.getFuelType() + "\t" + 
								"Vehicle Group: " + car2.getVehicleGroup() + "\t" + 
								"Pick Up Location: " + client.getPickUpLocation() + "\t" +  
								"Pick Up Date: " + car2.getPickUpDate() + "\t" + 
								"Return Location: " + client.getReturnLocation() + "\t" + 
								"Return Date: " +car2.getReturnDate() + "\n";
						file1Wr.write(s);
					System.out.println("reservation car2");
					file1Wr.close();
					}catch (IOException e1) {//exception
						System.out.println(e1.getMessage()+"Reservation dosyas� olu�turulamad�");
					}
				}
				
				if(carsComboBox.getSelectedItem() == "Toyota") {
					try {
						rentCar3Counter++;
						car3.setRentCounter(rentCar3Counter);//araban�n ka� kere kiraland���n� Car calss�na g�nderir
						
						car3.setPickUpDate(pickUpDateText.getText());//yaz�lan tarihleri Car class�na g�nderme
						car3.setReturnDate(returnDateText.getText());
						carArray.add(car3);//arabay� arrayliste ekler
						b.addCar(carArray);//arabay� car_plate e ekler
						carArray.remove(car3);// ayn� nesne bir den �ok kullan�laca��ndan, �nceki verilen bilgileir kaybetmemk ad�na arraydan bu eleman� siler		
						
						FileWriter file1Wr = new FileWriter("reservation.txt",true);
						String s = "Client id:" + client.getId() + "\t" + 
								"Gear Type: " + car3.getGearType() + "\t" + 
								"Fuel Type: " + car3.getFuelType() + "\t" + 
								"Vehicle Group: " + car3.getVehicleGroup() + "\t" + 
								"Pick Up Location: " + client.getPickUpLocation() + "\t" +  
								"Pick Up Date: " + car3.getPickUpDate() + "\t" + 
								"Return Location: " + client.getReturnLocation() + "\t" + 
								"Return Date: " +car3.getReturnDate() + "\n";
						file1Wr.write(s);
					System.out.println("reservation car3");
					file1Wr.close();
					}catch (IOException e1) {//exception
						System.out.println(e1.getMessage()+"Reservation dosyas� olu�turulamad�");
					}
				}			
				if(carsComboBox.getSelectedItem() == "Volvo") {
					try {
						rentCar4Counter++;
						car4.setRentCounter(rentCar4Counter);//araban�n ka� kere kiraland���n� Car calss�na g�nderir
						
						car4.setPickUpDate(pickUpDateText.getText());//yaz�lan tarihleri Car class�na g�nderme
						car4.setReturnDate(returnDateText.getText());
						carArray.add(car4);//arabay� arrayliste ekler
						b.addCar(carArray);//arabay� car_plate e ekler
						carArray.remove(car4);// ayn� nesne bir den �ok kullan�laca��ndan, �nceki verilen bilgileir kaybetmemk ad�na arraydan bu eleman� siler		
						
						FileWriter file1Wr = new FileWriter("reservation.txt",true);
						String s = "Client id:" + client.getId() + "\t" + 
								"Gear Type: " + car4.getGearType() + "\t" + 
								"Fuel Type: " + car4.getFuelType() + "\t" + 
								"Vehicle Group: " + car4.getVehicleGroup() + "\t" + 
								"Pick Up Location: " + client.getPickUpLocation() + "\t" +  
								"Pick Up Date: " + car4.getPickUpDate() + "\t" + 
								"Return Location: " + client.getReturnLocation() + "\t" + 
								"Return Date: " +car4.getReturnDate() + "\n";
						file1Wr.write(s);
					System.out.println("reservation car4");
					file1Wr.close();
					}catch (IOException e1) {//exception
						System.out.println(e1.getMessage()+"Reservation dosyas� olu�turulamad�");
					}
				}			
			}
		}
	);     
		invoiceButton.addActionListener(new ActionListener() {//anonymous inner class
			public void actionPerformed(ActionEvent e) {//invoice butonuna bas�ld���nda fatura olu�turulur
				//texte kullan�c�n�n se�ti�i ya da yazd��� �zellikleri faturaya ekleme
				invoiceTextArea.append("M��teri id: " + idTtext.getText()+"\n");
				invoiceTextArea.append("M��teri ismi: " + nameText.getText()+"\n");
				invoiceTextArea.append("Arabay� teslim ald��� yer: " + pickUpLocationText.getText()+"\n");
				invoiceTextArea.append("Arabay� teslim edece�i yer: " + returnLocationText.getText()+"\n");
				invoiceTextArea.append("�denecek tutar: " + payText.getText()+"\n");
				invoiceTextArea.append("Se�ilen araba: "+ carsComboBox.getSelectedItem() + "\n");
				invoiceTextArea.append("Se�ilen �cretsiz �zellikler: " +"\n");
				
				if (automaticTransmissionRadioButton.isSelected() || manualTransmissionRadioButton.isSelected()) {
					if(automaticTransmissionRadioButton.isSelected()) {
						invoiceTextArea.append(automaticTransmissionRadioButton.getText()+"\n");
						manualTransmissionRadioButton.setEnabled(false);
					}
					if(manualTransmissionRadioButton.isSelected()) {
						invoiceTextArea.append(manualTransmissionRadioButton.getText()+"\n");
						automaticTransmissionRadioButton.setEnabled(false);
					}
		         }   
		         if (fourDoorsRadioButton.isSelected() || twoDoorsRadioButton.isSelected()) {
		        	 if(fourDoorsRadioButton.isSelected() ) {
		        		 invoiceTextArea.append(fourDoorsRadioButton.getText()+"\n");
		        		 twoDoorsRadioButton.setEnabled(false);
		        	 }
		        	 if(twoDoorsRadioButton.isSelected()) {
		        		 invoiceTextArea.append(twoDoorsRadioButton.getText()+"\n");
		        		 fourDoorsRadioButton.setEnabled(false);
		        	 }
		         }
		         if (smokerCarRadioButton.isSelected() || nonsmokerCarRadioButton.isSelected()) {
		        	 if(smokerCarRadioButton.isSelected()) {
		        		  invoiceTextArea.append(smokerCarRadioButton.getText()+"\n");
		        		  nonsmokerCarRadioButton.setEnabled(false);
		        	 }
		        	 if(nonsmokerCarRadioButton.isSelected()) {
		        		 invoiceTextArea.append(nonsmokerCarRadioButton.getText()+"\n");
		        		 smokerCarRadioButton.setEnabled(false);
		        	 }	        
		          }
		         invoiceTextArea.append("Se�ilen �cterli �zellikler: " +"\n");
		         if(roofrackJCheckBox.isSelected()) {
		        		invoiceTextArea.append(roofrackJCheckBox.getText()+"\n");
		         }
		         if(trailerJCheckBox.isSelected()) {
		        		invoiceTextArea.append(trailerJCheckBox.getText()+"\n");
		         }
		         if(snowchainsJCheckBox.isSelected()) {
		        		invoiceTextArea.append(snowchainsJCheckBox.getText()+"\n");
		         }
		         if(navigationJCheckBox.isSelected()) {
		        		invoiceTextArea.append(navigationJCheckBox.getText()+"\n");
		         }
		         if(childseatsJCheckBox.isSelected()) {
		        		invoiceTextArea.append(childseatsJCheckBox.getText()+"\n");
		         } 
			    }
		      }
		    ); 			
	     carsComboBox.addActionListener( new ActionListener() {//se�ilen araban�n �zelliklerini text lere yazmay� sa�layan anonymous class
				public void actionPerformed(ActionEvent e) {
					if(carsComboBox.getSelectedItem() == "BMW") {
						plateText.setText(car1.getPlate());
						gearTypeText.setText(car1.getGearType());
						fuelTypeText.setText(car1.getFuelType());
						vehicleGroupText.setText(car1.getVehicleGroup());
						pickUpDateText.setText(car1.getPickUpDate());
						returnDateText.setText(car1.getReturnDate());
						payText.setText("700");
					}
					if(carsComboBox.getSelectedItem() == "Ford") {
						plateText.setText(car2.getPlate());
						gearTypeText.setText(car2.getGearType());
						fuelTypeText.setText(car2.getFuelType());
						vehicleGroupText.setText(car2.getVehicleGroup());
						pickUpDateText.setText(car2.getPickUpDate());
						returnDateText.setText(car2.getReturnDate());
						payText.setText("600");
					}
					
					if(carsComboBox.getSelectedItem() == "Totoya") {
						plateText.setText(car3.getPlate());
						gearTypeText.setText(car3.getGearType());
						fuelTypeText.setText(car3.getFuelType());
						vehicleGroupText.setText(car3.getVehicleGroup());
						pickUpDateText.setText(car3.getPickUpDate());
						returnDateText.setText(car3.getReturnDate());
						payText.setText("800");
					}
					if(carsComboBox.getSelectedItem() == "Volvo") {
						plateText.setText(car4.getPlate());
						gearTypeText.setText(car4.getGearType());
						fuelTypeText.setText(car4.getFuelType());
						vehicleGroupText.setText(car4.getVehicleGroup());
						pickUpDateText.setText(car4.getPickUpDate());
						returnDateText.setText(car4.getReturnDate());
						payText.setText("900");
					}				
				}
	     	}
	    );   
	}
    public void pay(Client c) {//�cterin hesapland��� yer, reservation anonymous inner class�nda �a�r�l�r
    	String day = pickUpDateText.getText();//girilen tarihleri guiden �ekme
    	String day2 = returnDateText.getText();
    	int o = d.calculate(day, day2);//bu tarihlerin aras�ndaki g�n fark�n� d�nd�r�r
    	System.out.println("g�n fark�" + o);
    	double a = (c.getPay()*o);
     	if(childseatsJCheckBox.isSelected()) {
     		a=a+110;
     		c.setPay(a);//yani paray� Client class�na atar
     		payText.setText(String.valueOf(a));
				}
     	if(roofrackJCheckBox.isSelected()) {
     		a=a+100;
     		c.setPay(a);//yani paray� Client class�na atar
     		payText.setText(String.valueOf(a));
     	}
     	if(navigationJCheckBox.isSelected()) {
     		a=a+120;
     		c.setPay(a);//yani paray� Client class�na atar
     		payText.setText(String.valueOf(a));
     	}
     	if(snowchainsJCheckBox.isSelected()) {
     		a=a+150;
     		c.setPay(a);//yani paray� Client class�na atar
     		payText.setText(String.valueOf(a));
     	}
     	if(trailerJCheckBox.isSelected()) {
     		a=a+200;
     		c.setPay(a);//yani paray� Client class�na atar
     		payText.setText(String.valueOf(a));
     	}
	}
}