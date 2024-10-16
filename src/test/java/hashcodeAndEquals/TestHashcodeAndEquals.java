package hashcodeAndEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Set;

@RunWith(JUnit4.class)
public class TestHashcodeAndEquals {
    @Test
    public void test_Objects_Equal(){

        Set<Shoe> shoeSet = new HashSet<>();
        Shoe shoe = new Shoe("Nike", "Black");
        Shoe shoe1 = new Shoe("Nike", "Black");
        shoeSet.add(shoe);
        shoeSet.add(shoe1);
        Assert.assertEquals(shoe.hashCode(), shoe1.hashCode());
        Assert.assertEquals(1, shoeSet.size());

        Set<Animal> animalSet = new HashSet<>();
        Animal animal = new Animal("Tiger", "Orange");
        Animal animal1 = new Animal("Tiger", "Orange");
        animalSet.add(animal);
        animalSet.add(animal1);
        Assert.assertNotEquals(animal.hashCode(), animal1.hashCode());
        Assert.assertEquals(2, animalSet.size());
    }
}
