package ticketBookingApp.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ticketBookingApp.model.Ticket;

import java.util.GregorianCalendar;

public class Serialize {

    public static String ticketToJson(Ticket ticket) {

        GregorianCalendar bDate = new GregorianCalendar(
                Integer.parseInt(ticket.getPassenger().getYearOfBirth()),
                Integer.parseInt(ticket.getPassenger().getMonthOfBirth()),
                Integer.parseInt(ticket.getPassenger().getDayOfBirth()));

        GregorianCalendar depDate = new GregorianCalendar(2019,
                Integer.parseInt(ticket.getFligth().getDepMonth()),
                Integer.parseInt(ticket.getFligth().getDepDay()),
                Integer.parseInt(ticket.getFligth().getDepHour()),
                Integer.parseInt(ticket.getFligth().getDepMin()));

        return "{\"First name\":\"" + ticket.getPassenger().getFirstName() + "\"n" +
                "\"Last name\":\"" + ticket.getPassenger().getLastName() + "\"n" +
                "\"Sex\":\"" + ticket.getPassenger().getSex() + "\"n" +
                "\"Date of birth\":\"" + bDate.getTime() + "\"n" +

                "\"Airlines\":\"" + ticket.getFligth().getAirlines() + "\"n" +
                "\"Flight number\":\"" + ticket.getFligth().getFlightNumber() + "\"n" +
                "\"Departure country\":\"" + ticket.getFligth().getDepartureCountry() + "\"n" +
                "\"Arrival country\":\"" + ticket.getFligth().getArrivalCountry() + "\"n" +
                "\"Departure time\":\"" + depDate.getTime() + "\"}";
    }

    public static String ticketToJsonViaGson(Ticket ticket) {

        Gson gson = new Gson();
        return gson.toJson(ticket);
    }

    public static Ticket ticketFromJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, Ticket.class);
    }


}
