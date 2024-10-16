import entity.Person;

public class Test {
    public static void main(String[] args) {
       Person p = new Person("Mike", 50);
       Person p1 = new Person("Mike", 50);

       System.out.println(p.hashCode());
       System.out.println(p1.hashCode());
    }






}
