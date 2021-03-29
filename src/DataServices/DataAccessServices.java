package DataServices;

import DataInput.AddressBook;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;



import java.io.*;


public class DataAccessServices {
/*
*This method takes in an AddressBook list called the list and uses the ObjectMapper to map the properties from the list.
* Then using the ObjectMapper calling we utilize prettyprinter to make the Json look presentable and write the information
* using writeValue passing parameters for new file can calling it ContactList.json as well as theList which was passed in.
 */

    public void writeJsonContacts(AddressBook theList) throws IOException {

        ObjectMapper writeOM = new ObjectMapper();
        writeOM.writerWithDefaultPrettyPrinter().writeValue(new File("ContactList.json"), theList);
    }

    /*
    *This method is for reading the Json file and sending it to an array list so that we can load the contact list into
    * the applications. The functionality is not yet working.
     */

    /*


    public ArrayList<AddressBook> readJsonContacts(){
        ArrayList<AddressBook> addC = new ArrayList<AddressBook>();
        InputStream jsonIn = null;
        try {
            jsonIn = new FileInputStream(new File("ContactList.json"));

            ObjectMapper readOM = new ObjectMapper();
            TypeReference<ArrayList<AddressBook>> tr = new TypeReference<ArrayList<AddressBook>>(){};
            ArrayList<AddressBook> inPar = readOM.readValue(jsonIn, tr);
            addC = inPar;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return addC;
    }
*/
}