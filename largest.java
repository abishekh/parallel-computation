import java.io.*;
import java.util.*;
import java.lang.*;

public class mode implements Runnable
{
		int j;
		
		static volatile int i,p,n,temp;
		static volatile int[] a=new int[100];
		statci volatile int[] tally=new int[100];
	
		mode(int k)
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
					
					int value =a[i];
					tally[value]++;
				
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
			
		
			for(i=0;i<100;i++)
			{
				a[i]=generator.nextInt(100);
				tally[i]=0;
			}
			
			
			System.out.println("The list generated is: ");
			
			for(i=0;i<n;i++)
				System.out.println(a[i]+"\t");
			System.out.println("\n");	
			
				
			
		  	Thread[] t= new Thread[p];
			for(i=0;i<p;i++)
			{
				t[i]=new Thread(new mode(i));
			}
			for(i=0;i<p;i++)
				t[i].start();
			for(i=0;i<p;i++)
				t[i].join();
			System.out.println("\n");
			System.out.println("The mode from the list  is: ");
		int maxIndex=0;
		for(i=0;;i<tally.length();i++)
		{
			if(tally[i] > tally[maxIndex]) 
			{
			            maxIndex = i;
			}
		}
		System.out.println(maxIndex);
		}
}