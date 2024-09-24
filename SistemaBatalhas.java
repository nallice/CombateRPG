import java.util.Random;
import java.util.Scanner;

public class SistemaBatalhas {
    private Personagem personagem;
    private Inimigos[] inimigos;

    // Construtor da classe SistemaBatalhas
    public SistemaBatalhas(Personagem personagem) {
        this.personagem = personagem;
        inimigos = new Inimigos[3];  // Corrigi o tamanho do array
        inimigos[0] = new Inimigos("Menino Perdido", 40, 16, 3, 2, 10, 10);
        inimigos[1] = new Inimigos("Lazuli", 30, 12, 2, 3, 10, 10);
        inimigos[2] = new Inimigos("Moony", 50, 20, 4, 1, 10, 10);
    }

    public boolean verificacaoBatalha1() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int dado3Lados = random.nextInt(3);  // Corrigi o valor máximo do dado

        Texto.Nivel1();
        System.out.println("Resultado do dado: " + dado3Lados);
        System.out.println("Seu inimigo é: " + inimigos[dado3Lados].getNome());

        boolean vencedor = batalha(scanner, inimigos[dado3Lados]);

        if (!vencedor) {
            return false;
        }

        // Atribuir novos pontos de vida após a batalha (você pode ajustar como isso deve funcionar)
        personagem.hp = personagem.getHP(); // Assumindo que 'hp' está sendo modificado corretamente.

        return true;  // Retorne true ou false dependendo do resultado da batalha
    }

    public boolean batalha(Scanner scanner, Inimigos inimigo) {
        while (personagem.getHP() > 0 && inimigo.getHp() > 0) {
            System.out.println("Sua vida: " + personagem.getHP());
            System.out.println("Vida do inimigo (" + inimigo.getNome() + "): " + inimigo.getHp());

            // Turno do jogador
            if (turnoJogador(personagem, inimigo, scanner)) {
                // Verificar se o inimigo ainda está vivo após o ataque
                if (inimigo.getHp() > 0) {
                    // Turno do inimigo
                    Random random = new Random();
                    int acaoInimigo = random.nextInt(3);  // Ação aleatória do inimigo

                    if (acaoInimigo == 0) {
                        // Inimigo ataca
                        System.out.println("O inimigo te atacou com " + inimigo.getAtaque());
                        double danoRecebidoP = inimigo.getAtaque() - personagem.getDefesa();
                        personagem.danoRecebido(danoRecebidoP);
                        System.out.println("Sua vida: " + personagem.getHP());
                    } else if (acaoInimigo == 1) {
                        // Inimigo defende
                        System.out.println("O inimigo está se defendendo.");
                    } else if (acaoInimigo == 2) {
                        // Inimigo usa poção
                        System.out.println("O inimigo usou uma poção e recuperou parte da vida.");
                        inimigo.recuperarHP(10);  // Exemplo de recuperação de vida
                        System.out.println("Vida do inimigo: " + inimigo.getHp());
                    }
                } else {
                    System.out.println("Você derrotou " + inimigo.getNome() + "!");
                    return true;
                }
            }
        }
        // Se o personagem morrer, o jogo termina
        if (personagem.getHP() <= 0) {
            System.out.println("Você foi derrotado.");
            return false;
        }
        return true;
    }

    // Turno do jogador
    private static boolean turnoJogador(Personagem personagem, Inimigos inimigo, Scanner input) {
        System.out.println("Este é o seu turno, o que deseja fazer?");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Usar poção");

        int escolha = input.nextInt();
        input.nextLine();  // Limpa o buffer

        switch (escolha) {
            case 1:
                // Atacar
                int danoCausado = Math.max(0, personagem.getAtaque() - inimigo.getDefesa());
                inimigo.danoRecebido(danoCausado);
                System.out.println("Você causou " + danoCausado + " de dano em " + inimigo.getNome());
                break;

            case 2:
                // Defender
                personagem.defesaDupla();
                System.out.println("Você está defendendo. Sua defesa aumentou.");
                break;

            case 3:
                // Usar poção
                personagem.usarPocao();
                System.out.println("Você usou uma poção e recuperou parte da sua vida.");
                System.out.println("Sua vida atual: " + personagem.getHP());
                break;

            default:
                System.out.println("Ação inválida. Tente novamente.");
                return false;
        }

        return true;
    }
}
