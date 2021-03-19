package DataServices;

import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files

public class FileIOServices extends DataAccessServices {
    //file instance
    File contactFile = new File("C:\\ContactManager\\contacts.txt");



    public void importContactFromFile() throws Exception{

        //creating scanner for reading file
        Scanner input = new Scanner(contactFile);

        //read from file and prints to the console
        while (input.hasNext()){
            System.out.println("importing contacts to address book from file\n");
            String name1 = input.next();
            String name2 = input.next();
            String name3 = input.next();

            System.out.println("The contacts' names that were imported are: \n" +
                    name1 + "\n " + name2 + "\n " + name3);
        }
    }
}