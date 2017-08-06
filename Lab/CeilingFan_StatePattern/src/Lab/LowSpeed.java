package Lab;

public class LowSpeed implements FanState {

	@Override
	public void pullgreen(CeilingFan ceilfan) {
		ceilfan.setFanstate(new MediumSpeed());
		
	}

	@Override
	public void pullred(CeilingFan ceilfan) {
		ceilfan.setFanstate(new Off());
		
	}

	
}
