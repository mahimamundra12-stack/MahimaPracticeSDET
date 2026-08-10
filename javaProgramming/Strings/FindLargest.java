package Strings;

public class FindLargest {
    public static void main(String[] args) {
        int[] numbers = {10, 5, 20, 8, 15};
        int largest = findLargest(numbers);
        System.out.println("The largest number is: " + largest);
    }

    public static int findLargest(int[] numbers) {
        int largest = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }
        return largest;
    }
}