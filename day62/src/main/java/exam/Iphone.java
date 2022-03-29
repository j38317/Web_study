package exam;

public class Iphone implements Phone {
	
	private Watch watch;
	
	
	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public Iphone() {
		System.out.println("아이폰 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("폰으로 아이폰 전원 켜기");
	}

	@Override
	public void powerOff() {
		System.out.println("폰으로 아이폰 전원 끄기");
		
	}

	@Override
	public void soundUp() {
		watch.soundUp();
	}

	@Override
	public void soundDown() {
		watch.soundDown();
		
	}

}
