
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.AbstractCollection;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.util.PriorityQueue;
import java.util.Comparator;


class DiskTower {
    public void solve(int testNumber, ScanReader in, PrintWriter out) {
        int n = in.scanInt();

        System.out.println("enter the floor size on consecutive days");

        int current_need = n;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++) {
            int x = in.scanInt();
            out.println("day:" + (i + 1) + " ");
            if (current_need == x) {
                out.print(x + "\n");
                current_need--;

                while (!queue.isEmpty() && current_need == queue.peek()) {
                    out.print(queue.poll() + "\n");
                    current_need--;
                }
            } else {
                queue.add(x);
            }

        }
    }

}

class ScanReader {
    private byte[] buf = new byte[4 * 1024];
    private int index;
    private BufferedInputStream in;
    private int Total_Char;

    public ScanReader(InputStream inputStream) {
        System.out.println("enter the total no of floors in the building");
        in = new BufferedInputStream(inputStream);
    }

    private int scan() {
        if (index >= Total_Char) {
            index = 0;
            try {
                Total_Char = in.read(buf);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (Total_Char <= 0) return -1;
        }
        return buf[index++];
    }

    public int scanInt() {
        int integer = 0;
        int n = scan();
        while (isWhiteSpace(n)) n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = scan();
            }
        }
        return neg * integer;
    }

    private boolean isWhiteSpace(int n) {
        if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
        else return false;
    }

}

