/**
 * 
 */
package poj;

/**
 * @author chenxi
 *
 */
import java.util.*;
public class Main {
	static int max(int a,int b)
	{
		return a>b?a:b;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int n,m;
		n =s.nextInt();m=s.nextInt();
		int i,j;
		int c[]= new int[n];
		int w[] = new int[n];
		for(i=0;i<n;i++)
		{
			c[i] =s.nextInt();
			w[i] =s.nextInt();
		}
		int dp[]= new int[m+1];
		dp[0] = 0;
		for( i=0;i<n;i++)
		{
			for(j = m;j>=c[i];j--)
			{
				dp[j] = max(dp[j],dp[j-c[i]]+w[i]);
			}
		}
		System.out.println(dp[m]);
		
	}

}
