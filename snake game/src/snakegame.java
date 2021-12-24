import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class snakegame extends Applet implements Runnable,KeyListener  {
	Graphics gfx;
	Image img;
	Thread thread;
	snake snake;
	snake2 snake2;
	food food;
	boolean gameover;
	public void init(){
		this.resize(900,900);
		img=createImage(900,900);
		gfx=img.getGraphics();
		gameover=false;
		this.addKeyListener(this);
		snake=new snake();
		snake2=new snake2();
		food=new food(snake,snake2);
		thread=new Thread(this);
		thread.start();
	}
	public void paint(Graphics g){
	gfx.setColor(Color.black);
	gfx.fillRect(0, 0,900,900);
		if(!gameover){
		snake.draw(gfx);
		snake2.draw(gfx);
		food.draw(gfx);
		}
	else{
		gfx.setColor(Color.red);
		gfx.drawString("GAME OVER",180,150);
		gfx.drawString("SCORE of player1 "+food.getScore(),180,190);
		gfx.drawString("SCORE of player2 "+food.getScore1(),180,220);
	}
	g.drawImage(img,0,0,null);
	}
	public void update(Graphics g){
	paint(g);	
	}
	public void repaint( Graphics g){
		paint(g);
	}
	public void run() {
		// TODO Auto-generated method stub
		
		for(;;){
			if(!gameover){
				snake.move();
				snake2.move();
		this.checkgameover();
				food.snakecollision();
				food.snakecollision2();
			}
			int i=food.getScore();
			this.repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void checkgameover(){
		if(snake.getX()<0||snake.getX()>896){
			gameover=true;
		}
		if(snake.getY()<0||snake.getY()>896){
			gameover=true;
		}
		/*if(snake.snakecollision()){
			gameover=true;*/
		}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(!snake.ismoving()){
			if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_LEFT
					||e.getKeyCode()==KeyEvent.VK_RIGHT){
				snake.setismoving(true);
			}
		}
	if(!snake2.ismoving()){
			if(e.getKeyCode()==KeyEvent.VK_W||e.getKeyCode()==KeyEvent.VK_S||e.getKeyCode()==KeyEvent.VK_A
					||e.getKeyCode()==KeyEvent.VK_D){
				snake2.setismoving(true);
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			if(snake.getyDir()!=1){
				snake.setyDir(-1);
				snake.setxDir(0);
			}
		}
if(e.getKeyCode()==KeyEvent.VK_DOWN){
	if(snake.getyDir()!=-1){
		snake.setyDir(1);
		snake.setxDir(0);
	}
		}
if(e.getKeyCode()==KeyEvent.VK_LEFT){
	if(snake.getxDir()!=1){
		snake.setxDir(-1);
		snake.setyDir(0);
	}
}
if(e.getKeyCode()==KeyEvent.VK_RIGHT){
	if(snake.getxDir()!=-1){
		snake.setxDir(1);
		snake.setyDir(0);
	}
}if(e.getKeyCode()==KeyEvent.VK_W){
	if(snake2.getyDir1()!=1){
		snake2.setyDir1(-1);
		snake2.setxDir1(0);
	}
}
if(e.getKeyCode()==KeyEvent.VK_S){
if(snake2.getyDir1()!=-1){
snake2.setyDir1(1);
snake2.setxDir1(0);
}
}
if(e.getKeyCode()==KeyEvent.VK_A){
if(snake2.getxDir1()!=1){
snake2.setxDir1(-1);
snake2.setyDir1(0);
}
}
if(e.getKeyCode()==KeyEvent.VK_D){
if(snake2.getxDir1()!=-1){
snake2.setxDir1(1);
snake2.setyDir1(0);
}
}
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
