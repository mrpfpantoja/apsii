package fabricas;

import ingredientes.Cheese;
import ingredientes.Clam;
import ingredientes.Dough;
import ingredientes.FreshClams;
import ingredientes.Garlic;
import ingredientes.MarinaraSauce;
import ingredientes.Mushroom;
import ingredientes.Onion;
import ingredientes.Pepperoni;
import ingredientes.RedPepper;
import ingredientes.ReggianoCheese;
import ingredientes.Sauce;
import ingredientes.SlicedPepperoni;
import ingredientes.ThinCrustDough;
import ingredientes.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { 
            new Garlic(), 
            new Onion(), 
            new Mushroom(), 
            new RedPepper() 
        };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clam createClam() {
        return new FreshClams();
    }
}