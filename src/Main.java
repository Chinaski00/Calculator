import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите два числа: ");
        String number = console.nextLine();
        System.out.println(parse(number));
    }

    public static String parse(String number) throws Exception {
        int num1;
        int num2;
        String operand;
        String result;
        boolean check;
        String[] operands = number.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception("Должно быть два операнда");
        operand = detectOperation(number);
        if (operand == null) throw new Exception("Неподдерживаемая математическая операция");
        if (numbersGrec.cheked(operands[0]) && numbersGrec.cheked(operands[1])) {
            num1 = numbersGrec.convertToArabian(operands[0]);
            num2 = numbersGrec.convertToArabian(operands[1]);
            check = true;
        }
        else if (!numbersGrec.cheked(operands[0]) && !numbersGrec.cheked(operands[1])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            check = false;
        }
        else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = calc(num1, num2, operand);
        if (check) {
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = numbersGrec.convertToGrec(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }

    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    static int calc(int a, int b, String oper) {

        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }

}

class numbersGrec {
    static String[] grecArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
            "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXIV", "XXV",
            "XXVII", "XXVIII", "XXX", "XXXII", "XXXV", "XXXVI", "XL", "XLII", "XLV", "XLVIII", "XLIX",
            "L", "LIV", "LVI", "LX", "LXIII", "LXIV", "LXX", "LXXII", "LXXX", "LXXXI", "XC", "C"};

    public static boolean cheked(String val) {
        for (int i = 0; i < grecArray.length; i++) {
            if (val.equals(grecArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String roman) {
        for (int i = 0; i < grecArray.length; i++) {
            if (roman.equals(grecArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToGrec(int arabian) {
        return grecArray[arabian];
    }

}