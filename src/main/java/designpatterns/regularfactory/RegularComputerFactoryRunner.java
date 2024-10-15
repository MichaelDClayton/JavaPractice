package designpatterns.regularfactory;

public class RegularComputerFactoryRunner {
    public static void main(String[] args){
        Computer pc = RegularComputerFactory.getComputer("pc","20MB", "SSD", "Intel");
        System.out.println(pc.toString());
    }
}
