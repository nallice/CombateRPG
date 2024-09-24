import java.util.Random;
import java.util.Scanner;

public class SistemaBatalhas {
    private Personagem personagem;
    private Inimigos[] inimigos;
    // private Inimigos[] inimigos2f;

        //Construtor da classe SistemaBatalhas
        public SistemaBatalhas(Personagem personagem){
            this.personagem = personagem;
            Inimigos inimigos[] = new Inimigos[2];
                inimigos[0]=new Inimigos("Menino Perdido", 40, 16, 3, 2,10);                       
                inimigos[1]=new Inimigos("Lazuli", 30, 12, 2, 3,10);                       
                inimigos[2]=new Inimigos("Moony", 50, 20, 4, 1,10);                       
                 }          
                
                public boolean verificacaoBatalha1(){
                Scanner scanner = new Scanner(System.in);
                Random random = new Random();
                int dado3Lados = random.nextInt(2)+0;
                Texto.Nivel1();
                System.out.println(dado3Lados);
                System.out.println(inimigos[dado3Lados]); 
                System.out.println("Seu inimigo é:"+ inimigos[dado3Lados].getNome());
                
                boolean vencedor = batalha(scanner, inimigos[dado3Lados]);

                if (!vencedor) {
                    return false;
                }
                personagem.hp = hp;//novos pontos de constituição que o usuario escolher;

                }

                public boolean batalha(Scanner scanner, Inimigos inimigo){
                    while (personagem.getHP() > 0 && inimigo.getHp() > 0) {
                        System.out.println("Sua vida: " + personagem.getHP());
                        System.out.println(inimigo.getNome() + " vida: " + inimigo.getHp());

                        turno(personagem, inimigo);
                        if (turno(personagem, inimigo)) {
                        System.out.println("Escolha sua ação:");
                        System.out.println("1. Atacar");
                        System.out.println("2. Fugir");
                        System.out.println("3. usar porção");
                        int choice = scanner.nextInt();
                            if (choice == 1) {
                                //turno personagem
                                //personagem ataque
                                System.out.println("Você atacou o inimgo com:"+ personagem.getAtaque());
                                int danoRecebidoI = personagem.getAtaque() - inimigo.armadura;
                                inimigo.danoRecebido(danoRecebidoI);
                                System.out.println("Vida inimigo:"+ inimigo.getHp());

                                if (inimigo.getHp()>0) {
                                    //turno inimigo
                                    Random random = new Random();
                                    int dado3Lados = random.nextInt(2)+0;
                                    if (dado3Lados==0) {
                                        //inimigo ataque
                                        System.out.println("o inimigo te atacou com"+ inimigo.ataque);
                                        double danoRecebidoP = inimigo.ataque - personagem.getDefesa();
                                        personagem.danoRecebido(danoRecebidoP);
                                        System.out.println("Sua vida:"+ personagem.getHP());
                                    }
                                    else if (dado3Lados==1) {
                                        //defender
                                        
                                        
                                    }
                                    else if (dado3Lados==2) {
                                        //usar porção
                                    }
                                }
                            }
                        } 


                        
            }
        }
        
        

        
            // if (choice == 1) {

            //     inimigo.Dano(player.getAttack());
            //     System.out.println("Você atacou " + inimigo.getNome() + " por " + player.getAttack() + " de dano.");

            //     if (inimigo.getHp() > 0) {
            //         player.takeDamage(enemy.getAttack());
            //         System.out.println(inimigo.getNome() + " te atacou por " + enemy.getAttack() + " de dano.");
            //     }
            // } else if (choice == 2) {
            //     System.out.println("Você fugiu da batalha.");
            //     return false;
            // }
        

        return personagem.getHP() > 0;
    }
}
private boolean turno(Personagem personagem, Inimigos inimigo){
    if (personagem.agilidade>inimigo.agilidade) {
        return true;
    }else{
        return false;
    }
}
