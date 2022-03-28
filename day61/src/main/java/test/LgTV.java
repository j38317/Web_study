package test;

public class LgTV implements TV {
	private Remote remote;
	private int tvid;
	
	public LgTV() {
		System.out.println("LgTV 객체생성");
	}
	public LgTV(Remote remote) {
		// 생성자를 통해 의존관계에 있는 객체를 주입
		// 생성자 주입(생성자 인젝션)
		System.out.println("LgTV 객체생성2");
		this.remote = remote;
	}
	public LgTV(Remote remote, int tvid) {
		// 생성자를 통해 의존관계에 있는 객체를 주입
		// 생성자 주입(생성자 인젝션)
		System.out.println("LgTV 객체생성333");
		this.remote = remote;
		this.tvid = tvid;
		
	}
	
	public void powerOn() {
		System.out.println("전원 ON tvid:" + tvid);
	}
	public void powerOff() {
		System.out.println("전원 OFF tvid:" + tvid);
	}
	public void volumeUp() {
		remote.volumeUp();
	}
	public void volumeDown() {
		remote.volumeDown();
	}
}
