import java.io.*;
import java.util.*;
import java.lang.*;

public class scdlgt implements Runnable
{
		int j;
		
		static volatile int i,p,n,large1,large2;
		static volatile int[] a=new int[100];
		
	
		scdlgt(int k)
		{ 
			j=k;
		}
		public void run()
		{	
		//	System.out.println( "Temp: "+temp);
			int be,e;
			be=j*n/p;
			
			e=((j+1)*(n/p));
			for(i=be;i<e;i++)
				{ 	//	System.out.println("a["+i+"] Handled by "+" PE: "+j+" Temp: "+temp);
					
			if(a[i]>large1)
				large1=a[i];
				
				if(a[i]>large2 && a[i]<large1)
					large2=a[i];
			
					else
					System.out.println("Temp Unchanged");
				}
			//	System.out.println("Beg: "+be+" End: "+e+" PE: "+j+" Temp: "+temp);
				
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
			large1=a[0];
			large2=a[0];
			System.out.println("The list generated is: ");
			
			for(i=0;i<n;i++)
				System.out.println(a[i]+"\t");
			System.out.println("\n");	
			
				
			
		  	Thread[] t= new Thread[p];
			for(i=0;i<p;i++)
			{
				t[i]=new Thread(new scdlgt(i));
			}
			for(i=0;i<p;i++)
				t[i].start();
			for(i=0;i<p;i++)
				t[i].join();
			System.out.println("\n");
			System.out.println("The Largest number from the list  is: ");
			System.out.println(large1);
			System.out.println(large2);
		
		}
}