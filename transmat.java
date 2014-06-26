import java.io.*;
import java.util.*;
import java.lang.*;
public class transmat implements Runnable
{
		
		static volatile int i,j,p,n,l,row,col;
		static volatile int[][] a=new int[100][100];
		static volatile int[][] o=new int[100][100];
		
		transmat(int k)
		{ 
			j=k;
		}
		public void run()
		{ 	int be,e;
			be=j*row/p;
		
			e=((j+1)*(row/p));
			for(i=be;i<e;i++)
				{
				for(j=0;j<col;j++)
					{		System.out.println(" \n Putting  a["+j+"]["+i+"] in O["+i+"]["+j+"]");
						o[j][i]=a[i][j];
					
						System.out.println("Beg: "+be+"\tEnd: "+e+"\t PE: "+j+"Position a["+i+"]["+j+"]");
	   					System.out.println("Intermediate result from PE: "+j+" = "+a[i][j]);
					}
				}
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
			
				}
			}
			System.out.println("The matrix generated is: ");
			for(i=0;i<row;i++)
			{ System.out.println("");
				for(int j=0;j<col;j++)
				{
			
				System.out.print(" "+a[i][j]);
			
				}
			}
	
		Thread[] x= new Thread[p];
		
			for(i=0;i<p;i++)
			{
				
			x[i]=new Thread(new transmat(i));
				
			}
			for(i=0;i<p;i++)
				x[i].start();
			for(i=0;i<p;i++)
				x[i].join();
			System.out.println("\n");
			System.out.println("The transposed Matrix is: ");
			
				for(i=0;i<row;i++)
				{ System.out.println("");
					for(int j=0;j<col;j++)
					{

					System.out.print(" "+o[j][i]);
					
					}
				}
				System.out.println("\n");
		}
}