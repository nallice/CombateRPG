import java.util.Scanner;

public class VerificacaoInput {
   
    public static int LerNumero(String prompt, int EscolhaDoJogador)
    {
        Scanner scanner = new Scanner(System.in);
        int input;
        do
        {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            }
            catch(Exception e)
            {
                input = -1;
                System.out.println("Digite um numero!");
            }
        }while (input < 1 || input > EscolhaDoJogador);
        return input;
    }
}
