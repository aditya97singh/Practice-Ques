import java.util.Scanner;

public class Pwr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int r=0;
    while(n!=1 && r==0)
    {
      r=n%10;
      n=n/10;
    }	
    if(r==0)
    	System.out.println("Correct");
    else
    	System.out.println("Not correct");
	}

}
