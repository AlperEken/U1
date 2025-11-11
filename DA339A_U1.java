/*
  Author: Alper Eken
  Id: aq0647
  Study program: Systemutvecklare
*/
import java.util.Scanner;

public class DA339A_U1 {
  static Scanner input = new Scanner(System.in); //can be removed if another solution is used that do not require this scanner-object                                                
  
  // an array to use for testing, replace as needed to test your code
  static String[][] guestList = {{"Adam Ason", "35"},
                                 {"Berta Bson", "70"},
                                 {"Ceasar Cson", "12"},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                               };


 /* Parameters for methods below may NOT be changed and HAVE TO BE USED as intended for a passing grade.*/

  /**
   * This method makes sure to print the information about the guests 
   * (name and age) from the guest list in the terminal for the user. 
   * The print out shall show name, age and a number representing the guest's place in the guest list. 
   * Empty places in the guest list will NOT be shown.
   */

  public static void printGuestInformation() {
    for(int i = 0; i < guestList.length; i++){
      if (!guestList [i] [0].isEmpty()) {
        System.out.print("Place nr: " + (i+1));
        for (int j = 0; j < guestList[i].length; j++){
          System.out.print("  " + guestList [i] [j] + " ");
          }
        System.out.println();
      }
     }
  }

  /**
   * This method makes sure to print the whole guest list in the terminal for the user. 
   * If a place in the guest list contains data for a guest the guest's name and age is shown. 
   * If a place in the guest list is empty a text stating that the place in empty is shown. 
   * In both cases a number representing the place in the guest list is shown.
   */
  public static void printGuestList() {
    
    System.out.println();
    for(int i = 0; i < guestList.length; i++){
      if (!guestList [i] [0].isEmpty()) {
        System.out.print("Place nr: " + (i+1));
        for (int j = 0; j < guestList[i].length; j++){
          System.out.print("  " + guestList [i] [j] + " ");
          }
        } else {
          System.out.print("Place nr: " + (i+1) + " is empty" );
      }     System.out.println();
     }
     System.out.println();
  }

  /**
   * This method makes sure to print statistics about the guest list to the user. 
   * The following statistics shall be shown:
   * -	Total number guests
   * -	Total number of adult guests
   * -	Total number of child guests
   * -	Who the oldest guest is and thier age
   * -	Who the youngest guest is and their age
   */
  public static void printStatistics() {
    int totalGuest = 0;
    int totalAdults = 0;
    int totalChildren = 0;
    String oldestGuestName = "";
    String youngestGuestName = "";
    String oldestGuestAge = "";
    String youngestGuestAge = "";
    int oldestAge = Integer.MIN_VALUE; 
    int youngestAge = Integer.MAX_VALUE;

    System.out.println();
    for (int i = 0; i < guestList.length; i++){
      if (!guestList [i] [0].isEmpty()){
        totalGuest++;
        int age = Integer.parseInt(guestList[i] [1]);
        
        if  (age < 13){
          totalChildren++;
        }else{
          totalAdults++;
        }
        if (age > oldestAge){
          oldestAge = age;
          oldestGuestName = guestList[i] [0];
          oldestGuestAge = guestList [i] [1];
        }
        if (age < youngestAge){
          youngestAge = age;
          youngestGuestName = guestList[i] [0];
          youngestGuestAge = guestList [i] [0];
        }
      }
    }
    System.out.println("There are a total of " + totalGuest + " guests booked for today.");    
    System.out.println("There are a total of " + totalChildren + " children booked for today.");
    System.out.println("The oldest guest is " + oldestGuestName + " and is " + oldestAge + " years old.");
    System.out.println("The youngest guest is " + youngestGuestName + " and is " + youngestAge + " years old");
    System.out.println();
  }

  /**
   * This method adds a guest to the guest list. 
   * The information that is added to the guest list is defined in the method parameters. 
   * If a user tries to add a guest to a full guest list an error messages informing the user 
   * about this will be shown and no guest added to the list.
   * @param name The name of the guest to add
   * @param age The age of the guest to add as a String 
   */
  public static void addGuest(String name, String age) {
    boolean guestAdded = false;

    for (int i = 0; i < guestList.length; i++){
      if (guestList[i][0].isEmpty()) {
        guestList [i] [0] = name;
        guestList [i] [1] = age;
        guestAdded = true;
        break;
        }
      }
      if (guestAdded){
      System.out.println("Welcome " + name + " you are " + age + " years old!");
      } else {
        System.out.println("Sorry, we are fully booked for today, you are welcome another day.");
      }
      System.out.println();      
    }

