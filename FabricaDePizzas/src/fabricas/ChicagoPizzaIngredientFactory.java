package fabricas;

import ingredientes.BlackOlives;
import ingredientes.Cheese;
import ingredientes.Clam;
import ingredientes.Dough;
import ingredientes.Eggplant;
import ingredientes.FrozenClams;
import ingredientes.MozzarellaCheese;
import ingredientes.Pepperoni;
import ingredientes.PlumTomatoSauce;
import ingredientes.Sauce;
import ingredientes.SlicedPepperoni;
import ingredientes.Spinach;
import ingredientes.ThickCrustDough;
import ingredientes.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        // massa grossa típica do estilo Chicago deep-dish
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        // molho de tomate pelado encorpado
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        // mussarela
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        // vegetais: espinafre, azeitonas pretas e berinjela
        Veggies veggies[] = { 
            new BlackOlives(), 
            new Spinach(), 
            new Eggplant() 
        };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        // calabresa fatiada (partilhada com NY)
        return new SlicedPepperoni();
    }

    @Override
    public Clam createClam() {
        // mariscos congelados (Chicago situa-se longe da costa marítima)
        return new FrozenClams();
    }
}