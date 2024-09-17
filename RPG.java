import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int opcao;
        Scanner leitor = new Scanner(System.in);

        do {
            System.out.println("Menu Principal");
            System.out.println("1. Iniciar jogo");
            System.out.println("2. História");
            System.out.println("3. Sair");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("JOGO INICIA");
                    break;
                case 2:
                    System.out.println("HISTORIA");
                    break;
                case 3:
                    System.out.println("ENCERRAMENTO DO PROGRAMA");
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
                    break;
            }

        } while (opcao != 3);
    }
}
