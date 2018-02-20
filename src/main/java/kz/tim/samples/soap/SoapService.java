package kz.tim.samples.soap;

import kz.tim.samples.model.Person;
import kz.tim.samples.model.Status;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Interface for soap web service.
 *
 * @author Timur Tibeyev.
 */

@WebService
public interface SoapService {

    @WebMethod
    @WebResult(name = "person")
    List<Person> getPersons();

    @WebMethod
    @WebResult(name = "person")
    Person savePerson(@WebParam(name = "person") Person person);

    @WebMethod
    @WebResult(name = "person")
    Person getPerson(@WebParam(name = "id") int id);

    @WebMethod
    @WebResult(name = "status")
    Status updatePerson(@WebParam(name = "id") int id, @WebParam(name = "person") Person person);

    @WebMethod
    @WebResult(name = "status")
    Status deletePerson(@WebParam(name = "id") int id);
}
