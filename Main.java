package HomeWork;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    static String virashenie;

    public static void main(String[] args) {
        System.out.println("Input:");
        Scanner sc = new Scanner(System.in);
        virashenie = sc.nextLine();
        Main mainClass = new Main();
        mainClass.calc(virashenie);
    }

    static String RomeCalc(int dd, int ddd) {

        String[] rome = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        int index = 0;

        String[] char3 = {"+", "-", "*", "/"};
        String aChar = String.valueOf(virashenie.charAt(2));
        String aChar2 = String.valueOf(virashenie.charAt(3));

        if (aChar.equals(char3[0]) || aChar2.equals(char3[0])) {
            index = dd + ddd;
        }
        if (aChar.equals(char3[1]) || aChar2.equals(char3[1])) {
            index = dd - ddd;
        }
        if (aChar.equals(char3[2]) || aChar2.equals(char3[2])) {
            index = dd * ddd;
        }
        if (aChar.equals(char3[3]) || aChar2.equals(char3[3])) {
            index = dd / ddd;
        }
        if (index < 0) {
            throw new IllegalArgumentException("В римской системе нет отрицательных чисел");
        }
        System.out.println("Output: ");
        System.out.println(rome[index]);

        return null;
    }

    static String ArabCalc(int c, int d) {

        int result;

        String[] char3 = {"+", "-", "*", "/"};
        String aChar = String.valueOf(virashenie.charAt(2));
        String aChar2 = String.valueOf(virashenie.charAt(3));

        if ((c >= 0 && c <= 10) && (d >= 0 && d <= 10)) {
            if (aChar.equals(char3[0]) || aChar2.equals(char3[0])) {
                result = Integer.parseInt(String.valueOf(c + d));
                System.out.println("Output: ");
                System.out.println(result);
            }
            if (aChar.equals(char3[1]) || aChar2.equals(char3[1])) {
                result = Integer.parseInt(String.valueOf(c - d));
                System.out.println("Output: ");
                System.out.println(result);
            }
            if (aChar.equals(char3[2]) || aChar2.equals(char3[2])) {
                result = Integer.parseInt(String.valueOf(c * d));
                System.out.println("Output: ");
                System.out.println(result);
            }
            if (aChar.equals(char3[3]) || aChar2.equals(char3[3])) {
                result = Integer.parseInt(String.valueOf(c / d));
                System.out.println("Output: ");
                System.out.println(result);
            }
        } else {
            throw new IllegalArgumentException("Введите от I до X или от 0 до 10");
        }
        return null;
    }

    public static String calc(String virashenie) {

        String levoeChislo;
        String pravoeChislo;

        String delenieStroki = virashenie;
        String[] operands = delenieStroki.split(" ");

        if (operands.length != 3) {
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор, а так же соблюдайте пробелы");
        }

        levoeChislo = operands[0];
        pravoeChislo = operands[2];

        String[] romeNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        try {
            if (Integer.parseInt(levoeChislo) != -1 && Integer.parseInt(pravoeChislo) != -1) {
                int c = Integer.parseInt(levoeChislo);
                int d = Integer.parseInt(pravoeChislo);
                Main.ArabCalc(c, d);
            }

        } catch (NumberFormatException e) {
            int dd = 0;
            int ddd = 0;

            for (int i = 0; i < romeNumbers.length; i++) {
                if (levoeChislo.equals(romeNumbers[i])) {
                    dd = i + 1;
                    for (int c = 0; c < romeNumbers.length; c++) {
                        if (pravoeChislo.equals(romeNumbers[c])) {
                            ddd = c + 1;
                            Main.RomeCalc(dd, ddd);
                        }
                    }
                }
            }
            if (dd == 0 || ddd == 0) {
                throw new IllegalArgumentException("Введите от I до X или от 0 до 10");
            }
        }
        return null;
    }
}











