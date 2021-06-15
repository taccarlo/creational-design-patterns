public class Builder {
    public static void main(String[] args) {
        Cook cook = new Cook();
        PizzaBuilder margheritaPizzaBuilder = new MargheritaPizzaBuilder();
        PizzaBuilder prosciuttoEFunghiPizzaBuilder = new ProsciuttoEFunghiPizzaBuilder();

        cook.setPizzaBuilder(margheritaPizzaBuilder);
        cook.constructPizza();

        Pizza pizzaMargherita = cook.getPizza();
        System.out.println(pizzaMargherita);

        cook.setPizzaBuilder(prosciuttoEFunghiPizzaBuilder);
        cook.constructPizza();

        Pizza pizzaProsciuttoEFunghi = cook.getPizza();
        System.out.println(pizzaProsciuttoEFunghi);
    }
}

class Pizza {
    private String impasto = "";
    private String salsa = "";
    private String ingredienti = "";

    public void setDough(String a) {
        this.impasto = a;
    }

    public void setSauce(String b) {
        this.salsa = b;
    }

    public void setTopping(String c) {
        this.ingredienti = c;
    }

    @Override
    public String toString() {
        return impasto + " " + salsa + " " + ingredienti;
    }
}

/**
 * "Abstract Builder"
 */
abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizzaProduct() {
        pizza = new Pizza();
    }

    public abstract void buildDough();

    public abstract void buildSauce();

    public abstract void buildTopping();
}

/**
 * "ConcreteBuilder"
 */
class MargheritaPizzaBuilder extends PizzaBuilder {

    public void buildDough() {
        pizza.setDough("normale");
    }

    public void buildSauce() {
        pizza.setSauce("pomodoro");
    }

    public void buildTopping() {
        pizza.setTopping("pomodoro e mozzarella");
    }
}

/**
 * "ConcreteBuilder"
 */
class ProsciuttoEFunghiPizzaBuilder extends PizzaBuilder {

    public void buildDough() {
        pizza.setDough("integrale");
    }

    public void buildSauce() {
        pizza.setSauce("niente salsa");
    }

    public void buildTopping() {
        pizza.setTopping("prosciutto e funghi");
    }
}

/**
 * "Director"
 */
class Cook {

    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}
