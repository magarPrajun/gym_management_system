// Scanner import for accepting user's input
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.regex.*;

// Gym class to provide text based interface for gym management system
public class Gym {

     // member record to store all the members' data
    final static List<Member> memberRecord = new LinkedList<>();


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
                            // checking and clearing the buffer before accepting string input
                            if(keyboardInput.hasNextLine()){
                                keyboardInput.nextLine();
                            }
                            
                            // storing returned member object from member registration method
                            Member member = memberRegistration();

                            // registering member in the gym management system through manager
                            manager.registerMembership(member);

                            // adding member to the global member record list
                            memberRecord.add(member);
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
                            //manager.terminateMembership();
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
                if (keyboardInput.hasNextLine()){
                    keyboardInput.nextLine();
                }
           
        }
    }
        
    }

    // method to register new member in the gym
    public static Member memberRegistration() {
        String memberName;
        String memberContact;
        String memberEmail;
        // member's name entry
        while(true){
            System.out.println("Enter member's Name: ");

            memberName = keyboardInput.nextLine();

            // checking for empty name
            if(!memberName.isEmpty()){
                break;
            }
            System.out.println("Member's name cannot be empty. Please enter a valid name.");
           
        }

        // member's contact entry
        while(true){
            System.out.println("Enter member's contact:");
    
            memberContact = keyboardInput.nextLine();
            
            String contactRegex = "^(\\+[0-9]{3}-)?[0-9]{10}$";
            
            // checking for empty contact
            if(memberContact.isEmpty()){
                System.out.println("Member's contact cannot be empty. Please enter a valid contact.");
                continue;
            }

            // validating contact format if not empty
            if(Pattern.matches(contactRegex, memberContact)){
                break;
            }
            System.out.println("Invalid contact number!");    
        }

        while(true){
            System.out.println("Enter member's email:");
    
            memberEmail = keyboardInput.nextLine();
            
            String emailRegex = "^[a-zA-Z0-9.]+@[a-zA-Z]+(\\.[a-zA-Z]{2,3})+$";

            // checking for empty email
            if(memberEmail.isEmpty()){
                System.out.println("Member's email cannot be empty. Please enter a valid email.");
                continue;
            }
            
            // validating email format
            if(Pattern.matches(emailRegex, memberEmail)){
                break;
            }
            System.out.println("Invalid email format!");
            
        }
    
            System.out.println("Is the member a Premium member? (Y/N):");

            String memberType = keyboardInput.nextLine().toUpperCase();

            // Premium member registration if user input is 'Y' or 'YES
            if("Y".equals(memberType) || "YES".equals(memberType) ){
                Member newMember = new PremiumMember(memberName, memberContact, memberEmail);
                return newMember;
            }

            // Regualr member registration as default option
            Member newMember = new RegularMember(memberName, memberContact, memberEmail);
            return newMember;
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
        interfaceOption(manager);
    }
}
