import java.util.Arrays;
import java.util.Random;

interface Pizza {
    String getIngredients();
}

class Margherita implements Pizza {
    @Override
    public String getIngredients() {
        return "Pomodoro mozzarella";
    }
}

class ProsciuttoFunghi implements Pizza {
    @Override
    public String getIngredients() {
        return "Pomodoro mozzarella prosciutto e funghi";
    }
}

class PizzaFactory {
    public PizzaFactory() {

    }

    public Pizza getPizza(int i) {
        if (i == 0)
            return new Margherita();
        else
            return new ProsciuttoFunghi();
    }
}

/**
 * Define an interface for creating a single object, but let subclasses decide which class to instantiate.
 * Factory Method lets a class defer instantiation to subclasses.
 */
public class FactoryMethodJava {
    public static void main(String[] args) {
        PizzaFactory factory = new PizzaFactory();
        Pizza[] a = new Pizza[10];
        Random r = new Random();

        for (int i = 0; i < 10; i++)
            a[i] = factory.getPizza(r.nextInt(2));

        Arrays.stream(a).map(Pizza::getIngredients).forEach(System.out::println);

    }
}