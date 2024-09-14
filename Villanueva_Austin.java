package assignment1;
// imports 
import java.util.Random;
import java.util.Scanner;

public class Villanueva_Austin { // file class
  public static void main(String[] args) { // main method
    print_title(); // print the end
    System.out.println("reciept number      " + reciept_number());
    System.out.println(date());

    Scanner scanner = new Scanner(System.in); // scanner
   
    int counter = 0; // item number counter  
    double total = 0.0; // total of all items
    boolean loop = true;

    while (loop == true) { // take user input
      System.out.print("Write item name "); 
      String name = scanner.nextLine(); // get the item name

      if (name.equals("DONE")) { // check if the user puts 'DONE'
        break;
      }
      else { // check to see if the first letter is lowercase
        char first_char = name.charAt(0);
        if (Character.isLowerCase(first_char)) { // if so then change it to upper and change it back
          first_char = Character.toUpperCase(first_char);
          name = first_char + name.substring(1);
        }
      }

      System.out.print("Write price "); // get the item price
      double price = scanner.nextDouble();
      scanner.nextLine();

      if (!name.equalsIgnoreCase("Food")) { // if it is not a food item add a 30% tax
        price += (price * 0.3);
      }

      price = Math.round(price); // round the price to the nearest int
      
      counter++; // increment the counter
      total += price; // add this item's price to the total

      System.out.println("item number " + counter + " " + name + " " + price);
    }

    scanner.close(); // close the scanner after use
    
    total = Math.round(total); // round the total price

    System.out.println(counter + " items      total " + total); // print the total

    print_end(); // print the end
  }
  public static void print_title() { // prints the title/head of the reciept
    for (int i = 0; i < 30; i++) {
      System.out.print("*");
    }

    System.out.println(" ");
    System.out.println("****** S store ***************");

    for (int i = 0; i < 30; i++) {
      System.out.print("*");
    }
    System.out.println(" ");
  }
  public static void print_end() { // prints the end/foot of the reciept
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 30; j++) {
        System.out.print("*");
      }     
      System.out.println(" ");
    }
  }
  public static int reciept_number() { // generates a random reciept number
    Random random = new Random(); // random number generator

    int min = 1000; // inclusive
    int max = 2000; // exclusive

    int reciept = random.nextInt(max - min) + min; // get the number

    return reciept; // return the number
  }
  public static String date() { // generates a random date
    Random random = new Random(); // random number generator

    String[] months = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; // months

    int min_year = 1900; // inclusive
    int max_year = 2100; // exclusive

    int min_day = 1; // inclusive
    int max_day = 28; // inclusive

    int min_month = 1; // inclusive
    int max_month = 12; // inclusive

    int year = random.nextInt(max_year - min_year) + min_year;
    int day = random.nextInt(max_day - min_day + 1) + min_day;
    int month = random.nextInt(max_month - min_month + 1) + min_month;

    String date = months[month - 1] + " " + day + " " + year; // concatenate the total date

    return date;
  }
}
