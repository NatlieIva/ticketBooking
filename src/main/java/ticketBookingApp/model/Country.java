package ticketBookingApp.model;

import java.util.Random;

public enum Country {
    ARMENIA("Armenia"),
    AUSTRALIA("Australia"),
    AUSTRIA("Austria"),
    BAHAMAS("Bahamas"),
    BELARUS("Belarus"),
    BRAZIL("Brazil"),
    CANADA("Canada"),
    CHINA("China"),
    CUBA("Cuba"),
    DENMARK("Denmark"),
    EGYPT("Egypt"),
    ESTONIA("Estonia"),
    FINLAND("Finland"),
    FRANCE("France"),
    GEORGIA("Georgia"),
    GERMANY("Germany"),
    GREECE("Greece"),
    ICELAND("Iceland"),
    INDIA("India"),
    ITALY("Italy"),
    JAPAN("Japan"),
    LATVIA("Latvia"),
    MADAGASCAR("Madagascar"),
    MEXICO("Mexico"),
    NORWAY("Norway"),
    PORTUGAL("Portugal"),
    RUSSIA("Russia"),
    SERBIA("Serbia"),
    SINGAPORE("Singapore"),
    SPAIN("Spain"),
    TURKEY("Turkey"),
    UK("UK"),
    USA("USA"),
    VIETNAM("Vietnam");

    private String humanFriendlyName;

    Country(String humanFriendlyName) {
        this.humanFriendlyName = humanFriendlyName;
    }

    public String getHumanFriendlyName() {
        return humanFriendlyName;
    }

    public static Country randomCountry() {
        Random random = new Random();
        int index = random.nextInt(Country.values().length);
        return Country.values()[index];
    }
}
