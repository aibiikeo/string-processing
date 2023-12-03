package org.example;

public class Main {
    public static void main(String[] args) {
        StringProcessor sp = new StringProcessor();
        System.out.println(sp.isStrongPassword("Ww1!"));
        System.out.println(sp.isStrongPassword("Ww1!kkkk"));
        System.out.println(sp.calculateDigits("In 2023, 5 adventurous explorers traveled to 3 different countries, discovering new cultures and landscapes."));
        System.out.println(sp.calculateWords("Disestablishmentarianism, often misunderstood, is a formidable concept, necessitating careful consideration and understanding due to its intricate historical, political, and socio-religious implications."));

        System.out.println(sp.calculateExpression("10 / 4"));
        System.out.println(sp.calculateExpression("(15 - 3) * 2"));
        System.out.println(sp.calculateExpression("30 / (4 + 1)"));
        System.out.println(sp.calculateExpression("(9 + 3) / (2 * 4)"));
        System.out.println(sp.calculateExpression("((7 * 3) - (4 * 2)) / 5"));
    }
}