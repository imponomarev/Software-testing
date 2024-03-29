import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task2.MergeSort;

import java.lang.reflect.Method;

import static org.junit.Assert.assertArrayEquals;

class MergeSortTest {

    @Test
    @DisplayName("Проверка на пустом массиве")
    void testEmptyArray() {
        int[] array = {};
        MergeSort.mergeSort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    @DisplayName("Проверка на массиве с одним элементом")
    void testSingleElementArray() {
        int[] array = {1};
        MergeSort.mergeSort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    @DisplayName("Проверка на отсортированном массиве")
    void testSortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        MergeSort.mergeSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    @DisplayName("Проверка на отсортированном в обратном порядке массиве")
    void testReverseSortedArray() {
        int[] array = {5, 4, 3, 2, 1};
        MergeSort.mergeSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    @DisplayName("Проверка на неотсортированном массиве")
    void testRandomArray() {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6};
        MergeSort.mergeSort(array);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 6, 9}, array);
    }

    @Test
    @DisplayName("Проверка на массиве с дубликатами")
    void testArrayWithDuplicates() {
        int[] array = {1, 2, 2, 1, 3, 3, 2};
        MergeSort.mergeSort(array);
        assertArrayEquals(new int[]{1, 1, 2, 2, 2, 3, 3}, array);
    }

    @Test
    @DisplayName("Проверка на массиве с отрицательными числами")
    void testArrayWithNegativeNumbers() {
        int[] array = {-3, -1, -4, -1, -5, -9, -2, -6};
        MergeSort.mergeSort(array);
        assertArrayEquals(new int[]{-9, -6, -5, -4, -3, -2, -1, -1}, array);
    }

    @Test
    @DisplayName("Проверка на массиве с отрицательными и положительными числами")
    void testArrayWithNegativeAndPositiveNumbers() {
        int[] array = {-3, 1, -4, -1, 5, -9, 2, -6};
        MergeSort.mergeSort(array);
        assertArrayEquals(new int[]{-9, -6, -4, -3, -1, 1, 2, 5}, array);
    }

    @Test
    void testMerge() throws Exception {

        Method mergeMethod = MergeSort.class.getDeclaredMethod("merge", int[].class, int[].class, int[].class);
        mergeMethod.setAccessible(true);

        int[] array = new int[6];
        int[] left = {1, 3, 5};
        int[] right = {2, 4, 6};

        mergeMethod.invoke(null, array, left, right);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, array);
    }
}
