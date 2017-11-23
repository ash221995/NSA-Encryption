import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class Ns{
	public static void main(String arg[]) throws IOException
		{
		Hashtable<Integer,Integer> hm=new Hashtable<Integer,Integer>(256);
		Vector v=new Vector();		
		String key="7894567894562138975187498749";
		int rgb;
		int k=key.length();
		int len=k;		
		if(k%4==0)
			k=k/4;
		else
			k=(k/4)+1;
		System.out.println(k);
		int c[]=new int[k];
		c[0]=245;c[1]=231;c[2]=213;c[3]=218;c[4]=254;c[5]=235;c[6]=124;
		int skey[]=new int[k];
		int start=0,end=4;
		for(int i=0;i<k;i++)
		{		
			if(end<len)
			skey[i]=Integer.parseInt(key.substring(start,end));
			else
			skey[i]=Integer.parseInt(key.substring(start,len));
			start=start+4;end=end+4;
			
		}
		
		int temp[]=new int[k];
		int count=0,a=0;
		while(count<257)
		{
			for(int z=0;z<k;z++)
			{
			temp[z]=skey[z]+(a*z)+c[z];
			if(temp[z]<65090)
			{
			if(!(v.contains(temp[z])))
			{
			hm.put(count,temp[z]);
			v.addElement(temp[z]);
			count=count+1;
			if(count>257)
			break;
			}a++;
			}
			}		
		}			
		for(Map.Entry m:hm.entrySet())
		{System.out.println(m.getKey()+" "+m.getValue());  }
		File f=new File("input.txt");
		FileInputStream fis=new FileInputStream(f);
		int ch=0;
		int xx;
		int num=100;int r,g,b;int pix;
		File ff=ff=new File("10.png");
		BufferedImage img=ImageIO.read(ff);
		int i=1;int x=1;
		int rr,gg,bb;
		int ct=0;
		while((ch=fis.read())>0)
		{
		xx=hm.get(ch);
		r=xx%num;
		b=xx/num;
		g=num;
		int pit=img.getRGB(x,i);ct++;
		int aa=(pit>>>24)& 0xff;
		rr = (pit >>> 16) & 0xff;//System.out.print(rr+" ");
		gg = (pit >>> 8) & 0xff;//System.out.print(gg+" ");
		bb = pit & 0xff;//System.out.print(aa+" ");
		pix = (aa<<24) | (r<<16) | (gg<<8) | bb;
		img.setRGB(x,i,pix);//aa=(pix>>>24)& 0xff;System.out.print(aa+" ");
		pix=(aa<<24) | (b<<16) | (gg<<8) | bb;
		img.setRGB(x,i+1,pix);
		if(x>996)
		{
		if(i>996)
		break;
		x=1;i=i+3;
		}
		else
		x=x+2;	
		}
		img.setRGB(0,0,((255)<<24 | ((ct/255)<<16) | ((ct%255)<<8) | 100));
		//System.out.println((ct%255)<<24);
		ImageIO.write(img, "png",new File("10out.png"));		
		System.out.println(ct);		
		fis.close();	
		}
} 
