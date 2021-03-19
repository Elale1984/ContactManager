package DataInput;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List  <contactBase> contacts;
    private List <BusinessContact> allBusinesses;
    private List <PersonalContact> allPersonals;

    //creates the different address books, one for all contacts, one for business contacts, and one for personal contacts
    public AddressBook(){
        this.contacts = new ArrayList<contactBase>();
        this.allBusinesses = new ArrayList<BusinessContact>();
        this.allPersonals = new ArrayList<PersonalContact>();
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
    public <T extends contactBase> boolean deleteOne(T contact){
        if(this.contacts.contains(contact)){
            this.contacts.remove(contact);
            if(contact.getType() == 'B'){
                this.allBusinesses.remove((BusinessContact) contact);
            }
            else if(contact.getType() == 'P'){
                this.allPersonals.remove((PersonalContact) contact);
            }
            return true;
        }
        else{
            return false;
        }
    }

    // This overrided toString will print out to the console the individual contact as called.
    @Override
    public String toString() {
        System.out.println("\r");
        System.out.println("--------All Contacts--------\r");
        for (contactBase contact : contacts) {
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
            if (contact.getName().contains(searchFor)) {
                searchResult.add(contact);
               cnt++;
            }

        }
        System.out.println(cnt + " Contacts found!!");
        System.out.println(searchResult);


    }

    //the find ID method searches for a specific contact given by the id of that contact. Prints out the
    //contact with the toString()
    public void findID(int ID){
        for (int i = 0; i < contacts.size(); i++) {
            if (i == ID) {
                System.out.println(contacts.get(i).toString());

            }
        }
    }

    // the call method finds the contact name and phone number and prints a message that it is calling that contact
    // based on the input of the ID and type (B/P)
    public void call(int ID, char type){
        for (int i = 0; i < contacts.size(); i++) {
            if (i == ID && contacts.get(i).getType() == type) {
                System.out.println("Calling Business " + contacts.get(i).getName() + " at " + contacts.get(i).getPhoneNum());
            }
            else if(i == ID && contacts.get(i).getType() != type) {
                System.out.println("Calling Personal Contact " + contacts.get(i).getName() + " at " + contacts.get(i).getPhoneNum());
            }
        }
    }

    // the text method finds the contact name and phone number and prints a message that it is texting that contact
    // based on the input of the ID and type (B/P)
    public void text(int ID, char type){
        for (int i = 0; i < contacts.size(); i++) {
            if (i == ID && contacts.get(i).getType() == type) {

                System.out.println("Texting the Business " + contacts.get(i).getName() + " at " + contacts.get(i).getPhoneNum());
            }
            else if(i == ID && contacts.get(i).getType() != type) {
                System.out.println("Texting Personal Contact " + contacts.get(i).getName() + " at " + contacts.get(i).getPhoneNum());
            }

        }
    }

    // the sendEmail method finds the contact name and email address and prints a message that it is emailing that contact
    // based on the input of the ID and type (B/P)
    public void sendEmail(int ID, char type){
        for (int i = 0; i < contacts.size(); i++) {
            if (i == ID && contacts.get(i).getType() == type) {

                System.out.println("Sending Email to the business  " + contacts.get(i).getName() + " at " + contacts.get(i).getEmail());
            }
            else if(i == ID && contacts.get(i).getType() != type) {
                System.out.println("Sending Email to Personal Contact " + contacts.get(i).getName() + " at " + contacts.get(i).getEmail());
            }
        }
    }

    // the navTo finds the contact name and address and prints a message that it is opening google maps and getting
    // direction to that contacts address based on the input of the ID and type (B/P)
    public void navTo(int ID, char type){
        for (int i = 0; i < contacts.size(); i++) {
            if (i == ID && contacts.get(i).getType() == type) {

                System.out.println("Opening Google Maps and getting directions to the business " + contacts.get(i).getName() + " " +
                        contacts.get(i).getStreetName() + " " + contacts.get(i).getCity() + " " + contacts.get(i).getState() +
                        " " + contacts.get(i).getZip());
            }
            else if(i == ID && contacts.get(i).getType() != type) {
                System.out.println("Opening Google Maps and getting directions to Personal Contact " + contacts.get(i).getName() + " " +
                        contacts.get(i).getStreetName() + " " + contacts.get(i).getCity() + " " + contacts.get(i).getState() +
                        " " + contacts.get(i).getZip());
            }
        }
    }

    // the openURL method finds the business contacts name and url and prints a message that it is opening the
    // web page based on the input of the ID and type (B/P)
    public void openURL(int ID, char type){
        for (int i = 0; i < allBusinesses.size(); i++) {
            if (i == ID && allBusinesses.get(i).getType() == type) {

                System.out.println("Opening URL to the business website " + allBusinesses.get(i).getName() + " " +
                        allBusinesses.get(i).getUrl());
            }

        }
    }

    // openBusinessCon prints out the list of business contacts
    public void openBusinessCon(){
        System.out.println("\n-----All Business contacts-----\r");

        for(int i = 0; i < allBusinesses.size(); i++){
            System.out.println("Contact: " + (i+1));
            System.out.println(allBusinesses.get(i));
            System.out.println(" ");
        }
    }

    // openPersonalCon prints out the list of personal contacts
    public void openPersonalCon(){
        System.out.println("\n-----All Personal contacts-----\r");
        for(int i = 0; i < allPersonals.size(); i++){

            System.out.println("Contact: " + (i+1));
            System.out.println(allPersonals.get(i));
            System.out.println(" ");
        }

    }
}

