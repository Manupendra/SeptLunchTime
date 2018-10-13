import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OPPOSITE {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer s = new StringBuffer();
        label1:
        for (int testcases = Integer.parseInt(br.readLine()); testcases > 0; testcases--) {
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            int flag = 0;
            String ss1 = br.readLine();
            String[] s1 = ss1.split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(s1[i]);
            }
            if (N % 2 != 0)
                s.append("NO").append('\n');
            else {
                for (int i = 0; i < N / 2; i++) {
                    if(arr[i]==arr[N/2+i]){
                        if(arr[i]==-1){
                            arr[i]=arr[i+N/2]=1;
                        }
                    }else if(arr[i]==-1){
                        arr[i]=arr[N/2+i];
                    } else if (arr[N/2+i]==-1){
                        arr[N/2+i]=arr[i];
                    }else{
                        s.append("NO\n");
                        continue label1;
                    }
                }
                s.append("YES\n");
                for (int i = 0; i <N ; i++) {
                    s.append(arr[i]+" ");
                }
                s.append('\n');
            }

        }

        System.out.print(s);

    }
}
