package GuiHw;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//Car.java 															Author: Berþan Gülce Yurtseven ID: 21997330
//																	e-mail: gulceyurtseven@gmail.com
//Bir arabanýn özellikleri (attribute) olarak burada tanýmlanmýþtýr. 
//Set ve Get fonksiyonlarý sayesinde bu özelliklere eriþim ya da deðer atama saðlanmýþtýr.
//Bir kurucu fonksiyona sahiptir.
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
public class Car {
	private String plate;
	private String gearType;
	private String fuelType;
	private String vehicleGroup;
	private int rentCounter;
	private String pickUpDate;
	private String returnDate;
	
	public Car(String plate, String gearType, String fuelType, String vehicleGroup, int rentCounter, String pickUpDate,String returnDate) {
		super();
		this.plate = plate;
		this.gearType = gearType;
		this.fuelType = fuelType;
		this.vehicleGroup = vehicleGroup;
		this.rentCounter = rentCounter;
		this.pickUpDate = pickUpDate;
		this.returnDate = returnDate;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getGearType() {
		return gearType;
	}
	public void setGearType(String gearType) {
		this.gearType = gearType;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getVehicleGroup() {
		return vehicleGroup;
	}
	public void setVehicleGroup(String vehicleGroup) {
		this.vehicleGroup = vehicleGroup;
	}
	public int getRentCounter() {
		return rentCounter;
	}
	public void setRentCounter(int rentCounter) {
		this.rentCounter = rentCounter;
	}
	public String getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
}