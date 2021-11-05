package application.models;

public enum Gender {

    MALE("male"),
    FEMALE("female");

    private final String LOVER_CASE;
    Gender (String loverCase){
        LOVER_CASE=loverCase;
    }
}
