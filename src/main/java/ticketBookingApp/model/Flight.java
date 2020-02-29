package ticketBookingApp.model;

import ticketBookingApp.data.DataGeneration;

import java.util.GregorianCalendar;

public class Flight {

//    private String airlines;
//    private int flightNo;
//    private String departureCountry;
//    private  String ArrivalCountry;


//    private  GregorianCalendar arrivalTime;


    private String airlines;
    private String departureCountry;
    private String arrivalCountry;
    private String flightNumber;
    private String depDay;
    private String depMonth;
    private String depHour;
    private String depMin;
    GregorianCalendar depDate;

    public Flight(String airlines, String departureCountry, String arrivalCountry, String flightNumber, String depDay, String depMonth, String depHour, String depMin) {
        this.airlines = airlines;
        this.departureCountry = departureCountry;
        this.arrivalCountry = arrivalCountry;
        this.flightNumber = flightNumber;
        this.depDay = depDay;
        this.depMonth = depMonth;
        this.depHour = depHour;
        this.depMin = depMin;
    }

    public Flight(String airlines, String departureCountry, String arrivalCountry, String depDay,
                  String depMonth) {
        this.airlines = airlines;
        this.departureCountry = departureCountry;
        this.arrivalCountry = arrivalCountry;
        this.flightNumber = DataGeneration.randomFlightNo();
        this.depDay = depDay;
        this.depMonth = depMonth;
        this.depHour = DataGeneration.randomHour();
        this.depMin = DataGeneration.randomMinute();
        this.depDate = new GregorianCalendar(2019,
                Integer.parseInt(depMonth),
                Integer.parseInt(depDay),
                Integer.parseInt(depHour),
                Integer.parseInt(depMin));
    }

    public String getAirlines() {
        return airlines;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public String getArrivalCountry() {
        return arrivalCountry;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepDay() {
        return depDay;
    }

    public String getDepMonth() {
        return depMonth;
    }

    public String getDepHour() {
        return depHour;
    }

    public String getDepMin() {
        return depMin;
    }

    public GregorianCalendar getDepDate() {
        return depDate;
    }

    @Override
    public String toString() {
        return " Airlines: " + airlines + ";\n " +
                "Departure Country: " + departureCountry + ";\n " +
                "Arrival Country: " + arrivalCountry + ";\n " +
                "Flight: " + flightNumber + ";\n " +
                "Departure time: " + depDay + "." + depMonth + " " + depHour + ":" + depMin + ";\n";
    }
}

