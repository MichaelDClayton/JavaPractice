package designpatterns.abstractfactory;


import designpatterns.regularfactory.Computer;

public class ComputerAbstractFactoryRunner {
    public static void main(String[] args){
        Computer pc = ComputerFactory.getComputer(new PCFactory("20MB","SSD","Intel"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("20MB","SSD","Intel Server"));
        System.out.println(pc.toString());
        System.out.println(server.toString());

    }
}
