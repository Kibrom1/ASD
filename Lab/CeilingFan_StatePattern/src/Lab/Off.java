package Lab;

public class Off implements FanState{

	@Override
	public void pullgreen(CeilingFan ceilfan) {
		ceilfan.setFanstate(new LowSpeed());
		
	}

	@Override
	public void pullred(CeilingFan ceilfan) {
		ceilfan.setFanstate(new HighSpeed());
		
	}

}
