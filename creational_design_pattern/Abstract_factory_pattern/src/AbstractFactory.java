
abstract class PizzaFactory {
    public static PizzaFactory getFactory(int i) {
        if (i == 0) {
            return new MargheritaFactory();
        } else {
            return new ProsciuttoEFunghiFactory();
        }
    }

    public abstract Pizza createPizza();
}

class MargheritaFactory extends PizzaFactory {
    public Pizza createPizza() {
        return new PizzaMargherita();
    }
}

class ProsciuttoEFunghiFactory extends PizzaFactory {
    public Pizza createPizza() {
        return new PizzaProsciuttoEFunghi();
    }
}

abstract class Pizza {
    public abstract void showIngredients();
}

class PizzaMargherita extends Pizza {
    public void showIngredients() {
        System.out.println("Pomodoro e mozzarella");
    }
}

class PizzaProsciuttoEFunghi extends Pizza {
    public void showIngredients() {
        System.out.println("Prosciutto e funghi");
    }
}

public class AbstractFactory {

    /**
     * Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
     * In this example I create a Pizza without specific the pizza type, Margherita or ProsciuttoEFunghi.
     */
    public static void main(String[] args) {
        PizzaFactory factory = PizzaFactory.getFactory(1);
        Pizza pizzaProsciuttoEFunghi = factory.createPizza();
        pizzaProsciuttoEFunghi.showIngredients();

        factory = PizzaFactory.getFactory(0);
        Pizza pizzaMargherita = factory.createPizza();
        pizzaMargherita.showIngredients();
    }

}

