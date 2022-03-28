package test;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println("SamsungTV 객체생성");
	}
	
	public void initMethod() {
		System.out.println("객체의 멤버변수들 초기화 작업");
	}
	public void destroyMethod() {
		System.out.println("객체 메모리 해제 작업");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("전원을 켭니다.");
	}
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("전원을 끕니다.");
	}
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("소리를 올립니다.");
	}
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("소리를 내립니다.");
	}

}
