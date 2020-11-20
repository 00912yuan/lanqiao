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
	Image heroLeftImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
	int x,y;
	int leftFlag,upFlag,rightFlag,downFlag;
	public MainCanvas(){
		try
		{
			//给变量赋值：语法：变量名称=value
			for (int i=0;i<3;i++ )
			{  heroLeftImg[i] =Image.createImage("/sayo"+i+"2.png");
			}
			//向左
			/*
			img5=Image.createImage("/sayo02.png");
            img2=Image.createImage("/sayo12.png");
            img6=Image.createImage("/sayo22.png");
			*/
             for (int i=0;i<3;i++ )
			{  heroUpImg[i] =Image.createImage("/sayo"+i+"4.png");
			}
             //向上
			 /*
            img7=Image.createImage("/sayo04.png");
            img3=Image.createImage("/sayo14.png");
			img8=Image.createImage("/sayo24.png");
			*/
            for (int i=0;i<3;i++ )
			{ heroRightImg[i] =Image.createImage("/sayo"+i+"6.png");
			}
            //向右
			/*
            img9=Image.createImage("/sayo06.png");
            img4=Image.createImage("/sayo16.png");  
			img10=Image.createImage("/sayo26.png");
			*/
             for (int i=0;i<3;i++ )
			{ heroDownImg[i] =Image.createImage("/sayo"+i+"0.png");
			}
             

			//向下
			/*
			img11=Image.createImage("/sayo00.png");
			img1=Image.createImage("/sayo10.png");
			img12=Image.createImage("/sayo20.png");
			*/
			currentImg=heroDownImg[1];
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
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
    public void keyPressed(int keyCode){
	/*
		action是一个动作：取值UP,DOWN,LEFT,RIGHT
	*/
		int action=getGameAction(keyCode);
	    if(action==LEFT){
			currentImg=heroLeftImg[1];
			x=x-1;
			if (leftFlag==0)
			{  currentImg=heroLeftImg[0];			
			   repaint();
			   leftFlag=1;
			} else
			{currentImg=heroLeftImg[2];
			 leftFlag=0;
			 repaint();
			}
		}
	    if(action==UP){
			currentImg=heroUpImg[1];
			y=y-1;
			if (upFlag==0)
			{  currentImg=heroUpImg[0];			
			   repaint();
			   upFlag=1;
			} else
			{currentImg=heroUpImg[2];
			 upFlag=0;
			 repaint();
			}
	    }
		if(action==RIGHT){
			currentImg=heroRightImg[1];
			x=x+1;
			if (rightFlag==0)
			{  currentImg=heroRightImg[0];			
			   repaint();
			  rightFlag=1;
			} else
			{currentImg=heroRightImg[2];
			 rightFlag=0;
			 repaint();
			}
		}
		if (action==DOWN)
	       {
			currentImg=heroDownImg[1];
			y=y+1;
			if (downFlag==0)
			{  currentImg=heroDownImg[0];			
			   repaint();
			 downFlag=1;
			} else
			{currentImg=heroDownImg[2];
			 downFlag=0;
			 repaint();
			}
		}
  }
}