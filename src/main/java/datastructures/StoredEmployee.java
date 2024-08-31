package datastructures;

public class StoredEmployee {

    public String key;
    public SimpleEmployee employee;

    public StoredEmployee(String key, SimpleEmployee employee) {
        this.key = key;
        this.employee = employee;
    }
}
