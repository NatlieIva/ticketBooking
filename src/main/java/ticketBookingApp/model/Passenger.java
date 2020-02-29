package ticketBookingApp.model;

import java.util.GregorianCalendar;

public class Passenger {

    //    private Name name;
//    private String sex;
//    private GregorianCalendar dateOfBirth;
//    private int passNo;
//
//    public Passenger(Name name, String sex, GregorianCalendar dateOfBirth, int passNo) {
//        this.name = name;
//        this.sex = sex;
//        this.dateOfBirth = dateOfBirth;
//        this.passNo = passNo;
//    }
    private String idPassenger;
    private String firstName;
    private String lastName;
    private String sex;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String passport;
    private GregorianCalendar bDate;

    public Passenger(String idPassenger, String firstName, String lastName, String sex, String dayOfBirth, String monthOfBirth, String yearOfBirth, String passport) {
        this.idPassenger = idPassenger;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.passport = passport;
    }

    public Passenger(String firstName, String lastName, String sex, String dayOfBirth, String monthOfBirth, String yearOfBirth, String passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.passport = passport;
        this.idPassenger = lastName + passport;
        this.bDate = new GregorianCalendar(
                Integer.parseInt(dayOfBirth),
                Integer.parseInt(monthOfBirth),
                Integer.parseInt(yearOfBirth));

        if (firstName.isEmpty() | lastName.isEmpty()) {
            throw new IllegalArgumentException("name shouldn't be empty");
        }

        if (dayOfBirth.isEmpty() | yearOfBirth.isEmpty()) {
            throw new IllegalArgumentException("date of birth shouldn't be empty");
        }

        if (passport.isEmpty()) {
            throw new IllegalArgumentException("passport number shouldn't be empty");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getPassport() {
        return passport;
    }

    public String getIdPassenger() {
        return idPassenger;
    }

    @Override
    public String toString() {
        return "First name: " + firstName + ";\n " +
                "Last name: " + lastName + ";\n " +
                "Sex: " + sex + ";\n " +
                "Date of birth: " + dayOfBirth + "." + monthOfBirth + "." + yearOfBirth + ";\n " +
                "Passport number: " + passport + "\n";
    }
}

