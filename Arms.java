
public class Arms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,r=0;
		int sum=0;
   for(int i=1;i<1000;i++)
   {
    n=i;sum=0;
    while(n!=0)
    {
    	r=n%10;
    	sum=sum+(r*r*r);
    	n=n/10;
    }
    if(sum==i)
    	System.out.println(sum);
    }
	}

}
