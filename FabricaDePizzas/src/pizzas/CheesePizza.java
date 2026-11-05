package pizzas;

import fabricas.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
    // Referência para a fábrica de ingredientes abstrata injetada
    PizzaIngredientFactory ingredientFactory;

    // Cada subclasse de Pizza recebe a fábrica no seu construtor
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName());
        
        // A pizza solicita à fábrica a criação dos seus ingredientes específicos
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}