import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
public class CharacterCounterTest {
    CharacterCounter characterCounter = new CharacterCounter();

    @Test
    void countUnicSymbols_nullAsInParameter_exceptionIsExpected() {
        assertThrows(NullPointerException.class, () -> characterCounter.countUnicSymbols(false,null));
    }

    @Test
    void countUnicSymbols_singleStringAsInParameter_aMapOfUnicSymbolsAndTheirCountExpected() {
        String initialString = "hahah";

        String expectedResult = "hahah\n" +
                                "\"h\" - 3\n" +
                                "\"a\" - 2";
        String actualResult = characterCounter.countUnicSymbols(true, initialString);
        assertEquals(expectedResult,actualResult,"Method returns a String representation of initial string and a map of it's unic symbols and their counts");
    }

    @Test
    void countUnicSymbols_multipleStringsAsInParameters_aMapOfUnicSymbolsAndTheirCountExpected() {
        String[] initialStrings = new String[]{"java", "language"};

        String expectedResult = "java\n" +
                                "\"j\" - 1\n" +
                                "\"a\" - 2\n" +
                                "\"v\" - 1\n" +
                                "language\n" +
                                "\"l\" - 1\n" +
                                "\"a\" - 2\n" +
                                "\"n\" - 1\n" +
                                "\"g\" - 2\n" +
                                "\"u\" - 1\n" +
                                "\"e\" - 1";
        String actualResult = characterCounter.countUnicSymbols(true, initialStrings);
        assertEquals(expectedResult,actualResult,"Method returns a String representation of initial string and a map of it's unic symbols and their counts");
    }

    @Test
    void countUnicSymbols_multipleSameStringsAsInParameters_aMapOfUnicSymbolsAndTheirCountExpected() {
        String[] initialStrings = new String[]{"cache", "cache"};

        String expectedResult = "cache\n" +
                                "\"c\" - 2\n" +
                                "\"a\" - 1\n" +
                                "\"h\" - 1\n" +
                                "\"e\" - 1\n" +
                                "cache\n" +
                                "\"c\" - 2\n" +
                                "\"a\" - 1\n" +
                                "\"h\" - 1\n" +
                                "\"e\" - 1";
        String actualResult = characterCounter.countUnicSymbols(true, initialStrings);
        assertEquals(expectedResult,actualResult,"Method returns a String representation of initial string and a map of it's unic symbols and their counts");
    }

    @Test
    void countUnicSymbols_differentCasesOfSameSymbolInAString_caseExpectedNotToBeIgnored() {
        String initialString = "lLLLl";

        String expectedResult = "lLLLl\n" +
                                "\"l\" - 2\n" +
                                "\"L\" - 3";
        String actualResult = characterCounter.countUnicSymbols(true, initialString);
        assertEquals(expectedResult,actualResult,"Method returns a String representation of initial string and a map of it's unic symbols and their counts");
    }

    @Test
    void countUnicSymbols_otherSymbolsAndSpacesMixedWithString_aMapOfUnicSymbolsAndTheirCountExpected() {
        String initialString = "eff a& ?! :;";

        String expectedResult = "eff a& ?! :;\n" +
                                "\"e\" - 1\n" +
                                "\"f\" - 2\n" +
                                "\" \" - 3\n" +
                                "\"a\" - 1\n" +
                                "\"&\" - 1\n" +
                                "\"?\" - 1\n" +
                                "\"!\" - 1\n" +
                                "\":\" - 1\n" +
                                "\";\" - 1";
        String actualResult = characterCounter.countUnicSymbols(true, initialString);
        assertEquals(expectedResult,actualResult,"Method returns a String representation of initial string and a map of it's unic symbols and their counts");
    }

    @Test
    void countUnicSymbols_numbersAsInParameters_aMapOfUnicSymbolsAndTheirCountExpected() {
        String initialString = "137991";

        String expectedResult = "137991\n" +
                                "\"1\" - 2\n" +
                                "\"3\" - 1\n" +
                                "\"7\" - 1\n" +
                                "\"9\" - 2";
        String actualResult = characterCounter.countUnicSymbols(true, initialString);
        assertEquals(expectedResult,actualResult,"Method returns a String representation of initial string and a map of it's unic symbols and their counts");
    }

    @Test
    void countUnicSymbols_resultsWithCacheEnabledAndWithoutCache_shouldBeTheSame () {

        boolean isSame = characterCounter.countUnicSymbols(true, "eee") == characterCounter.countUnicSymbols(true, "eee");

        System.out.println(isSame);
        assertTrue(isSame);

    }

}

