import static java.lang.Math.pow;

public class HashGenerator {
    final static int primzahl=getrandomPrimzahlinIntervall();
    private static int alphabetSignsCount ;

    public HashGenerator(){
        alphabetSignsCount=127;//Because we use ASCII
    }

    public HashGenerator(int alphabetSignsCount){
        this.alphabetSignsCount=alphabetSignsCount;
    }

    public static int hashfunktion(String string){
        int hashCode=0;
        double helper =0;
        int length = string.length();
        char c = ' ';
        for(int i = 0;i<length;i++){
            if(Character.isUpperCase(string.charAt(i))){
                c = Character.toLowerCase(string.charAt(i));
                helper += c  * pow(alphabetSignsCount,(length - 1 - i));
            } else {
                helper += string.charAt(i) * pow(alphabetSignsCount , (length - 1 - i));
            }
        }
        hashCode = (int) helper;
        hashCode %=primzahl;
        return hashCode;
    }

    public static int getrandomPrimzahlinIntervall(int lowerbound,int upperbound){
        PrimeGenerator helper = new PrimeGenerator();
        return helper.getPrime(lowerbound,upperbound);
    }
    public static int getrandomPrimzahlinIntervall(){
        PrimeGenerator helper = new PrimeGenerator();
        return helper.getPrime();
    }
}
