
import java.util.Random;
import java.util.Scanner;

public class SistemaBatalhas {
    private Personagem personagemB;
    private Inimigos[] inimigos;
    // private Inimigos[] inimigos2f;
    
//Construtor da classe SistemaBatalhas
    public SistemaBatalhas(Personagem personagem){
        this.personagemB = personagem;
        Inimigos inimigos[] = new Inimigos[2];
            inimigos[0]=new Inimigos("Tes1", 15, 5, 5, 5);                       
            inimigos[1]=new Inimigos("Tes2", 15, 5, 5, 5);                       
            inimigos[2]=new Inimigos("Tes3", 15, 5, 5, 5);                       
}

    public boolean verificacaoBatalha1(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int dado3Lados = random.nextInt(2)+0;
        System.out.println(dado3Lados);
        System.out.println(inimigos[dado3Lados]); 
        System.out.println("Seu inimigo é:"+ inimigos[dado3Lados].getNome());
        
        boolean vencedor = batalha(scanner, inimigos[dado3Lados]);

        if (!vencedor) {
            return false;
        }
        personagemB.hp = hp//novos pontos de constituição que o usuario escolher;

    }




    private boolean batalha(Scanner scanner, Inimigos inimigo){
        while (personagemB.getHP() > 0 && inimigo.getHp() > 0) {
            System.out.println("Sua vida: " + personagemB.getHP());
            System.out.println(inimigo.getNome() + " vida: " + inimigo.getHp());

            System.out.println("Escolha sua ação:");
            System.out.println("1. Atacar");
            System.out.println("2. Fugir");

            int choice = scanner.nextInt();
            if (choice == 1) {
                inimigo.Dano(player.getAttack());
                System.out.println("Você atacou " + inimigo.getNome() + " por " + player.getAttack() + " de dano.");

                if (inimigo.getHp() > 0) {
                    player.takeDamage(enemy.getAttack());
                    System.out.println(inimigo.getNome() + " te atacou por " + enemy.getAttack() + " de dano.");
                }
            } else if (choice == 2) {
                System.out.println("Você fugiu da batalha.");
                return false;
            }
        }

        return personagemB.getHP() > 0;


    }




// void inimigos2f (Personagem personagemB){
//     // this.personagemB = personagemB;
//     this.inimigos2f = new Inimigos[]{
//         new Inimigos("Tes1", 15, 5, 5, 5),                       
//         new Inimigos("Tes2", 15, 5, 5, 5)                
//     };
// }

public boolean batalha1(Personagem personMain){

}







}
