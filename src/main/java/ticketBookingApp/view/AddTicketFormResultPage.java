package ticketBookingApp.view;

import java.io.IOException;
import java.io.Writer;

public class AddTicketFormResultPage implements Page {
    private String firstName;
    private String lastName;
    private boolean added;

    public AddTicketFormResultPage(String firstName, String lastName, boolean added) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.added = added;
    }

    public void generate(Writer out) throws IOException {
        out.write("<p><a href='/'>HOME</a></p>");
        if (added) {
            out.write("<p>Passenger " + firstName + " " + lastName + " added.</p>");
        } else {
            out.write("<p>Passenger " + firstName + " " + lastName + " already exists.</p>");
        }
    }
}
