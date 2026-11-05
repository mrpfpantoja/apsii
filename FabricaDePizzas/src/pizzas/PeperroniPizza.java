package pizzas;

import fabricas.PizzaIngredientFactory;

public class PeperroniPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public PeperroniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName());
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        pepperoni = ingredientFactory.createPepperoni();
    }
}