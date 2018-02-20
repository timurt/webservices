package kz.tim.samples.bean;

import kz.tim.samples.model.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for storing data on application level.
 * On instance for whole application.
 *
 * @author Timur Tibeyev.
 */
@ApplicationScoped
public class StorageBean {

    /** List of the persons **/
    private List<Person> persons = new ArrayList<>();

    /**
     * Getter method.
     * @return list of the persons.
     */
    public List<Person> getPersons() {
        return persons;
    }

    /**
     * Setter method.
     * @param persons list of the persons.
     */
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
