package insightbook.newjava.ch02;

public class VehicleImpl implements Vehicle {
	
	// public 으로 반드시 선언되어야 한다.
	public int getSpeedLimit() {
		// SPEED_LIMIT 속성이 public static final로 인식된다.
		return Vehicle.SPEED_LIMIT;
	}
}