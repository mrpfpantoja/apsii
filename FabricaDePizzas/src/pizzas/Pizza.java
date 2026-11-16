package pizzas;

import ingredientes.Cheese;
import ingredientes.Clam;
import ingredientes.Dough;
import ingredientes.Pepperoni;
import ingredientes.Sauce;
import ingredientes.Veggies;

public abstract class Pizza {

    // de ingredientes para cada pizza
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clam clam;

    //os ingredientes seraorecolhidos da fabrica
    public abstract void prepare();

    public void bake() {
        System.out.println("Assar por 25 minutos a 350°");
    }

    public void cut() {
        System.out.println("Cortar a pizza em fatias diagonais");
    }

    public void box() {
        System.out.println("Colocar a pizza na caixa oficial da pizzaria");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("---- ").append(name).append(" ----\n");
        if (dough != null) {
            result.append(dough.getNome()).append("\n");
        }
        if (sauce != null) {
            result.append(sauce.getNome()).append("\n");
        }
        if (cheese != null) {
            result.append(cheese.getNome()).append("\n");
        }
        if (veggies != null) {
            for (int i = 0; i < veggies.length; i++) {
                result.append(veggies[i].getNome());
                if (i < veggies.length - 1) {
                    result.append(", ");
                }
            }
            result.append("\n");
        }
        if (clam != null) {
            result.append(clam.getNome()).append("\n");
        }
        if (pepperoni != null) {
            result.append(pepperoni.getNome()).append("\n");
        }
        return result.toString();
    }
}