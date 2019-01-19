import java.lang.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PrimeGenerator {
    public int getPrime() {
        Random rand = new Random();
        int number = rand.nextInt(1000) + 1;

        while (isPrime(number)==false) {
            number = rand.nextInt(1000) + 1;
        }
        return number;

    }
    public int getPrime(int a,int b) {
        Random rand = new Random();
        int number = ThreadLocalRandom.current().nextInt(a, b);
        while (isPrime(number)==false) {
            number = rand.nextInt(1000) + 1;
        }
        return number;

    }

    private static boolean isPrime(int inputNum){
        if (inputNum <= 3 || inputNum % 2 == 0)
            return inputNum == 2 || inputNum == 3; // hier ueberpruefen wir dies auch fuer alle gerade zahlen
        int divideBy = 3;
        while ((divideBy <= Math.sqrt(inputNum)) && (inputNum % divideBy != 0)) //weil wir dies schon fuer die geraden zahlen7
        //ueberprueft haben,koennen wir immer 2 aufaddieren,damit wir nur die ungeraden zahlen testen und zeit sparen.
            divideBy += 2;
        return inputNum % divideBy != 0;
    }
}
