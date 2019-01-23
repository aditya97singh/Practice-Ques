import java.util.Scanner;
public class Menud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the thing you want to perform");
    String c=sc.next();
    System.out.println("Enter the numbers");
    int x=sc.nextInt(), y=sc.nextInt(),z=0;
    switch(c)
    {
    case "+":
     z=x+y;
     break;
    case "-":
     z=x-y;
     break;
    case "*":
     z=x*y;
     break;
    case "/":
     z=x/y;
     break;
    default:
    	System.out.println("invalid");
    }
    System.out.println("Result:"+z);
	}

}
