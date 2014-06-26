import java.io.*;
import java.util.*;
import java.lang.*;
public class matsum implements Runnable
{
		int j;
		static volatile int i,p,n,l;
		static volatile int[][] a=new int[100][100];
		static volatile int[][] o=new int[100][100];
		static volatile int[][] b=new int[100][100];
		matsum(int k)
		{ 
			j=k;
		}
		public void run()
		{  int i,r;
			for(i=0;i<r;i++)
				o[j][i]=a[j][i]+b[j]][i];
		}
		public static void main(String[] args) throws Exception
		{
			int i;
			DataInputStream S = new DataInputStream(System.in);
			Random generator=new Random();
			System.out.println("Enter the number of rows");
			row=Integer.parseInt(S.readLine());
				System.out.println("Enter the number of columns");
				col=Integer.parseInt(S.readLine());
			System.out.println("Enter the number of processors");
			p=Integer.parseInt(S.readLine());
			for(i=0;i<row;i++)
			{
				for(j=0;j<col;j++)
				{
				a[i][j]=generator.nextInt(100);
				b[i][j]=generator.nextInt(100);
				}
			}
			System.out.println("The two arrays generated are: ");
			
	
		Thread[] x= new Thread[p];
		
			for(i=0;i<p;i++)
			{
				for(j=0;j<col;j++)
				{
				x[i][j]=new Thread(new matsum(i));
				}
			}
			for(i=0;i<p;i++)
				x[i].start();
			for(i=0;i<p;i++)
				x[i].join();
			System.out.println("\n");
			System.out.println("The Sum of array is: ");
			
			for(i=0;i<n;i++)
				System.out.println(o[i]+"\t");
		}
}