/**
 * 
 */
package wc3211;

import java.util.*;
 

/**
 * @author chenxi
 * 直接给这道题跪了，后来想想确实是大神啊
 * 两个人一起洗一堆衣服，给定了每件衣服的时间，求最短时间
 * 贪心的思路：将时间排序，两人先一起洗最长时间的衣服，先洗碗的挑选最长时间的衣服进行清洗
 * 这个的确无法证明是最优的
 * 
 * 
 * 背包问题的思路：两个人的清洗时间加起来肯定是总时间，而且一定一个人长一个人短，
 * 那就假设男的有一个 sum[i]/2 的包，然后他来捡衣服，要捡的最多
 * 剩下的女的来洗，那么女的时间肯定更多，应为男的至多 一半，女的至少一半
 * 
 */
public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 	Scanner s = new Scanner( System.in);
			//m and n;
			while (true){
				int m,n;
				m =  s.nextInt();n=s.nextInt();
				if(m==0&&n==0) break;
				List<String> l = new ArrayList<String>();
				int i,j;
				for(i=0;i<m;i++)
				{
					String color = s.next();
					l.add(color);
				}
				List<List<Integer>>  time = new ArrayList<List<Integer>>();
				for(i=0;i<m;i++)
				{
					time.add(new ArrayList<Integer>());
				}
				for(i=0;i<n;i++)
				{
					int t = s.nextInt();
					String color = s.next();
					j = l.indexOf(color);
					time.get(j).add(t);
				}
				
			 		
			 
				int sum [] = new int[m];
				for(i=0;i<m;i++)
				{
					for(int v:time.get(i)) sum[i] += v;
				}
				
				int rt=0;
				List<Integer> temp ;
				
				for(i=0;i<m;i++)
				{
					temp = time.get(i);
					int dp[] = new int[sum[i]/2+1];
					for(int c:temp)
					{
						
						for(int v = sum[i]/2;v>=c;v--)
						{
							if(v-c>=0)
								dp[v] = max(dp[v],dp[v-c]+c);
						}
					}
					rt += sum[i] - dp[sum[i]/2];
				}
				
				System.out.println(rt);
			}
			
	}
	 
	static int max(int a, int b)
	{
		return a>b?a:b;
	}
}
/*

 测试数据
3 5
red blue yellow
2 red
3 blue
4 blue
6 red
3 yellow

1 1
red
5 red  

2 1
red green 
3 green


3 2
red green yellow
3 green
4 yellow


1 4
red
1 red
8 red
3 red 
10 red


1 4
red
1 red
3 red 
10 red
8 red


1 5
red
1 red
3 red 
10 red
8 red
11 red


1 3
red
11 red
3 red 
10 red


1 0
red

3 4
red y g
11 red
1 y
3 g
10 g 

*/