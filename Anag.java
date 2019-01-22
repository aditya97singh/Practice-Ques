import java.util.Scanner;
public class Anag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter string");
    String s=sc.nextLine();
    System.out.println("Enter string");
    String h=sc.nextLine();
    int l=s.length();
    int k=h.length();
    int c=0,d=0;
    for(int i=0;i<l;i++)
    {
    	for(int j=0;j<k;j++)
    	{
    		if(s.charAt(i)==h.charAt(j))
    			c++;
    	}
    	if(c==1)
    		d++;
    	c=0;
    }
    if(l==k && d==l)
    	System.out.println("Anagram");
    else
    	System.out.println("not anagram");
	}

}
