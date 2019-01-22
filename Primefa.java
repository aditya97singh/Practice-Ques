import java.util.Scanner;
public class Primefa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int c=0;
    if(n>1)
    {
    	for(int i=2;i<n;i++)
    	{
    		if(n%i==0)
    		{
    			for(int j=1;j<=i;j++)
    			{
    				if(i%j==0)
    					c++;
    			}
    			if(c==2)
    				System.out.println("Prime fac :"+i);
    			c=0;
    		}
    	}
    }
    else
    	System.out.println(" ");
	}

}
