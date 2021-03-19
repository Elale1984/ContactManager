package DataInput;

public abstract class contactBase {
    protected String name;
    protected String phoneNum;
    protected String streetName;
    protected String city;
    protected String state;
    protected String zip;
    protected String country;
    protected String picName;
    protected String email;
    protected char type;

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
    //constructor
    public contactBase(String name,
                       String phoneNum,
                       String streetName,
                       String city,
                       String state,
                       String zip,
                       String country,
                       String picName,
                       String email,
                       char type) {
        super();
        this.name = name;
        this.phoneNum = phoneNum;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.picName = picName;
        this.email = email;
        this.type = type;
    }
    //no-args Constructor for generic

    public contactBase() {
        this.name = "Jordan Baldwin";
        this.phoneNum = "303-717-2244";
        this.streetName = "156 Dale st.";
        this.city = "Colorado Springs";
        this.state = "Colorado";
        this.zip = "80915";
        this.country = "USA";
        this.picName = "JBald";
        this.email = "JBaldwin@kingdomfootsteps.com";
        this.type = 'P';
    }


}
