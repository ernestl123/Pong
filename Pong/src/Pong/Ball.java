package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	public Ball(int x, int y)
	{
		super(x,y);
                xSpeed = 3;
		ySpeed = 1;

	}
        public Ball(int x, int y, int w, int h)
	{
		super(x, y, w, h);
                xSpeed = 3;
		ySpeed = 1;

	}
        public Ball(int x, int y, int w, int h, Color c)
	{
		super(x, y, w, h, c);
                xSpeed = 3;
		ySpeed = 1;

	}
        public Ball(int x, int y, int w, int h, Color c, int xSp, int ySp)
	{
		super(x, y, w, h, c);
                xSpeed = xSp;
                ySpeed = ySp;
	}
	
	
	

	
   //add the set methods
    /**
     * @return the xSpeed
     */
    public int getxSpeed() {
        return xSpeed;
    }

    /**
     * @param xSpeed the xSpeed to set
     */
    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    /**
     * @return the ySpeed
     */
    public int getySpeed() {
        return ySpeed;
    }

    /**
     * @param ySpeed the ySpeed to set
     */
    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
        

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location

       draw(window, Color.white);
       setxPos(getxPos() + getxSpeed());

      
		//setY
      setyPos(getyPos() + getySpeed());
		//draw the ball at its new location
      draw(window);
   }
   
	public boolean equals(Object obj)
	{
            Ball test = (Ball)obj;
            return super.equals(obj) && this.getxSpeed() == test.getxSpeed() && this.getySpeed() == test.getySpeed();



	}   

   //add the get methods
        
   public boolean didCollideLeft(Object obj){
       Paddle test = (Paddle)obj;
       if (((this.getxPos() <= test.getxPos() + test.getWidth()+Math.abs(this.getxSpeed())) && (this.getyPos()) >=test.getxPos() + test.getHeight()) || 
               this.getyPos() + this.getHeight() >= test.getyPos() && this.getyPos() + this.getHeight() < test.getyPos() + test.getHeight()){
           
           if (this.getxPos() <= test.getxPos() + test.getWidth()-Math.abs(this.getxSpeed())){
               setySpeed(-getySpeed());
               return false;
           }
           else{
               setxSpeed(-getxSpeed());
               return true;
           }
       }
       return false;
   }

   //add a toString() method
   public String toString(){
       return getxPos() + " " + getyPos() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getxSpeed() + " " + getySpeed();
   }
   
}