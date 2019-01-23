import java.util.Scanner;
public class Strt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    String ar[]=new String[4];
    String s;
    for(int i=0;i<4;i++)
    {	
     ar[i]=sc.next();
	}
    for(int i=0;i<4;i++)
    {
    	s=ar[i];
    	if(s.charAt(0)=='s' || s.charAt(0)=='S')
    		System.out.println(ar[i]);
    }
    
	}
}
