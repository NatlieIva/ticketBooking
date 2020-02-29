package ticketBookingApp.view;

import java.io.IOException;
import java.io.Writer;

public class SearchTicketFormPage implements Page {
    public void generate(Writer out) throws IOException {

        out.write("<h1>SEARCH TICKET BY NAME</h1>\n");
        out.write("<p><a href='/'>HOME</a></p>");

        out.write("<form method='post' action='/search'>\n");

        out.write("<p>First name: <input type='text' name='searchFirstName'></p>");
        out.write("<p>Last name: <input type='text' name='searchLastName'></p>");

        out.write("<p><input type='submit'></p>");

        out.write("</form>\n");


    }
}

