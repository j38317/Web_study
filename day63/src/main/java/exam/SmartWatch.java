package exam;

public class SmartWatch implements Watch {
	
	public SmartWatch() {
		System.out.println("스마트워치 생성");
	}

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		System.out.println("스마트워치로 소리 올리기");
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		System.out.println("스마트워치로 소리 줄이기");		
	}

}
