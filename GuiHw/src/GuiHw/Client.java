package GuiHw;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//Client.java 													Author: Ber�an G�lce Yurtseven ID: 21997330
//																	e-mail: gulceyurtseven@gmail.com
//Bir m��terinin �zellikleri (attribute) olarak burada tan�mlanm��t�r. 
//Set ve Get fonksiyonlar� sayesinde bu �zelliklere eri�im ya da de�er atama sa�lanm��t�r.
//Bir kurucu fonksiyona sahiptir.
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class Client {
	private int id;
	private String name;
	private int rentCounter;
	private String pickUpLocation;
	private String returnLocation;
	private double pay;
	
	public Client() {
	}

	public Client(int id, String name, int rentCounter, String pickUpLocation, String returnLocation, double pay) {
		super();
		this.id = id;
		this.name = name;
		this.rentCounter = rentCounter;
		this.pickUpLocation = pickUpLocation;
		this.returnLocation = returnLocation;
		this.pay = pay;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRentCounter() {
		return rentCounter;
	}
	public void setRentCounter(int rentCounter) {
		this.rentCounter = rentCounter;
	}
	public String getPickUpLocation() {
		return pickUpLocation;
	}
	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	public String getReturnLocation() {
		return returnLocation;
	}
	public void setReturnLocation(String returnLocation) {
		this.returnLocation = returnLocation;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
}