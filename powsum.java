import java.io.*;
import java.util.*;
import java.lang.*;


public class powsum implements Runnable
{
		int j;
		static volatile int i,p,n;
		static volatile double result;
		

	    static volatile double[] out=new double[100];
		powsum(int k)
		{ 
			j=k;
		}
		public void run()
		{
		out[j]=Math.pow(n,j);
			
	   System.out.println("Intermediate result from PE: "+j+" = "+out[j]);
		}
		
		public static void main(String[] args) throws Exception
		{
				
			int i;
			DataInputStream S = new DataInputStream(System.in);
		
			
			System.out.println("Enter the number of elements to add");
			n=Integer.parseInt(S.readLine());
			System.out.println("Enter the number of processors");
			p=Integer.parseInt(S.readLine());
		
		
			System.out.println("\n");
			
		  	Thread[] t= new Thread[p+1];
			for(i=p;i>=0;i--)
			{
				t[i]=new Thread(new powsum(i));
			}
			for(i=p;i>=1;i--)
				t[i].start();
			for(i=p;i>=1;i--)
				t[i].join();
			System.out.println("\n");
			System.out.println("The Sum of the numbers is: ");
			
			for(i=1;i<=p;i++)
			{
				result =result+out[i];
			}
			System.out.println(result);	
		}

}