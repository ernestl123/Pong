package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
        private static int leftxPos = 30;
        private static int leftyPos = 10;
        private static int rightxPos = 700;
        private static int rightyPos = 60;
        private int leftScore;
        private int rightScore;

	public Pong()
	{
		//set up all variables related to the game
            ball = new BlinkyBall(100,100,20,20,Color.RED,2,2);
            leftPaddle = new Paddle(leftxPos, leftyPos, 10, 30, Color.RED, 5);
            leftScore = 0;
            rightScore = 0;
		
		
            rightPaddle = new Paddle(rightxPos, rightyPos, 10, 30, Color.GREEN, 5);


		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);


		//see if ball hits left wall or right wall
		if(!(ball.getxPos()>=0 && ball.getxPos()<=getWidth()))
		{
			ball.setxSpeed(0);
			ball.setySpeed(0);
                        
		}

		
		//see if the ball hits the top or bottom wall 

		if(!(ball.getyPos()>=10 && ball.getyPos()<=getHeight() - ball.getHeight()))
		{
			ball.setySpeed(-ball.getySpeed());
		}



		//see if the ball hits the left paddle
		if(!(ball.getxPos()>=0 && ball.getxPos()<=getWidth()-rightPaddle.getWidth()))
		{
			ball.setxSpeed(0);
			ball.setySpeed(0);
			if (ball.getxPos() <= leftPaddle.getxPos()){
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Right :  " + rightScore, 500, 500);
				rightScore++;
				graphToBack.setColor(Color.BLUE);
				graphToBack.drawString("Right :  " + rightScore, 500, 500);
                                graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Left : "+leftScore, 200, 500);
				graphToBack.setColor(Color.BLUE);
				graphToBack.drawString("Left : "+leftScore, 200, 500);
			}
			
			else if (ball.getxPos() >= rightPaddle.getxPos()+rightPaddle.getWidth()){graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Right :  " + rightScore, 500, 500);
				graphToBack.setColor(Color.BLUE);
				graphToBack.drawString("Right :  " + rightScore, 500, 500);
                            
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Left : "+leftScore, 200, 500);
				leftScore++;
				graphToBack.setColor(Color.BLUE);
				graphToBack.drawString("Left : "+leftScore, 200, 500);
			}
			
			ball.draw(graphToBack, Color.WHITE);
			ball= new BlinkyBall(300 + (int) (Math.random() * 200),200 + (int) (Math.random() * 200),20,20,Color.BLUE, 2, 2);
			ball.moveAndDraw(graphToBack);
		}

		
		//see if the ball hits the top or bottom wall 
		if(!(ball.getyPos()>=0 && ball.getyPos() <= getHeight())) {
			ball.setySpeed(-ball.getySpeed());
		}


		
		//see if the ball hits the left paddle
		if (ball.didCollideLeft(leftPaddle)) 
		{
			ball.setxSpeed(Math.abs(ball.getxSpeed()));
		}
		else if (ball.didCollideRight(rightPaddle)) {
			ball.setxSpeed(-Math.abs(ball.getxSpeed()));
		}
		
				
		if(keys[0] == true && leftPaddle.getyPos() >= 0)
		{
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		
		if(keys[1] == true && leftPaddle.getyPos() <= getHeight() - leftPaddle.getHeight())
		{
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		
		if(keys[2] == true && rightPaddle.getyPos() >= 0)
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		
		if(keys[3] == true && rightPaddle.getyPos() <= getHeight()-leftPaddle.getHeight())
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		


		//see if the paddles need to be moved















		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}