package Testing;

import DataInput.BusinessContact;
import DataInput.PersonalContact;
import DataInput.contactBase;
import DataRecall.BusinessServices;
import DataServices.DataAccessServices;
import DataServices.FileIOServices;


import java.util.Scanner;

public class TestApplication {
    public static void main(String[] args) throws Exception {


        Scanner input = new Scanner(System.in).useDelimiter("\\n");

        BusinessServices bs = new BusinessServices();
        PersonalContact pc1 = new PersonalContact();
        BusinessContact bc = new BusinessContact();
        bs.list.addOne(pc1);
        bs.list.addOne(bc);
        System.out.println("\nStarting new test script\n");

        int menuOption;
        do {

            System.out.println("Welcome to the Contact Manager. Choose an options below");
            System.out.println("1: Show all Contacts");
            System.out.println("2: Show all Personal Contacts");
            System.out.println("3: Show all Business Contacts");
            System.out.println("4: Search for a Contact by name");
            System.out.println("5: Search for a contact by ID");
            System.out.println("6: Create new Contact");
            System.out.println("7: Delete Contact");
            System.out.println("8: Call a Contact");
            System.out.println("9: Text a Contact");
            System.out.println("10: Email a contact");
            System.out.println("11: Open Webpage of a Contact");
            System.out.println("12: Get Directions to a contact's address");
            System.out.println("13: Load all contact data from file");
            System.out.println("14: Save all contact data to file");
            System.out.println("99: Exit");
            menuOption = input.nextInt();

            switch (menuOption){
                case 1:
                    //print out the whole list of all contacts
                    bs.list.toString();
                    break;
                case 2:
                    //print out the whole list of all personal contacts
                    bs.list.openPersonalCon();
                    break;
                case 3:
                    //print out the whole list of all business contacts
                    bs.list.openBusinessCon();
                    break;
                case  4:
                    //Search by name
                    bs.list.toString();

                    System.out.print("\nEnter the name or part of the name of the contact that you want to search for: ");
                    String searchName = input.next();
                        bs.list.searchByName(searchName);
                    break;
                case  5:
                    //Search by ID
                    bs.list.toString();
                    System.out.print("\nEnter the ID of the contact that you want to search for: ");
                    int searchID = input.nextInt();
                    bs.list.findID(searchID);

                    break;
                case 6:
                    //create new contact
                    System.out.println("\nChoose from the following options");
                    System.out.println("1: Add Personal Contact");
                    System.out.println("2: Add Business Contact");
                    int option = input.nextInt();
                    if (option == 1)  {
                        bs.list.createPersonal(bs, input);

                    }
                    else{
                        bs.list.createBusiness(bs, input);
                    }
                    break;
                case 7:
                    //Delete contact
                    int delCon;
                    bs.list.toString();
                    System.out.print("Enter the ID of the contact that you want to delete: ");
                    delCon = input.nextInt();
                    contactBase a = bs.list.findID(delCon);
                    System.out.println("\nAre you sure that this is the contact that you want to delete?(y/n): ");
                    String ans = input.next();
                    if(ans.contains("y")){

                        bs.list.deleteOne(a);
                        System.out.println("Contact was deleted!\n\n");
                        bs.list.toString();
                        bs.list.openBusinessCon();
                        bs.list.openPersonalCon();
                    }else
                        System.out.println("Your contact was not deleted");

                    break;
                case 8:
                    //call contact
                    bs.list.toString();
                    System.out.print("\nEnter the ID of the contact you would like to call: \n");
                    searchID = input.nextInt();
                    searchID--;
                    bs.list.call(searchID);
                    break;
                case 9:
                    //text contact
                    bs.list.toString();
                    System.out.print("\nEnter the ID of the contact you would like to text: \n");
                    searchID = input.nextInt();
                    searchID--;
                    bs.list.text(searchID);
                    break;
                case 10:
                    //email contact
                    bs.list.toString();
                    System.out.print("\nEnter the ID of the contact you would like to Email: \n");
                    searchID = input.nextInt();
                    searchID--;
                    bs.list.sendEmail(searchID);
                    break;
                case 11:
                    //Displays list of business contacts, uses id from that list to open URL
                    bs.list.openBusinessCon();
                    System.out.print("\nEnter the ID of the business contact whose web page you would like to visit: \n");
                    searchID = input.nextInt();
                    searchID--;
                    bs.list.openURL(searchID);
                    break;
                case 12:
                    //get directions
                    bs.list.toString();
                    System.out.print("\nEnter the ID of the contact whose address you would like directions to: \n");
                    searchID = input.nextInt();
                    searchID--;
                    bs.list.navTo(searchID);
                    break;
                case 13:
                    //read from file
                    System.out.println("Now we are going to read contacts from a file and print them. you will see it below: ");
                    FileIOServices readFile = new FileIOServices();
                    break;
                case 14:
                    //write to Json file
                    System.out.println("Saving contacts to file");
                    DataAccessServices d = new DataAccessServices();
                    d.writeJsonContacts(bs.list);
                    break;
                case 99:
                    //exit program
                    break;
                default:
                    break;

            }


        }while (menuOption != 99);
        BusinessServices contList = new BusinessServices();
        DataAccessServices DAS = new DataAccessServices();
        DAS.writeJsonContacts(bs.list);
        System.out.println("Thanks for using Contact Manager... Goodbye");


    }





}
