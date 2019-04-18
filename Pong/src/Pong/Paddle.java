package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
      super(10,10);
      speed =5;
   }


   //add the other Paddle constructors
   public Paddle(int x, int y)
	{
		super(x,y);
                speed =5;

	}
        public Paddle(int x, int y, int spd){
            super(x, y);
            speed = spd;
        }
        public Paddle(int x, int y, int w, int h)
	{
		super(x, y, w, h);
                speed =5;

	}
        public Paddle(int x, int y, int w, int h, int spd)
	{
		super(x, y, w, h);
                speed =spd;

	}
        public Paddle(int x, int y, int w, int h, Color c, int sp)
	{
		super(x, y, w, h, c);
                speed =sp;
	}









   public void moveUpAndDraw(Graphics window)
   {
       draw(window, Color.white);
       setyPos(getxPos() - getSpeed());
       draw(window);

   }

   public void moveDownAndDraw(Graphics window)
   {
       draw(window, Color.white);
       setyPos(getxPos() + getSpeed());
       draw(window);

   }
   /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
   
   
   //add a toString() method
    public String toString(){
        return getxPos() + " " + getyPos() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getSpeed();
    }
    
}