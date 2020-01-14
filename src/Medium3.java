import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.io.OutputStream;


public class Medium3 {

	public static void main(String[] args) {

		Kattio io = new Kattio(System.in, System.out);

		int n = io.getInt();
		double k = (double)io.getInt();

		int value1;
		int value2;
		double maxSimReq;

		int[] simRequests = new int[n];
		Arrays.fill(simRequests, 1);
		ArrayList<Integer> numbers = new ArrayList<Integer>();


		for(int i=0;i<n;i++) {
			numbers.add(io.getInt());
		}
		//io.close();

		for(int i=0;i<n;i++){ // COMPARISONS
			for (int j=i+1;j<n;j++){
				if (Math.abs(numbers.get(i)-numbers.get(j))<1000){
					 
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
