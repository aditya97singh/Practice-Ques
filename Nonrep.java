import java.util.Scanner;
public class Nonrep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    int l=s.length();
    int c=0;
    for(int i=0;i<l;i++)
    {
    	c=0;
    	for(int j=0;j<l;j++)
    	{
    		if(s.charAt(i)==s.charAt(j))
    			c++;
    	}
    	if(c==1)
    	{
    		System.out.println(s.charAt(i));
    		break;
    	}
    }
	}

}
