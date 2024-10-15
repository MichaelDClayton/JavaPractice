package designpatterns.regularfactory;

public class RegularComputerFactory {
    public static Computer getComputer(String type, String ram, String hdd, String cpu){
        if(type.equalsIgnoreCase("PC")){
            return new PC("20MB", "SSD", "INTEL");
        }else if(type.equalsIgnoreCase("SERVER")){
            return new Server("20MB", "SSD", "INTEL");
        }
        return null;
    }
}
