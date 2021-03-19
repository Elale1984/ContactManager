package DataRecall;


import DataInput.AddressBook;

public class BusinessServices extends AddressBook {
    public AddressBook list;


    public BusinessServices(AddressBook contacts){

        this.setList(contacts);


    }

    public BusinessServices(){
        super();
        this.setList(new AddressBook());

    }


    public AddressBook getList(){
        return list;

    }


    public void setList(AddressBook contacts) {
        this.list = contacts;

    }


}
