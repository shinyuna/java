package gbb;

import java.util.Scanner;

public class player {
	Scanner m_key;
	
	public player(){
		m_key = new Scanner(System.in);
	}
	int go(){
		int player_temp = 0;
		try {
			System.out.println("0 : 가위  1 : 바위  2 : 보   -1 : 종료 ");
			player_temp = m_key.nextInt();
			
		} catch (Exception e) {
			player_temp = -1;
		}
		
		
		return player_temp;
	}
}
