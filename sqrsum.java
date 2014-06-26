import java.io.*;
import java.util.*;
import java.lang.*;

public class sqrsum implements Runnable
{
int j;
static volatile int i,p,n,result;

static volatile int[] a=new int[100];
static volatile int[] b=new int[100];
static volatile int[] out=new int[100];
sqrsum(int k)
{ 
j=k;
}
public void run()
{
int be,e;
be=j*n/p;
e=((j+1)*((n)/p));
if (j>0)
{
be=be+1;

}

for(i=be;i<=e;i++)
{ out[j]=out[j]+b[i];

System.out.println("Elements " +be+" to "+e+" being handled by processor number :"+ j);
System.out.println("Adding " +b[i]);
}
j++; 
}

public static void main(String[] args) throws Exception
{

int i;
DataInputStream S = new DataInputStream(System.in);
Random generator=new Random();

System.out.println("Enter the number of elements to add");
n=Integer.parseInt(S.readLine());
System.out.println("Enter the number of processors");
p=Integer.parseInt(S.readLine());
for(i=0;i<n;i++)
{
a[i]=generator.nextInt(100);

}
System.out.println("The numbers generated are: ");

for(i=0;i<n;i++)
System.out.println(a[i]+"\t");
System.out.println("\n");
System.out.println("Squares:"); 
for(i=0;i<n;i++)
{
b[i]= a[i]*a[i];
System.out.println(b[i]+"\t");

}
System.out.println("\n");

Thread[] t= new Thread[p];
for(i=0;i<p;i++)
{
t[i]=new Thread(new sqrsum(i));
}
for(i=0;i<p;i++)
t[i].start();
for(i=0;i<p;i++)
t[i].join();
System.out.println("\n");
System.out.println("The Sum of the numbers is: ");

for(i=0;i<p;i++)
{System.out.println("Intermediate result from PE: "+i+" = "+out[i]);
result =result+out[i];
}
System.out.println(result); 
}

}
