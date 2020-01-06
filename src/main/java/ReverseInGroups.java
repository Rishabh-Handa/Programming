import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseInGroups {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int testCases = Integer.parseInt(br.readLine());

	for (int i = 0; i < testCases; i++) {
	    String line = br.readLine();
	    String[] strs = line.trim().split("\\s+");

	    int n = Integer.parseInt(strs[0]);
	    int d = Integer.parseInt(strs[1]);

	    int[] elements = new int[n];

	    line = br.readLine();
	    strs = line.trim().split("\\s+");

	    for (int j = 0; j < n; j++)
		elements[j] = Integer.parseInt(strs[j]);

	    StringBuffer output = new StringBuffer();

	    for (int x = 0; x < n; ) {
		for (int y = x + d - 1; y >= x; y--) {
		    if (y <= n - 1)
			output.append(elements[y] + " ");
		}
		x += d;
	    }

	    System.out.println(output);
	}

	br.close();

    }
}
