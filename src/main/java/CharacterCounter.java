import java.util.*;
import java.util.stream.Collectors;

public class CharacterCounter {
    private HashMap<List<String>, String> cache = new HashMap<>();
    private Map<Character, Integer> mapOfUnicSymbolsAndTheirCount = new LinkedHashMap<>();
    
    public String countUnicSymbols(boolean isCacheEnabled, String... initialStrings) {
        StringJoiner joiner = new StringJoiner("\n");
        List<String> initialStringsAsList = Arrays.asList(initialStrings);
        if (isCacheEnabled) {
            if (cache.containsKey(initialStringsAsList)) {
                return cache.get(initialStringsAsList);
            }
            count(joiner, mapOfUnicSymbolsAndTheirCount, initialStrings);
            String stringResult = joiner.toString();
            cache.put(initialStringsAsList, stringResult);
            return stringResult;
        }

        count(joiner, mapOfUnicSymbolsAndTheirCount, initialStrings);
        return joiner.toString();
    }

    private void count(StringJoiner joiner, Map<Character, Integer> mapOfUnicSymbolsAndTheirCount, String... initialStrings) {
        for (String eachInitialString : initialStrings) {
            mapOfUnicSymbolsAndTheirCount.clear();
            countSymbolsInEachString(eachInitialString, mapOfUnicSymbolsAndTheirCount);
            joiner.add(eachInitialString).add(convertWithStream(mapOfUnicSymbolsAndTheirCount));
        }
    }

    private void countSymbolsInEachString(String stringToCount, Map<Character, Integer> mapToCollectCounts) {
        for (char eachSymbol : stringToCount.toCharArray()) {
            long count = stringToCount.chars().filter(currentSymbol -> currentSymbol == eachSymbol).count();
            mapToCollectCounts.put(eachSymbol, (int) count);
        }
    }

    private String convertWithStream(Map<Character, Integer> map) {
        String mapAsString = map.keySet().stream()
                .map(key -> String.format("\"%s\" - %d", key, map.get(key)))
                .collect(Collectors.joining("\n"));
        return mapAsString;
    }
}

