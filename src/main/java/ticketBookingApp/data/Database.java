package ticketBookingApp.data;

import ticketBookingApp.model.Ticket;
import ticketBookingApp.utils.ArrivalCompare;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static ticketBookingApp.utils.Serialize.ticketToJsonViaGson;

public class Database {

    private ArrayList<Ticket> allTickets = new ArrayList<Ticket>();
    private final static Object syncAddTicket = new Object();
    static BufferedWriter writer;

    public boolean addTicket(Ticket addTicket) {

        synchronized (syncAddTicket) {
            String idPassenger = addTicket.getPassenger().getIdPassenger();

            for (Ticket ticket : allTickets) {
                if (ticket.getPassenger().getIdPassenger().equals(idPassenger)) {
                    return false;
                }
            }

            allTickets.add(addTicket);
            try {
                writer = new BufferedWriter(
                        new FileWriter("C:\\Users\\user\\Desktop\\tickets.txt", true));
                String toJson = ticketToJsonViaGson(addTicket);
                writer.write(toJson);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public ArrayList<Ticket> getAllTickets() {
        return new ArrayList<>(allTickets);
    }

    public static ArrayList<Ticket> ticketFindByName(ArrayList<Ticket> allTickets, String searchFirstName, String searchLastName) {
        ArrayList<Ticket> findName = new ArrayList<Ticket>();
        for (Ticket ticket : allTickets) {
            if ((ticket.getPassenger().getFirstName().equals(searchFirstName)) && (ticket.getPassenger().getLastName().equals(searchLastName))) {
                findName.add(ticket);
            }
        }
        return findName;
    }

    public Ticket findById(String idPassenger) {
        Ticket foundTicket = new Ticket();
        for (Ticket ticket : allTickets) {
            if (ticket.getPassenger().getIdPassenger().equals(idPassenger)) {
                foundTicket = ticket;
                break;
            }
        }
        return foundTicket;
    }

    public static ArrayList<Ticket> sortedByCountryList(ArrayList<Ticket> tickets) {
        ArrivalCompare nc = new ArrivalCompare();
        Collections.sort(tickets, nc);
        return tickets;
    }

}