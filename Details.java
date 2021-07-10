public class Details {
    private String Name;
    private String Email;
    private String EnrolNumber;
    private int PhoneNumber;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEnrolNumber() {
        return EnrolNumber;
    }

    public void setEnrolNumber(String enrolNumber) {
        EnrolNumber = enrolNumber;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Details(String name, String email, String enrolNumber, int phoneNumber) {
        Name = name;
        Email = email;
        EnrolNumber = enrolNumber;
        PhoneNumber = phoneNumber;
    }
}
