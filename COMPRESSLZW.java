import java.util.ArrayList;
import java.util.Scanner;
public class COMPRESSLZW {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Text do you need compress");
        String Text = input.nextLine();

        ArrayList<Integer> position = new ArrayList<Integer>();
        ArrayList<String> DICTIONARY = new ArrayList<String>();

        for (int i = 0; i < 128; i++)// save Ascii char in my dictionary(we choose 128 look doctor in lecture )
            DICTIONARY.add(String.valueOf((char) i));

        String temp = "";
        int i = 0;
        int Coded = 0;
        while (i < Text.length()) {
            temp += Text.charAt(i);
            if (DICTIONARY.contains(temp)) {
                i++;
                if (i == Text.length()) {
                    position.add(DICTIONARY.indexOf(temp));
                    break;
                }
                Coded = DICTIONARY.indexOf(temp);
                continue;
            }
            DICTIONARY.add(temp);
            position.add(Coded);
            temp = "";
        }

        input.close();
        for (i = 0; i < position.size(); i++)
            System.out.println("<" + position.get(i) + ">");
    }
}
