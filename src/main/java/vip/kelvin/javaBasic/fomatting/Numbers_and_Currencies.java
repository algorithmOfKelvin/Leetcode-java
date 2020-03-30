package vip.kelvin.javaBasic.fomatting;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

/**
 * ## Numbers and Currencies
 * This section explains how to use the NumberFormat, DecimalFormat, and DecimalFormatSymbols classes.
 * https://docs.oracle.com/javase/tutorial/i18n/format/numberintro.html
 */
public class Numbers_and_Currencies {

    public static void main(String[] args) {
//        __NumberFormat();
//        __DecimalFormat();
        __DecimalFormatSymbols();
    }

    /**
     * # Using Predefined Formats
     * https://docs.oracle.com/javase/tutorial/i18n/format/numberFormat.html
     */
    private static void __NumberFormat() {
        // Using Predefined Formats
        Object number = 0.4341;
        NumberFormat instance = NumberFormat.getInstance();
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        NumberFormat integerInstance = NumberFormat.getIntegerInstance();
        System.out.printf("instance: %s\n", instance.format(number));
        System.out.printf("currencyInstance: %s\n",currencyInstance.format(number));
        System.out.printf("numberInstance: %s\n",numberInstance.format(number));
        System.out.printf("percentInstance: %s\n", percentInstance.format(number));
        System.out.printf("integerInstance: %s\n", integerInstance.format(number));

    }

    /**
     * # Customizing Formats
     * https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
     */
    private static void __DecimalFormat() {
//        value	pattern	output	Explanation
//        123456.789	###,###.###	123,456.789	The pound sign (#) denotes a digit, the comma is a placeholder for the grouping separator, and the period is a placeholder for the decimal separator.
//        123456.789	###.##	123456.79	The value has three digits to the right of the decimal point, but the pattern has only two. The format method handles this by rounding up.
//        123.78	000000.000	000123.780	The pattern specifies leading and trailing zeros, because the 0 character is used instead of the pound sign (#).
//        12345.67	$###,###.###	$12,345.67	The first character in the pattern is the dollar sign ($). Note that it immediately precedes the leftmost digit in the formatted output.
//        12345.67	\u00A5###,###.###	¥12,345.67	The pattern specifies the currency sign for Japanese yen (¥) with the Unicode value 00A5.
        String[] patterns = new String[]{"###,###.###", "###.##", "00000000.000", "$###,###.###", "\u00A5###,###.###"};
        Object value = 000123456.789;
        // Constructing Patterns
        for (String pattern : patterns) {
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            System.out.println(value + " " + pattern + " " + myFormatter.format(value));
        }


    }

    /**
     * # Altering the Formatting Symbols
     * https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
     *
     */
    private static void __DecimalFormatSymbols() {
        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(/*currentLocale*/);
        unusualSymbols.setDecimalSeparator('|');
        unusualSymbols.setGroupingSeparator('^');

        String strange = "#,##0.###";
        DecimalFormat weirdFormatter = new DecimalFormat(strange, unusualSymbols);
        weirdFormatter.setGroupingSize(4);

        String bizarre = weirdFormatter.format(12345.678);
        System.out.println(bizarre);
    }

    /**
     * # Number Format Pattern Syntax
     * https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
     *
     * ------------------------------------------------
     * You can design your own format patterns for numbers by following the rules specified by the following BNF diagram:
     * pattern    := subpattern{;subpattern}
     * subpattern := {prefix}integer{.fraction}{suffix}
     * prefix     := '\\u0000'..'\\uFFFD' - specialCharacters
     * suffix     := '\\u0000'..'\\uFFFD' - specialCharacters
     * integer    := '#'* '0'* '0'
     * fraction   := '0'* '#'*
     *
     * ------------------------------------------------
     * Notation	Description
     * X*	0 or more instances of X
     * (X | Y)	either X or Y
     * X..Y	any character from X up to Y, inclusive
     * S - T	characters in S, except those in T
     * {X}	X is optional
     *
     * ---------------------------------------------
     * Symbol	Description
     * 0	a digit
     * #	a digit, zero shows as absent
     * .	placeholder for decimal separator
     * ,	placeholder for grouping separator
     * E	separates mantissa and exponent for exponential formats
     * ;	separates formats
     * -	default negative prefix
     * %	multiply by 100 and show as percentage
     * ?	multiply by 1000 and show as per mille
     * ¤	currency sign; replaced by currency symbol; if doubled, replaced by international currency symbol; if present in a pattern, the monetary decimal separator is used instead of the decimal separator
     * X	any other characters can be used in the prefix or suffix
     * '	used to quote special characters in a prefix or suffix
     */
}
