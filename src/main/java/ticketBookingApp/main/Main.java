package ticketBookingApp.main;

import ticketBookingApp.data.DataGeneration;
import ticketBookingApp.model.Country;
import ticketBookingApp.model.Flight;
import ticketBookingApp.model.Passenger;
import ticketBookingApp.model.Ticket;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static ticketBookingApp.utils.Serialize.ticketToJsonViaGson;

public class Main {

    private static final Main main = new Main();
    static BufferedWriter writer;

    public static void main(String[] args) throws IOException, InterruptedException {
        final ArrayList<Ticket> tickets = new ArrayList<>();
        final int numberOfTickets = 10;

        Runnable target = new Runnable() {
            public void run() {

                synchronized (main) {
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
                }
            }
        };
        ArrayList<Thread> ticketThreads = new ArrayList<Thread>();
        for (int i = 0; i < numberOfTickets; ++i) {
            Thread thread = new Thread(target, "thread-" + i);
            thread.start();
            ticketThreads.add(thread);
        }

        for (Thread ticketThread : ticketThreads) {
            ticketThread.join();
        }

        try {
            writer = new BufferedWriter(
                    new FileWriter("C:\\Users\\user\\Desktop\\tickets.txt"));
            for (Ticket ticket : tickets) {
                String toJson = ticketToJsonViaGson(ticket);
                System.out.println(toJson);
                writer.write(toJson);
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(ticketThreads);

//        try {
//            writer = new BufferedWriter(
//                    new FileWriter("C:\\Users\\user\\Desktop\\tickets.txt"));
//            for (Ticket ticket : tickets) {
//                String toJson = ticketToJsonViaGson(ticket);
//                System.out.println(toJson);
//                writer.write(toJson);
//                writer.flush();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}


