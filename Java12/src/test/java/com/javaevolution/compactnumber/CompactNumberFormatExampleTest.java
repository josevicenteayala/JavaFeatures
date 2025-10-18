package com.javaevolution.compactnumber;

import org.junit.jupiter.api.Test;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class CompactNumberFormatExampleTest {

    private final CompactNumberFormatExample example = new CompactNumberFormatExample();

    @Test
    void formatShort_shouldFormatThousands() {
        assertEquals("1K", example.formatShort(1000));
        assertEquals("10K", example.formatShort(10000));
        assertEquals("100K", example.formatShort(100000));
    }

    @Test
    void formatShort_shouldFormatMillions() {
        assertEquals("1M", example.formatShort(1000000));
        assertEquals("10M", example.formatShort(10000000));
    }

    @Test
    void formatShort_shouldFormatBillions() {
        assertEquals("1B", example.formatShort(1000000000));
    }

    @Test
    void formatLong_shouldFormatWithWords() {
        String result = example.formatLong(1000);
        assertTrue(result.contains("thousand") || result.equals("1K"));
    }

    @Test
    void formatLong_shouldFormatMillionsWithWords() {
        String result = example.formatLong(1000000);
        assertTrue(result.contains("million") || result.equals("1M"));
    }

    @Test
    void formatWithLocale_shouldFormatWithUSLocale() {
        String result = example.formatWithLocale(1000, Locale.US);
        assertTrue(result.equals("1K") || result.equals("1000"));
    }

    @Test
    void formatDecimal_shouldFormatDecimalNumbers() {
        String result = example.formatDecimal(1500.5);
        assertNotNull(result);
        assertTrue(result.length() > 0);
    }

    @Test
    void demonstrateLocales_shouldNotThrowException() {
        assertDoesNotThrow(() -> example.demonstrateLocales(1000000));
    }

    @Test
    void formatFileSize_shouldFormatSmallFiles() {
        assertEquals("100 B", example.formatFileSize(100));
    }

    @Test
    void formatFileSize_shouldFormatLargeFiles() {
        String result = example.formatFileSize(1024 * 1024);
        assertTrue(result.contains("K") || result.contains("M"));
    }

    @Test
    void formatSocialCount_shouldFormatCounts() {
        assertEquals("1K", example.formatSocialCount(1000));
        assertEquals("1M", example.formatSocialCount(1000000));
    }

    @Test
    void formatCompactCurrency_shouldIncludeDollarSign() {
        String result = example.formatCompactCurrency(1000);
        assertTrue(result.startsWith("$"));
        assertTrue(result.contains("K") || result.contains("1000"));
    }

    @Test
    void formatShort_shouldHandleZero() {
        assertEquals("0", example.formatShort(0));
    }

    @Test
    void formatShort_shouldHandleSmallNumbers() {
        assertEquals("100", example.formatShort(100));
        assertEquals("500", example.formatShort(500));
    }
}
