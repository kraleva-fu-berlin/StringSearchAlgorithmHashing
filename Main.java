import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        OpenData file = new OpenData();
        String text;
        text = file.readFileGetText("https://algs4.cs.princeton.edu/63suffix/mobydick.txt");
        System.out.println("Robin Karp:"+file.rabinKarpAlgorithm("WHALE")+file.getIndizes()+"\n" + file.getIndizes().size());
        System.out.println("Naiv:"+file.naiveAlgorithm("WHALE") + file.getIndizes()+"\n" + file.getIndizes().size());
    }
}
