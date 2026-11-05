package pizzas;

import fabricas.PizzaIngredientFactory;

public class ClamPizza extends Pizza {
    // Referência para a fábrica de ingredientes injetada
    PizzaIngredientFactory ingredientFactory;

    // Construtor que recebe a fábrica regional específica
    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName());
        
        // Solicita à fábrica os ingredientes necessários para a pizza de mariscos
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();
    }
}