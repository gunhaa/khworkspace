package note;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class note {

		public static void main(String[] args) {
			
			
			try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int X = Integer.parseInt(br.readLine());
			
			int[] arr = {64,32,16,8,4,2,1};
			int count = 0 ;
			int sum = 0 ;
			
			
			for(int i =0 ; i<7 ; i++) {
				
				
				sum+=arr[i];	
				
				if(sum==X) {
					System.out.println(count+"회 부숨");
					break;
					
				} else if (sum>X) {
					sum-=arr[i];
					count++;
				} else if (sum<X) {

					count++;
					
				}
				
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}


