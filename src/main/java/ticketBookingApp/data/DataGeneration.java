package ticketBookingApp.data;

import ticketBookingApp.model.Airlines;
import ticketBookingApp.model.Gender;

import java.util.*;

public class DataGeneration {

    public static Airlines randomAirlines() {
        Random random = new Random();
        int index = random.nextInt(Airlines.values().length);
        return Airlines.values()[index];
    }

    public static Gender randomPassengerSex() {
        Random random = new Random();
        int index = random.nextInt(Gender.values().length);
        return Gender.values()[index];
    }

    public static String randomDay() {
        int day = new Random().nextInt(31);
        return Integer.toString(day);
    }

    public static String randomMonth() {
        int month = new Random().nextInt(11) + 1;
        return Integer.toString(month);
    }

    public static String randomYear() {
        int randYear = new Random().nextInt(100);
        int year = 1919 + randYear;
        return Integer.toString(year);
    }

    public static String randomHour() {
        int hour = new Random().nextInt(24);
        return Integer.toString(hour);
    }

    public static String randomMinute() {
        int minute = new Random().nextInt(60);
        return Integer.toString(minute);
    }

    public static String randomPassNo() {
        int passNo = new Random().nextInt(1000000);
        return Integer.toString(passNo);
    }

    public static GregorianCalendar randomDate() {
        int day = new Random().nextInt(31);
        int month = new Random().nextInt(11);
        int year = 2019;
        int hour = new Random().nextInt(23);
        int minute = new Random().nextInt(60);
        GregorianCalendar randDate = new GregorianCalendar();
        randDate.set(Calendar.MINUTE, minute);
        randDate.set(Calendar.HOUR_OF_DAY, hour);
        randDate.set(Calendar.DAY_OF_MONTH, day);
        randDate.set(Calendar.MONTH, month);
        randDate.set(Calendar.YEAR, year);
        return randDate;
    }

    public static String randomFlightNo() {
        int flightNo = new Random().nextInt(1000000);
        return Integer.toString(flightNo);
    }

    public static class NamesBase {
        static List<String> firstNamesMale =
                Arrays.asList("Liam", "Noah", "William", "James", "Jacob");
        static List<String> firstNamesFemale =
                Arrays.asList("Emma", "Olivia", "Ava", "Sophia", "Mia");
        static List<String> lastNames =
                Arrays.asList("Smith", "Johnson", "Jones", "Brown", "Davis", "Miller", "Moore", "William", "Stewart", "Morris");


        public static String randomName(List<String> knownNames) {
            int number = new Random().nextInt(knownNames.size());
            return knownNames.get(number);
        }

        public static String randomFirstName(String sex) {
            String firstName = "";
            if (sex.equals("male")) {
                firstName = randomName(firstNamesMale);
            } else {
                firstName = randomName(firstNamesFemale);
            }
            return firstName;
        }

        public static String randomLastName(String sex) {
            String lastName = "";
            lastName = randomName(lastNames);
            return lastName;
        }
    }
}


