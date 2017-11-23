import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
class ashok{
	public static void main(String arg[]) throws Exception
	{
		File ff=ff=new File("1out.png");
		BufferedImage img=ImageIO.read(ff);
		int width=img.getWidth();
		int height=img.getHeight();
		File f=new File("1out.csv");
		FileWriter fr=new FileWriter(f);
		int num=16777216;
		String str=" ";
		String st="\n";
		int wr=0;int pix;
		//System.out.println(width+" "+height);
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<height;j++)
			{
				pix=img.getRGB(i,j);
				wr=num+pix;
				//System.out.println(wr);
				fr.append(wr+"");
				fr.append("\n");//break;
			}
			//fr.write("\n");break;
		}
		fr.close();
	}
}