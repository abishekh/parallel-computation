import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.String.*;



public class vowchk implements Runnable
{
		int j;
		static volatile int i,p,length,constant;
		static volatile String str;
		static volatile int result=0;
		static volatile String vow="aieouAEIOU";
		static volatile String[] out=new String[100];
		
		vowchk(int k)
		{
			j=k;
			
		}
		public void run()
		{
				int beg,end;
				beg=j*constant;
				
				
					
				
			if(j==(p-1))
				{
				end=length;
			 	}
			else 
			end=(j+1)*constant;
			
				out[j]=str.substring(beg,end);
				System.out.println("Beg: "+beg+"\tEnd: "+end+"\t PE: "+j);
	   			System.out.println("Intermediate result from PE: "+j+" = "+out[j]);
					
					for(i=0;i<(out[j].length());i++)
						{	char op=out[j].charAt(i);
							   for (int x=0;x<10;x++)
								{	
									char ch=vow.charAt(x);
									if(op==ch)
									result++;
								}
						}

		}
		
		public static void main(String[] args) throws Exception
		{
				
			int i;
			DataInputStream S = new DataInputStream(System.in);
			BufferedReader  R = new BufferedReader(new InputStreamReader(System.in)); 
			
			System.out.println("Enter a sentence:");
			str=R.readLine();
			length=str.length();
		
			System.out.println("The Length Of the string is : "+length);
			System.out.println("Enter the number of processors");
			p=Integer.parseInt(S.readLine());
			constant=length/p;
		System.out.println("Const : "+constant);
			System.out.println("\n");
			
		  	Thread[] t= new Thread[p];
			for(i=0;i<p;i++)
			{
				t[i]=new Thread(new vowchk(i));
			}
			for(i=0;i<p;i++)
				t[i].start();
			for(i=0;i<p;i++)
				t[i].join();
					
					System.out.println("\n");
					
		
		
		System.out.println("The Number of vowels in the String are: ");
		System.out.println("\n"+result);	
			
			System.out.println("\n");	
		
		}

}