package kz.tim.samples.rest;

import com.google.gson.Gson;
import kz.tim.samples.bean.StorageBean;
import kz.tim.samples.model.Person;
import kz.tim.samples.model.Status;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Class represents rest endpoints for CRUD operations for {@code Person} class.
 *
 * @author Timur Tibeyev.
 */

@ApplicationScoped
@Path("person")
public class PersonService {

    @Inject
    private StorageBean storageBean;

    /**
     * Returns list of the persons.
     * @return json response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String list() {
        String json = new Gson().toJson(storageBean.getPersons());
        return json;
    }

    /**
     * Finds person by id.
     * @param id person id
     * @return json response.
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String person(@PathParam("id") Integer id) {
        Person result = storageBean.getPersons().stream().filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        String json = new Gson().toJson(result);
        return json;
    }

    /**
     * Saves new person.
     * @param person {@code Person} object
     * @return json response.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String save(Person person) {
        int id = ThreadLocalRandom.current().nextInt(1, 1000);
        person.setId(id);
        storageBean.getPersons().add(person);
        return new Gson().toJson(person);
    }

    /**
     * Updates person by id.
     * @param id person id
     * @param person {@code Person} object
     * @return json response.
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(Person person, @PathParam("id") Integer id) {
        storageBean.setPersons(storageBean.getPersons().stream().filter(p -> p.getId() != id)
                .collect(Collectors.toList()));
        person.setId(id);
        storageBean.getPersons().add(person);
        return new Gson().toJson(new Status());
    }

    /**
     * Deletes person by id.
     * @param id person id
     * @return json response.
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") Integer id) {
        storageBean.setPersons(storageBean.getPersons().stream().filter(p -> p.getId() != id)
                .collect(Collectors.toList()));
        return new Gson().toJson(new Status());
    }

}
