import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] ARGS) {
        new Thread(null, new Runnable() {
            public void run() {
                new Main().solve();
            }
        }, "1", 1 << 26).start();
    }

    void solve() {
        InputStream IS = System.in;
        OutputStream OS = System.out;
        ScanReader in = new ScanReader(IS);
        PrintWriter out = new PrintWriter(OS);
        DiskTower disktower = new DiskTower();
        disktower.solve(1, in, out);
        out.close();
    }

}

