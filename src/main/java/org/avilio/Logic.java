package org.avilio;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Logic {

    public static String checkForNumber(String string) {
        String result;
        try {
            Double num = Double.parseDouble(string);
            if (num > 7) {
                result = "Привет";
            } else {
                result = "";
            }
        } catch (NumberFormatException e) {
            return "Пожалуйста, введите корректные данные";
        }
        return result;
    }

    public static String checkForName(String string) {
        if (!containsOnlyAlphabetCharacters(string))
            return "Пожалуйста, введите корректные данные";
        if (string.equalsIgnoreCase("Вячеслав")) {
            return "Привет, Вячеслав";
        } else return "Нет такого имени";
    }

    private static boolean containsOnlyAlphabetCharacters(String string) {
        return string.matches("\\p{L}+");
    }

    public static String outputMultiplesOf3(String string) {

        if (!string.matches("^[-\\d\\s]*\\d+[-\\d\\s]*$"))
            return "Пожалуйста, введите корректные данные";
        String[] numbers = string.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num % 3 == 0 && num != 0) {
                sb.append(num).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String checkBracketSequence(String sequence) {
        if (!sequence.matches("[\\[\\]{}()<>]+"))
            return "Пожалуйста, введите корректные данные: ()[]{}<>";
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put('>', '<');
        StringBuilder correctedSequence = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();

        for (Character c : sequence.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
                correctedSequence.append(c);
            } else if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != brackets.get(c)) {
                    correctedSequence.append(brackets.get(c)).append(c);
                } else {
                    stack.pop();
                    correctedSequence.append(c);
                }
            }
        }
        while (!stack.isEmpty()) {

            correctedSequence.append(getKeyByValue(brackets,stack.pop()));
        }
        return correctedSequence.toString();
    }

    private static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
