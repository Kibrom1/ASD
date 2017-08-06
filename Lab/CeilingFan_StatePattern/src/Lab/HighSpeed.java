package Lab;

public class HighSpeed implements FanState {

	@Override
	public void pullgreen(CeilingFan ceilfan) {
		ceilfan.setFanstate(new Off());
		
	}

	@Override
	public void pullred(CeilingFan ceilfan) {
	ceilfan.setFanstate(new MediumSpeed());
		
	}

}
