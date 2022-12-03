package entity;

public class Schooling {
    private Education education;
    private String city = "Bhopal";

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    private int pincode = 462023;

    public Schooling(Education education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Schooling{" +
                "education=" + education +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                '}';
    }

    public Schooling() {
        this(Education.NURSARY);
    }

    public Schooling(Education education, String city, int pincode) {
        this.education = education;
        this.city = city;
        this.pincode = pincode;
    }
}
