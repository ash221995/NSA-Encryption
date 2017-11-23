import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Ns2{
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
			hm.put(temp[z],count);
			v.addElement(temp[z]);
			count=count+1;
			if(count>257)
			break;
			}a++;
			}
			}		
		}	int fff=0;	
		/*for(Map.Entry m:hm.entrySet())
		{System.out.println(m.getValue()+" "+m.getKey());fff++;  }System.out.println("       "+fff);*/
		int r,g,b;int pix;
		File ff=ff=new File("out.png");
		BufferedImage img=ImageIO.read(ff);
		int i=1;int x=1;
		int rr,gg,bb;
		//int ct=0;
		int ct=img.getRGB(0,0);
		int lenn=ct >>> 8 & 0xff;int len1=ct>>>16& 0xff;//System.out.print(ct);
		int lengthh=(len1*255)+lenn;
		System.out.println(lenn+" "+len1+" "+lengthh);
		File f=new File("ot.txt");
		FileOutputStream fis=new FileOutputStream(f);
		while(lengthh>0)
		{
		int pit=img.getRGB(x,i);
		int pit1=img.getRGB(x,i+1);
		rr=(pit>>>16)& 0xff;
		gg=(pit1>>>16)& 0xff;
		int num=(gg*100)+rr;
		if(x>1350)
		{
		if(i>750)
		break;
		x=1;i=i+3;
		}
		else
		x=x+2;
		//System.out.println(num);
		lengthh--;System.out.print(num+" ");
		int xx=0;
		try{
		 xx=hm.get(num);fis.write(xx);
		}catch(Exception e){System.out.println(e);}
			
		}
		fis.close();	
		}
} 
