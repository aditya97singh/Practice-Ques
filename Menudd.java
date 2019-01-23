import java.util.Scanner;
public class Menudd {
    int z=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter operation");
    String c=sc.next();
    System.out.println("Enter values");
    int x=sc.nextInt(), y=sc.nextInt();
    Menudd d=new Menudd();
    int result=0;
    switch(c)
    {
    case "+":
    	result=d.add(x,y);
    	break;
    case "-":
    	result=d.sub(x,y);
    	break;
    case "*":
    	result=d.mul(x,y);
    	break;
    case "/":
    	result=d.div(x,y);
    	break;
    case "E":
    	d.ex();
    	break;
    default:
     System.out.println("Invalid");
    }
    System.out.println("Result:"+result);
    }

	public int add(int x,int y) {
		// TODO Auto-generated method stub
		z=x+y;
		return z;
	}

	public int sub(int x,int y) {
		// TODO Auto-generated method stub
		z=x-y;
		return z;
	}

	public int mul(int x,int y) {
		// TODO Auto-generated method stub
		z=x*y;
		return z;
	}

	public int div(int x,int y) {
		// TODO Auto-generated method stub
		z=x/y;
		return z;
	}

    public void ex() {
		// TODO Auto-generated method stub
    	System.exit(0);
	}
}
