import java.util.Scanner;
public class Fibbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
	int a=0,b=1;
	int c=0;
	System.out.print(a+" "+b);
	for(int i=0;i<n;i++)
	{
     c=a+b;
     System.out.print(" "+c);
     a=b;
     b=c;
	}
}
}
