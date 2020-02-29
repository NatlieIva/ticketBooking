package ticketBookingApp.model;

import java.io.Serializable;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 3626590974203252245L;
    private Passenger passenger;
    private Flight flight;

    public Ticket(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public Ticket() {
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFligth() {
        return flight;
    }

    @Override
    public String toString() {
        return passenger + " " + flight + "\n ";
    }
}
