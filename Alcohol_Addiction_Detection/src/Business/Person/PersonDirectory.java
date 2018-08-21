/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anubhavgupta
 */
public class PersonDirectory {

    private List<Person> persons;

    public PersonDirectory() {

        persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Person createPerson(String firstName, String lastName) {

        Person p = new Person(firstName, lastName);
        persons.add(p);
        return p;

    }

    public Person findById(int id) {

        return persons.stream()
                .filter(p -> p.getId() == id).findFirst()
                .orElse(null);

    }

}
