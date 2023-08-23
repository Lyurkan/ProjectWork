import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CurrencyConverterTest {

    @Test
    public void testConvertToWords() {
        assertEquals("пять рублей", CurrencyConverter.convertToWords(5));
        assertEquals("ноль рублей", CurrencyConverter.convertToWords(0));
        assertEquals("сто один рубль", CurrencyConverter.convertToWords(101));
        assertEquals("четыреста пятьдесят рублей", CurrencyConverter.convertToWords(450));
        assertEquals("три рубля", CurrencyConverter.convertToWords(3));
        assertEquals("сорок пять рублей", CurrencyConverter.convertToWords(45));
        assertEquals("девятьсот девяносто девять рублей", CurrencyConverter.convertToWords(999));
        assertEquals("тысяча пятьсот восемьдесят четыре рубля", CurrencyConverter.convertToWords(1584));
    }

    @Test
    public void testConvertToWordsOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> CurrencyConverter.convertToWords(-1));
        assertThrows(IllegalArgumentException.class, () -> CurrencyConverter.convertToWords(10001));
    }
}