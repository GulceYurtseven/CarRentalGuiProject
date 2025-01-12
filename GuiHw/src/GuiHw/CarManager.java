package GuiHw;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//CarManager.java 													Author: Berþan Gülce Yurtseven ID: 21997330
//																	e-mail: gulceyurtseven@gmail.com
//Arabalarýn car_plate dosyasýna yazýlmasýný saðlar. CarInterface den miras alýr
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CarManager implements CarInterface{
	@Override
	public void addCar(ArrayList<Car> carArray) {//arabalarý Car türünde bir arraylistte tutar
		try {
			BufferedWriter file1Wr = new BufferedWriter(new FileWriter("car_plate.txt",true));//dosya açma
			for(Car car2: carArray) {
				String s = "Plate: " + car2.getPlate() + "  \t" + 
						"Fuel Type: " + car2.getFuelType() + "  \t" + //bütün bir satýrý string s tuttu
						"Gear Type: " + car2.getGearType() + "  \t" + 
						"Vehicle Group: " + car2.getVehicleGroup() +  "  \t" +
						"Pick Up Date: " + car2.getPickUpDate() + "  \t" + 
						"Return Date: " + car2.getReturnDate() + "  \t" + 
						"Rent Counter: " + car2.getRentCounter() + "\n";
				file1Wr.write(s);//dosyaya yazma
				System.out.println("Car dosyasýna yazýldý");
			}
			file1Wr.close();//dosyayý kapatma
		}
		catch
			(IOException e) {//exception
			System.out.println(e.getMessage() + "Car dosyasýna yazýlamadý");
		}
	}
	
}
