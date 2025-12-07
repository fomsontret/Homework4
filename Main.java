import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("                                       ");
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr1 = scanner.nextLine();
                    int money1 = Integer.parseInt(moneyStr1);
                    earnings += money1;
                    break;
                case 2:
                    System.out.println("Введите ваш расход");
                    String moneyStr2 = scanner.nextLine();
                    int money2 = Integer.parseInt(moneyStr2);
                    spendings += money2;
                    break;
                case 3:
                    int result1 = taxEarningsNotMinusSpendings(earnings);
                    int result2 = taxEarningsMinusSpendings(earnings,spendings);
                    if (result2 == result1) {
                        System.out.println("Можете выбрать любую систему налогообложения");
                    } else if (result2 > result1) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + result1);
                        System.out.println("Налог на другой системе: " + result2);
                        System.out.println("Экономия:" + (result2 - result1));
                    } else {
                        System.out.println("Мы советуем вам УСН доходы - расходы");
                        System.out.println("Ваш налог составит: " + result2);
                        System.out.println("Налог на другой системе: " + result1);
                        System.out.println("Экономия:" + (result1 - result2));
                    }

                    break;
                default:
                    System.out.println("Такой операции нет");
                    break;
            }

        }
        System.out.println("Программа завершена!");
    }
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarningsNotMinusSpendings(int earnings) {
        int tax = (earnings) * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
}