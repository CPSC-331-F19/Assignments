package cpsc331.assignment1;

/**
 *
 * A class for the loop-based computation of the MacGonagall Mystery sequence
 *
 * @author Steven Ferguson (30037518)
 * @author Daniel Contreras (10080311)
 * @author Guransh Mangat (30061719)
 * @version 1.0
 *
 */

public class FMacGonagall {

    /**
     *
     * The main method for this class.
     *
     * @param args A single non-negative integer n.
     *
     */

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Fiddlesticks! One integer input is required.");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);
            System.out.println(fmacG(n));
        } catch (NumberFormatException e) {
            System.out.println("Fiddlesticks! One integer input is required.");
        } catch (IllegalArgumentException e) {
            System.out.println("Fiddlesticks! The integer input cannot be negative.");
        }

    }

    /**
     *
     *  Computes the nth MacGonagall Number M_n, throwing
     *  an IllegalArgumentException if n is negative.
     *
     * Precondition:
     * An integer n given as input.
     *
     * Postcondition:
     * The nth MacGonagall Number, M_n is returned as output, and
     * an IllegalArgumentException is thrown if n < 0.
     *
     * @param n the MacGonagall Number to be computed
     * @return the nth MacGonagall Number, M_n
     * @throws IllegalArgumentException if the input is negative
     *
     */

    public static int fmacG(int n) throws IllegalArgumentException {

        // Assertion: n is an integer such that n >= 0

        if (n < 0) {
            throw new IllegalArgumentException();
        }

        switch (n) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 5;
            case 3:
                return 8;
            default:

                int[] M = new int[n + 1];
                M[0] = 1;
                M[1] = 0;
                M[2] = 5;
                M[3] = 8;
                int i = 4;

                // Loop Invariant:
                // 1. n is an integer such that n >= 4
                // 2. i is an integer variable such that 4 <= i <= n
                // 3. M is an integer array with length n + 1
                // 4. M_j = fmacG_j for every integer j such that 0 <= j <= i
                //
                // Bound Function: n - (i - 1)

                while (i <= n) {
                    M[i] = 2 * M[i - 1] - 2 * M[i - 3] + M[i - 4];
                    i += 1;
                }

                return M[n];
        }

    }
}

