package lojas;

import pizzas.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        System.out.println("--- A preparar uma " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // Método de fábrica que as subclasses implementam
    protected abstract Pizza createPizza(String item);
}