package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client { // 사용자, 브라우저
	public static void main(String[] args) {
		// 0. Spring 컨테이너를 실행 시킬 때 필요한 설정 정보 파일(=applicationContext.xml) 생성했기 때문에 1번이 가능!
		// 1. Spring 컨테이너를 실행시킴
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 스프링 컨테이너에게 객체요청
//		TV tv = (TV)factory.getBean("tv"); // 객체를 요청하는 행위 == Lookup
		// applicationContext.xml 에 tv 가 있다면 그것을 생성해줌
		// applicationContext.xml에 <bean class="test.SamsungTV" id="tv" /> id 를 보고 읽어옴
		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.powerOff();
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		// 3. 컨테이너 연결 해제
		factory.close();
		
		
///////////////////////////////////////////////////////////////////////////////////////////////////		
		// 1. 다형성(인터페이스)
//		TV tv = new LgTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.powerOff();
		
		// 2. 디자인 패턴 활용
//		// Factory 패턴 : 객체 생성을 캠슐화하여 결합을 약하게 만듦
//		BeanFactory factory = new BeanFactory();
//		TV tv = (TV)factory.getBean(args[0]);
//		// ★ "new" 라는 코드가 캡슐화 되었기 때문에,
//		// 개발자가 객체 생성을 직접 하지 않는다! 컨테이너가 대신함!!!
//		tv.powerOn();
//		tv.volumeUp();
//		tv.powerOff();
//		// Run -> Run Configurations -> Arguments -> Program arguments 에 lg or samsung 작성 하면 변경됨
		
	}
}
