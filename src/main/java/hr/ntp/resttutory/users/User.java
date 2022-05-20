package hr.ntp.resttutory.users;


public class User {
    private String name;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String dateOfBirth;
    private String profilePictureFilePath;
    private String contact;

    public User(){

    }


    public User(String name, String lastName, String username, String email, String password, String dateOfBirth, String profilePictureFilePath, String contact) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.profilePictureFilePath = profilePictureFilePath;
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfilePictureFilePath() {
        return profilePictureFilePath;
    }

    public void setProfilePictureFilePath(String profilePictureFilePath) {
        this.profilePictureFilePath = profilePictureFilePath;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", profilePictureFilePath='" + profilePictureFilePath + '\'' +
                '}';
    }
}
