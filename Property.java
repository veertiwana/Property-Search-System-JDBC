import java.util.Scanner;
import java.util.List;


public class Property{
	int propertyId;
	String noOfRooms;
	double areaInSqFt;
	int floorNo;
	String city;
	String state;
	double cost;
	String ownerName;
	String ownerContactNo;
	Property(){}
	
	Property(int ID, String Rooms, double Area, int Floor, String City, String State, double Cost, String Owner, String Contact){
		this.propertyId=ID;
		this.noOfRooms=Rooms;
		this.floorNo=Floor;
		this.city=City;
		this.state=State;
		this.cost=Cost;
		this.ownerName=Owner;
		this.ownerContactNo=Contact;
	}
	@Override
    public String toString() {
        return "propertyId=" + propertyId +
                ", noOfRooms=" + noOfRooms +
                ", areaInSqft=" + areaInSqFt +
                ", floorNo=" + floorNo +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", cost=" + cost +
                ", ownerName='" + ownerName + '\'' +
                ", ownerContactNo='" + ownerContactNo + '\'' ;
    }	
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public String getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(String noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public double getAreaInSqFt() {
		return areaInSqFt;
	}
	public void setAreaInSqFt(double areaInSqFt) {
		this.areaInSqFt = areaInSqFt;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerContactNo() {
		return ownerContactNo;
	}
	public void setOwnerContactNo(String ownerContactNo) {
		this.ownerContactNo = ownerContactNo;
	}
	
}