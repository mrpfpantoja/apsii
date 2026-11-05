package fabricas;

import ingredientes.Cheese;
import ingredientes.Clam;
import ingredientes.Dough;
import ingredientes.Pepperoni;
import ingredientes.Sauce;
import ingredientes.Veggies;

public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clam createClam();

}