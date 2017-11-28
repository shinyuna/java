package gbb;

import java.util.Random;

public class computer {
	Random m_rand;
	
	public computer(){ //생성자 (class랑 같은 이름)
		m_rand = new Random();
	}
	
	int go(){
		return  m_rand.nextInt(3); //0 1 2	
	}
}
