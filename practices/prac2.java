package practices;
import java.util.*;

public class prac2 {
	
	public static boolean check(int x[],int y[],int n)
	{
		Stack<Integer> s=new Stack<Integer>();
		int j=0;
		for(int i=0;i<n;i++)
		{
			s.push(x[i]);
			while(!s.isEmpty()&&y[j]==s.peek())
			{
				s.pop();
				j++;
			}
		}
		return s.isEmpty();	
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		for(int j=0;j<n;j++)
			b[j]=sc.nextInt();
		if(check(a,b,n))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}