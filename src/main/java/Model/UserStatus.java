package Model;

public enum UserStatus{
    ALLOW("allow"), DENY("deny");
    private final String value;
    UserStatus(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
