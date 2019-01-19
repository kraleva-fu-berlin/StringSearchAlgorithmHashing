import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;


public class OpenData {
    public String inputText;
    private String inputLine;
    List<Integer> myList;

    public OpenData(int alphabetSignsCount){
        this.inputText = new String();
        this.inputLine = new String();
        myList=new ArrayList<Integer>();

    }
    public OpenData(){
        this.inputText = new String();
        this.inputLine = new String();
    }
    public void setString(String str){
        this.inputText=str;
    }
    public String getString(String str){
        return this.inputText;
    }
    public List<Integer> getIndizes(){
        return myList;
    }


    public String readFileGetText(String url) throws IOException {
       URL oracle = new URL(url);
        try {
            inputText=new String();
            BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
            while ((inputLine=in.readLine()) !=  null){
                inputText += inputLine + "\n" ;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return inputText;
    }
    public int naiveAlgorithm(String str){
        myList=new ArrayList<Integer>();
        int numberofWords = 0;
        int numberofletters=0;
        boolean upperCase=(str.charAt(0)<91 && str.charAt(0)>64);
        int length = str.length();
        String s = new String();
        char c='\0';
        int index = 0;
        for (int i =0;i<(inputText.length()-length + 1);i++){
            c = inputText.charAt(i);
            if(c==str.charAt(0) || Character.toUpperCase(c)==str.charAt(0) || Character.toUpperCase(str.charAt(0))==c){
                numberofletters=1;
                index=i;
                for (int j=1;j<length;j++){
                    if(inputText.charAt(i+j)==str.charAt(j) || Character.toUpperCase(inputText.charAt(i+j))==str.charAt(j) || Character.toUpperCase(str.charAt(j))==inputText.charAt(i+j)){
                        numberofletters++;
                    }
                }
                if (numberofletters==length){
                    myList.add((Integer) index);
                    numberofWords+=1;
                }
            }
            }
        return numberofWords;
    }

    public int rabinKarpAlgorithm(String str){
        myList=new ArrayList<Integer>();
        int numberofWords = 0;
        int length = str.length();
        int hash = HashGenerator.hashfunktion(str);
        int index = 0;
        for (int i =0;i<(inputText.length()-length);i++){
            if(hash == HashGenerator.hashfunktion(inputText.substring(i,i+length)) ){
                index=i;
                if(equalsWithUpperCase(inputText.substring(i,i+length),str)){
                    myList.add((Integer) index);
                    numberofWords++;
                }
            }
        }
        return numberofWords;
    }

    private boolean equalsWithUpperCase(String a,String b){
        if (a.length()!=b.length()){
            return false;
        }
        char c;
        int numberofletters=0;
        for (int i =0;i<a.length();i++) {
            c = a.charAt(i);
            if (a.charAt(i) == b.charAt(i) || Character.toUpperCase(a.charAt(i)) == b.charAt(i) || Character.toUpperCase(b.charAt(i)) == a.charAt(i)) {
               numberofletters++;
            }
        }
        if (numberofletters==a.length()) {
            return true;
        } else {
            return false;
        }
    }


}
