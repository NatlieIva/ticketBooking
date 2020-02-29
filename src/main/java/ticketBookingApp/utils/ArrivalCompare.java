package ticketBookingApp.utils;

import ticketBookingApp.model.Ticket;

import java.util.Comparator;

public class ArrivalCompare implements Comparator<Ticket> {
    public int compare(Ticket one, Ticket two) {
        return one.getFligth().getArrivalCountry().compareTo(two.getFligth().getArrivalCountry());
    }
}