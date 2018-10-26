package sms.model;

/**
 * 选课
 */
public class Enrolment extends Entity{
    public Enrolment() {
    }

    public Enrolment(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Enrolment{" +
                "id='" + id + '\'' +
                '}';
    }
}
