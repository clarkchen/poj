/**
 * 
 */
package bs3628;
import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		
		int n,b;
		n = s.nextInt();
		b = s.nextInt();
		int i,j;
		int h[] = new int[n];
		int sum =0;
		for(i=0;i<n;i++)
		{
			h[i] =  s.nextInt();
			sum += h[i];
		}
		 
		int dp[] = new int[sum+1];
		dp[0] =0;
		 
		for( i=0;i<n;i++){
			 
			for(j=sum;j>=h[i];j--)
			{
				if(dp[j]<dp[j-h[i]]+h[i])
				{
					dp[j] = dp[j-h[i]]+h[i];
				}
			}
			 
		}
 		int min=Integer.MAX_VALUE; 
		for(i=b;i<=sum;i++)
		{
			if(min == Integer.MAX_VALUE && dp[i]>=b  )
			{
				min = dp[i];
			}
			else if(dp[i]>min)
			{
				break;
			}
		}
		System.out.println(min-b);
	}

}
/*
测试数据：
5 16
3
1
3
5
6

5 16
1
1
3
5
6
*/