package exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("galaxy")
public class Galaxy implements Phone {
	@Autowired
	private Watch watch;
	
	public Galaxy() {
		System.out.println("갤럭시 폰 생성");
	}
	public Galaxy(Watch watch) {
		System.out.println("갤럭시 폰 생성");
		this.watch = watch;
	}

	@Override
	public void powerOn() {
		System.out.println("폰으로 갤럭시 전원 켜기");
	}

	@Override
	public void powerOff() {
		System.out.println("폰으로 갤럭시 전원 끄기");
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
