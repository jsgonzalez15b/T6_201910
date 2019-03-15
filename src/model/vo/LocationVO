package model.vo;

public class LocationVO implements Comparable<LocationVO> {

	private int adressId; 
	private String location; 
	private  int numberOfRegisters; 

	public LocationVO(int pId, String pLocatio, int pNumber) {
		adressId=pId;
		location=pLocatio;
		numberOfRegisters=pNumber; 
	}

	public int darId() {
		return adressId;
	}
	
	public String darLocation() {
		return location;
	}
	
	public int darNumberOfRegisters() {
		return numberOfRegisters;
	}
	public int compareTo(LocationVO otro) {
	
		if(this.numberOfRegisters==otro.darNumberOfRegisters()) {
			return this.location.compareTo(otro.darLocation())==0?0:(this.location.compareTo(otro.darLocation())>0?1:-1);
		}else {
			return this.numberOfRegisters>otro.darNumberOfRegisters()?1:-1;
		}
	}

}
