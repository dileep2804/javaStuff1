package useCases;

import entity.Person;
import myUtils.MyUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class M_Lambda_Use {
    public static void main(String[] args) {
        List<Person> personList = Person.getDefaultPersonList();
        MyUtils.print("initial list",personList); nl();

        personList.forEach(e -> {
            if(e.getGender() == Person.Sex.MALE){
                System.out.println(e.getName());
            }
        });  nl();

        Person.allFemales(personList, p -> p.getGender() == Person.Sex.FEMALE); nl();
        Person.femalesMiddleAge(personList,p -> p.getAge() > 25 && p.getGender()== Person.Sex.FEMALE, Person::printPerson);  nl();
        Person.emailsOfFemalesMiddleAge(personList, p -> p.getAge() > 25 && p.getGender()== Person.Sex.FEMALE, Person::getEmailAddress);  nl();

        Person.dayOfNextBirthday(personList,p -> {
            int age = (int) ChronoUnit.YEARS.between(p.getBirthday(),LocalDate.now());
            DayOfWeek day = p.getBirthday().plusYears(age).getDayOfWeek();
            return day;
        }); nl();


        Person p = new Person();
        Person.methodTesting(personList, (Person e) -> (String) e.getEmailAddress());
        Person.methodTesting(personList, e -> e.getEmailAddress());
        Person.methodTesting(personList, Person::getEmailAddress);

        System.out.println("hey there");
        System.out.println(10);
        System.out.println('A');
        System.out.println(personList);
    }


    private static void nl(){
        System.out.println("-------------------");
    }

}
