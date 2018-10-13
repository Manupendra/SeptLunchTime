/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class ChefresS
{
    public static void main (String[] args) throws java.lang.Exception
    {
        //Scanner sc=new Scanner(System.in);
        int T=sc.ni();
        for(int ai=0;ai<T;ai++){
            int N=sc.ni();
            int M=sc.ni();
            int L[]=new int[N];
            int R[]=new int[N];
            for(int i=0;i<N;i++){
                L[i]=sc.ni();
                R[i]=sc.ni();
            }
            Arrays.sort(L);
            Arrays.sort(R);
            for(int i=0;i<M;i++){
                int val=sc.ni();
                if(val<=L[0]){
                    out.prn(L[0]-val);
                    continue;
                }
                else if(L[N-1]<=val){
                    if(R[N-1]>val)
                        out.prn("0");
                    else
                        out.prn("-1");
                    continue;
                }
                int pos=search(L,val,0,N-1);
                if(val<R[pos]&&val>=L[pos]){
                    out.prn("0");
                    continue;
                }
                else if(R[pos]<=val){
                    if(pos==N-1){
                        out.prn("-1");
                        continue;
                    }
                    else{
                        out.prn(L[pos+1]-val);
                        continue;
                    }
                }
            }
        }
        sc.close();
        out.flush();
        out.close();
    }
    static int search(int L[],int val,int st,int end){
        int mid=(st+end)/2;
        if(end-st<=1)
            return st;
        if(L[mid]==val)
            return mid;
        else if(L[mid]<val)
            st=mid;
        else
            end=mid;
        return search(L,val,st,end);
    }


















    /*Template Starts here*/
    //  double start=System.currentTimeMillis();
    static long gcd(long a, long b) {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }

    static long modpow(long x, long y, long p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static Reader sc = new Reader();
    static OutputWriter out = new OutputWriter(System.out);

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int ni() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nl() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nd() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void pr(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void prn(Object... objects) {
            pr(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }
    /*Template ends here*/

}