  /**
   * This method changes the name of a specific guest in the guest list. 
   * Which guest's name is changed is decided by a method parameter. 
   * If a user tries to change the name at a place in the list that has 
   * no current guest an error message informing the user about this 
   * will be shown and no data in the guest list is changed.
   * @param index The index of the guest whose name shall be changed.
   * @param newName The new name of the guest at place given by index.
   */
  public static void changeNamneOfGuest(int index, String newName) {
    System.out.println();
    guestList[index] [0] = newName;
    System.out.println("Guest booked for place " + (index + 1) + " has been renamed to " + newName);
    System.out.println();
  }

  /**
   * This method changes the age of a specific guest in the guest list. 
   * Which guest's age is changed is decided by a method parameter. 
   * If a user tries to change the age at a place in the list that has 
   * no current guest an error message informing the user about this 
   * will be shown and no data in the guest list is changed.
   * @param index The index of the guest whose age shall be changed.
   * @param newAge The new age, as a String, of the guest at place given by index. 
   */
  public static void changeAgeOfGuest(int index, String newAge) {
    System.out.println();
    guestList[index] [1] = newAge;
    System.out.println("The age of the guest in place " + (index + 1) + " has been updated to " + newAge);
    System.out.println();

  }

  /**
   * This method removes a guest at a given index from the guest list. 
   * The data at this index is replaced by empty Strings. 
   * If no guest exists at the given index an error message informing 
   * the user about this will be shown and no data in the guest list is changed.
   * @param index The index of the place where a guest is to be removed. 
   */
  public static void removeGuest(int index) {
    index--;
    if (guestList[index] [0].isEmpty()) {
      System.out.println("Sorry, there is no guest at that place.");
    } else {
      guestList [index] [0] = "";
      guestList [index] [1] = "";
      index++;
      System.out.println("The guest at place " + index + " has now been removed");
    }
  }

  /**
   * This method changes places in the guest list for the data existing 
   * at those places given by the parameters. It is possible to change 
   * places between data even if one or both places contains empty strings. 
   * This gives the user the possibility to change the place of one guest 
   * to an empty place in the guest list.  
   * If the two parameters have the same value an error message informing 
   * the user about this will be shown and no data in the guest list is changed.
   * @param index1 First index involved in the change of places
   * @param index2 Second index involved in the change of places 
   */
  public static void changePlaces(int index1, int index2) {
    System.out.println();


    String [] temporary = guestList [index1 - 1];
    guestList[index1 - 1] = guestList[index2 - 1];
    guestList[index2 - 1] = temporary;

    System.out.println("You switched places between " + (index1) + " and " + (index2));
    System.out.println();
  }

  /**
   * This method prints the program menu in the terminal for the user to view.
   */
  public static void printMenu() {
    System.out.println("Program menu");
    System.out.println("1: Print out the guest list ");
    System.out.println("2: Print out the statistics ");
    System.out.println("3: Add another guest to the guest list");
    System.out.println("4: Remove a guest from the guest list");
    System.out.println("5: Change the name of a guest");
    System.out.println("6: Change the age of a guest");
    System.out.println("7: Change the place of a guest");
    System.out.println("8: Quit the program");
  }

  /**
   * This method reads the menu choice from the user and returns the choice the user made as an integer.
   * @return The menu choice made by the user represented by an integer value of type int.
   */
  public static int readMenuChoice() {
    int choice = -1;
    System.out.println("Make a decision between 1-8.");
    while(true){
      if (input.hasNextInt()){
        choice = input.nextInt();
        input.nextLine();
        if (choice >= 1 && choice <= 8){
          break;
        } else{
          System.out.println();
          System.out.println("You have to choose a NUMBER between 1-8!");
          System.out.println();
          break;
        }
      } else {
        System.out.println();
        System.out.println("You have to choose a Number between 1-8!");
        input.next();
        System.out.println();
      }
    }
      return choice;
}


