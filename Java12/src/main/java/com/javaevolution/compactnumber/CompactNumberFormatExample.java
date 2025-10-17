package com.javaevolution.compactnumber;

import java.text.CompactNumberFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Demonstrates Compact Number Formatting introduced in Java 12.
 * CompactNumberFormat formats numbers in a compact, human-readable form.
 */
public class CompactNumberFormatExample {

    /**
     * Format number in short style (e.g., 1K, 1M)
     */
    public String formatShort(long number) {
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        return formatter.format(number);
    }

    /**
     * Format number in long style (e.g., 1 thousand, 1 million)
     */
    public String formatLong(long number) {
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        return formatter.format(number);
    }

    /**
     * Format with specific locale
     */
    public String formatWithLocale(long number, Locale locale) {
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.SHORT);
        return formatter.format(number);
    }

    /**
     * Format decimal numbers
     */
    public String formatDecimal(double number) {
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        return formatter.format(number);
    }

    /**
     * Compare different locales
     */
    public void demonstrateLocales(long number) {
        // US English
        NumberFormat usFormatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        String us = usFormatter.format(number);

        // German
        NumberFormat deFormatter = NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.SHORT);
        String de = deFormatter.format(number);

        // French
        NumberFormat frFormatter = NumberFormat.getCompactNumberInstance(Locale.FRENCH, NumberFormat.Style.SHORT);
        String fr = frFormatter.format(number);
    }

    /**
     * Practical example: Format file sizes
     */
    public String formatFileSize(long bytes) {
        if (bytes < 1024) {
            return bytes + " B";
        }
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        return formatter.format(bytes / 1024.0) + "B";
    }

    /**
     * Practical example: Format social media counts
     */
    public String formatSocialCount(long count) {
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        return formatter.format(count);
    }

    /**
     * Practical example: Format currency in compact form
     */
    public String formatCompactCurrency(long amount) {
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        return "$" + formatter.format(amount);
    }
}
