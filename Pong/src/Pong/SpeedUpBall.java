package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

   public SpeedUpBall()
   {
       super();

   }

   public SpeedUpBall(int x, int y)
   {
       super(x, y);

   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
       super(x, y, xSpd, ySpd);

   }

   /*
   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {

       super(x, y, wid, ht, xSpd, ySpd);
   }
*/

   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
       super(x, y, wid, ht, col, xSpd, ySpd);



   }

   public void setxSpeed( int xSpd )
   {

      super.setxSpeed(xSpd);


   }

   public void setySpeed( int ySpd )
   {
       super.setySpeed(ySpd);



   }
   
   public boolean didCollideLeft(Object obj) {
       
		boolean thing = super.didCollideLeft(obj);
                if (thing){
                    super.setxSpeed(Math.abs(super.getxSpeed())+1);
                   super.setySpeed(Math.abs(super.getySpeed())+1);
                   System.out.println(super.getxSpeed() + " " + super.getySpeed());
                }
                return thing;
	}

	public boolean didCollideRight(Object obj) {
		boolean thing = super.didCollideRight(obj);
                if (thing){
                    super.setxSpeed(Math.abs(super.getxSpeed())+1);
                   super.setySpeed(Math.abs(super.getySpeed())+1);
                   System.out.println(super.getxSpeed() + " " + super.getySpeed());
                }
                return thing;
	}

	public boolean didCollideTop(Object obj) {
		boolean thing = super.didCollideTop(obj);
                if (thing){
                    super.setxSpeed(Math.abs(super.getxSpeed())+1);
                   super.setySpeed(Math.abs(super.getySpeed())+1);
                   System.out.println(super.getxSpeed() + " " + super.getySpeed());
                }
                return thing;
	}

	public boolean didCollideBottom(Object obj) {
		boolean thing = super.didCollideBottom(obj);
                if (thing){
                    super.setxSpeed(Math.abs(super.getxSpeed())+1);
                   super.setySpeed(Math.abs(super.getySpeed())+1);
                   System.out.println(super.getxSpeed() + " " + super.getySpeed());
                }
                return thing;
	}
}

