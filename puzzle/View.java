package puzzle;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JPanel implements MouseListener{
	int[][] m_data = {{1,2,3},{4,5,6},{7,8,9}};
	Random rd;
	
	public View(){
		rd = new Random();
		initData(10);
		addMouseListener(this);
	}
	private void initData(int loop) {
		int dx = 2; int dy = 2;
		for (int i = 0; i < loop; i++) {
			switch (rd.nextInt(4)) {
			case 0: //right
				if((dx+1)<= 2){
					m_data[dy][dx]=m_data[dy][dx+1];
					dx++;
					m_data[dy][dx]=0;
				}else
					i--;
					break;

			case 1://left
				if((dx-1)>= 0){
					m_data[dy][dx]=m_data[dy][dx-1];
					dx--;
					m_data[dy][dx]=0;
				}else
					i--;
				break;
				
			case 2://top
				if((dy-1)>= 0){
					m_data[dy][dx]=m_data[dy-1][dx];
					dy--;
					m_data[dy][dx]=0;
				}else
					i--;
				break;
				
			case 3://bottom
				if((dy+1)<= 2){
					m_data[dy][dx]=m_data[dy+1][dx];
					dy++;
					m_data[dy][dx]=0;
				}else
					i--;
				break;
			}
		}
	}
	@Override
	public void paint(Graphics g){
		paintComponent(g);
		
		int size = 30;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				int dx = x * size;
				int dy = y * size;
				g.drawRect(dx,dy,size,size);
				String str = Integer.toString(m_data[y][x]);
				if(m_data[y][x] != 0)
					g.drawString(str,dx+size/3,dy+size/2);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		int x,y;
		x = e.getX() /30;
		y = e.getY() /30;
		checkMove(x,y);
		
		if(checkGameOver() == true){
			JOptionPane.showMessageDialog(this,"GameOver","¾Ë¸²",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private boolean checkGameOver() {
		int vlaue =1;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if(vlaue != m_data[y][x])
					return false;
				if(vlaue ==8)
					vlaue =0;
				else vlaue++;
			}
		}
		return true;
	}
	private void checkMove(int x, int y) {
		try{
			// check left
			if((x-1)>=0){
				if(m_data[y][x-1]==0){
					m_data[y][x-1]=m_data[y][x];
					m_data[y][x]=0;
					
					repaint();
					return;
				}
			}
			//check right
			if((x+1)<=2){
				if(m_data[y][x+1]==0){
					m_data[y][x+1]=m_data[y][x];
					m_data[y][x]=0;
					
					repaint();
					return;
				}
			}
			//check bottom
			if((y+1)<=2){
				if(m_data[y+1][x]==0){
					m_data[y+1][x]=m_data[y][x];
					m_data[y][x]=0;
					
					repaint();
					return;
				}
			}
			//check top
			if((y-1)>=0){
				if(m_data[y-1][x]==0){
					m_data[y-1][x]=m_data[y][x];
					m_data[y][x]=0;
					
					repaint();
					return;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.toString());
		}
		
	}
	public void mouseReleased(MouseEvent e) {}

}