import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

public class Main {
    public static void main(String [] args)throws InterruptedException{
        Scanner input = new Scanner(System.in);
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
        System.out.println("Distribua seus pontos de atributo. Você tem " + personagem.pontos + " pontos para distribuir.");

        int value = personagem.pontos;
        
        boolean verify = true;

        while (verify){
            personagem.pontos = value;

            System.out.println("Pontos Restantes: " + personagem.pontos);

            System.out.print("Força: ");
            int forca = scanner.nextInt();
            personagem.setForca(forca);
            scanner.nextLine();
                     

            System.out.println("Pontos Restantes: " + personagem.pontos);
            System.out.print("Destreza: ");
            int destreza = scanner.nextInt();
            personagem.setDestreza(destreza);
            scanner.nextLine();
            
            System.out.println("Pontos Restantes: " + personagem.pontos);
            System.out.print("Constituição: ");
            int constituicao = scanner.nextInt();
            personagem.setConstituicao(constituicao);
            scanner.nextLine();
            
            System.out.println("Pontos Restantes: " + personagem.pontos);
            System.out.print("Agilidade: ");
            int agilidade = scanner.nextInt();
            personagem.setAgilidade(agilidade);
            scanner.nextLine();
            

            System.out.println("Pontos Restantes: " + personagem.pontos);

    
            
            if ( personagem.pontos < 0 ) {
                System.out.println(personagem.pontos);
                System.out.println("Você ultrapassou o limite de pontos disponível. Tente novamente!");

            } else {
                verify = false;
            }
        }  
        
        /*while (Personagem.pontos>=0);*/
        

        
        // Escolher a arma
        Armas armas = new Armas();
        System.out.println("Escolha sua arma:");
        System.out.println("1. Warm Hug (leve)\n2. SunnyDay (pesada)\n");
        int escolhaArma = scanner.nextInt();
        if (escolhaArma == 1) {
            personagem.arma = armas.WarmHug(personagem.destreza);
        } /*else if (escolhaArma == 2) {
            personagem.arma = armas.SunBath(personagem.destreza);
        }*/ else if (escolhaArma == 2) {
            personagem.arma = armas.SunnyDay(personagem.forca);
        } /*else if (escolhaArma == 4) {
            personagem.arma = armas.MorningStar(personagem.forca);
        }*/

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
        System.out.println("Força: " + personagem.getForca());
        System.out.println("Destreza: " + personagem.getDestreza());
        System.out.println("Constituição: " + personagem.getConstituicao());
        System.out.println("Agilidade: " + personagem.getAgilidade());
        System.out.format("HP: %d " , personagem.getHP());
        System.out.println("Arma selecionada - Dano: " + personagem.arma);
        System.out.println("Armadura selecionada - Defesa: " + personagem.armadura);
        
        Clean();
       }

    

    private static void Combate() {

        while(true) {
            SistemaBatalhas.verificacaoBatalha1();
            SistemaBatalhas.verificacaoBatalha2();
            SistemaBatalhas.verificacaoBatalha3();


            Texto.Lose();

        
        }
    }

    private static void Clean(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }

    
    //Funções de tutoriais
    private static void TutorialCustom(){
        Clean();
         System.out.println("Você deve customizar seu personagem! Agora explicarei como funcionara: \nEscolhera seu nome e terá 15 pontos para dividir entre seus atributos, sendo estes: força, destreza, constituiçao, agilidade,\nconstituição, sua força será importante para armas pesadas, sua destreza para armas leves, agilidade para atacar mais rápido \ne sua constituição influenciara na sua vida,voce ira jogar 3d6 para descobrir sua vida e adicionará mais a sua constituição, depois \nescolherá sua arma e armadura, e então estará pronto para o combate.");}
    
    
    public static void Start() throws InterruptedException {
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
                        Combate();
                    break;
                    default:
                        System.out.println("Tecla inválida");
                    break;
            }
        }
    
    

    }
}      
