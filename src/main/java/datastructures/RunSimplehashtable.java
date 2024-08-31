package datastructures;

public class RunSimplehashtable {

    public static void main(String[] args) {
        SimpleEmployee janeJones = new SimpleEmployee("Jane", "Jones", 123);
        SimpleEmployee johnDoe = new SimpleEmployee("John", "Doe", 4567);
        SimpleEmployee marySmith = new SimpleEmployee("Mary", "Smith", 22);
        SimpleEmployee mikeWilson = new SimpleEmployee("Mike", "Wilson", 3245);
        SimpleEmployee billEnd = new SimpleEmployee("Bill", "End", 78);
        SimpleEmployee janeJones2 = new SimpleEmployee("Jane2", "Jones2", 123);

        datastructures.SimpleHashtable ht = new SimpleHashtable();
        ht.put("Jones", janeJones);
        ht.put("Jones", janeJones2);
        ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);

        ht.printHashtable();

        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
        System.out.println("Retrieve key Smith: " + ht.get("Smith"));

       // ht.remove("Wilson");
       // ht.remove("Jones");
        ht.printHashtable();

        System.out.println("Retrieve key Smith: " + ht.get("Smith"));



    }

}
