import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener {
	
	final int PANEL_WIDTH = 500;
	final int PANEl_HEIGHT = 500;
	Image enemy;
	Image backgroundImage;
	Timer timer;
	int xVelocity = 2;
	int yVelocity = 1;
	int x = 0;
	int y = 0;
	
	MyPanel(){
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEl_HEIGHT));
		this.setBackground(Color.black);
		enemy = new ImageIcon("enemy4.png").getImage();
		backgroundImage = new ImageIcon("space.jpg").getImage();
		timer = new Timer(10,this);
		timer.start();
	
	}
	public void paint(Graphics g) {
		super.paint(g); // paint background
		
		Graphics g2D = (Graphics2D) g;
		
		g2D.drawImage(backgroundImage,0,0,null);
		g2D.drawImage(enemy,x,y,null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(x>=PANEL_WIDTH-enemy.getWidth(null) || x<0 ) {
			xVelocity = xVelocity * -1;
		}
		x = x + xVelocity;
		
		if(y>=PANEl_HEIGHT-enemy.getHeight(null) || y<0 ) {
			yVelocity = yVelocity * -1;
		}
		y = y + yVelocity;
		repaint();
	}
}
