package Recursion;
import java.util.*;

public class mazeProblem {

    public static void main(String[] args) {
        mazeProblem mp = new mazeProblem();

        int rows = 3, cols = 4;   // 3x4 matrix
        ArrayList<String> ans = new ArrayList<>();

        System.out.println("Bottom-up paths:");
        mp.mazePath(0, 0, rows - 1, cols - 1, ans);

        System.out.println("\nTop-down paths:");
        ArrayList<String> allPaths = mp.mazePath(0, 0, rows - 1, cols - 1);
        System.out.println(allPaths);
        System.out.println("Total paths: " + allPaths.size());
    }

    // Top-Down (returns all paths)
    ArrayList<String> mazePath(int sr, int sc, int er, int ec) {
        ArrayList<String> ans = new ArrayList<>();

        // Base case
        if (sr == er && sc == ec) {
            ans.add("");
            return ans;
        }

        // Horizontal move (right)
        if (sc < ec) {
            ArrayList<String> rightPath = mazePath(sr, sc + 1, er, ec);
            for (String p : rightPath) {
                ans.add("H" + p);
            }
        }

        // Vertical move (down)
        if (sr < er) {
            ArrayList<String> downPath = mazePath(sr + 1, sc, er, ec);
            for (String p : downPath) {
                ans.add("V" + p);
            }
        }

        // Diagonal move (down-right)
        if (sr < er && sc < ec) {
            ArrayList<String> diagPath = mazePath(sr + 1, sc + 1, er, ec);
            for (String p : diagPath) {
                ans.add("D" + p);
            }
        }
        return ans;
    }

    // Bottom-up (prints all paths)
    void mazePath(int sr, int sc, int er, int ec, ArrayList<String> ans) {

        // Base case
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return;
        }

        // Horizontal move (right)
        if (sc < ec) {
            ans.add("H");
            mazePath(sr, sc + 1, er, ec, ans);
            ans.remove(ans.size() - 1); // backtrack
        }

        // Vertical move (down)
        if (sr < er) {
            ans.add("V");
            mazePath(sr + 1, sc, er, ec, ans);
            ans.remove(ans.size() - 1); // backtrack
        }

        // Diagonal move (down-right)
        if (sr < er && sc < ec) {
            ans.add("D");
            mazePath(sr + 1, sc + 1, er, ec, ans);
            ans.remove(ans.size() - 1); // backtrack
        }
    }
}
