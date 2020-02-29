package ticketBookingApp.model;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String humanFriendlyName;

    Gender(String humanFriendlyName) {
        this.humanFriendlyName = humanFriendlyName;
    }

    public String getHumanFriendlyName() {
        return humanFriendlyName;
    }
}
