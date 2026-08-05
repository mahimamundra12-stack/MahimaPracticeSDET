public class ArrayPractice {

    public static void main(String[] args) {

        int[] numbers = {10,20,30,40,50};
        int[] marks = {85,90,78,95,88};
        int result[]= new int[marks.length];
         int sum=0;

for(int i = 0; i < numbers.length; i++) {
    System.out.println("Number at position "+i);
            System.out.println(numbers[i]);
        }

for(int i = 0; i < marks.length; i++) {
    System.out.println("Marks at position "+i +" is "+marks[i]);
   
    sum=sum+marks[i];
    result[i]=marks[i];
    }
    System.out.println("Total marks: "+sum);
    System.out.println("Result array:");
    for(int i = 0; i < result.length; i++) {
        System.out.println("Result at position "+i +" is "+result[i]);
    }

    int total = findTotal(marks);
    System.out.println("Total marks (using method): " + total);
    printArray(marks);
}

public static void printArray(int[] numbers) {
    for(int i = 0; i < numbers.length; i++) {
        System.out.println("Element at position "+i +" is "+numbers[i]);
    }
}

public static int findTotal(int[] numbers) {
    int total = 0;
    for(int i = 0; i < numbers.length; i++) {
        total += numbers[i];
    }
    return total;
}

}