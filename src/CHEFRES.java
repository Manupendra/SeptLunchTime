import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CHEFRES {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer s = new StringBuffer();
        for (int testcases = Integer.parseInt(br.readLine()); testcases > 0; testcases--) {
            String s1[] = br.readLine().split(" ");
            int N = Integer.parseInt(s1[0]);
            int M = Integer.parseInt(s1[1]);
            int min=Integer.MAX_VALUE;

            Pair pairs[]=new Pair[N];
            for (int i = 0; i < N; i++) {
                String s2[]=br.readLine().split(" ");
                int a=Integer.parseInt(s2[0]);
                int b=Integer.parseInt(s2[1]);
                pairs[i]=new Pair(a,b);
            }
            //Sort the pairs with value a in increasing order takes O(n^2)
            /*for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N-1 ; j++) {
                    if(pairs[j].p1>pairs[j+1].p1){
                        Pair temp=pairs[j];
                        pairs[j]=pairs[j+1];
                        pairs[j+1]=temp;
                    }

                }

            }*/
            Arrays.sort(pairs);


            //Number of the people
            int peopleT[]=new int[M];
            label1:for (int i = 0; i < M ; i++) {
                peopleT[i]=Integer.parseInt(br.readLine());
                for (int j = 0; j < N ; j++) {
                    if(peopleT[i]>=pairs[j].p1 && peopleT[i]<pairs[j].p2)
                    {
                        s.append("0").append('\n');
                        continue label1;
                    }
                    else if(peopleT[i]<pairs[j].p1)
                    {
                        if(min>pairs[j].p1-peopleT[i])
                            min=pairs[j].p1-peopleT[i];

                    }
                    if(j==N-1 && peopleT[i]>pairs[j].p2)
                    {
                        s.append("-1").append('\n');
                        continue label1;
                    }
                    /*
                    if(peopleT[i]>=pairs[N-j-1].p2)
                        s.append("-1").append('\n');
                    else if(peopleT[i]<=pairs[N-j-1].p1)*/

                }
                s.append(min).append('\n');
            }




        }

        System.out.print(s);

    }
}

class Pair implements Comparable<Pair> {
    int p1;
    int p2;

    public Pair(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public int getP1() {
        return p1;
    }

    public int getP2() {
        return p2;
    }

    @Override
    public int compareTo(Pair o) {
        return this.p1-o.p1;
    }
}
