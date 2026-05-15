package ex1;

import java.util.*;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println("Type some words, and when you be tired type exit ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        List<String> list = new ArrayList<>();
        Set<String> set = new TreeSet<>();
        Map<String, Integer> map = new HashMap<>();
        while (!word.equals("exit")) {
            list.add(word);
            set.add(word);
            map.put(word, map.getOrDefault(word, 0) + 1);
            // map.merge(word, 1, Integer::sum);
            // "insira 1, ou se já existir, some com o valor atual"
            word = scanner.nextLine();
        }
        System.out.println("List of words: " + list);
        System.out.println("List of words without repetition: " + set);
        System.out.println("List of words count: " + map);
    }

}
