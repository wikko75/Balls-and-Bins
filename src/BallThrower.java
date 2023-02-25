import java.security.SecureRandom;

public class BallThrower {

    private final int n;      // no. of bins
    private final int[] m;    // bins
    private int B;            // first collision
    private int U;            // no. of empty bins (after n throws)
    private int L;            // max no. of balls in one bin (after n throws)
    private int C;            // min. no. of throws, so that
                              // at least one ball in each bin
    private int D;            //  min. no. of throws, so that
                              // at least two balls in each bin
    public int getB() {
        return B;
    }

    public int getU() {
        return U;
    }

    public int getL() {
        return L;
    }

    public int getC() {
        return C;
    }

    public int getD() {
        return D;
    }


    public BallThrower(int n) {
        this.n = n;
        m = new int[n];
    }


    private boolean firstCollision() {
        for (int balls : m) {
            if (balls == 2) {
                return true;
            }
        }
        return false;
    }


    private void emptyBins() {
        for (int ball : m) {
            if (ball == 0) {
                U++;
            }
        }
    }


    private void maxBallsInBins() {
        L = 0;
        for (int ball : m) {
            if (ball > L) {
                L = ball;
            }
        }
    }


    private boolean eachHasSingle() {
        for (int ball : m) {
            if (ball < 1) {
                return false;
            }
        }
        return true;
    }


    private boolean eachDoubled() {
        for (int ball : m) {
            if (ball < 2) {
                return false;
            }
        }
        return true;
    }


    public void throwBalls() {

        SecureRandom secureRandom = new SecureRandom();
        int throwNo = 0;

        while (!firstCollision()){
            throwNo++;
            int random = secureRandom.nextInt(0, n);
            m[random]++;
        }

        B = throwNo;

        while (throwNo < n) {
            throwNo++;
            int random = secureRandom.nextInt(0, n);
            m[random]++;
        }

        emptyBins();
        maxBallsInBins();


        while (!eachHasSingle()) {
            throwNo++;
            int random = secureRandom.nextInt(0, n);
            m[random]++;
        }

        C = throwNo;


        while (!eachDoubled()) {
            throwNo++;
            int random = secureRandom.nextInt(0, n);
            m[random]++;
        }

        D = throwNo;

        }
}

