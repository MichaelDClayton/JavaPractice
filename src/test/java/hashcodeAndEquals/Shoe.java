package hashcodeAndEquals;


import java.util.Objects;

public class Shoe {
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Shoe(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Shoe shoe = (Shoe)o;
        return Objects.equals(name, shoe.name) && Objects.equals(color, shoe.color);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, color);
    }

}

