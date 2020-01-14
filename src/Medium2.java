import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;


public class Medium2 {

	public static void main(String[] args) {

		Kattio io = new Kattio(System.in, System.out);

		int n = io.getInt();
		double k = io.getInt();
		int streak = 1;
		int j = 1;
		double bestStreak = 1;
		ArrayList<Integer> numbers = new ArrayList<Integer>();


		for(int i=0;i<n;i++) {
			numbers.add(io.getInt());
		}
		//io.close();s
		for (int i=0;i<(n-1);i++){
			j=i+1;
			while (numbers.get(j)-numbers.get(i)<1000 ){
				j++;
				streak+=1;
				if (j>(n-1)){break;}
			}
			if (streak>bestStreak){
				bestStreak=streak;	
			}
			streak=1;
		}
		double answer = bestStreak/k; 
		int minimumNumOfServers = (int) Math.ceil(answer); // round up
		System.out.println(minimumNumOfServers);
	}
}

class Kattio extends PrintWriter {
	public Kattio(InputStream i) {
		super(new BufferedOutputStream(System.out));
		r = new BufferedReader(new InputStreamReader(i));
	}
	public Kattio(InputStream i, OutputStream o) {
		super(new BufferedOutputStream(o));
		r = new BufferedReader(new InputStreamReader(i));
	}

	public boolean hasMoreTokens() {
		return peekToken() != null;
	}

	public int getInt() {
		return Integer.parseInt(nextToken());
	}

	public double getDouble() {
		return Double.parseDouble(nextToken());
	}

	public long getLong() {
		return Long.parseLong(nextToken());
	}

	public String getWord() {
		return nextToken();
	}



	private BufferedReader r;
	private String line;
	private StringTokenizer st;
	private String token;

	private String peekToken() {
		if (token == null)
			try {
				while (st == null || !st.hasMoreTokens()) {
					line = r.readLine();
					if (line == null) return null;
					st = new StringTokenizer(line);
				}
				token = st.nextToken();
			} catch (IOException e) { }
		return token;
	}

	private String nextToken() {
		String ans = peekToken();
		token = null;
		return ans;
	}
}


