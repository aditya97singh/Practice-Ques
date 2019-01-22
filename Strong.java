import java.util.Scanner;
public class Strong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int i,f,r,sum=0;
    i=n;
    while(n!=0)
    {
    	r=n%10;
    	f=1;
    	for(int j=1;j<=r;j++)
    	{
    		f=f*j;
    	}
    	sum=sum+f;
    	n=n/10;
    }
    if(sum==i)
    	System.out.println("Strong");
    else
    	System.out.println("Not Strong");
	}

}
