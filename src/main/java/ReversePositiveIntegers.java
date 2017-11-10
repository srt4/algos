/**
 * @author srt4@uw.edu
 */
public class ReversePositiveIntegers {

    public static void main(String[] args) {
        new ReversePositiveIntegers().reversePositiveNumbers(new int[] { 1, 3, 5, 7, -1, 7, 3, 5, 1});
    }

    public int[] reversePositiveNumbers(int[] numbers) {
        int begin = 0;
        int end = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                end = i;
            }
            else {
                reverseRange(numbers, begin, end);
                begin = end = i;
            }
        }
        reverseRange(numbers, begin, end);
        return numbers;
    }

    private void reverseRange(int[] array, int start, int end) {
        int i = 0;
        for (int j = start; j >= end; j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

}
