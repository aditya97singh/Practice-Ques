import java.util.Scanner;
public class Numero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    int sum=0,sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0;
    int n=0,ss=0,r,res=0;
    int l=s.length();
    for(int i=0;i<l;i++)
    {
      if(s.charAt(i)=='A' || s.charAt(i)=='I' || s.charAt(i)=='J' || s.charAt(i)=='Q' || s.charAt(i)=='Y')
    	  sum=sum+1;
      else if(s.charAt(i)=='B' || s.charAt(i)=='K' || s.charAt(i)=='R')
    	  sum1=sum1+2;
      else if(s.charAt(i)=='C' || s.charAt(i)=='G' || s.charAt(i)=='L' || s.charAt(i)=='S')
    	  sum2=sum2+3;
      else if(s.charAt(i)=='D' || s.charAt(i)=='M' || s.charAt(i)=='T')
    	  sum3=sum3+4;
      else if(s.charAt(i)=='E' || s.charAt(i)=='H' || s.charAt(i)=='N' || s.charAt(i)=='X')
    	  sum4=sum4+5;
      else if(s.charAt(i)=='U' || s.charAt(i)=='V' || s.charAt(i)=='W')
          sum5=sum5+6;
      else if(s.charAt(i)=='O' || s.charAt(i)=='Z')
    	  sum6=sum6+7;
      else if(s.charAt(i)=='F' || s.charAt(i)=='P')
          sum7=sum7+8;
      else
    	  n=l;
    }
    ss=sum+sum1+sum2+sum3+sum4+sum5+sum6+sum7;
    while(ss!=0)
    {
    	r=ss%10;
    	res=res+r;
    	ss=ss/10;
    }
    System.out.println("Result:"+res);
	}

}
