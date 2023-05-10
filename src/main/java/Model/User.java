package Model;

public class User {
    private int id;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String passwword;

    public User(String username, String password, Role role) {
    }

    public User(int id, String fullName, String address, String phone, String email, String passwword) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.passwword = passwword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswword() {
        return passwword;
    }

    public void setPasswword(String passwword) {
        this.passwword = passwword;
    }
}
