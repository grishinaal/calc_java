import java.util.Scanner;

class Calc {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите два числа: ");
        String information = scan.nextLine();
        System.out.println(parse(information));
    }
    public static String parse(String information) throws Exception {
        int number1;
        int number2;
        String operation;
        String result;
        boolean isRoman;
        operation = detectOperation(information);
        String[] operands = information.split("[+\\-*/]");
        if (operands.length !=2) throw new Exception("Необходимое количество опреандов - 2");
        if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            number1 = Roman.convertToArabian(operands[0]);
            number2 = Roman.convertToArabian(operands[1]);
            isRoman = true;
        }
        else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            number1 = Integer.parseInt(operands[0]);
            number2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        else {
            throw new Exception("Использование одновременно разных систем счисления");
        }
        if (number1 > 10 || number2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = calc(number1, number2, operation);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Римское число не может быть меньше нуля");
            }
            result = Roman.convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }
    static String detectOperation(String information) throws Exception {
        if (information.contains("+")) return "+";
        else if (information.contains("-")) return "-";
        else if (information.contains("*")) return "*";
        else if (information.contains("/")) return "/";
        else throw new Exception("Неверная операция");
    }
    static int calc(int a, int b, String operation) {
        if (operation.equals("+")) return a + b;
        else if (operation.equals("-")) return a - b;
        else if (operation.equals("*")) return a * b;
        else return a / b;
    }
}
class Roman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};
    public static boolean isRoman(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }
    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }
    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }
}