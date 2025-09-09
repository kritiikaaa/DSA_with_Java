package Recursion;
import java.util.*;

public class mazeProblem {

    public static void main(String[] args) {
        mazeProblem mp = new mazeProblem();

        int rows = 3, cols = 4;   // 3x4 matrix

        ArrayList<String> paths = mp.mazePath(0, 0, rows - 1, cols - 1);

        System.out.println("Total paths: " + paths.size());
        System.out.println("All paths: " + paths);
    }

    // Top-Down (returns all paths)
    ArrayList<String> mazePath(int sr, int sc, int er, int ec) {
        ArrayList<String> ans = new ArrayList<>();

        // Base case
        if (sr == er && sc == ec) {
            ans.add("");
            return ans;
        }

        // Horizontal move
        if (sc < ec) {
            ArrayList<String> rightPath = mazePath(sr, sc + 1, er, ec);
            for (String p : rightPath) {
                ans.add("H" + p);
            }
        }

        // Vertical move
        if (sr < er) {
            ArrayList<String> downPath = mazePath(sr + 1, sc, er, ec);
            for (String p : downPath) {
                ans.add("V" + p);
            }
        }

        // Diagonal move
        if (sr < er && sc < ec) {
            ArrayList<String> diagPath = mazePath(sr + 1, sc + 1, er, ec);
            for (String p : diagPath) {
                ans.add("D" + p);
            }
        }

        return ans;
    }
}
