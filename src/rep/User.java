package rep;

public class User {
    private String fullName;

    private String password;

    private boolean isAdmin;

    public User(String fullName, String password, boolean isAdmin) {
        this.fullName = fullName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
    //    public User(String fullName, String password) {
//        this.fullName = fullName;
//        this.password = password;
//    }

    public User() {
    }

    @Override
    public String toString() {
        return "Users : " + "fullName = '" + fullName + ", password ='" + password + "\n" + " is admin = "  + isAdmin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
