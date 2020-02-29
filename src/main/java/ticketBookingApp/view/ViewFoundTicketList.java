package ticketBookingApp.view;

import ticketBookingApp.model.Ticket;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class ViewFoundTicketList implements Page {
    private ArrayList<Ticket> tickets;

    public ViewFoundTicketList(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void generate(Writer out) throws IOException {
        out.write("<h1>Passengers found upon request: </h1>\n");
        out.write("<p><a href='/'>HOME</a></p>");

        for (Ticket ticket : tickets) {
            out.write("<p>");
            out.write("<a href='/profile/" + ticket.getPassenger().getIdPassenger() + "'>");
            out.write(ticket.getPassenger().getFirstName() + " " + ticket.getPassenger().getLastName());
            out.write("</a>");
            out.write("</p>\n");
        }
    }
}
