package entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Person implements Comparable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }


    public enum Sex {
        MALE("men"), FEMALE("women"), UNKNOWN("undefined");
        private Sex(String synonems){
        }
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;
    private List<Schooling> educationDetails;

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Schooling> getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(List<Schooling> educationDetails) {
        this.educationDetails = educationDetails;
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress, List<Schooling> educationDetails) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.educationDetails = educationDetails;
    }
    Person(String nameArg, LocalDate birthdayArg, Sex genderArg, String emailArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        emailAddress = emailArg;
    }
    public Person() {
        this(
                "default_name",
                LocalDate.of(2001,1,1),
                Sex.UNKNOWN,
                "default@example.com",
                new ArrayList<>(Arrays.asList(
                        new Schooling(Education.NURSARY), new Schooling(Education.SCHOOL))));
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(this.birthday, LocalDate.now());
    }

    public void printPerson() {
        System.out.println("name: "+this.name + ", age: " + getAge());
    }

    public Sex getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Deprecated
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static List<Person> getDefaultPersonList() {

        List<Person> roster = new ArrayList<>();
        roster.add(
                new Person(
                        "cassie",
                        LocalDate.of(1980, 10, 24),
                        Sex.FEMALE, "cassie@example.com",
                        new ArrayList<>(Arrays.asList(new Schooling(Education.SCHOOL,"kyiv",12345),
                                new Schooling(Education.SCHOOL, "Kharkiv",6100),
                                new Schooling(Education.SCHOOL, "Bercelona",8001)))));
        roster.add(
                new Person(
                        "Dileep",
                        LocalDate.of(2001, 4, 28),
                        Sex.MALE, "dileep@example.com",
                        new ArrayList<>(Arrays.asList(new Schooling(Education.COLLEGE, "Roorkee", 247667),
                                new Schooling(Education.SCHOOL,"Nowgong",471011),
                                new Schooling(Education.SCHOOL, "Harpalpur",6100),
                                new Schooling(Education.SCHOOL, "Bangalore",8001)))));
        roster.add(
                new Person(
                        "Aman",
                        LocalDate.of(2004, 7, 5),
                        Person.Sex.MALE, "george@example.com",
                        new ArrayList<>(Arrays.asList(new Schooling(Education.NURSARY,"Chhatarpur",471001),
                                new Schooling(Education.NURSARY, "Urdmau",6100)))));
        roster.add(
                new Person(
                        "Bob",
                        LocalDate.of(1980, 10, 24),
                        Person.Sex.MALE, "bob@example.com",
                        new ArrayList<>(Arrays.asList(new Schooling(Education.NURSARY,"kyiv",12345),
                                new Schooling(Education.NURSARY, "Kharkiv",6100),
                                new Schooling(Education.NURSARY, "Bercelona",8001)))));
        roster.add( new Person(
                        "Akash",
                        LocalDate.of(1990,8,14),
                        Sex.MALE, "akash@abc.com",
                        new ArrayList<>(Arrays.asList(new Schooling(Education.COLLEGE,"kyiv",12345),
                        new Schooling(Education.COLLEGE, "Kharkiv",6100),
                        new Schooling(Education.COLLEGE, "Bercelona",8001)))));
        roster.add(
                new Person(
                        "Sweta",
                        LocalDate.of(1996,7,16),
                        Sex.FEMALE, "sweta@xyz.com",
                        new ArrayList<>(Arrays.asList(new Schooling(Education.COLLEGE,"kyiv",12345),
                                new Schooling(Education.COLLEGE, "Kharkiv",6100),
                                new Schooling(Education.COLLEGE, "Bercelona",8001)))));
        roster.add(
                new Person(
                        "Anita",
                        LocalDate.of(2000,2,1),
                        Sex.FEMALE,"antu@zzz.com",
                        new ArrayList<>(Arrays.asList(new Schooling(Education.SCHOOL,"palera",12345),
                                new Schooling(Education.SCHOOL, "nowgong",6100)))));

        return roster;
    }

    public static void allFemales(List<Person> roster, Predicate<Person> tester){
        for(Person p : roster){
            if(tester.test(p)){
                System.out.println(p);
            }
        }
    }
    public static void femalesMiddleAge(List<Person> roster, Predicate<Person> tester, Consumer<Person> block){
        for (Person p : roster){
            if(tester.test(p)){
                block.accept(p);
            }
        }
    }
    public static void emailsOfFemalesMiddleAge(List<Person> roster, Predicate<Person> tester, Function<Person,String> mapper) {
        for(Person p : roster){
            if(tester.test(p)){
                System.out.println(mapper.apply(p));
            }
        }
    }

    public static void methodTesting(List<Person> roster, Function<Person,String> mapper){
        for(Person p : roster){
            System.out.println(mapper.apply(p));
        }
    }

    public static void  dayOfNextBirthday(List<Person> roster, Function<Person, DayOfWeek> mapper){
        for(Person p : roster){
            System.out.println("day of next birthday of "+p.getName()+": "+mapper.apply(p));
        }
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}