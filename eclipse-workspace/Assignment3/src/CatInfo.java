
public class CatInfo {

	final String name;
	final int monthHired;
	final int furThickness;
	final int nextGroomingAppointment;
	final int expectedGroomingCost;
	
	public CatInfo(String name, int monthHired, int furThickness, int nextGroomingAppointment, int expectedGroomingCost){
		this.name = name;
		this.monthHired = monthHired;
		this.furThickness = furThickness;
		this.nextGroomingAppointment = nextGroomingAppointment;
		this.expectedGroomingCost = expectedGroomingCost;
	}
	
	public String toString(){
		String result = this.name + "(" + this.monthHired + " , " + this.furThickness + ")";
		return result;
	}
	
	public boolean equals(CatInfo b){
		boolean temp = this.name.equals(b.name);
		temp = temp && this.nextGroomingAppointment == b.nextGroomingAppointment;
		temp = temp && this.monthHired == b.monthHired;
		temp = temp && this.furThickness == b.furThickness;
		temp = temp && this.expectedGroomingCost == b.expectedGroomingCost;
		return temp;
	}
	


}
