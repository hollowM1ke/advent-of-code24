import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;

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
        // sort the lists
        Collections.sort(list1);
        Collections.sort(list2);

        int size = Math.min(list1.size(), list2.size());
        int sum = 0;    
        // loop through both lists and calculate the distance
        for (int i = 0; i < size; i++){
            sum += Math.abs(list1.get(i) - list2.get(i));
        }
        return sum;
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
            File file = new File("./input.txt");
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