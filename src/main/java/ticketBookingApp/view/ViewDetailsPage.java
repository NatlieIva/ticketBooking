package ticketBookingApp.view;

import ticketBookingApp.model.Ticket;

import java.io.IOException;
import java.io.Writer;
import java.util.GregorianCalendar;

public class ViewDetailsPage implements Page {
    private Ticket ticket;

    public ViewDetailsPage(Ticket ticket) {
        this.ticket = ticket;
    }

    public void generate(Writer out) throws IOException {

        GregorianCalendar bDate = new GregorianCalendar(
                Integer.parseInt(ticket.getPassenger().getYearOfBirth()),
                Integer.parseInt(ticket.getPassenger().getMonthOfBirth()),
                Integer.parseInt(ticket.getPassenger().getDayOfBirth()));

        GregorianCalendar depDate = new GregorianCalendar(2019,
                Integer.parseInt(ticket.getFligth().getDepMonth()),
                Integer.parseInt(ticket.getFligth().getDepDay()),
                Integer.parseInt(ticket.getFligth().getDepHour()),
                Integer.parseInt(ticket.getFligth().getDepMin()));

        out.write("<h1>Flight information for " + ticket.getPassenger().getFirstName() + " " +
                ticket.getPassenger().getLastName() + "</h1>\n");

        out.write("<p><a href='/'>HOME</a></p>");

        out.write("<p>First name: " + ticket.getPassenger().getFirstName() + "</p>\n");
        out.write("<p>Last name: " + ticket.getPassenger().getLastName() + "</p>\n");
        out.write("<p>Sex: " + ticket.getPassenger().getSex() + "</p>\n");
        out.write("<p>Date Of Birth: " + bDate.getTime() + "</p>\n");

        out.write("<p>Airlines: " + ticket.getFligth().getAirlines() + "</p>\n");
        out.write("<p>FlightNo: " + ticket.getFligth().getFlightNumber() + "</p>\n");
        out.write("<p>Departure Country: " + ticket.getFligth().getDepartureCountry() + "</p>\n");
        out.write("<p>Arrival Country: " + ticket.getFligth().getArrivalCountry() + "</p>\n");
        out.write("<p>Departure Time: " + depDate.getTime() + "</p>\n");
    }
}
