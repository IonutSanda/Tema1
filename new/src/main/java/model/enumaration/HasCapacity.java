package model.enumaration;

public enum HasCapacity {

    HAS_CAPACITY("Hotel still has capacity"),
    NO_CAPACITY("Hotel does not have any more capacity");

    private final String message;

    HasCapacity (String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
