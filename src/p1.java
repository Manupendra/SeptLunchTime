import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer s = new StringBuffer();
        for (int testcases = Integer.parseInt(br.readLine()); testcases > 0; testcases--) {
            int count=0;
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String s1[]=br.readLine().split(" ");
                int S=Integer.parseInt(s1[0]);
                int J=Integer.parseInt(s1[1]);
                if(J-S>5)
                    count++;
            }
            s.append(count).append('\n');

        }

        System.out.print(s);

    }
}
