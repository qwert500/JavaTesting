import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Medium {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		double maxSimReq;
		int value1;
		int value2;
		int i;
		int j;
		Scanner scanner = new Scanner(System.in);
  
		while (scanner.hasNextInt()) // INPUT
	      {
	         int input = scanner.nextInt();
	         numbers.add(input);
	      }
		 scanner.close();
		//ArrayList<Integer> simRequests = new ArrayList<Integer>();

		double k = numbers.get(1); 
		int numberOfRequests= numbers.size();
		int[] simRequests = new int[numberOfRequests];
		Arrays.fill(simRequests, 1);
		
		//for (i=0;i<numberOfRequests-2; i++){ // INITIALIZE simReq
		//	simRequests.add(1);
		//	}
		

		for(i=0;i<=numberOfRequests-3;i++){ // COMPARISONS
			for (j=i+1;j<=numberOfRequests-3;j++){
				if (Math.abs(numbers.get(i+2)-numbers.get(j+2))<1000){
					 
					value1 = (int) Array.get(simRequests,i);
					value2 = (int) Array.get(simRequests,j);
					value1 = value1 + 1;
					value2 = value2 +1;
					Array.set(simRequests, i, value1);
					Array.set(simRequests, j, value2);
					//simRequests.set(i, value1);
					//simRequests.set(j, value2);
				}
			}
		}
		maxSimReq = Arrays.stream(simRequests).max().getAsInt();; // max value
		double answer = maxSimReq/k; 
		int minimumNumOfServers = (int) Math.ceil(answer); // round up
		System.out.println(minimumNumOfServers);
	}

}
