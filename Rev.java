import java.util.Scanner;
public class Rev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    int l=s.length();
    char c[]=s.toCharArray();
    char n[]=new char[l];
    for(int i=0;i<l;i++)
    {
    	if(c[i]==' ')
    		n[i]=' ';
    }
    for(int i=l-1;i>0;i++)
    {
    	for(int j=0;j<l;j--)
    	{
    		if(c[i]==' ')
    		{	j--;
    		break;}
    		n[j]=c[i];
    	}
    }
    for(int i=0;i<l;i++)
     System.out.println(n[i]);
	}

}
