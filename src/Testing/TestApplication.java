package Testing;

import DataInput.BusinessContact;
import DataInput.PersonalContact;
import DataInput.contactBase;
import DataRecall.BusinessServices;
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
                        createPersonal(bs, input);

                    }
                    else{
                        createBusiness(bs, input);
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
                    readFile.importContactFromFile();
                    break;
                case 14:
                    //write to file
                    System.out.println("Saving contacts to file");
                    break;
                case 99:
                    //exit program
                    break;
                default:
                    break;

            }


        }while (menuOption != 99);

        System.out.println("Thanks for using Contact Manager... Goodbye");


    }
    //create new personal contact input promps
    public static void createPersonal(BusinessServices bs, Scanner input){

        PersonalContact p = new PersonalContact();
        System.out.print("Name: ");
        p.setName(input.next());
        System.out.print("\nPhone Number: ");
        p.setPhoneNum(input.next());
        System.out.print("\nStreet Name: ");
        p.setStreetName(input.next());
        System.out.print("\nCity: ");
        p.setCity(input.next());
        System.out.print("\nState: ");
        p.setState(input.next());
        System.out.print("\nZip Code: ");
        p.setZip(input.next());
        System.out.print("\nCountry: ");
        p.setCountry(input.next());
        System.out.print("\nPic Name: ");
        p.setPicName(input.next());
        System.out.print("\nEmail: ");
        p.setEmail(input.next());
        System.out.print("\nDOB: ");
        p.setDOB(input.next());
        System.out.print("\nAdd a Description: ");
        p.setDescription(input.next());
        p.setType('P');


        bs.list.addOne(p);
        System.out.println("\n");

    }
    //create new business contact input prompts
    public static void createBusiness(BusinessServices bs, Scanner input){

        boolean s,m,t,w,th,f,sa;
        String openDayAns;
        BusinessContact b = new BusinessContact();
        System.out.print("Business Name: ");
        b.setName(input.next());
        System.out.print("\nPhone Number: ");
        b.setPhoneNum(input.next());
        System.out.print("\nStreet Name: ");
        b.setStreetName(input.next());
        System.out.print("\nCity: ");
        b.setCity(input.next());
        System.out.print("\nState: ");
        b.setState(input.next());
        System.out.print("\nZip Code: ");
        b.setZip(input.next());
        System.out.print("\nCountry: ");
        b.setCountry(input.next());
        System.out.print("\nPic Name: ");
        b.setPicName(input.next());
        System.out.print("\nEmail: ");
        b.setEmail(input.next());
        System.out.print("\nDOB: ");

        // find out open and close times for each day
        System.out.println("Is the business open Sunday(y/n): ");
        openDayAns = input.next();
        if (openDayAns == "y" || openDayAns == "Y"){
            s = true;
            System.out.print("Open Time(hh:mm am/pm): ");
            b.setOpenHour(input.next());

        }
        System.out.println("Is the business open Monday(y/n): ");
        openDayAns = input.next();
        if (openDayAns == "y" || openDayAns == "Y"){
            m = true;
        }
        System.out.println("Is the business open Tuesday(y/n): ");
        openDayAns = input.next();
        if (openDayAns == "y" || openDayAns == "Y"){
            t = true;
        }
        System.out.println("Is the business open Wednesday(y/n): ");
        openDayAns = input.next();
        if (openDayAns == "y" || openDayAns == "Y"){
            w = true;
        }
        System.out.println("Is the business open Thursday(y/n): ");
        openDayAns = input.next();
        if (openDayAns == "y" || openDayAns == "Y"){
            th = true;
        }
        System.out.println("Is the business open Friday(y/n): ");
        openDayAns = input.next();
        if (openDayAns == "y" || openDayAns == "Y"){
            f = true;
        }
        System.out.println("Is the business open Saturday(y/n): ");
        openDayAns = input.next();
        if (openDayAns == "y" || openDayAns == "Y"){
            sa = true;
        }

        System.out.print("\nOpen Time(hh:mm am/pm): ");
        b.setOpenHour(input.next());
        System.out.print("\nClose Time(hh:mm am/pm): ");
        b.setCloseHour(input.next());
        System.out.print("\nURL: ");
        b.setUrl(input.next());
        System.out.print("\nRating(1-5): ");
        b.setRating(input.nextInt());
        b.setType('B');
        bs.list.addOne(b);
    }



}
