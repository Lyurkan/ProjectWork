public class CurrencyConverter {
    private static final String[] units = {
            "", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"
    };

    private static final String[] teens = {
            "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
            "семнадцать", "восемнадцать", "девятнадцать"
    };

    private static final String[] tens = {
            "", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"
    };

    private static final String[] hundreds = {
            "", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"
    };

    private static final String[] thousands = {
            "", "тысяча", "тысячи", "тысяч"
    };

    private static final String[] rubles = {
            "рубль", "рубля", "рублей"
    };

    public static String convertToWords(int number) {
        if (number < 0 || number > 10000) {
            throw new IllegalArgumentException("Number must be between 0 and 10000");
        }

        if (number == 0) {
            return "ноль " + rubles[2];
        }

        int thousandsPart = number / 1000;
        int hundredsPart = (number % 1000) / 100;
        int tensPart = (number % 100) / 10;
        int unitsPart = number % 10;

        StringBuilder result = new StringBuilder();

        if (thousandsPart > 0) {
            if (thousandsPart == 1) {
                result.append(thousands[1]);
            } else if (thousandsPart <= 4) {
                result.append(units[thousandsPart]).append(" ").append(thousands[2]);
            } else if (thousandsPart == 10) {
                return result.append(teens[0]).append(" ").append(thousands[3]).append(" ").append(rubles[2]).toString();
            }
            else {
                result.append(units[thousandsPart]).append(" ").append(thousands[3]);
            }
            result.append(" ");
        }

        if (hundredsPart > 0) {
            result.append(hundreds[hundredsPart]);
        }

        if (tensPart > 0 || unitsPart > 0) {
            if (tensPart == 1) {
                result.append(" ").append(teens[unitsPart]);
            } else {
                result.append(" ").append(tens[tensPart]);
                if (unitsPart > 0) {
                    result.append(" ").append(units[unitsPart]);
                }
            }
        }

        if (number >= 10 && number <= 20 || tensPart == 1) {
            result.append(" ").append(rubles[2]);
        } else {
            result.append(" ").append(rubles[getRublesForm(unitsPart)]);
        }

        return result.toString().trim().replaceAll("\\s+", " ");
    }

    private static int getRublesForm(int unitsPart) {
        if (unitsPart == 1) {
            return 0;
        } else if (unitsPart >= 2 && unitsPart <= 4) {
            return 1;
        } else {
            return 2;
        }
    }
}
