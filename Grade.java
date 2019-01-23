import java.util.Scanner;
public class Grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter grades");
    int g=sc.nextInt();
    if(g>=75)
    	System.out.println("Distinction");
    else if(g>=60 && g<75)
    	System.out.println("First class");
    else
    	System.out.println("Fail");
	}

}
