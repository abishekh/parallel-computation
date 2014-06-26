import java.io.*;
import java.util.*;
import java.lang.*;

public class secondlargest implements Runnable
{
		int j;
		
		static volatile int i,del,p,n,temp,largest,lardel;
		static volatile int[] a=new int[100];
		
	
		secondlargest(int k)
		{ 
			j=k;
		}
		public void run()
		{	
			System.out.println( "Temp: "+temp);
			int be,e;
			be=j*n/p;
			
			e=((j+1)*(n/p));
			for(i=be;i<e;i++)
				{ 		System.out.println("a["+i+"] Handled by "+" PE: "+j+" Temp: "+temp);
					
					if(a[i]>temp)
					{
						temp=a[i];
						del=i;
					}	
					
					else
					{
						System.out.println("Temp Unchanged");
					}
				}
				System.out.println("Beg: "+be+" End: "+e+" PE: "+j+" Temp: "+temp);
				
		}
		public static void main(String[] args) throws Exception
		{
			int i;
			DataInputStream S = new DataInputStream(System.in);
			Random generator=new Random();
			
			System.out.println("Enter the number of elements to add to the list");
			n=Integer.parseInt(S.readLine());
			System.out.println("Enter the number of processors");
			p=Integer.parseInt(S.readLine());
			
		
			for(i=0;i<n;i++)
			{
				a[i]=generator.nextInt(100);
			
			}
			temp=a[0]*1;
			System.out.println("The list generated is: ");
			
			for(i=0;i<n;i++)
				System.out.println(a[i]+"\t");
			System.out.println("\n");	
			
				
			
		  	Thread[] t= new Thread[p];
			for(i=0;i<p;i++)
			{
				t[i]=new Thread(new secondlargest(i));
			}
			for(i=0;i<p;i++)
				t[i].start();
			for(i=0;i<p;i++)
				t[i].join();
			System.out.println("\n");
			System.out.println("The Largest number from the list  is: ");
			System.out.println(temp);
			for(i=0;i<p;i++)			//RErun code begins from here
				t[i].stop();
			
			a[del]=0;
			lardel=del;
			largest=temp;
			temp=a[0];
		
				for(i=0;i<p;i++)
				{
					t[i]=new Thread(new secondlargest(i));
				}
			for(i=0;i<p;i++)
				t[i].start();
			for(i=0;i<p;i++)
				t[i].join();
				
				a[lardel]=largest;
				System.out.println("\n");
				System.out.println("The SecondLargest number from the list  is: ");
				System.out.println(temp);
				
			
		
		}
}