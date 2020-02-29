package ticketBookingApp.view;

import java.io.IOException;
import java.io.Writer;

public class AddTicketFormPage implements Page {
    public void generate(Writer out) throws IOException {

        out.write("<h1>ADD TICKET</h1>\n");
        out.write("<p><a href='/'>HOME</a></p>");

        out.write("<form method='post' action='/add'>\n");

        out.write("<p>First name: <input type='text' name='firstName'></p>");
        out.write("<p>Last name: <input type='text' name='lastName'></p>");
        out.write("<p>Sex:\n" +
                "<select name='sex'>\n" +
                "  <option value=\"Male\">Male</option>\n" +
                "  <option value=\"Female\">Female</option>\n" +
                "</select>\n" +
                "</p>");

        out.write("<h5>Date of birth:</h5>\n");

        out.write("<p>Day: <input type='text' name='dayOfBirth'></p>");

        out.write("<p>Month:\n" +
                "<select name='monthOfBirth'>\n" +
                "  <option value=\"0\">January</option>\n" +
                "  <option value=\"1\">February</option>\n" +
                "  <option value=\"2\">March</option>\n" +
                "  <option value=\"3\">April</option>\n" +
                "  <option value=\"4\">May</option>\n" +
                "  <option value=\"5\">June</option>\n" +
                "  <option value=\"6\">July</option>\n" +
                "  <option value=\"7\">August</option>\n" +
                "  <option value=\"8\">September</option>\n" +
                "  <option value=\"9\">October</option>\n" +
                "  <option value=\"10\">November</option>\n" +
                "  <option value=\"11\">December</option>\n" +
                "</select>\n" +
                "</p>");

        out.write("<p>Year: <input type='text' name='yearOfBirth'></p>");

        out.write("<p>PassNo: <input type='text' name='passport'></p>");

        out.write("<p>Airlines:\n" +
                "<select name='airlines'>\n" +
                "  <option value=\"Nordavia\">Nordavia</option>\n" +
                "  <option value=\"Utair\">Utair</option>\n" +
                "  <option value=\"S7 Airlines\">S7 Airlines</option>\n" +
                "  <option value=\"American Airlines\">American Airlines</option>\n" +
                "  <option value=\"Aeroflot\">Aeroflot</option>\n" +
                "</select>\n" +
                "</p>");

        out.write("<p>Departure country:\n" +
                "<select name='departureCountry'>\n" +
                "  <option value=\"Armenia\">Armenia</option>\n" +
                "  <option value=\"Australia\">Australia</option>\n" +
                "  <option value=\"Belarus\">Belarus</option>\n" +
                "  <option value=\"China\">China</option>\n" +
                "  <option value=\"Denmark\">Denmark</option>\n" +
                "  <option value=\"Estonia\">Estonia</option>\n" +
                "  <option value=\"Finland\">Finland</option>\n" +
                "  <option value=\"France\">France</option>\n" +
                "  <option value=\"Georgia\">Georgia</option>\n" +
                "  <option value=\"Germany\">Germany</option>\n" +
                "  <option value=\"Iceland\">Iceland</option>\n" +
                "  <option value=\"India\">India</option>\n" +
                "  <option value=\"Spain\">Spain</option>\n" +
                "  <option value=\"Turkey\">Turkey</option>\n" +
                "  <option value=\"Vietnam\">Vietnam</option>\n" +
                "</select>\n" +
                "</p>");

        out.write("<p>Country arrival:\n" +
                "<select name='arrivalCountry'>\n" +
                "  <option value=\"Armenia\">Armenia</option>\n" +
                "  <option value=\"Australia\">Australia</option>\n" +
                "  <option value=\"Belarus\">Belarus</option>\n" +
                "  <option value=\"China\">China</option>\n" +
                "  <option value=\"Denmark\">Denmark</option>\n" +
                "  <option value=\"Estonia\">Estonia</option>\n" +
                "  <option value=\"Finland\">Finland</option>\n" +
                "  <option value=\"France\">France</option>\n" +
                "  <option value=\"Georgia\">Georgia</option>\n" +
                "  <option value=\"Germany\">Germany</option>\n" +
                "  <option value=\"Iceland\">Iceland</option>\n" +
                "  <option value=\"India\">India</option>\n" +
                "  <option value=\"Spain\">Spain</option>\n" +
                "  <option value=\"Turkey\">Turkey</option>\n" +
                "  <option value=\"Vietnam\">Vietnam</option>\n" +
                "</select>\n" +
                "</p>");

        out.write("<h5>Departure date:</h5>\n");

        out.write("<p>Day: <input type='text' name='depDay'></p>");

        out.write("<p>Month:\n" +
                "<select name='depMonth'>\n" +
                "  <option value=\"0\">January</option>\n" +
                "  <option value=\"1\">February</option>\n" +
                "  <option value=\"2\">March</option>\n" +
                "  <option value=\"3\">April</option>\n" +
                "  <option value=\"4\">May</option>\n" +
                "  <option value=\"5\">June</option>\n" +
                "  <option value=\"6\">July</option>\n" +
                "  <option value=\"7\">August</option>\n" +
                "  <option value=\"8\">September</option>\n" +
                "  <option value=\"9\">October</option>\n" +
                "  <option value=\"10\">November</option>\n" +
                "  <option value=\"11\">December</option>\n" +
                "</select>\n" +
                "</p>");

        out.write("<p>Year:\n" +
                "<select name='year'>\n" +
                "  <option value=\"2019\">2019</option>\n" +
                "</select>\n" +
                "</p>");

        out.write("<p><input type='submit'></p>");

        out.write("</form>\n");


    }
}

