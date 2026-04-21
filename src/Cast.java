public class Cast {
    private String fullName;
    private String role;


    public Cast(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return fullName + " (в роли " + role + ")";
    }
}
