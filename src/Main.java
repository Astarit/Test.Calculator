import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите выражение в формате 'число оператор число': ");
            String input = scanner.nextLine();
            String result = calc(input);
            System.out.println(result);
            if (result.equalsIgnoreCase("Завершение работы")) {
                break;
            }
        }
    }
    public static String calc(String input){
        String[] parts = input.split(" ");
        if (parts.length == 1 && parts[0].equalsIgnoreCase("exit")) {
            return "Завершение работы";
        } else if (parts.length == 3) {
            int num1;
            int num2;
            try {
                num1 = Integer.parseInt(parts[0]);
                num2 = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода, введите выражение в формате 'число оператор число'");
                return "Завершение работы";
            }
            char operator = parts[1].charAt(0);
            if (checkFormat(num1, num2)){
                return checkOperator(num1, num2, operator);
            }else {
                try {
                    throw new Exception("Числа не в диапазоне от 1 до 10");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return "Завершение работы";
                }
            }

        } else {
            try {
                throw new Exception("Неверный формат ввода");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return "Завершение работы";
            }
        }
    }
    public static String checkOperator(int num1, int num2, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                try {
                    throw new Exception("Неверный оператор. Пожалуйста, используйте один из следующих операторов: +, -, *, /");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return "Завершение работы";
                }
        }
        return String.valueOf(result);
    }
    public static boolean checkFormat (int num1, int num2){
        return ((num1 >= 1 && num1 <=10) && (num2 >= 1 && num2 <=10));
    }
}