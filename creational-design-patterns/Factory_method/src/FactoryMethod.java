import java.util.Arrays;
import java.util.Random;

interface Animal {
    String getCall();
}

class Dog implements Animal {
    @Override
    public String getCall() {
        return "Bau";
    }
}

class Cat implements Animal {
    @Override
    public String getCall() {
        return "Miao";
    }
}

class AnimalFactory {
    public AnimalFactory() {

    }

    public Animal getAnimal(int i) {
        if (i == 0)
            return new Cat();
        else
            return new Dog();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();
        Animal[] a = new Animal[10];
        Random r = new Random();

        for (int i = 0; i < 10; i++)
            a[i] = factory.getAnimal(r.nextInt(2));

        Arrays.stream(a).map(Animal::getCall).forEach(System.out::println);

    }
}