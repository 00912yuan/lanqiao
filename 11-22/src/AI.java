import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	//声明变量：语法格式：数据类型  变量名称
	Image  currentImg;
	Image heroImg[][]=new Image[4][3];
	int x,y;
	int leftFlag,upFlag,rightFlag,downFlag;
	public MainCanvas(){
		try
		{
			//给变量赋值：语法：变量名称=value
			for (int i=0;i<heroImg.length;i++)
			{    for (int j=0;j<heroImg[i].length ;j++ )
			     {
				    heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			
				 }

			}
			
			currentImg=heroImg[3][0];
			x=120;
			y=100;
			leftFlag=0;
			upFlag=0;
			rightFlag=0;
			downFlag=0;
		}
		catch (IOException e)
		{
			e.printStackTrace();

		}
	}

	public void paint(Graphics g){
		g.setColor(125,135,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
    public void keyPressed(int keyCode){
	/*
		action是一个动作：取值UP,DOWN,LEFT,RIGHT
		*/
	
		int action=getGameAction(keyCode);
	    if(action==LEFT){
			currentImg=heroImg[0][0];
			x=x-1;
			if (leftFlag==0)
			{  currentImg=heroImg[0][1];			
			   repaint();
			   leftFlag=1;
			} else
			{currentImg=heroImg[0][2];
			 leftFlag=0;
			 repaint();
			}
		}
	    if(action==UP){
			currentImg=heroImg[1][0];
			y=y-1;
			if (upFlag==0)
			{  currentImg=heroImg[1][1];			
			   repaint();
			   upFlag=1;
			} else
			{currentImg=heroImg[1][2];
			 upFlag=0;
			 repaint();
			}
	    }
		if(action==RIGHT){
			currentImg=heroImg[2][0];
			x=x+1;
			if (rightFlag==0)
			{  currentImg=heroImg[2][1];			
			   repaint();
			  rightFlag=1;
			} else
			{currentImg=heroImg[2][2];
			 rightFlag=0;
			 repaint();
			}
		}
		if (action==DOWN)
	       {
			currentImg=heroImg[3][0];
			y=y+1;
			if (downFlag==0)
			{  currentImg=heroImg[3][1];			
			   repaint();
			 downFlag=1;
			} else
			{currentImg=heroImg[3][2];
			 downFlag=0;
			 repaint();
			}
		}
  }
}