package calculator;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (например, 3 + 4):");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static String calc(String input) {
        // Разделяем входную строку по пробелам
        String[] parts = input.split(" ");

        // Проверяем, что в строке ровно три части: число, оператор, число
        if (parts.length != 3) {
            throw new IllegalArgumentException("throws Exception // Формат ввода не соответствует заданию.");
        }

        int num1;
        int num2;
        try {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("throws Exception // Неверный формат числа.");
        }

        String operator = parts[1];

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("throws Exception // Числа должны быть от 1 до 10 включительно.");
        }

        // Используем улучшенный switch и сразу возвращаем результат
        return switch (operator) {
            case "+" -> String.valueOf(num1 + num2);
            case "-" -> String.valueOf(num1 - num2);
            case "*" -> String.valueOf(num1 * num2);
            case "/" -> String.valueOf(num1 / num2);
            default -> throw new IllegalArgumentException("throws Exception // Неправильный оператор. Доступные операторы: +, -, *, /.");
        };
    }
}
