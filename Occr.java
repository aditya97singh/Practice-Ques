import java.util.Scanner;
public class Occr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    int l=s.length();
    int c;
    for(int i=1;i<l;i++)
    {
    	c=0;
    	for(int j=0;j<l;j++)
    	{
    		if(s.charAt(i)==s.charAt(j))
    			c++;
    	}
    	System.out.println(s.charAt(i)+" "+c);
    	
    }
	}

}
