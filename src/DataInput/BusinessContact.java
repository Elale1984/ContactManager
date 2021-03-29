package DataInput;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BusinessContact extends contactBase{

    private String[] openHour, closeHour;
    private Boolean[] openDays;
    private String url;
    private int rating;

    //getters and setters
    public String[] getCloseHour(){
        return closeHour;
    }

    public void setCloseHour(String[] closeHour) {
        this.closeHour = closeHour;
    }

    public String[] getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String[] openHour) {
        this.openHour = openHour;
    }

    public Boolean[] getOpenDays() {
        return openDays;
    }

    public void setOpenDays(Boolean[] openDays) {
        this.openDays = openDays;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    //constructor

    public BusinessContact(String name, String phoneNum, String streetName, String city, String state,
                           String zip, String country, String picName, String email, String[] openHour,
                           String[] closeHour, Boolean[] openDays, String url, int rating, char type) {

        super(name, phoneNum, streetName, city, state, zip, country, picName, email, type);
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.openDays = openDays;
        this.url = url;
        this.rating = rating;

    }

    //no-args constructor
    public BusinessContact() {
        super("Kingdom Footsteps", "719-557-9977", "765 Peterson rd.",
                "Colorado Springs", "Colorado", "80915","USA", "kfmPic.jpeg",
                "kfm@kingdomfootsteps.com", 'B');

        this.openHour = new String[] {"6:00 am", "6:00 am","6:00 am","6:00 am","6:00 am","8:00 am","6:00 am"};
        this.closeHour = new String[] {"6:00 pm", "6:00 pm","6:00 pm","6:00 pm","6:00 pm","8:00 pm","8:00 pm",};
        this.openDays = new Boolean[] {false, true, true, true, true, true, false};
        this.url = "https://www.kingdomfootsteps.com/";
        this.rating = 5;

    }
    //overridden toString() method for business contacts
    @Override
    public String toString() {
        System.out.println("Name: \t\t\t" + super.name + "\nAddress: \t\t" + super.streetName + " " + super.city +
                " " + super.zip + " " + super.country + "\n" + "Phone: \t\t\t" + super.phoneNum + "\n" +
                "Pic Name: \t\t" + super.picName + "\n" + "Email: \t\t\t" + super.email + "\n" +
                "URL: \t\t\t" + getUrl() + "\n" + "Rating: \t\t" + getRating() + "\n");

        System.out.println("\nHours of Operations\n");
        String[] daysOfWeek = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String oIndicator = "Open";

        //utilizes printf to create a column formatted output
        for(int i = 0; i < openDays.length; i++){
            if(openDays[i]){
                System.out.printf("%-15s %-10s %-5s - %-5s\n", daysOfWeek[i], oIndicator, openHour[i],closeHour[i]);
            }
            else
                System.out.printf("%-15s Closed\n",daysOfWeek[i]);
        }
        return "\r";
    }

}
