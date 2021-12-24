import java.awt.Color;
import java.awt.Graphics;
public class food {
	private  int x,y,score,score1;
	private snake snake;
	food l;
	Graphics g;
	private snake2 snake2;
	public food(snake s,snake2 s1){
		x=(int)(Math.random()* 895);
		y=(int)(Math.random()* 895);
		snake= s;
		snake2=s1;
	}
/**/
	public void changeposition(){
		x=(int)(Math.random()* 895);
		y=(int)(Math.random()* 895);
	}
	public int getScore(){
		return score;
	}
	public void draw(Graphics g){
		g.setColor(Color.green);
		g.fillRect(x, y, 6, 6);
	}
	public boolean snakecollision(){
		int snakex=snake.getX()+2;
		int snakey=snake.getY()+2;
		
		if(snakex>=x-1 && snakex<=(x+7))
		if(snakey>=y-1 && snakey<=(y+7)){
			changeposition();
			score ++;
			snake.setelongate(true);
	
			return true;
		}
		return false;
	}
	public boolean snakecollision2(){
		int snakex1=snake2.getX1()+2;
		int snakey1=snake2.getY1()+2;
		if(snakex1>=x-1 && snakex1<=(x+7))
			if(snakey1>=y-1 && snakey1<=(y+7)){
				changeposition();
				score1 ++;
				snake2.setelongate(true);
				return true;
			}
			return false;
	}
	public int getScore1(){
		return score1;
	}
}
