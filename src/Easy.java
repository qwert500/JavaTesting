import java.util.Scanner;

public class Easy {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLong()) {
			
			   int n1 = sc.nextInt();
			   int n2 = sc.nextInt();
			   int dmed;
			   int dmot;
			   
			   if (n2>n1){
				   dmed=n2-n1;
				   dmot=n1+360-n2;
			   }
			   else if (n2<n1){
				   dmed=360-n1+n2;
				   dmot=n1-n2;
			   }
			   else {// If n1=n2
				   dmed=0;
				   dmot=0;
			   }
			  
			   //Clockwise
			   if (dmed<dmot){
				   System.out.println(dmed);
			   }
			   //Counter clockwise
			   else if (dmed>dmot){
				   System.out.println(-dmot);
			   }
			   // 180 degrees
			   else if (dmed==180){ // case 180
				   System.out.println(dmed);
			   }
			   // case n1=n2
			   else if (dmed==0){ 
				   System.out.println(dmed);
			   }
			   
			}

		sc.close();
	}

}