  public static void main(String[] args) {
    boolean fortsätt = true;

    while (fortsätt) {
      printMenu();
      int choice = readMenuChoice();

      switch (choice) {
        case 1:
        printGuestInformation();
          break;
        case 2:
        printStatistics();
          break;
        case 3:
        System.out.println("Hello! What is your name?");
        String name = input.nextLine();
        if (name.trim().isEmpty()){
          System.out.println("You need to enter a name.");
          break;
        }

        System.out.println("... And what is your age?");
        if (input.hasNextInt()) {
          int age = input.nextInt();
          input.nextLine();

          if (age<0) {
            System.out.println("Age cannot be negative, please try again.");
            break;
          } else {
          addGuest(name, Integer.toString(age));
          } 
        } else {
          System.out.println("Your age can not be negative, please try again.");
          input.nextLine();
        }
          break;
        case 4:
        System.out.println("Which place do you want to remove?");
        if (input.hasNextInt()) {
          int index = input.nextInt();
          if (index >= 1 && index <= guestList.length) {
            removeGuest(index);
          } else {
          System.out.println("You need to enter a NUMBER between 1-10.");
          }
        }else{
          System.out.println("You need to enter a NUMBER between 1-10.");
          input.next();
        }
          break;
        case 5:
        System.out.println("Which place are you booked for?");
        if (input.hasNextInt()) {
          int index = input.nextInt() - 1;
          input.nextLine();

          System.out.println("Enter the name you want to change to: ");
          String newName = input.nextLine().trim();

          if(newName.isEmpty()){
            System.out.println("You need to enter a name.");
            break;
          }
          if (index < 0 || index >= guestList.length) {
            System.out.println("Sorry, that place does not exist!");
            break;
          }
          if (guestList[index] [0].isEmpty()) {
            System.out.println("Sorry, no guest has booked place " + (index + 1) + " and no changes has been made.");
            break;  
          } else {
            guestList[index] [0] = newName;
            System.out.println("Guest booked for place " + (index + 1) + " has been renamed to " + newName);
          }
          System.out.println();
          changeNamneOfGuest(index, newName);
          } else {
          System.out.println("You need to enter a NUMBER for the place.");
          input.nextLine();
        }
          break;
        case 6:
        System.out.println("Which place are you booked for?");
        if (input.hasNextInt()) {
          int index = input.nextInt() - 1;
          input.nextLine();
          System.out.println("Which age do you want to update to?");

          if (input.hasNextInt()) {
            int newAge = input.nextInt();
            input.nextLine();
            
            if (index < 0 || index >= guestList.length){
              System.out.println("Sorry, that place does not exist.");
              break;
            }
            if (guestList[index] [1].isEmpty()) {
              System.out.println("Sorry, no guest has booked place " + (index + 1) + " and no changes has been made.");
              break;
            }
            if (newAge<0) {
              System.out.println("You can't have a negative age!");
              break;
            }
            changeAgeOfGuest(index, String.valueOf(newAge));
          } else {
            System.out.println("You entered an invalid age, please try again.");
            input.nextLine();
          }
        } else {
          System.out.println("You entered an invalid place, please try again.");
          input.nextLine();
        }
          break;
        case 7:
        System.out.print("Here is the full guest list:");
        printGuestList();
        System.out.println("Which places do you want to switch?");
        System.out.println("Enter the first place: ");
        if (input.hasNextInt()) {
          int index1 = -1;
          index1 = input.nextInt();
          input.nextLine();

          System.out.println("Enter the second place: ");
          if (input.hasNextInt()) {
            int index2 = -1;
            index2 = input.nextInt();
            input.nextLine();
            
            if (index1 == index2) {
              System.out.println("You can't change to the same place!");
              break;
            }
            if (index1 < 0 || index2 < 0 || index1 > guestList.length || index2 > guestList.length) {
              System.out.println("That place does not exist!");
              break;
            }
            if (guestList[index1 - 1][0].isEmpty() && guestList[index2 - 1][0].isEmpty()) {
              System.out.println("Both places are empty, no swap will be made.");
              break;
            }
            changePlaces(index1, index2);
          } else {
            System.out.println("You entered an invalid place, please try again.");
            input.nextLine();
          }
        } else {
          System.out.println("You entered an invalid place, please try again.");
          input.nextLine();
        }
          break;
        case 8:
        System.out.println("You exited the program");
        fortsätt = false;
          break;
        default:
      }
    }
  }
}