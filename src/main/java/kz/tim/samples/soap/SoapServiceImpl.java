package kz.tim.samples.soap;

import kz.tim.samples.bean.StorageBean;
import kz.tim.samples.model.Person;
import kz.tim.samples.model.Status;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Implementation of the {@code SoapService} interface.
 *
 * @author Timur Tibeyev.
 */

@WebService(endpointInterface = "kz.tim.samples.soap.SoapService")
public class SoapServiceImpl implements SoapService {

    @Inject
    private StorageBean storageBean;

    /**
     * Returns list of the persons.
     * @return list of the persons.
     */
    @Override
    public List<Person> getPersons() {
        return storageBean.getPersons();
    }

    /**
     * Saves new person.
     * @param person {@code Person} object
     * @return new person.
     */
    @Override
    public Person savePerson(Person person) {
        int id = ThreadLocalRandom.current().nextInt(1, 1000);
        person.setId(id);
        storageBean.getPersons().add(person);
        return person;
    }

    /**
     * Finds person by id.
     * @param id person id
     * @return person.
     */
    @Override
    public Person getPerson(int id) {
        Person result = storageBean.getPersons().stream().filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        return result;
    }

    /**
     * Updates person by id.
     * @param id person id
     * @param person {@code Person} object
     * @return status.
     */
    @Override
    public Status updatePerson(int id, Person person) {
        storageBean.setPersons(storageBean.getPersons().stream().filter(p -> p.getId() != id)
                .collect(Collectors.toList()));
        person.setId(id);
        storageBean.getPersons().add(person);
        return new Status();
    }

    /**
     * Deletes person by id.
     * @param id person id
     * @return status.
     */
    @Override
    public Status deletePerson(int id) {
        storageBean.setPersons(storageBean.getPersons().stream().filter(p -> p.getId() != id)
                .collect(Collectors.toList()));
        return new Status();
    }
}
