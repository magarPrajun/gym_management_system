// Scanner import for accepting user's input
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

// Gym class to provide text based interface for gym management system
public class Gym {

     // member record to store all the members' data
    final static List<Member> memberRecord = new LinkedList<Member>();


    // Scanner object creation for accepting user's input
    final static Scanner keyboardInput = new Scanner(System.in);

   
    // method to display text based interface 
    public static void textBasedInterface() {
        System.out.println("1. Import existing members' data");
        System.out.println("2. Membership registration");
        System.out.println("3. Search member's detail");
        System.out.println("4. Update member's data");
        System.out.println("5. Terminate membership");
        System.out.println("6. Export current members' data");
        System.out.println("7. Exit interface system");
        System.out.println("===================================================");
        System.out.println("Please choose an option to execute:");
    }

    // method to provide options and accept user's choice
    public static void interfaceOption(Manager manager){
        
        while(true){
            // show options before accepting user's choice
            Gym.textBasedInterface(); 
            try{
                // user's choice according to the options
                int choice = keyboardInput.nextInt();
                    switch (choice) {
                        case 1:
                            //TODO:Implementation of logic to load data.
                            break;
                        case 2:
                            // option to register new member
                            manager.registerMembership();
                            break;
                        case 3:
                            // option to search for member's information
                            manager.viewMemberDetail(choice);
                            break;
                        case 4:
                            //TODO: Member's information update
                            break;
                        case 5:
                            // Membership termination option
                            manager.terminateMembership();
                            break;
                        case 6:
                            break;
                        case 7:
                            // program terminate option
                            System.exit(0);
                            break;
                        default:
                            System.out.println("\nInvalid choice!\n");
                    }
            }catch(Exception e){
                System.out.println("\nInvalid input! Please enter corresponding numbers to execute.\n");
                
                // nextLine to consume and clear the invalid input for making it ready to accept another user's input.
                keyboardInput.nextLine();
             }

        }
    }

    public static void memberRegistration() {
        System.out.println("");
        
    }

    // starting point of a system
    public static void main(String[] args) {
        
        /*
         *  Manager object creation to manage the gym members' data
         *  Relation between Gym and Manager is composition
         */
        Manager manager = new Manager(); 

        System.out.println("\n=============| Welcome to Gym Management System |=============\n");
        
        // calling interface option method to provide options to user
        Gym.interfaceOption(manager);
    }
}
