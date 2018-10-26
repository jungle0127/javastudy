package sms.model;

/**
 * 分数
 */
public class Grade extends Entity{
    public Grade() {
    }

    public Grade(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id='" + id + '\'' +
                '}';
    }
}
