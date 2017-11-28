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
		System.out.println("* 총게임수 :"+m_total);
		System.out.println("* 이긴수 :"+m_win);
		System.out.println("* 비긴수 :"+equal);
		System.out.println("* 진수 :"+m_lost);
		System.out.println("* 승률 :"+rate);
		System.out.println("==================");
		
	}
	private void ShowPlay(int com, int p, int result) {
		System.out.println("computer : "+ getValue(com));
		System.out.println("player : "+ getValue(p));
		switch(result){
		case 0 :
			System.out.println("무승부");
			break;
		case 1 :
			System.out.println("이겼다");
			break;
		case 2 :
			System.out.println("졌다");
			break;
			default:
				System.out.println("졌다.");
				break;
		}
		
	}
	private String getValue(int a) {
		String msg = null;
		
		if(a == 0) msg = "가위";
		else if(a == 1) msg = "바위";
		else if(a == 2) msg = "보";
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

