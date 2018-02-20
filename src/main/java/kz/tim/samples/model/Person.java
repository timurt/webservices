package kz.tim.samples.model;

import java.util.Date;

/**
 * Model class.
 *
 * @author Timur Tibeyev.
 */
public class Person {
    /** Person id **/
    private int id;

    /** Person age **/
    private int age;

    /** Person first name **/
    private String firstName;

    /** Person last name **/
    private String lastName;

    /** Person email **/
    private String email;

    /** Person birth date **/
    private Date birthDate;

    /**
     * Getter method for id.
     * @return person id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     * @param id person id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for age.
     * @return person age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for age.
     * @param age person age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter method for first name.
     * @return person first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for first name.
     * @param firstName person first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter method for last name.
     * @return person last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for last name.
     * @param lastName person last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter method for email.
     * @return person email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     * @param email person email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for birth date.
     * @return person birth date.
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Setter method for birth date.
     * @param birthDate person birth date.
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
