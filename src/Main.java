import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        int[][] Bn = new int[100][50];
        int[][] Un = new int[100][50];
        int[][] Ln = new int[100][50];
        int[][] Cn = new int[100][50];
        int[][] Dn = new int[100][50];
        int[][] DnCn =new int[100][50];

        int maxN = 100000;

        for (int n = 1000; n <= 100000; n += 1000) {
            int i = n/1000;
            for (int k = 0; k < 50; k++) {
                BallThrower ballThrower = new BallThrower(n);
                ballThrower.throwBalls();
                Bn[i-1][k] = ballThrower.getB();
                Un[i-1][k] = ballThrower.getU();
                Ln[i-1][k] = ballThrower.getL();
                Cn[i-1][k] = ballThrower.getC();
                Dn[i-1][k] = ballThrower.getD();
                DnCn[i-1][k] = (ballThrower.getD()-ballThrower.getC());
            }
            System.out.println("n: "+ n + "   ✅");

        }
        ToFile BnToFile = new ToFile("Bn", Bn, maxN, 50);
        ToFile UnToFile = new ToFile("Un", Un, maxN, 50);
        ToFile LnToFile = new ToFile("Ln", Ln, maxN, 50);
        ToFile CnToFile = new ToFile("Cn", Cn, maxN, 50);
        ToFile DnToFile = new ToFile("Dn", Dn, maxN, 50);
        ToFile DnCnToFile = new ToFile("DnCn", DnCn, maxN, 50);

        BnToFile.saveData();
        UnToFile.saveData();
        LnToFile.saveData();
        CnToFile.saveData();
        DnToFile.saveData();
        DnCnToFile.saveData();

        System.out.println("\nAll done!" + " \uD83C\uDFC6");
    }
}



