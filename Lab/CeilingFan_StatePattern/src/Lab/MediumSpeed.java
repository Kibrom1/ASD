package Lab;

public class MediumSpeed implements FanState {

	@Override
	public void pullgreen(CeilingFan ceilfan) {
		ceilfan.setFanstate(new HighSpeed());
		
	}

	@Override
	public void pullred(CeilingFan ceilfan) {
		ceilfan.setFanstate(new LowSpeed() );
		
	}

}
