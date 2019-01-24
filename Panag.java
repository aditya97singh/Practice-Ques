import java.util.Scanner;
public class Panag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    int l=s.length();
    boolean ar[]=new boolean[26];
    for(int i=0;i<26;i++)
    	ar[i]=false;
    int index=0,c=0;
    for(int i=0;i<l;i++)
    {
    	if(s.charAt(i)>='A' && s.charAt(i)<='Z')
    	    index=s.charAt(i)-'A';
    	if(s.charAt(i)>='a' && s.charAt(i)<='z')		
    	    index=s.charAt(i)-'a';
    	ar[index]=true;	
    }
    for(int i=0;i<26;i++)
    {
    	if(ar[i]==false)
    		c++;
    }
    if(c<1)
    	System.out.println("panagram");
    else 
    	System.out.println("not anagram");
	}

}
