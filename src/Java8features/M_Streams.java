package Java8features;

import entity.Education;
import entity.Person;
import entity.Schooling;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class M_Streams {
    static void nl(){System.out.println("--------------");}

    public static void main(String[] args) {
        List<Person> personList = Person.getDefaultPersonList();

        collectorUse(personList);

        for(Person p : personList){
            System.out.print(p.getName()+",");
            for(Schooling sh : p.getEducationDetails()){
                System.out.print("["+sh.getEducation()+","+sh.getCity()+"],");
            }
            System.out.println(p.getEmailAddress());
        }  nl();

        Map<Education,List<Person>> mp1 = personList.stream()
                .filter(person -> person.getEducationDetails() != null &&
                        person.getEducationDetails().size() > 0)
                .collect(groupingBy(p -> p.getEducationDetails().get(0).getEducation()));

        for(Map.Entry<Education,List<Person>> entry : mp1.entrySet()){
            System.out.print(entry.getKey()+"->");
            for(Person p : entry.getValue()){
                System.out.print(p.getName()+", ");
            }
            System.out.println();
        }

        Map<Education,List<Person>> mp2 = personList.stream()
                .filter(person -> person.getEducationDetails() != null &&
                        person.getEducationDetails().size() > 0)
                .collect(groupingBy(p -> getPersonByEducation(p)));

        for(Map.Entry<Education,List<Person>> entry : mp2.entrySet()){
            System.out.print("\n"+entry.getKey()+"->");
            entry.getValue().iterator().forEachRemaining(
                    p -> System.out.print("["+p.getName()+","+p.getGender()+","+p.getEmailAddress()+"] "));
        }

    }

    private static void collectorUse(List<Person> personList){
        System.out.println("in collectorUse: ");
        personList.forEach(person -> System.out.println(person.getName()+","+person.getEducationDetails()));

        List<Schooling> l1 = personList
                .stream()
                .map(person -> person.getEducationDetails())
                .flatMap(educationDetails -> educationDetails.stream())
                .collect(Collectors.toList());

        System.out.println("\n");
        l1.forEach(element -> System.out.println(element)); nl();
    }

    private static Education getPersonByEducation(Person p){
        return p.getEducationDetails().iterator().next().getEducation();
//        return p.getEducationDetails().stream().map(ed -> ed.getEducation());
    }
}
