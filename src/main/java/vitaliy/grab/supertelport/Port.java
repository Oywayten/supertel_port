package vitaliy.grab.supertelport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility class with two public methods:
 * stringArrToIntArr() - the method converts the array of strings indexes into an array of sequences of numbers;
 * multiplyArrays() - the method returns all possible unique ordered groups of elements of the obtained arrays of numbers.
 *
 * @author Oywayten 07.04.2023
 */
public final class Port {

    private final String[] indexes;

    /**
     * The constructor creates a Port object with an indexed set of arbitrarily long sequences of numbers
     * described in the indexes string array.
     *
     * @param indexes {@link String}[] an array of strings with the described sequence of numbers of arbitrary length.
     */
    public Port(String[] indexes) {
        this.indexes = indexes;
    }

    /**
     * Method returns all possible unique ordered groups of elements of the obtained arrays of numbers.
     *
     * @return int[][] result as an array all possible unique ordered groups of elements of the obtained arrays of numbers.
     */
    public int[][] multiplyArrays() {
        return listToArr(uniqueGroups(arraysToList(stringArrToIntArr())));
    }

    private static List<List<Integer>> uniqueGroups(List<List<Integer>> listList) {
        if (listList.isEmpty()) {
            return Collections.singletonList(Collections.emptyList());
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> newGroup;
        for (Integer item : listList.get(0)) {
            for (List<Integer> group : uniqueGroups(listList.subList(1, listList.size()))) {
                newGroup = new ArrayList<>();
                newGroup.add(item);
                newGroup.addAll(group);
                result.add(newGroup);
            }
        }
        return result;
    }

    private static List<List<Integer>> arraysToList(int[][] ints) {
        return Arrays.stream(ints).map(ints1 -> Arrays.stream(ints1).boxed().collect(Collectors.toList())).collect(Collectors.toList());
    }

    private static int[][] listToArr(List<List<Integer>> inputList) {
        int size = inputList.size();
        int[][] result = new int[size][];
        List<Integer> integers;
        int[] temp;
        for (int i = 0; i < size; i++) {
            integers = inputList.get(i);
            int tempSize = integers.size();
            temp = new int[tempSize];
            for (int j = 0; j < tempSize; j++) {
                temp[j] = integers.get(j);
            }
            result[i] = temp;
        }
        return result;
    }

    /**
     * Method converts the array of strings indexes into an array of sequences of numbers;
     *
     * @return int[][] array of sequences of numbers;
     */
    public int[][] stringArrToIntArr() {
        if (indexes == null) {
            throw new IllegalArgumentException("null is an invalid value!");
        }
        int[][] ints = new int[indexes.length][];
        Arrays.setAll(ints, i -> getInts(stringsList(indexes[i])));
        return ints;
    }

    private static String[] stringsList(String indexes) {
        if (null == indexes) {
            throw new IllegalArgumentException("null is an invalid value!");
        }
        return indexes.split(",");
    }

    private static int[] getInts(String[] result) {
        List<Integer> integers = new ArrayList<>();
        for (String s : result) {
            if (s.isEmpty()) {
                throw new IllegalArgumentException("An empty array specified!");
            } else if (s.length() == 1) {
                integers.add(Integer.parseInt(s));
            } else {
                String[] strings = s.split("-");
                IntStream.rangeClosed(Integer.parseInt(strings[0]), Integer.parseInt(strings[1])).forEach(integers::add);
            }
        }
        int[] ints = new int[integers.size()];
        Arrays.setAll(ints, integers::get);
        return ints;
    }
}
