package africa.semicolon.sendAm.Dtos.responses;

public class FindUserResponse {
    @Override
    public String toString() {
        return "Search Result->" +
                "Email : " + email + '\'' +
                ",Name : " + fullName + '\'' ;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private  String fullName;
}
