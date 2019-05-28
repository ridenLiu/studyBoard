package exercise.date_0507;

public class Pascal_s_Triangle {
    public static void main(String[] args) {
        get_Pascal_s_Triangle(3);
    }

    public static void get_Pascal_s_Triangle(int line) {
        final int NMAX = line;

        // allocate triangular array
        int[][] odds = new int[NMAX + 1][];
        for (int n = 0; n <= NMAX; n++) {
            odds[n] = new int[n + 1];
        }
        // fill triangular array
        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {
                /*
                 * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
                 */
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++)
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;

                odds[n][k] = lotteryOdds;
            }
        }

        // print triangular array
        for (int[] row : odds) {
            for (int odd : row) {
                System.out.print(odd);
            }
            System.out.println();
        }

    }
}

