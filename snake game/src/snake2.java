import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class snake2 {
	List<point2> snakepoints1;
	int xdir,ydir;
	boolean ismoving,elongate;
	final int startsize=20,startx=180,starty=180;
	public snake2(){
	snakepoints1=new ArrayList<point2>();
	xdir=0;
	ydir=0;
	ismoving=false;
	elongate=false;
	snakepoints1.add(new point2(startx,starty));
	for(int i=1;i<startsize;i++){
		snakepoints1.add(new point2(startx-i*4,starty));	
	}
	}
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		for(point2 p:snakepoints1){
			g.fillRect(p.getX(),p.getY(),4,4);
		}
	}
	public void move(){
		if(ismoving){
			point2 temp=snakepoints1.get(0);
			point2 last=snakepoints1.get(snakepoints1.size()-1);
			point2 newstart=new point2(temp.getX()+xdir*4,temp.getY()+ydir*4);
			for(int i=snakepoints1.size()-1;i>=1;i--){
				snakepoints1.set(i, snakepoints1.get(i-1));
			}
			snakepoints1.set(0,newstart);
			if(elongate){
				snakepoints1.add(last);
				elongate=false;
			}
		}
		
	}
	public boolean snakecollision(){
		int x=this.getX1();
		int y=this.getY1();
		for(int i=1;i<snakepoints1.size();i++){
			if(snakepoints1.get(i).getX()==x && snakepoints1.get(i).getY()==y )
			{
			return true;	
			}
			
		}return false;
	}
	public boolean ismoving(){
		return ismoving;
	}
	public void setismoving(boolean b){
		ismoving=b;
	}
	public int getxDir1(){
		return xdir;
	}
	public int getyDir1(){
	return ydir;	
	}
	public void setxDir1(int x){
		xdir=x;
	}
	public void setyDir1(int y){
		ydir=y;
	}
	public int getX1(){
	return snakepoints1.get(0).getX();	
	}
	public int getY1(){
		return snakepoints1.get(0).getY();
	}
	public void setelongate(boolean b){
		elongate=b;
	}
}
