package training.intermediateoperators;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperatorsExercise implements StreamIntermediateOperators {

    @Override
    public Stream<String> wordsLongerThanFiveCharacters(List<String> words) {
        return words.stream().filter(s->s.length()>5);
    }

    @Override
    public Stream<String> firstThreeWordsLongerThanFiveCharacters(List<String> words) {
        return wordsLongerThanFiveCharacters(words).limit(3);
    }

    @Override
    public Stream<String> firstThreeDistinctWordsLongerThanFiveCharactersInReverseAlphabeticalOrder(List<String> words) {
        return wordsLongerThanFiveCharacters(words).distinct().limit(3).sorted(Comparator.reverseOrder());
    }

    @Override
    public Stream<Integer> lengthOfWords(List<String> words) {
        return words.stream().map(s->s.length());
    }

    @Override
    public Stream<Integer> staircase() {
        return IntStream.rangeClosed(0,6)
                .flatMap((row)->IntStream.rangeClosed(0,row))
                .boxed();
    }
}
