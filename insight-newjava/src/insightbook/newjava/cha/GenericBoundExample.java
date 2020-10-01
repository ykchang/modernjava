package insightbook.newjava.cha;

import insightbook.newjava.cha.vo.Sedan;
import insightbook.newjava.cha.vo.Truck;
import insightbook.newjava.cha.vo.Vehicle;


public class GenericBoundExample<T extends Vehicle> {
	private T vehicleType;
	
	public void setVehicleType(T vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public T getVehicleType() {
		return vehicleType;
	}
	
	public static void main(String[] args) {
		GenericBoundExample<Sedan> sedan = new GenericBoundExample<Sedan>();
		GenericBoundExample<Truck> truck = new GenericBoundExample<Truck>();
//		GenericBoundExample<String> error = new GenericBoundExample<String>();
	}
}