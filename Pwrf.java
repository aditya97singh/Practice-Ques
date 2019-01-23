import java.util.Scanner;
public class Pwrf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();

    Pwrf c=new Pwrf();
    c.cal(n);
	}
    public void cal(int n)
    {
        int r=0;
    	if(n%5==0)
    	{
    	 r=n/5;
    	 if(r==1)
    		 System.out.println("correct");
    	 else
    		 cal(r);
    	}
    	else
    		System.out.println("not correct");
    	}
    	  	
    }
    
