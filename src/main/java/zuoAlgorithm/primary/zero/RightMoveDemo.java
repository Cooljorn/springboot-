package zuoAlgorithm.primary.zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sun
 * @since 2022/1/13
 */
public class RightMoveDemo {

    public static void main(String[] args) {
        System.out.println("Please enter the number of word:");
        Scanner scanner = new Scanner(System.in);
        int wordNumber = scanner.nextInt();
        int rightNumber = 0;
        List<String> wordList = new ArrayList<>();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("picture");
        dictionary.add("turepic");
        dictionary.add("hello");
        dictionary.add("world");
        for (int i = 0; i < wordNumber; i++) {
            System.out.println("Please enter the words:");
            String s = scanner.next();
            wordList.add(s);
        }
        for (String word : wordList) {
            rightNumber += reverseWord(word, dictionary);
        }
        System.out.println("right number is:" + rightNumber);
    }

    private static int reverseWord(String s, List<String> dictionary){
        int rightNumber = 0;
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(s.split("")));
        for (int i = 0 ; i < strings.size()-1; i++) {
            String s1 = strings.get(0);
            for (int j = 1; j < strings.size(); j++) {
                strings.set(j-1, strings.get(j));
            }
            strings.set(strings.size()-1, s1);
            StringBuilder stringBuilder = new StringBuilder();
            strings.forEach(item -> stringBuilder.append(item));
            if(dictionary.contains(stringBuilder.toString())){
                rightNumber++;
            }
        }
        return rightNumber;
    }
}