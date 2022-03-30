package exam;

public class AppleWatch implements Watch {
	public AppleWatch() {
		System.out.println("애플워치 생성");
	}

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		System.out.println("애플워치로 소리 올리기");
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		System.out.println("애플워치로 소리 줄이기");		
	}

}
