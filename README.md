# java
import java.util.Random;

public class random {

	public static void main(String[] args) {
		Random rn = new Random();
		int ran1 = rn.nextInt(100)+1;
		int ran2 = rn.nextInt(100)+1;
		int max,min;
		
		if(ran1>ran2){
			max = ran1;
			min = ran2;
		}
		else{
			max = ran2;
			min = ran1;
		}
		
		for(int i = max; i >= min; i--){
//			if(i <=10 ) break;
//			if(i %2==1) continue;
			if(i >10 && i %2==0)
			System.out.print(i+" ");
		}
	}

}
