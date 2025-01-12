package GuiHw;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//CarManager.java 													Author: Ber�an G�lce Yurtseven ID: 21997330
//																	e-mail: gulceyurtseven@gmail.com
//Arabalar�n car_plate dosyas�na yaz�lmas�n� sa�lar. CarInterface den miras al�r
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CarManager implements CarInterface{
	@Override
	public void addCar(ArrayList<Car> carArray) {//arabalar� Car t�r�nde bir arraylistte tutar
		try {
			BufferedWriter file1Wr = new BufferedWriter(new FileWriter("car_plate.txt",true));//dosya a�ma
			for(Car car2: carArray) {
				String s = "Plate: " + car2.getPlate() + "  \t" + 
						"Fuel Type: " + car2.getFuelType() + "  \t" + //b�t�n bir sat�r� string s tuttu
						"Gear Type: " + car2.getGearType() + "  \t" + 
						"Vehicle Group: " + car2.getVehicleGroup() +  "  \t" +
						"Pick Up Date: " + car2.getPickUpDate() + "  \t" + 
						"Return Date: " + car2.getReturnDate() + "  \t" + 
						"Rent Counter: " + car2.getRentCounter() + "\n";
				file1Wr.write(s);//dosyaya yazma
				System.out.println("Car dosyas�na yaz�ld�");
			}
			file1Wr.close();//dosyay� kapatma
		}
		catch
			(IOException e) {//exception
			System.out.println(e.getMessage() + "Car dosyas�na yaz�lamad�");
		}
	}
	
}
