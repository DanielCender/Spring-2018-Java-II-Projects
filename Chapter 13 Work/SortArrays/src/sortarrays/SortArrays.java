/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortarrays;
import java.lang.Number;
import java.lang.reflect.Array;
import java.lang.Comparable;
/**Name: SortArrays
 *Date: 2.20.18
 * @author danielcender
 * Abstract: This program will sort array elements in descending order.
 */
public class SortArrays {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer numArray[] = {2, 6, 7, 43, 5, 65, 234, 78, 3456, 23};
        Byte byteArray[] = {34, 65, 2, 6, 4, 7, 23, 54, 6, 3};
        Float floatArray[] = {34.654f, 34f, 65.34f, 234.654f, 75f, 34f, 4444f, 23563f, 2f, 777f};
        Double doubleArray[] = {2346765d, 454d, 234d, 765d, 34d, 654.34d, 655.533d, 2333d, 54.2233543d, 50d};
        // Sort arrays - pass to sort method
        sortData(numArray);
        sortData(byteArray);
        sortData(floatArray);
        sortData(doubleArray);
        // Display arrays - pass to display method
        displayArray(numArray);
        displayArray(byteArray);
        displayArray(floatArray);
        displayArray(doubleArray);
    }
        // Generic Method to sort arrays of 10 items in length
        static <T extends Comparable> void sortData(T[] array) {
            T tempArray[];
            tempArray = array;
            int a, b;
            T t; // Declare temporary holding value of generic type T
            int size = 10;
            // Working through length of array
            for(a = 0; a < array.length - 1; a++) {
                // Sort numbers next to each other
               // for(b = size - 1; b >= size; b--) {
               for(b = 0; b < array.length - a - 1; b++) {
                    if((array[b].compareTo(array[b+1])) > 0) {
                    // Exchange elements of the array
                    t = array[b];
                    array[b] = array[b+1];
                    array[b+1] = t;
                    }
                }
            }
        }
        // Method to display array contents
        public static <T> void displayArray(T[] array) {
            System.out.println(array.getClass().getName() + " Array was passed to sort.");
            System.out.println("Array Contents: ");
            for(T item : array) {
            System.out.println(item.toString());
            }
        }
    }