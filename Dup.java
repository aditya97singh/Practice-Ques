import java.util.Scanner;
public class Dup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    String ar[]=s.split(" ");
    int l=ar.length;
    for(int i=0;i<l;i++)
    {
    	if(ar[i]!=null)
    	{	
    	for(int j=i+1;j<l;j++)
    	{
    		if(ar[i].equals(ar[j]))
    		{
    			ar[j]=null;
    		}	
    	}
    	}
    }
    for(int m=0;m<l;m++)
    {
    	if(ar[m]!=null)
    		System.out.print(ar[m]+" ");
    }
    }
    
}


