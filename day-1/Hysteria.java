import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hysteria {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = readFile();
        ArrayList<Integer> list1 = input.get(0);
        ArrayList<Integer> list2 = input.get(1);
        
        System.out.println(totalDistance(list1, list2));
   }


   /**
    * Calculates the distance between two given lists.  
    * @param list1
    * @param list2
    * @return distance between list1 and list2 
    */ 
    public static int totalDistance (ArrayList<Integer> list1, ArrayList<Integer> list2) {
        // distance sum
        int sum = 0; 
        
        // loop until lists are empty
        while (!list1.isEmpty()) {
           
            // get the smallest id from both lists
            int min1 = min(list1);
            int min2 = min(list2);

            // remove the id's from both lists
            list1.remove(Integer.valueOf(min1));
            list2.remove(Integer.valueOf(min2));

            // calculate the distance
            int distance = Math.abs(min1 - min2);
            sum += distance; 
        }
        return sum;
    }
   
    /**
     * finds the smallest element in a given list  
     * @param list
     * @return smallest element
     */
    public static int min (ArrayList<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (min > list.get(i)) {
                min = list.get(i);
            }
        }
        return min;
   }


   /**
    * reads the input file
    * @return an ArrayList containing the data from the file
    */
   public static ArrayList<ArrayList<Integer>> readFile() {
       ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
       ArrayList<Integer> list1= new ArrayList<Integer>();
       ArrayList<Integer> list2= new ArrayList<Integer>();
       try {
            File file = new File("day-1/input.txt");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String inputLine= scanner.nextLine();
                String[] ids = inputLine.split("   ");
                int id1 = Integer.parseInt(ids[0]);
                int id2 = Integer.parseInt(ids[1]);
                list1.add(id1);
                list2.add(id2);

            }

            scanner.close();
            input.add(list1);
            input.add(list2);

       } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());       
       }
       return input;
   }
}