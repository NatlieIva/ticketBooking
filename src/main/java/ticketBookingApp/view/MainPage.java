package ticketBookingApp.view;

import java.io.IOException;
import java.io.Writer;

public class MainPage implements Page {

    public void generate(Writer out) throws IOException {
        String buttonNewTicket = "Create new ticket";
        String buttonAllTickets = "View ticket list";
        String buttonSortTickets = "View sorted list by arrival country";
        String buttonSearchTickets = "Search ticket by last name";

        out.write("<h1>MAIN PAGE<h1>");
        out.write("<h3> - Select an action - <h3>");

        out.write("<h5>Create new ticket<h5>");
        out.write("<p>");
        out.write("<a href='/add'>");
        out.write("<input type='button' value=" + buttonNewTicket + ">");
        out.write("</a>");
        out.write("</p>\n");

        out.write("<h5>Show ticket list<h5>");
        out.write("<p>");
        out.write("<a href='/view'>");
        out.write("<input type='button' value=" + buttonAllTickets + ">");
        out.write("</a>");
        out.write("</p>\n");

        out.write("<h5>Sorting by arrival country<h5>");
        out.write("<p>");
        out.write("<a href='/sort'>");
        out.write("<input type='button' value=" + buttonSortTickets + ">");
        out.write("</a>");
        out.write("</p>\n");

        out.write("<h5>Search passenger<h5>");
        out.write("<p>");
        out.write("<a href='/search'>");
        out.write("<input type='button' value=" + buttonSearchTickets + ">");
        out.write("</a>");
        out.write("</p>\n");


        out.write("</form>\n");
        out.close();
    }
}
