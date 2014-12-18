import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by acnightly on 12/17/14.
 */
public class Main {
    final static int MAX_N = 100;
    final static int MAX_M = 100;
    static int n;
    static int m;
    static char field[][] = new char[MAX_N + 1][MAX_M + 1];
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("resources/in"));
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        for (int i = 0; i < n; i++) {
            String str = cin.next();
            for (int j = 0; j < m; j++) {
                field[i][j] = str.charAt(j);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (field[i][j] == 'W') {
//                    print(field);
                    dfs(i, j);
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs(int x, int y) {
        field[x][y] = '.';

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx;
                int ny = y + dy;
                if (0 <= nx && nx < n && 0 <= ny && ny < m && field[nx][ny] == 'W')
                    dfs(nx, ny);
            }
        }
        return;
    }

    private static void print(char[][] field) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
