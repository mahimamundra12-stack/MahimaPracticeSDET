public class ArrayMultiplication {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
int[] output = new int[input.length];

for (int i = 0; i < input.length; i++) {

    int product = 1;

    for (int j = 0; j < input.length; j++) {

        if (i != j) {
            product = product * input[j];
        }
    }

    output[i] = product;
    System.out.println("Product of array except self at index " + i + ": " + output[i]);
}
    }
    
}
