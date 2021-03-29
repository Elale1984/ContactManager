package DataInput;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class PersonalContact extends contactBase{
    private String DOB;
    private String description;

    //getters and setters
   @JsonIgnore
    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    //constructor

    public PersonalContact(String name, String phoneNum, String streetName, String city,
                           String state, String zip, String country, String picName, String email,
                           String DOB, String description, char type) {
        super(name, phoneNum, streetName, city, state, zip, country, picName, email, type);
        this.DOB = DOB;
        this.description = description;

    }

    //no-args constructor
    public PersonalContact() {
        super("Jordan Baldwin",  "303-717-2244", "156 Dale st.",
                "Colorado Springs", "Colorado", "80915", "USA", "JBald.jpeg",
                "JBaldwin@kingdomfootsteps.com", 'P');
        this.DOB = "03/11/1987";
        this.description = "Met at a music festival. Best friends for life";

    }

    //overridden toString() method for personal contacts
    @Override
    public String toString(){
        System.out.println("Name: \t\t\t" + super.name + "\nAddress: \t\t" + super.streetName + " " + super.city +
                " " + super.zip + " " + super.country + "\n" + "Phone: \t\t\t" + super.phoneNum + "\n" +
                "Pic Name: \t\t" + super.picName + "\n" + "Email: \t\t\t" + super.email + "\n" +
                "DOB: \t\t\t" + DOB + "\n" + "Description: \t" + description);
        return "";
    }



}
