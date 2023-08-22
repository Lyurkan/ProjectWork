import java.util.Scanner;
//bug 781,891   1000, 1091, 1001, 7091
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество рублей ");
        int amount = scanner.nextInt();
        String[] thousand = {"", "одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "тысяч"};
        String[] hundred = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        String[] dec = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String[] units = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
                "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать",
                "восемьнадцать", "девятнадцать"};
        int temp = 0;
        boolean index = true;

        if (amount <= 10000 && amount > 999) {
            int thousandCount = amount / 1000;
            temp = amount - (thousandCount * 1000);
            thousandPrint(thousandCount, thousand, units, temp);
            {
                if (temp <= 999 && temp != 0 ) {
                    int hundredCount = temp / 100;
                    temp = temp - (hundredCount * 100);
                    if (temp == 0) {
                        index = false;
                    }
                    hundredPrint(hundredCount, hundred, temp, index);
                    {
                        if (temp <= 99 && temp >= 20 && temp != 0) {
                            int decCount = temp / 10;
                            temp = temp - (decCount * 10);
                            decPrint(decCount, dec, units, temp);
                            if (temp < 9 &&  temp != 0) {
                                unitsPrint(temp, units);
                                temp = 0;
                            }
                        }
                        if (temp < 20  && temp != 0) {
                            unitsPrint(temp, units);
                        }
                    }
                }
            }
        }
        if (amount <= 1000 && amount > 99) {
            int hundredCount = amount / 100;
            temp = amount - (hundredCount * 100);
            hundredPrint(hundredCount, hundred, temp, index);
            {
                if (temp < 100 && temp >= 20) {
                    int decCount = temp / 10;
                    temp = temp - (decCount * 10);
                    decPrint(decCount, dec, units, temp);
                    if (temp < 9 && temp > 0) {
                        unitsPrint(temp, units);
                        temp = 0;
                    }
                }
                if (temp < 20 && temp > 0) {
                    unitsPrint(temp, units);
                }
            }
        }
        if (amount <= 100 && amount >= 20) {
            int decCount = amount/10;
            temp = amount - (decCount * 10);
            decPrint(decCount, dec, units, temp);
            if (temp < 9 && temp > 0) {
                unitsPrint(temp, units);
                temp = 0;
            }
        }
        if (amount < 20 && amount > 0) {
            unitsPrint(amount, units);
        }
    }
    public static void thousandPrint(int thousandCount, String[] thousand, String[] units, int temp) {
        if (thousandCount == 1) {
            System.out.print(thousand[1]);
        }
        if (thousandCount == 2) {
            System.out.print(thousand[2]);
        }
        if (thousandCount == 3) {
            System.out.print(thousand[3]);
        }
        if (thousandCount == 4) {
            System.out.print(thousand[4]);
        }
        if (thousandCount >= 5) {
            System.out.print(units[thousandCount] + " " + thousand[5]);
        }
        if (temp == 0) {
            System.out.print(" рублей");
        }
    }
    public static void hundredPrint(int hundredCount, String[] hundred,int temp, boolean index) {
        System.out.print(" ");
        if (hundredCount == 1) {
            System.out.print(hundred[1]);
        }
        if (hundredCount == 2) {
            System.out.print(hundred[2]);
        }
        if (hundredCount == 3) {
            System.out.print(hundred[3]);
        }
        if (hundredCount == 4) {
            System.out.print(hundred[4]);
        }
        if (hundredCount == 5) {
            System.out.print(hundred[5]);
        }
        if (hundredCount == 6) {
            System.out.print(hundred[6]);
        }
        if (hundredCount == 7) {
            System.out.print(hundred[7]);
        }
        if (hundredCount == 8) {
            System.out.print(hundred[8]);
        }
        if (hundredCount == 9) {
            System.out.print(hundred[9]);
        }
        if (temp == 0 && index == false) {
            System.out.print("hрублей");

        }
    }
    public static void decPrint(int decCount, String[] dec, String[] units, int temp) {
        System.out.print(" ");

        if (decCount == 2) {
            System.out.print(dec[2]);
        }
        if (decCount == 3) {
            System.out.print(dec[3]);
        }
        if (decCount == 4) {
            System.out.print(dec[4]);
        }
        if (decCount == 5) {
            System.out.print(dec[5]);
        }
        if (decCount == 6) {
            System.out.print(dec[6]);
        }
        if (decCount == 7) {
            System.out.print(dec[7]);
        }
        if (decCount == 8) {
            System.out.print(dec[8]);
        }
        if (decCount == 9) {
            System.out.print(dec[9]);
        }
        if (temp == 0){
            System.out.print(" рублей");
        }

    }
    public static void unitsPrint(int amount, String[] units) {
        System.out.print(" ");
        if (amount == 1) {
            System.out.print(units[1]);
        }
        if (amount == 2) {
            System.out.print(units[2]);
        }
        if (amount == 3) {
            System.out.print(units[3]);
        }
        if (amount == 4) {
            System.out.print(units[4]);
        }
        if (amount == 5) {
            System.out.print(units[5]);
        }
        if (amount == 6) {
            System.out.print(units[6]);
        }
        if (amount == 7) {
            System.out.print(units[7]);
        }
        if (amount == 8) {
            System.out.print(units[8]);
        }
        if (amount == 9) {
            System.out.print(units[9]);
        }
        if (amount == 10) {
            System.out.print(units[10]);
        }
        if (amount == 11) {
            System.out.print(units[11]);
        }
        if (amount == 12) {
            System.out.print(units[12]);
        }
        if (amount == 13) {
            System.out.print(units[13]);
        }
        if (amount == 14) {
            System.out.print(units[14]);
        }
        if (amount == 15) {
            System.out.print(units[15]);
        }
        if (amount == 16) {
            System.out.print(units[16]);
        }
        if (amount == 17) {
            System.out.print(units[17]);
        }
        if (amount == 18) {
            System.out.print(units[18]);
        }
        if (amount == 19) {
            System.out.print(units[19]);
        }
        if (amount >= 2 && amount <= 4) {
            System.out.print(" рубля");
        }
        if (amount == 1) {
            System.out.print(" рубль");
        }
        if (amount >= 5 && amount <= 19) {
            System.out.print(" рублей");
        }
    }
}