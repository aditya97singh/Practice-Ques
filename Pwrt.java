import java.util.Scanner;
public class Pwrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    float m=0;
    if(n%2==0)
    {
      m=(float)Math.sqrt(n);
      if((int)m%2==0)
    	  System.out.println("Correct");
      else
    	  System.out.println("Not correct");
    }
    else
    	System.out.println("Not correct");
	}

}
