package gbb;

public class gbbClass {
	computer m_com;
	player m_player;
	int m_total;
	int m_win;
	int m_lost;
	
	public gbbClass(){
		m_com = new computer();
		m_player = new player();
		m_total = m_win = m_lost = 0 ;
	}
	private void run(){
		int com;
		int p;
		int result; //0same 1win 2lost
		while(true){
			p = m_player.go();
			com = m_com.go();
			
			if(p == -1) break;
			result = checkGame(com,p);
			
			ShowPlay(com,p,result);
		}
		showEndGame();
		
	}
	private void showEndGame() {
		int equal;
		float rate;
		
		equal = m_total - (m_win + m_lost);
		rate = (float)m_win / m_total;
		
		System.out.println("==================");
		System.out.println("* �Ѱ��Ӽ� :"+m_total);
		System.out.println("* �̱�� :"+m_win);
		System.out.println("* ���� :"+equal);
		System.out.println("* ���� :"+m_lost);
		System.out.println("* �·� :"+rate);
		System.out.println("==================");
		
	}
	private void ShowPlay(int com, int p, int result) {
		System.out.println("computer : "+ getValue(com));
		System.out.println("player : "+ getValue(p));
		switch(result){
		case 0 :
			System.out.println("���º�");
			break;
		case 1 :
			System.out.println("�̰��");
			break;
		case 2 :
			System.out.println("����");
			break;
			default:
				System.out.println("����.");
				break;
		}
		
	}
	private String getValue(int a) {
		String msg = null;
		
		if(a == 0) msg = "����";
		else if(a == 1) msg = "����";
		else if(a == 2) msg = "��";
		return msg;
	}
	private int checkGame(int com, int p) {
		int a = 0; //0same 1win 2lost
		m_total++;
		
		if(com == p)a = 0;
		else if(com ==0 && p ==1){
			a = 1;
			m_win++;
		}else if(com ==0 && p ==2){
			a = 2;
			m_lost++;
		}else if(com ==1 && p ==0){
			a = 2;
			m_lost++;
		}else if(com ==1 && p ==2){
			a = 1;
			m_win++;
		}else if(com ==2 && p ==0){
			a = 1;
			m_win++;
		}else if(com ==2 && p ==1){
			a = 2;
			m_lost++;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		gbbClass m = new gbbClass();
		m.run();
	}

	

}

