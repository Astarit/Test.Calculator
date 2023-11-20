import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите выражение в формате 'число оператор число': ");
            String input = scanner.nextLine();
            String result = calc(input);
            System.out.println(result);
            if (result.equals("Завершение работы")) {
                scanner.close();
                break;
            }
        }
    }
    public static String calc(String input) throws Exception {
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
            String operator = parts[1];
            if (checkRange(num1, num2)){
                return GetStrValue(num1, num2, operator);
            }else {
                throw new Exception("Числа не в диапазоне от 1 до 10");
            }

        }   else {
            throw new Exception("Неверный формат ввода");
        }
    }
    public static String GetStrValue(int num1, int num2, String operator) throws Exception{
        int result;
        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> result = num1 / num2;
            default ->
                    throw new Exception("Неверный оператор. Пожалуйста, используйте один из следующих операторов: +, -, *, /");
        }
        return String.valueOf(result);
    }
    public static boolean checkRange (int num1, int num2){
        return ((num1 >= 1 && num1 <=10) && (num2 >= 1 && num2 <=10));
    }
}