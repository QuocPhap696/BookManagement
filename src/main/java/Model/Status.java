package Model;

public enum Status {
    INSTOCK("INSTOCK"), OUTSTOCK("OUTSTOCK");
    private String value;
    Status (String value){
    this.value=value;
    }

    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }
        public static Status getStatus(String value){
        for (Status status : values()){
            if (status.getValue().equals(value)){
                return status;
            }
        }
        return null;
    }
}
