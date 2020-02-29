package ticketBookingApp.model;

public enum Airlines {
    NORDAVIA("Nordavia"),
    UTAIR("Utair"),
    S7AIRLINES("S7 Airlines"),
    AMERICAN_AIRLINES("American Airlines"),
    AEROFLOT("Aeroflot");

    private String humanFriendlyName;

    Airlines(String humanFriendlyName) {
        this.humanFriendlyName = humanFriendlyName;
    }

    public String getHumanFriendlyName() {
        return humanFriendlyName;
    }

}
