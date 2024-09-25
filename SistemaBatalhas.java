import java.util.Random;
import java.util.Scanner;

public class SistemaBatalhas {

    private static Inimigos[] inimigos;
    // private Inimigos[] inimigos1;
    // private Inimigos vultoEterno;

    // Construtor da classe SistemaBatalhas
    // public SistemaBatalhas(Personagem personagem) {
    //     this.personagem = personagem;
    //     
    //     // 
    // }
    private static boolean batalha(Personagem personagem, Inimigos inimigo) {
        Scanner scanner = new Scanner(System.in);
        while (personagem.getHP() > 0 && inimigo.getHp() > 0) {
            System.out.println("Sua vida: " + personagem.getHP());
            System.out.println("Vida do inimigo (" + inimigo.getNome() + "): " + inimigo.getHp());

            // Turno do jogador
            if (turnoJogador(personagem, inimigo)) {
                // Verificar se o inimigo ainda está vivo após o ataque
                if (inimigo.getHp() > 0) {
                    // Turno do inimigo
                    Random random = new Random();
                    int acaoInimigo = random.nextInt(3); // Ação aleatória do inimigo

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
                        inimigo.recuperarHP(10); // Exemplo de recuperação de vida
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
    public static boolean turnoJogador(Personagem personagem, Inimigos inimigo) {
        Scanner input = new Scanner(System.in);

        System.out.println("Este é o seu turno, o que deseja fazer?");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Usar poção");

        int escolha = input.nextInt();
        input.nextLine();

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

                break;

        }

        return true;
    }

    public static boolean verificacaoBatalha1(Personagem personagem) {
        inimigos = new Inimigos[3];
        inimigos[0] = new Inimigos("Menino Perdido", 40, 16, 3, 2, 10, 40);
        inimigos[1] = new Inimigos("Lazuli", 30, 12, 2, 3, 10, 30);
        inimigos[2] = new Inimigos("Moony", 50, 20, 4, 1, 10, 50);

        Random random = new Random();
        int dado3Lados = random.nextInt(3); // Corrigi o valor máximo do dado

        Texto.Nivel1();
        System.out.println("Resultado do dado: " + dado3Lados);
        System.out.println("Seu inimigo é: " + inimigos[dado3Lados].getNome());

        boolean vencedor = batalha(personagem, inimigos[dado3Lados]);
       /*  if(vencedor){
            Main.Premiacao1();
        }
        else{
            Texto.Lose();
        }*/

        // // Atribuir novos pontos de vida após a batalha
        // personagem.hp = personagem.getHP(); // Assumindo que 'hp' está sendo modificado corretamente.
        return vencedor;
    }

    public static boolean verificacaoBatalha2(Personagem personagem) {
        Inimigos inimigos1[] = new Inimigos[2];
        inimigos1[0] = new Inimigos("LunaLuz", 60, 16, 5, 4, 30, 60);
        inimigos1[1] = new Inimigos("MoonDancer", 70, 15, 14, 3, 30, 60);

        Random random = new Random();
        int dado2Lados = random.nextInt(2);

        Texto.Nivel2();
        System.out.println("Resultado do dado: " + dado2Lados);
        System.out.println("Seu inimigo é: " + inimigos1[dado2Lados].getNome());

        boolean vencedor = batalha(personagem, inimigos[dado2Lados]);

        if(vencedor){
            Main.Premiacao2();
        }
        else{
            Texto.Lose();
        }

        return vencedor;
    }

    public static boolean verificacaoBatalha3(Personagem personagem) {
        Inimigos vultoEterno = new Inimigos("Vulto Eterno", 90, 40, 12, 10, 35, 90);
        Scanner scanner = new Scanner(System.in);

        Texto.Nivel3();

        System.out.println("Seu inimigo é: " + vultoEterno.getNome());

        boolean vencedor = batalha(personagem, vultoEterno);
        if(vencedor){
            Texto.Win();
        }
        else{
            Texto.Lose();
        }
        return vencedor;
    }


    //   public void subirNivel(int nivel){
    //     Personagem personagem = new Personagem();
    //     Scanner scanner = new Scanner(System.in);
    //     int pontosAtributos = nivel * 5;
        
    //     boolean verify = true;

    //     while (verify){

    //         System.out.println("Pontos Restantes: " + pontosAtributos);

    //         System.out.print("Força: ");
    //         int forca1 = scanner.nextInt();
    //         personagem.setForca(personagem.getForca()+forca1);
    //         scanner.nextLine();
                     

    //         System.out.println("Pontos Restantes: " + pontosAtributos);

    //         System.out.print("Destreza: ");
    //         int destreza1 = scanner.nextInt();
    //         personagem.setDestreza(personagem.getDestreza()+destreza1);
    //         scanner.nextLine();
            
    //         System.out.println("Pontos Restantes: " + personagem.pontos);

    //         System.out.print("Constituição: ");
    //         int constituicao1 = scanner.nextInt();
    //         personagem.setConstituicao(personagem.getConstituicao()+constituicao1);
    //         scanner.nextLine();
            
    //         System.out.println("Pontos Restantes: " + personagem.pontos);
    //         System.out.print("Agilidade: ");
    //         int agilidade1 = scanner.nextInt();
    //         personagem.setAgilidade(personagem.getAgilidade()+agilidade1);
    //         scanner.nextLine();
            

    //         System.out.println("Pontos Restantes: " + pontosAtributos);

    
            
    //         if ( personagem.pontos < 0 ) {
    //             System.out.println(personagem.pontos);
    //             System.out.println("Você ultrapassou o limite de pontos disponível. Tente novamente!");

    //         } else {
    //             verify = false;
    //         }
    //     }  


    //     int hp = personagem.pontos + personagem.getConstituicao();

    // }


}
