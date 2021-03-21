package DataInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AddressBook {
    private List  <contactBase> contacts;
    private List <BusinessContact> allBusinesses;
    private List <PersonalContact> allPersonals;



    //creates the different address books, one for all contacts, one for business contacts, and one for personal contacts
    public AddressBook(){
        this.contacts = new ArrayList<>();
        this.allBusinesses = new ArrayList<>();
        this.allPersonals = new ArrayList<>();
    }

    //generic to addOne contact to the different arraylists. This Generic adds to the all contacts lise, and then
    //appropriately ads the contacts to their respective list based on personal or business contact
    public <T extends contactBase> void addOne(T contact){

        this.contacts.add(contact);

        if(contact.getType() == 'B'){
            this.allBusinesses.add((BusinessContact) contact);
        }
        else if(contact.getType() == 'P'){
            this.allPersonals.add((PersonalContact) contact);
        }

    }


    //generic to deleteOne contact from different array lists. This Generic deletes a contact from all contacts list,
    // and then appropriately deletes the contacts from their respective list based on personal or business contact
    public <T extends contactBase> void deleteOne(T contact){

        if(this.contacts.contains(contact)){
            this.contacts.remove(contact);

            if(contact.getType() == 'B'){
                this.allBusinesses.remove(contact);
            }
            else if(contact.getType() == 'P'){
                this.allPersonals.remove(contact);
            }

        }

    }

    // This overrided toString will print out to the console the individual contact as called.
    @Override
    public String toString() {
        System.out.println("\r");
        System.out.println("--------All Contacts--------\r");
        int idCnt = 1;
        for (contactBase contact : contacts) {
            System.out.println("ID: " + idCnt);
            idCnt++;
            System.out.println(contact);
            System.out.println("\r");
        }
        return "";
    }

    // the search by name searches for the contact that contains the string that it is given to search for,
    // it prints out the contacts that it finds to the toString
    public void searchByName(String searchFor){
        int cnt = 0;
        ArrayList searchResult = new ArrayList();

        for (contactBase contact : contacts) {
            if (contact.getName().toLowerCase(Locale.ROOT).contains(searchFor.toLowerCase(Locale.ROOT))) {
                searchResult.add(contact);
               cnt++;
            }

        }
        System.out.println(cnt + " Contacts found!!");
        System.out.println(searchResult);


    }

    //the find ID method searches for a specific contact given by the id of that contact. Prints out the
    //contact with the toString()
    public contactBase findID(int ID){

        ID--;
        for (int i = 0; i < contacts.size(); i++) {
            if (i == ID) {
                System.out.println(contacts.get(i).toString());

            }
        }
        return contacts.get(ID);
    }

    // the call method finds the contact name and phone number and prints a message that it is calling that contact
    // based on the input of the ID and type (B/P)
    public void call(int ID){
        for (int i = 0; i < contacts.size(); i++) {
            if (i == ID && contacts.get(i).getType() == 'B') {
                System.out.println("\nCalling Business " + contacts.get(i).getName() + " at " + contacts.get(i).getPhoneNum()+ "\n");
            }
            else if(i == ID && contacts.get(i).getType() == 'P') {
                System.out.println("\nCalling Personal Contact " + contacts.get(i).getName() + " at " + contacts.get(i).getPhoneNum()+ "\n");
            }
        }
    }

    // the text method finds the contact name and phone number and prints a message that it is texting that contact
    // based on the input of the ID and type (B/P)
    public void text(int ID){
        for (int i = 0; i < contacts.size(); i++) {
            if (i == ID && contacts.get(i).getType() == 'B') {

                System.out.println("\nTexting the Business " + contacts.get(i).getName() + " at " + contacts.get(i).getPhoneNum()+ "\n");
            }
            else if(i == ID && contacts.get(i).getType() == 'P') {
                System.out.println("\nTexting Personal Contact " + contacts.get(i).getName() + " at " + contacts.get(i).getPhoneNum() + "\n");
            }
        }
    }

    // the sendEmail method finds the contact name and email address and prints a message that it is emailing that contact
    // based on the input of the ID and type (B/P)
    public void sendEmail(int ID){
        for (int i = 0; i < contacts.size(); i++) {
            if (i == ID && contacts.get(i).getType() == 'B') {

                System.out.println("\nSending Email to the business  " + contacts.get(i).getName() + " at " + contacts.get(i).getEmail() + "\n");
            }
            else if(i == ID && contacts.get(i).getType() == 'P') {
                System.out.println("\nSending Email to Personal Contact " + contacts.get(i).getName() + " at " + contacts.get(i).getEmail() + "\n");
            }
        }
    }

    // the navTo finds the contact name and address and prints a message that it is opening google maps and getting
    // direction to that contacts address based on the input of the ID and type (B/P)
    public void navTo(int ID){
        for (int i = 0; i < contacts.size(); i++) {
            if (i == ID && contacts.get(i).getType() == 'B') {

                System.out.println("\nOpening Google Maps and getting directions to the business " + contacts.get(i).getName() + " " +
                        contacts.get(i).getStreetName() + " " + contacts.get(i).getCity() + " " + contacts.get(i).getState() +
                        " " + contacts.get(i).getZip() + "\n");
            }
            else if(i == ID && contacts.get(i).getType() == 'P') {
                System.out.println("\nOpening Google Maps and getting directions to Personal Contact " + contacts.get(i).getName() + " " +
                        contacts.get(i).getStreetName() + " " + contacts.get(i).getCity() + " " + contacts.get(i).getState() +
                        " " + contacts.get(i).getZip() + "\n");
            }
        }
    }

    // the openURL method finds the business contacts name and url and prints a message that it is opening the
    // web page based on the input of the ID and type (B/P)
    public void openURL(int ID){

        for (int i = 0; i < allBusinesses.size(); i++) {

            if (i == ID && allBusinesses.get(i).getType() == 'B') {

                System.out.println("\nOpening URL to the business website " + allBusinesses.get(i).getName() + " " +
                        allBusinesses.get(i).getUrl() + "\n1" +
                        "");
            }
            else
                System.out.println("\nThis is not a valid contact. Returning to main menu!!!\n");

        }
    }

    // openBusinessCon prints out the list of business contacts
    public void openBusinessCon(){
        System.out.println("\n-----All Business contacts-----\r");

        for(int i = 0; i < allBusinesses.size(); i++){
            System.out.println("ID: " + (i+1));
            System.out.println(allBusinesses.get(i));
            System.out.println(" ");
        }
    }

    // openPersonalCon prints out the list of personal contacts
    public void openPersonalCon(){
        System.out.println("\n-----All Personal contacts-----\r");
        for(int i = 0; i < allPersonals.size(); i++){

            System.out.println("ID: " + (i+1));
            System.out.println(allPersonals.get(i));
            System.out.println(" ");
        }

    }
}

