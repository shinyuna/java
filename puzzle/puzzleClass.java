package puzzle;

import javax.swing.JFrame;

public class puzzleClass extends JFrame {
	View m_view;
	
	public puzzleClass(){
		m_view = new View();
		add(m_view);
		setTitle("��������");
		setSize(200,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x������ �� ���μ����� ������
		
	}
		public static void main(String[] args) {
			puzzleClass m = new puzzleClass();
		}
}
