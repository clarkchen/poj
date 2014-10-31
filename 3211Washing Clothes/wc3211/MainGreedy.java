package wc3211;

/**
 * @author chenxi
 * 又一次证明了蛋疼的贪心算法是不能用于求最优解的
 */
import java.util.*;
public class MainGreedy {
	 
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
			for(i=0;i<m;i++)
		 		Collections.sort(time.get(i),Collections.reverseOrder());
			 
			int F []= new int[m+1];
			F[0] = 0;
			List<Integer> temp ;
			for(i=0;i<m;i++)
			{
				temp = time.get(i);
				if(temp.size()==1)
				{
					F[i+1] = F[i]+temp.get(0);;
				}
				else if(temp.size()>1){
					int t1 = F[i];
					int t2 = F[i];
					for(j=0;j<temp.size();j++)
					{
						
						if(t1>t2)
						{
						 	t2 = t2+ temp.get(j);
						}
						else 
						{
							t1 = t1+ temp.get(j);
						}
					}
					 
					F[i+1] = t1>t2?t1:t2;
					 
				}
				else F[i+1] = F[i];
			}
			
			System.out.println(F[m]);
		}
		
	}

}
