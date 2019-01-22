import java.util.Scanner;
public class Fact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int f=1;
    for(int i=1;i<=n;i++)
    {
    	f=f*i;
    }
    System.out.println("Factorial is :"+f);
	}

}
