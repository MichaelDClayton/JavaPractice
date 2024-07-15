package datastructures;

public class StoredEmployee {

    public String key;
    public datastructures.Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
}
