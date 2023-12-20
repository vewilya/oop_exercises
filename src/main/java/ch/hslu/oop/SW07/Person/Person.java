package ch.hslu.oop.SW07.Person;

import java.util.Objects;
import java.util.Random;

/**
 * This <code>Person</code> class represents a person object with a given name,
 * lastname and a unique id.
 * If not handed over on object creation, the id is generated randomly.
 */
public final class Person implements Comparable<Person> {
    public static void main(String[] args) {
        Person person = new Person();
        long id = person.generateID();
        System.out.println("ID: " + id);

        // final long personID = 4235654576567L;
        Person person2 = new Person(id, "Michael", "Jordan");
        System.out.println(person2.toString());

    }

    // ---------------------- Attributes ---------------------- //

    private final long id; // immutable

    private String firstname; // absichtlich nicht final
    private String lastname; // absichtlich nicht final

    private Random random = new Random();
    // ---------------------- Constructor ---------------------- //

    /**
     * Default constructor initialises fistname and lastname and generates a random
     * id.
     */
    public Person() {
        this.firstname = "unknown";
        this.lastname = "unknown";
        this.id = generateID();
    }

    /**
     * Constructor initialises name and surename and id.
     *
     * @param id       The id of the person.
     * @param name     The name of the person.
     * @param lastname The lastname of the person.
     */
    public Person(long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // ---------------------- Getters & Setters ---------------------- //

    /**
     * Returns the firstname of the person.
     *
     * @return The firstname of the person.
     */
    public final String getFirstname() {
        return this.firstname;
    }

    /**
     * Sets the firstname of the person as a String.
     *
     * @param firstname Firstname of the person
     */
    public final void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Returns the lastname of the person object as a String.
     *
     * @return The lastname of the person
     */
    public final String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastname of the person as a String.
     *
     * @param lastname given lastname
     */
    public final void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns the unique id of the person object as a long.
     *
     * @return unique id verifier
     */
    public final long getId() {
        return id;
    }

    // ---------------------- ToString Method Override ---------------------- //
    /**
     * Override of the toString method and returns the the id and the full name of
     * the person object.
     *
     * @return Id and full name of the person.
     */
    @Override
    public String toString() {
        return "Person [ ID: " + this.id + ", Name: " + this.firstname + ", Lastname: " + this.lastname + " ]";
    }

    // ---------------------- Equals and HashCode Method Override
    // ---------------------- //

    // ---------------------- CompareTo Method Override ---------------------- //
    /**
     * Compares two person objects by their id.
     * Overrides the compareTo method of Java's <code>Comparable</code> interface.
     */
    @Override
    public final int compareTo(Person otherPerson) {
        return Long.compare(this.id, otherPerson.id);
    }

    /**
     * Overrides the inherited equals method of the Java <code>Object</code> base
     * class.
     * The method checks for equality of value types.
     *
     * @param The object to compare it with
     */
    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }

        // Checking for id only, as this is the only immutable attribute.
        return (object instanceof Person person)
                && (person.id == this.id);
        // && Objects.equals(person.id, this.id);
    }

    /**
     * Overrides the hashCode method of Java's <code>Object</code> base class.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(this.id);
    }

    // ---------------------- Private Methods ---------------------- //
    /**
     * Generates a unique ID for a Person object.
     *
     * @return a long value representing the generated ID.
     */
    private long generateID() {
        long randomID = random.nextLong();

        return randomID;
    }

}
