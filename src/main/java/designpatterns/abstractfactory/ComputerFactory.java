package designpatterns.abstractfactory;

import designpatterns.regularfactory.Computer;

public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
