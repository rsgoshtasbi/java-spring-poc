package hello;

public class Schedule {

    public Schedule() {}

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;


    public Schedule(Integer id, String firstName, String lastName, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Schedule [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
