import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

public class main {
    public static void Main()throws InterruptedException{
        Scanner input = new Scanner(System.in);
        /*Texto texto = new Texto();*/
        char choice;
        
        while(true){
            System.out.println("\t1- Jogar\n\t2- Plot\n\t3- Sair");
            choice = input.next().charAt(0);
            //Limpar buffer do teclado
            input.nextLine();
            
            switch(choice){
                case '1':
                   Start();
                break;
                
                case '2':
                    Texto.Lore();
                break;

                case '3':
                    System.exit(0);
                break;
                
                default:
                    System.out.println("Valor inválido");
                break;
            }
        } 
    }
    private static void Customizacao() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        
        Personagem personagem = new Personagem();
        System.out.println("Bem-vindo ao jogo! Crie seu personagem.");
        TutorialCustom();
        System.out.print("\nDigite o nome do seu personagem: \n");
        String nome = scanner.nextLine();
        personagem.setNome(nome);

        do{
            System.out.println("Distribua seus pontos de atributo. Você tem 15 pontos para distribuir.");
            System.out.print("Força: ");
            int forca = scanner.nextInt();
            personagem.setForca(forca);
            System.out.println("pontos:"+ Personagem.pontos);
    
            System.out.print("Destreza: ");
            int destreza = scanner.nextInt();
            personagem.setDestreza(destreza);
            System.out.println("pontos:"+ Personagem.pontos);

    
            System.out.print("Constituição: ");
            int constituicao = scanner.nextInt();
            personagem.setConstituicao(constituicao);
            System.out.println("pontos:"+ Personagem.pontos);

    
            System.out.print("Agilidade: ");
            int agilidade = scanner.nextInt();
            personagem.setAgilidade(agilidade);
            System.out.println("pontos:"+ Personagem.pontos);
        } while(Personagem.pontos>=0);

        if(personagem.forca + personagem.agilidade + personagem.destreza + personagem.constituicao > 15){
        System.out.println("Voce ultrapassou o limite de pontos disponível. Reinicie a distribuição!");
        Clean();
        Thread.sleep(1000);
        Start();
        }
        /*while (Personagem.pontos>=0);*/
        

        
        // Escolher a arma
        Armas armas = new Armas();
        System.out.println("Escolha sua arma:");
        System.out.println("1. Warm Hug (leve)\n2. Sun Bath (leve)\n3. Sunny Day (pesada)\n4. Morning Star (pesada)");
        int escolhaArma = scanner.nextInt();
        if (escolhaArma == 1) {
            personagem.arma = armas.WarmHug(personagem.destreza);
        } else if (escolhaArma == 2) {
            personagem.arma = armas.SunBath(personagem.destreza);
        } else if (escolhaArma == 3) {
            personagem.arma = armas.SunnyDay(personagem.forca);
        } else if (escolhaArma == 4) {
            personagem.arma = armas.MorningStar(personagem.forca);
        }

        // Escolher a armadura
        Armadura armadura = new Armadura();
        System.out.println("Escolha sua armadura:");
        System.out.println("1. Basic\n2. Standard\n3. SomeWhere Over The Rainbow\n4. Here Comes The Sun");
        int escolhaArmadura = scanner.nextInt();
        if (escolhaArmadura == 1) {
            personagem.armadura = armadura.Basic(personagem.constituicao);
        } else if (escolhaArmadura == 2) {
            personagem.armadura = armadura.Standard(personagem.constituicao);
        } else if (escolhaArmadura == 3) {
            personagem.armadura = armadura.SomeWhereOverTheRainbow(personagem.constituicao);
        } else if (escolhaArmadura == 4) {
            personagem.armadura = armadura.HereComesTheSun(personagem.constituicao);
        }

        System.out.println("Seu personagem está pronto!");
        System.out.println("Nome: " + personagem.getNome());
        System.out.println("Força: " + personagem.forca);
        System.out.println("Destreza: " + personagem.destreza);
        System.out.println("Constituição: " + personagem.constituicao);
        System.out.println("Agilidade: " + personagem.agilidade);
        System.out.format("HP: %d " , personagem.getHP());
        System.out.println("Arma selecionada - Dano: " + personagem.arma);
        System.out.println("Armadura selecionada - Defesa: " + personagem.armadura);
    

       scanner.close();
        SistemaBatalhas.batalha();
    }
    private static void Clean(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }
    /*private static void Lore(){
        Clean();
        System.out.println(" Há muito tempo, o mundo de Aurelis foi dividido entre dois povos: os Filhos do Sol e os Filhos da Lua. Suas civilizações, separadas por montanhas de fogo e mares gelados, viviam em constante guerra, lutando por crenças antigas que sustentavam a rivalidade entre eles. Os Filhos do Sol acreditavam que o Sol era a fonte da vida e poder, abençoando-os com sua energia. Já os Filhos da Lua reverenciavam a Lua como a guardiã dos mistérios e da sabedoria, sua luz prateada guiando seus passos no mundo. Ambos os povos estavam convencidos de que a outra tribo era a culpada por suas misérias e que sua destruição garantiria a supremacia. No entanto, o que nenhum deles sabia é que, no início dos tempos, eram todos uma única raça. Foram divididos por um inimigo comum, uma força sombria que operava nas sombras, manipulando-os como peças em um jogo cruel. O Vulto Eterno manipulou as mentes dos líderes da antiga civilização, plantando a semente da desconfiança entre os povos, até que as lutas fratricidas os separassem para sempre. A guerra entre os Filhos do Sol e os Filhos da Lua era, na verdade, uma farsa perpetuada por esse inimigo, que se escondia nas sombras e prosperava na divisão.");
    }*/
    
    //Funções de tutoriais
    private static void TutorialCustom(){
        Clean();
         System.out.println("Você deve customizar seu personagem! Agora explicarei como funcionara: \nEscolhera seu nome e terá 15 pontos para dividir entre seus atributos, sendo estes: força, destreza, constituiçao, agilidade,\nconstituição, sua força será importante para armas pesadas, sua destreza para armas leves, agilidade para atacar mais rápido \ne sua constituição influenciara na sua vida,voce ira jogar 3d6 para descobrir sua vida e adicionará mais a sua constituição, depois \nescolherá sua arma e armadura, e então estará pronto para o combate.");
    }
    
    private static void Start() throws InterruptedException {
        Clean();
        System.out.println("\tVamos customizar seu pequeno herói. Pressione 'P' para começar.");
        
        Scanner input = new Scanner(System.in);
        char choice;
        
        while(true){
            choice = input.next().charAt(0);
            input.nextLine();
            
            switch(choice){
                    case 'P', 'p':
                        Customizacao();
                    break;

                    default:
                        System.out.println("Tecla inválida");
                    break;
            }
        }
        
    }
}
