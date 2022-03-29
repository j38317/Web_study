package exam;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		Phone phone =(Phone)factory.getBean("galaxy");
		
		phone.powerOn();
		phone.soundUp();
		phone.soundDown();
		phone.powerOff();
		
		
		
//		Phone phone2 =(Phone)factory.getBean("iphone");
//		
//		phone2.powerOn();
//		phone2.soundUp();
//		phone2.soundDown();
//		phone2.powerOff();
		
		
		factory.close();
		
		
	}

}
