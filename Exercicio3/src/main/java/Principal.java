
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Livro livro = new Livro();
        CD cd = new CD();

        System.out.println("--- Cadastro de Livro ---");
        System.out.print("Digite o título do livro: ");
        String nomeLivro = scanner.nextLine();
        livro.setNome(nomeLivro);

        System.out.print("Digite o preço do livro: ");
        double precoLivro = scanner.nextDouble();
        livro.setPreco(precoLivro);
        scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autorLivro = scanner.nextLine();
        livro.setAutor(autorLivro);

        System.out.println("\n--- Cadastro de CD ---");
        System.out.print("Digite o título do CD: ");
        String nomeCD = scanner.nextLine();
        cd.setNome(nomeCD);

        System.out.print("Digite o preço do CD: ");
        double precoCD = scanner.nextDouble();
        cd.setPreco(precoCD);

        System.out.print("Digite a quantidade de faixas do CD: ");
        int faixasCD = scanner.nextInt();
        cd.setNumFaixas(faixasCD);

        System.out.println();
        cd.exibeInformacoes();

        scanner.close();
    }
}