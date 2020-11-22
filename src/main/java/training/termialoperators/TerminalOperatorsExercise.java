package training.termialoperators;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperatorsExercise implements StreamTerminalOperators {

    @Override
    public void addToSet(Stream<String> stream, Set<String> set) {
        set.addAll(stream.collect(Collectors.toList()));
    }

    @Override
    public void addToListInReverseOrder(Stream<String> stream, List<String> list) {
        list.addAll(
                stream.collect(ArrayList::new,(arr,el)->arr.add(0,el),(l,r)->r.addAll(l))
        );
    }

    @Override
    public String[] collectToArray(Stream<String> stream) {
        return stream.toArray(String[]::new);
    }

    @Override
    public Set<String> collectToSet(Stream<String> stream) {
        return stream.collect(Collectors.toSet());
    }

    @Override
    public List<String> collectToList(Stream<String> stream) {
        return stream.collect(Collectors.toList());
    }

    @Override
    public String mergeIntoString(Stream<String> stream) {
        return stream.collect(Collectors.joining("-","[","]"));
    }

    @Override
    public int countCharacters(Stream<String> stream) {
        return stream.map(String::length).reduce(0,Integer::sum);
    }

    @Override
    public int longestWordLength(Stream<String> stream) {
        return stream.map(String::length).max(Integer::compare).orElse(0);
    }

    @Override
    public String longestWord(Stream<String> stream) {
        return stream.max(Comparator.comparingInt(String::length)).orElse("");
    }

    @Override
    public Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream) {
        return stream.collect(Collectors.groupingBy(String::length));
    }
}
