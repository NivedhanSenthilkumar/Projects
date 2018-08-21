/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Person.Person;

/**
 *
 * @author raunak
 */
public class Employee {

    private int id;
    private Person person;
    private static int count;

    public Employee(Person p) {
        count++;
        id = count;
        this.person = p;

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return person.getFirstName();
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

}
