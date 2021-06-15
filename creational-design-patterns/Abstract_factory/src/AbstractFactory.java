public class AbstractFactory {

    /**
     * L'Abstract factory (letteralmente, "fabbrica astratta")
     * fornisce un'interfaccia per creare famiglie di oggetti
     * connessi o dipendenti tra loro, in modo che non ci sia
     * necessità da parte degli utilizzatori di specificare i
     * nomi delle classi concrete all'interno del proprio codice.
     *
     * @param args
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
