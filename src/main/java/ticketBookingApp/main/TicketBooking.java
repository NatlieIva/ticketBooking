package ticketBookingApp.main;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import ticketBookingApp.data.DataGeneration;
import ticketBookingApp.data.Database;
import ticketBookingApp.model.Country;
import ticketBookingApp.model.Flight;
import ticketBookingApp.model.Passenger;
import ticketBookingApp.model.Ticket;
import ticketBookingApp.view.*;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;

import static ticketBookingApp.data.Database.sortedByCountryList;
import static ticketBookingApp.data.Database.ticketFindByName;
import static ticketBookingApp.utils.HttpUtils.getMapForm;

public class TicketBooking {
    public static void main(String[] args) throws IOException {

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        final Database ticketbase = new Database();

        int numberOfTickets = 10;

        for (int i = 0; i < numberOfTickets; i++) {
            String sex = DataGeneration.randomPassengerSex().getHumanFriendlyName();
            String firstName = DataGeneration.NamesBase.randomFirstName(sex);
            String lastName = DataGeneration.NamesBase.randomLastName(sex);
            String passport = DataGeneration.randomPassNo();
            String idPassenger = lastName + passport;
            Passenger passenger = new Passenger(idPassenger, firstName, lastName, sex, DataGeneration.randomDay(),
                    DataGeneration.randomMonth(), DataGeneration.randomYear(),
                    passport);
            Flight flight = new Flight(DataGeneration.randomAirlines().getHumanFriendlyName(),
                    Country.randomCountry().getHumanFriendlyName(),
                    Country.randomCountry().getHumanFriendlyName(),
                    DataGeneration.randomFlightNo(),
                    DataGeneration.randomDay(),
                    DataGeneration.randomMonth(),
                    DataGeneration.randomHour(),
                    DataGeneration.randomMinute());
            tickets.add(new Ticket(passenger, flight));
            ticketbase.addTicket(new Ticket(passenger, flight));

        }

        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8080), 1000);
        server.createContext("/", new HttpHandler() {

            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                String path = httpExchange.getRequestURI().getPath();
                String[] pathComponents = path.split("/");

                String firstComponent = "";
                if (pathComponents.length >= 1) {
                    firstComponent = pathComponents[1];
                }

                switch (firstComponent) {
                    case "":
                        mainPage(httpExchange);
                        break;
                    case "view":
                        viewAllTickets(httpExchange, ticketbase);
                        break;
                    case "add":
                        if (httpExchange.getRequestMethod().toLowerCase().equals("post")) {
                            processAddForm(httpExchange, ticketbase);
                        } else {
                            addTicketForm(httpExchange);
                        }
                        break;
                    case "sort":
                        sortTickets(httpExchange, ticketbase);
                        break;
                    case "search":
                        if (httpExchange.getRequestMethod().toLowerCase().equals("post")) {
                            processFindTicketForm(httpExchange, ticketbase);
                        } else {
                            findTicketForm(httpExchange);
                        }
                        break;
                    case "profile":
                        ticketProfile(httpExchange, path, ticketbase);
                        break;
                    default:
                        respondNotFound(httpExchange);
                }
            }
        });
        server.start();

    }

    private static void ticketProfile(HttpExchange httpExchange, String path, Database ticketbase) throws IOException {
        String idPassenger = path.substring("/profile/".length());
        Ticket ticket = ticketbase.findById(idPassenger);

        if (ticket == null) {
            respondNotFound(httpExchange);
        } else {
            respond(new ViewDetailsPage(ticket), httpExchange);
        }
    }

    private static void respond(Page page, HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, 0);
        Writer out = new OutputStreamWriter(httpExchange.getResponseBody(), "UTF-8");
        page.generate(out);
        out.close();
    }

    private static void respondNotFound(HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(404, 0);
        Writer out = new OutputStreamWriter(httpExchange.getResponseBody());
        out.write("<h1>Not found</h1>");
        out.close();
    }

    private static void mainPage(HttpExchange httpExchange) throws IOException {
        respond(new MainPage(), httpExchange);
    }

    private static void viewAllTickets(HttpExchange httpExchange, Database ticketbase) throws IOException {
        respond(new ViewTicketList(ticketbase.getAllTickets()), httpExchange);
    }

    private static void sortTickets(HttpExchange httpExchange, Database ticketbase) throws IOException {
        ArrayList<Ticket> st = sortedByCountryList(ticketbase.getAllTickets());
        respond(new ViewSortedTicketList(st), httpExchange);
    }

    private static void processFindTicketForm(HttpExchange httpExchange, Database ticketbase) throws IOException {
        HashMap<String, String> form = getMapForm(httpExchange);
        ArrayList<Ticket> foundName = ticketFindByName(ticketbase.getAllTickets(), form.get("searchFirstName"),
                form.get("searchLastName"));
        respond(new ViewFoundTicketList(foundName), httpExchange);
    }

    private static void findTicketForm(HttpExchange httpExchange) throws IOException {
        respond(new FindTicketFormPage(), httpExchange);
    }

    private static void addTicketForm(HttpExchange httpExchange) throws IOException {
        respond(new AddTicketFormPage(), httpExchange);
    }

    private static void processAddForm(HttpExchange httpExchange, Database ticketbase) throws IOException {

        HashMap<String, String> form = getMapForm(httpExchange);

        Passenger newPassenger = new Passenger(
                form.get("firstName"),
                form.get("lastName"),
                form.get("sex"),
                form.get("dayOfBirth"),
                form.get("monthOfBirth"),
                form.get("yearOfBirth"),
                form.get("passport"));
        Flight newFlight = new Flight(
                form.get("airlines"),
                form.get("departureCountry"),
                form.get("arrivalCountry"),
                form.get("depDay"),
                form.get("depMonth"));

        Ticket newTicket = new Ticket(newPassenger, newFlight);
        boolean added = ticketbase.addTicket(newTicket);
        respond(new AddTicketFormResultPage(newTicket.getPassenger().getFirstName(),
                newTicket.getPassenger().getLastName(), added), httpExchange);
    }

}



