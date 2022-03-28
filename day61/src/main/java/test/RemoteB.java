package test;

public class RemoteB implements Remote {

	public RemoteB() {
		System.out.println("B 리모컨 생성완료");
	}
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("B: 소리 ++");
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("B: 소리 --");
		
	}

}
