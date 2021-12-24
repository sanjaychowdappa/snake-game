import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class snake {
	private static final Color Color = null;
	List<Point> snakepoints;
	int xdir,ydir;
	Color k;
	boolean ismoving,elongate;
	final int startsize=20,startx=150,starty=150;
	public snake(){
	snakepoints=new ArrayList<Point>();
	xdir=0;
	ydir=0;
	ismoving=false;
	elongate=false;
	snakepoints.add(new Point(startx,starty));
	for(int i=1;i<startsize;i++){
		snakepoints.add(new Point(startx-i*4,starty));	
	}
	}
	public void draw(Graphics g){
		g.setColor(Color.red);
		for(Point p:snakepoints){
			g.fillRect(p.getX(),p.getY(),4,4);
		}
	}
	public void move(){
		if(ismoving){
			Point temp=snakepoints.get(0);
			Point last=snakepoints.get(snakepoints.size()-1);
			Point newstart=new Point(temp.getX()+xdir*4,temp.getY()+ydir*4);
			for(int i=snakepoints.size()-1;i>=1;i--){
				snakepoints.set(i, snakepoints.get(i-1));
			}
			snakepoints.set(0,newstart);
			if(elongate){
				snakepoints.add(last);
				elongate=false;
			}
		}
		
	}
	public boolean snakecollision(){
		int x=this.getX();
		int y=this.getY();
		for(int i=1;i<snakepoints.size();i++){
			if(snakepoints.get(i).getX()==x && snakepoints.get(i).getY()==y )
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
	public int getxDir(){
		return xdir;
	}
	public int getyDir(){
	return ydir;	
	}
	public void setxDir(int x){
		xdir=x;
	}
	public void setyDir(int y){
		ydir=y;
	}
	public int getX(){
	return snakepoints.get(0).getX();	
	}
	public int getY(){
		return snakepoints.get(0).getY();
	}
	public void setelongate(boolean b){
		elongate=b;
	}
}
