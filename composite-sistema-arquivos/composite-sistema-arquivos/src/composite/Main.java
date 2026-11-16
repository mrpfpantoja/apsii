package composite;

import java.util.Scanner;

/** Client: um mini terminal que só conhece ComponenteSistema e Pasta. */
public class Main {

    public static void main(String[] args) {
        Pasta raiz = new Pasta("raiz");
        Pasta atual = raiz;

        // Dados iniciais para facilitar a demonstração
        Pasta docs = new Pasta("documentos", raiz);
        docs.adicionar(new Arquivo("trabalho.docx", 120));
        docs.adicionar(new Arquivo("slides.pptx", 850));
        Pasta fotos = new Pasta("fotos", docs);
        fotos.adicionar(new Arquivo("praia.jpg", 2400));
        fotos.adicionar(new Arquivo("familia.png", 1800));
        docs.adicionar(fotos);
        raiz.adicionar(docs);
        raiz.adicionar(new Arquivo("leia-me.txt", 2));

        System.out.println("=== Simulador de Sistema de Arquivos (Padrão Composite) ===");
        ajuda();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\n" + caminho(atual) + " > ");
            if (!sc.hasNextLine()) break;
            String[] p = sc.nextLine().trim().split("\\s+");
            if (p[0].isEmpty()) continue;

            try {
                switch (p[0]) {
                    case "mkdir" -> atual.adicionar(new Pasta(arg(p, 1), atual));
                    case "touch" -> atual.adicionar(new Arquivo(arg(p, 1), Long.parseLong(arg(p, 2))));
                    case "rm" -> {
                        if (!atual.remover(arg(p, 1))) System.out.println("Não encontrado.");
                    }
                    case "ls" -> atual.getFilhos().forEach(c ->
                            System.out.println((c instanceof Pasta ? "📁 " : "📄 ") + c.getNome()
                                    + " (" + c.getTamanho() + " KB)"));
                    case "tree" -> atual.exibir("");
                    case "size" -> {
                        ComponenteSistema alvo = p.length > 1 ? atual.buscar(p[1]) : atual;
                        if (alvo == null) System.out.println("Não encontrado.");
                        else System.out.println(alvo.getNome() + ": " + alvo.getTamanho() + " KB");
                    }
                    case "cd" -> {
                        String destino = arg(p, 1);
                        if (destino.equals("..")) {
                            if (atual.getPai() != null) atual = atual.getPai();
                        } else if (atual.buscar(destino) instanceof Pasta pasta) {
                            atual = pasta;
                        } else {
                            System.out.println("Pasta não encontrada.");
                        }
                    }
                    case "ajuda" -> ajuda();
                    case "sair" -> { return; }
                    default -> System.out.println("Comando inválido. Digite 'ajuda'.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static String arg(String[] p, int i) {
        if (i >= p.length) throw new IllegalArgumentException("Argumento faltando.");
        return p[i];
    }

    private static String caminho(Pasta p) {
        return p.getPai() == null ? "/" + p.getNome() : caminho(p.getPai()) + "/" + p.getNome();
    }

    private static void ajuda() {
        System.out.println("""
                Comandos:
                  mkdir <nome>          cria pasta
                  touch <nome> <kb>     cria arquivo com tamanho em KB
                  rm <nome>             remove arquivo ou pasta
                  ls                    lista a pasta atual
                  tree                  mostra a árvore a partir da pasta atual
                  size [nome]           tamanho total (de um item ou da pasta atual)
                  cd <nome> | cd ..     navega entre pastas
                  ajuda | sair""");
    }
}
