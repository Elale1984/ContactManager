package Testing;

import DataInput.BusinessContact;
import DataInput.PersonalContact;
import DataRecall.BusinessServices;
import DataServices.FileIOServices;

public class TestApplication {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting new test script\n");

        BusinessServices bs = new BusinessServices();
        PersonalContact pc1 = new PersonalContact();
        BusinessContact bc = new BusinessContact();

        //print out pc1 personal contact and then add it to the list
        System.out.println("-----Adding the following Personal contact-----");
        pc1.toString();
        bs.list.addOne(pc1);
        System.out.println("\n");

        //print out bc business contact and then add it to the list

        System.out.println("-----Adding the following Business contact-----");
        bc.toString();
        bs.list.addOne(bc);
        System.out.println("\n");

        //create a third contact that is a personal contact then print it and add it to the list
        PersonalContact pc2 = new PersonalContact("Alex Jones", "606-221-9988", "123 info way",
                "Austin", "Texas", "99999","USA", "IFOW.jpeg",
                "alex@infowars.com", "10/22/67", "A basket case", 'P');

        System.out.println("-----Adding the following Personal contact-----");
        pc2.toString();
        bs.list.addOne(pc2);
        System.out.println("\n");

        //print out the whole list of all contacts
        System.out.println(bs.list.toString());

        //print out the whole list of all business contacts
        bs.list.openBusinessCon();

        //print out the whole list of all business contacts
        bs.list.openPersonalCon();


        //create another instance of the default contact and add it to the list
        System.out.println("-----Adding the following Personal contact-----");

        PersonalContact b = new PersonalContact();
        b.toString();
        bs.list.addOne(b);
        System.out.println("\n");

        // print out the updated list
        System.out.println("Showing updated lists of all contacts");
        System.out.println(bs.list.toString());
        System.out.println("\nShowing updated lists of all Personal contacts");
        bs.list.openPersonalCon();
        System.out.println("\nShowing updated lists of all Business contacts");
        bs.list.openBusinessCon();
        System.out.println("\n");

        // Delete a specified contact and then print the updated list
        System.out.println("Deleting a contact");
        bs.list.deleteOne(b);
        System.out.println(bs.list.toString());
        System.out.println("\n");

        // Searches the names of the contacts for the given String. if found, prints the contacts
        System.out.println("Searching for all contacts that contain Jor");
        bs.list.searchByName("Jor");
        System.out.println("\n");

        // Searches the names of the contacts for the given String. if found, prints the contacts
        System.out.println("Searching for all contacts that contain K");
        bs.list.searchByName("K");
        System.out.println("\n");

        // Run all functions for Personal Contact
        System.out.println("Running functions for Personal Contacts");
        System.out.println("\n");

        bs.list.call(0, 'B');
        bs.list.text(0,'B');
        bs.list.sendEmail(0, 'B');
        bs.list.navTo(0, 'B');
        System.out.println("\n");

        //run all functions for business contact
        System.out.println("Running functions for Business Contacts");
        System.out.println("\n");

        bs.list.call(1, 'B');
        bs.list.text(1,'B');
        bs.list.sendEmail(1, 'B');
        bs.list.navTo(1, 'B');
        bs.list.openURL(0, 'B');
        System.out.println("\n");

        System.out.println("Now we are going to read contacts from a file and print them. you will see it below: ");
        FileIOServices readFile = new FileIOServices();
        readFile.importContactFromFile();
        }

}
