
import java.util.Scanner;
import java.util.Random
import java.lang.Thread;

public class Main {
    //Função de iniciar o game
    private static void Start() throws InterruptedException{
        Clean();
        System.out.println("\tSe desejas jogar, pressione 'P");
        //Identificar o IO
import java.util.Scanner;
//Valor Aleatório
import java.util.Random;
//Sleep
import java.lang.Thread;

//Função main na classe principal
public class Main {
    //Função de iniciar o game
    private static void Start() throws InterruptedException{
        Clean();
        System.out.println("\tSe desejas jogar, pressione 'P");
        
        Scanner input = new Scanner(System.in);
        char choice;
        
        while(true){
            choice = input.next().charAt(0);
            input.nextLine();
            
            switch(choice){
                    case 'P', 'p':
                        Custom();
                    break;

                    case '2':
                        //StandardCharacters();
                    break;

                    default:
                        System.out.println("Tecla inválida");
                    break;
            }
        }
        
    }
    
    //Função para a customização
    private static void Custom() throws InterruptedException{
        Scanner input = new Scanner(System.in);
        char choice;
                
        TutorialCustom();
        
        System.out.println("\n\nPressione qualquer tecla para continuar");
        choice = input.next().charAt(0);
        input.nextLine();
        
        while(true){
            Personagem Character = new Personagem();
            
            Clean();
               
            System.out.println("\n\n\tPontos de Atributos: "+Character.pontos);
            System.out.print("\nForça: ");
            Character.Forca(input.nextInt());

            System.out.println("\n\n\tPontos de Atributos: "+Character.pontos);
            System.out.print("\nDestreza: ");
            Character.Destreza(input.nextInt());

            System.out.println("\n\n\tPontos de Atributos: "+Character.pontos);
            System.out.print("\n\nConstituição: ");
            Character.Constituicao(input.nextInt());

            System.out.println("\n\n\tPontos de Atributos: "+Character.pontos);
            System.out.print("\nAgilidade: ");
            Character.Agilidade(input.nextInt());
                        
            if(Character.pontos > 0 || Character.pontos == 0 ){
                while(true){
                    System.out.println("Aperte '1' para continuar ou '0' para refazer");
                    choice = input.next().charAt(0);
                    input.nextLine();

                    if(choice == '1'){
                        Armas arma = new Armas();
                        System.out.println("\n\n\tEscolha sua arma\n\n1- WarmHug\n2- SunBath");

                        char Choicearma = input.next().charAt(0);
                        input.nextLine();

                        switch(Choicearma){
                            case '1':
                                Character.arma = arma.WarmHug(Character.destreza);
                            break;

                            case '2':
                                Character.arma = arma.SunBath(Character.destreza);
                            break;
                        }

                        Armadura armor = new Armadura();
                        System.out.println("\n\n\tEscolha sua armadura\n\n1- Sunflower\n2- Sunday Morning");

                        char ChoiceArmor = input.next().charAt(0);
                        input.nextLine();

                        switch(ChoiceArmor){
                            case '1':
                                Character.armadura = armor.SunFlower(Character.constituicao);
                            break;

                            case '2':
                                Character.armadura = armor.SundayMorning(Character.constituicao);
                            break;
                        }

                        System.out.println("\nCalculando vida...");
                        Character.HP(Character.constituicao);
                        Thread.sleep(2000);

                        System.out.print("\n\nEscolha o nome de seu personagem: ");
                        Character.nome = input.next();

                        Character.Informacoes();

                        System.out.println("\n\tIniciando Combate...");
                        Thread.sleep(3000);

                        TutorialCombat();
                        System.out.println("\nPressione qualquer tecla para continuar");
                        choice = input.next().charAt(0);
                        input.nextLine();

                        Character.nivelJogador = 0;
                        while(Character.hp > 0) {
                            Inimigos enemies = gerarAdversarioAleatorio(Character.nivelJogador);
                            Combat(Character, enemies);
                            if (Character.hp <= 0) {
                                System.out.println("FALECEU, foi pro inferno.");
                                System.exit(0);
                                break;
                            }
                            else
                            {
                                Character.nivelJogador++;
                            }
                            if (Character.nivelJogador == 3 && Character.hp > 0) {
                                System.out.println("Você venceu o jogo! Parabéns!\n");
                                System.exit(0);
                                break;
                            }
                        }
                    break;
                }
                else{
                    System.out.println("Você ultrapassou o limite de atributos, refaça");
                    Thread.sleep(2000);
                }
            }
            
           }
        }
    }
    
    //Função para combate
    private static void Combat(Personagem Character, Inimigos enemies){
        Scanner input = new Scanner(System.in);
        Clean();
        
        int rodada = 1;
        
        while (true) {
            System.out.println("Rodada " + rodada + "\n");
            System.out.println("Kombat...FIGHT");
            
            int agilidadeJogador = Character.getAgilidade();
            int agilidadeAdversario = enemies.agilidade;

            if (agilidadeJogador > agilidadeAdversario) {
                turnoJogador(Character, enemies, input);
                if (enemies.hp <= 0) {
                    System.out.println("Você venceu o combate contra " + enemies.nome + "!");
                    System.out.println("");
                    break;
                }

                turnoAdversario(Character, enemies, input);
                if (Character.getHP() <= 0) {
                    System.out.println(enemies.nome + "Você morreu! Bem Vindo ao Lado Sombrio da Lua");
                    
                    break;
                }
            } else {
                turnoAdversario(Character, enemies, input);
                if (Character.getHP() <= 0) {
                    System.out.println(enemies.nome + "Você morreu! Bem Vindo ao Lado Sombrio da Lua");
                    break;
                }

                turnoJogador(Character, enemies, input);
                if (enemies.hp <= 0) {
                    System.out.println("Você venceu o combate contra " + enemies.nome + "!");
                    System.out.println("Pressione Enter para continuar...\n");
                    input.nextLine();
                    break;
                }
            }

            rodada++;
        }
    }
    
    //lore do jogo
    private static void Lore(){
        Clean();
        System.out.println(" Há muito tempo, o mundo de Aurelis foi dividido entre dois povos: os Filhos do Sol e os Filhos da Lua. Suas civilizações, separadas por montanhas de fogo e mares gelados, viviam em constante guerra, lutando por crenças antigas que sustentavam a rivalidade entre eles. Os Filhos do Sol acreditavam que o Sol era a fonte da vida e poder, abençoando-os com sua energia. Já os Filhos da Lua reverenciavam a Lua como a guardiã dos mistérios e da sabedoria, sua luz prateada guiando seus passos no mundo. Ambos os povos estavam convencidos de que a outra tribo era a culpada por suas misérias e que sua destruição garantiria a supremacia. No entanto, o que nenhum deles sabia é que, no início dos tempos, eram todos uma única raça. Foram divididos por um inimigo comum, uma força sombria que operava nas sombras, manipulando-os como peças em um jogo cruel. O Vulto Eterno manipulou as mentes dos líderes da antiga civilização, plantando a semente da desconfiança entre os povos, até que as lutas fratricidas os separassem para sempre. A guerra entre os Filhos do Sol e os Filhos da Lua era, na verdade, uma farsa perpetuada por esse inimigo, que se escondia nas sombras e prosperava na divisão.");
    }
    
    //Funções de tutoriais
    private static void TutorialCustom(){
        Clean();
         System.out.println("Como você decidiu utilizar um personagem customizado, agora explicarei como funcionara:\n Escolhera seu nome, e terá 15 pontos para dividir entre seus respectivos atributos, força, destreza, constituiçao, agilidade\nconstituição, sua força será importante para armas pesadas, sua destreza para armas leves, agilidade para atacar mais rápido e\nconstituição influenciara na sua vida,voçe ira jogar 3d6 para descobrir sua vida e adicionará mais a sua constituição, depois\nescolherá sua arma e armadura, e então estará pronto para o combate.");
    }
    
    private static void TutorialCombat(){
        System.out.println("Você deve customizar seu personagem! Agora explicarei como funcionara:\n Escolhera seu nome e terá 15 pontos para dividir entre seus atributos, sendo estes: força, destreza, constituiçao, agilidade\nconstituição, sua força será importante para armas pesadas, sua destreza para armas leves, agilidade para atacar mais rápido e\n sua constituição influenciara na sua vida,voce ira jogar 3d6 para descobrir sua vida e adicionará mais a sua constituição, depois\nescolherá sua arma e armadura, e então estará pronto para o combate.");
    }
    
    //Função para "limpar" o console
    private static void Clean(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    public static void main(String[] args) throws InterruptedException{
        Scanner input = new Scanner(System.in);
        
        char choise;
        
        while(true){
            System.out.println("\t1- Jogar\n\t2- Plot\n\t3- Sair");
            choise = input.next().charAt(0);
            //Limpar buffer do teclado
            input.nextLine();
            
            switch(choise){
                case '1':
                   Start();
                break;
                
                case '2':
                    Lore();
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

    //Turno do Jogador
    private static void turnoJogador(Personagem Character, Inimigos enemies, Scanner input){
        System.out.println("Agora é sua vez, o que deseja fazer?");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");

        int escolha = input.nextInt();
        input.nextLine();

        switch (escolha) {

            case 1:
                int danoCausado = Math.max(0, (int)Character.arma - enemies.defesa);
                if (danoCausado > 0) {
                    enemies.hp -= (int)Character.arma;
                    System.out.println("Você causou " + Character.arma + " de dano em " + enemies.nome + "!");
                } else {
                    System.out.println(enemies.nome + " se defendeu completamente!");
                }
                break;

            case 2:
                Character.defesaDupla = true;
                System.out.println("Você está defendendo. Sua defesa dobrou por uma rodada.");
                break;

            default:
                System.out.println("Ação inválida. Tente novamente.");
        }

        if (Character.defesaDupla) {
            Character.defesaDupla = false;
        }
}
    
    //Turno do Adversário
    private static void turnoAdversario(Personagem Character, Inimigos enemies, Scanner input) {
        Random random = new Random();
        int escolha = random.nextInt(3);
        input.nextLine();
        
        switch (escolha) {

            case 0:
                int danoCausado = Math.max(0, enemies.dano - (int)Character.armadura);
                if (danoCausado > 0) {
                    Character.hp -= danoCausado;
                    System.out.println(enemies.nome + " causou " + danoCausado + " de dano em você!");
                } else {
                    System.out.println("Você se defendeu completamente contra o ataque de " + enemies.nome + "!");
                }
                break;

            case 1:
                enemies.defesaDupla = true;
                System.out.println(enemies.nome + " está defendendo. Sua defesa dobrou por uma rodada.");
                break;
        }

        if (enemies.defesaDupla) {
            enemies.defesaDupla = false;
        }
}
   
    //Adversário Aleatório
    private static Inimigos gerarAdversarioAleatorio(int nivel){
    
        Random random = new Random();
        int escolha = random.nextInt(3);
        int escolha2 = random.nextInt(2);
        int escolha3 = random.nextInt(1);
        
        if(nivel==0){
            
            return switch (escolha) {
                case 0 -> new Inimigos ("Menino Perdido", 40, 16, 3, 2);
                case 1 -> new Inimigos ("Lazuli", 30, 12, 2, 3);
                case 2 -> new Inimigos ("Moony", 50, 20, 4, 1);
                default -> new Inimigos ("Inimigo Aleatório", 25, 14, 3, 2);
            };
            
        }
        
        if(nivel==1){
            
            return switch (escolha2) {
                case 0 -> new Inimigos ("LunaLuz", 60, 16, 5, 4);
                case 1 -> new Inimigos ("MoonDancer", 70, 15, 14, 3);
                default -> new Inimigos ("Inimigo Aleatório", 25, 14, 3, 2);
            };
            
        }
        
        if(nivel==2){
            
            return switch (escolha3) {
                case 0 -> new Inimigos ("Vulto Eterno", 90, 40, 12, 10);
                default -> new Inimigos ("Vulto Eterno", 90, 40, 12, 10);
            };
            
        }
        return null;
        
    }  
    
    //Dado de 6 lados
    private static int rolarD6() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
        Scanner input = new Scanner(System.in);
        char choice;
        
        while(true){
            choice = input.next().charAt(0);
            input.nextLine();
            
            switch(choice){
                    case 'P', 'p':
                        Custom();
                    break;

                    case '2':
                        //StandardCharacters();
                    break;

                    default:
                        System.out.println("Tecla inválida");
                    break;
            }
        }
        
    }
    
    //Função para a customização
    private static void Custom() throws InterruptedException{
        Scanner input = new Scanner(System.in);
        char choice;
                
        TutorialCustom();
        
        System.out.println("\n\nPressione qualquer tecla para continuar");
        choice = input.next().charAt(0);
        input.nextLine();
        
        while(true){
            Personagem Character = new Personagem();
            
            Clean();
               
            System.out.println("\n\n\tPontos de Atributos: "+Character.pontos);
            System.out.print("\nForça: ");
            Character.Forca(input.nextInt());

            System.out.println("\n\n\tPontos de Atributos: "+Character.pontos);
            System.out.print("\nDestreza: ");
            Character.Destreza(input.nextInt());

            System.out.println("\n\n\tPontos de Atributos: "+Character.pontos);
            System.out.print("\n\nConstituição: ");
            Character.Constituicao(input.nextInt());

            System.out.println("\n\n\tPontos de Atributos: "+Character.pontos);
            System.out.print("\nAgilidade: ");
            Character.Agilidade(input.nextInt());
                        
            if(Character.pontos > 0 || Character.pontos == 0 ){
                while(true){
                    System.out.println("Aperte '1' para continuar ou '0' para refazer");
                    choice = input.next().charAt(0);
                    input.nextLine();

                    if(choice == '1'){
                        Armas arma = new Armas();
                        System.out.println("\n\n\tEscolha sua arma\n\n1- Katana\n2- Machadinha");

                        char Choicearma = input.next().charAt(0);
                        input.nextLine();

                        switch(Choicearma){
                            case '1':
                                Character.arma = arma.WarmHug(Character.destreza);
                            break;

                            case '2':
                                Character.arma = arma.SunBath(Character.destreza);
                            break;
                        }

                        Armadura armor = new Armadura();
                        System.out.println("\n\n\tEscolha sua armadura\n\n1- Camisa do Vasco\n2- Comum");

                        char ChoiceArmor = input.next().charAt(0);
                        input.nextLine();

                        switch(ChoiceArmor){
                            case '1':
                                Character.armadura = armor.Basic(Character.constituicao);
                            break;

                            case '2':
                                Character.armadura = armor.Standard(Character.constituicao);
                            break;
                        }

                        System.out.println("\nCalculando vida...");
                        Character.HP(Character.constituicao);
                        Thread.sleep(2000);

                        System.out.print("\n\nEscolha o nome de seu personagem: ");
                        Character.nome = input.next();

                        Character.Informacoes();

                        System.out.println("\n\tIniciando Combate...");
                        Thread.sleep(3000);

                        TutorialCombat();
                        System.out.println("\nPressione qualquer tecla para continuar");
                        choice = input.next().charAt(0);
                        input.nextLine();

                        Character.nivelJogador = 0;
                        while(Character.hp > 0) {
                            Inimigos enemies = gerarAdversarioAleatorio(Character.nivelJogador);
                            Combat(Character, enemies);
                            if (Character.hp <= 0) {
                                System.out.println("FALECEU, foi pro inferno.");
                                System.exit(0);
                                break;
                            }
                            else
                            {
                                Character.nivelJogador++;
                            }
                            if (Character.nivelJogador == 3 && Character.hp > 0) {
                                System.out.println("Você venceu o jogo! Parabéns!\n");
                                System.exit(0);
                                break;
                            }
                        }
                    break;
                }
                else{
                    System.out.println("Você ultrapassou o limite de atributos, refaça");
                    Thread.sleep(2000);
                }
            }
            
           }
        }
    }
    
    //Função para combate
    private static void Combat(Personagem Character, Inimigos enemies){
        Scanner input = new Scanner(System.in);
        Clean();
        
        int rodada = 1;
        
        while (true) {
            System.out.println("Rodada " + rodada + "\n");
            System.out.println("Kombat...FIGHT");
            
            int agilidadeJogador = Character.getAgilidade();
            int agilidadeAdversario = enemies.agilidade;

            if (agilidadeJogador > agilidadeAdversario) {
                turnoJogador(Character, enemies, input);
                if (enemies.hp <= 0) {
                    System.out.println("Você venceu o combate contra " + enemies.nome + "!");
                    System.out.println("");
                    break;
                }

                turnoAdversario(Character, enemies, input);
                if (Character.getHP() <= 0) {
                    System.out.println(enemies.nome + "Você morreu! Bem Vindo ao Lado Sombrio da Lua");
                    
                    break;
                }
            } else {
                turnoAdversario(Character, enemies, input);
                if (Character.getHP() <= 0) {
                    System.out.println(enemies.nome + "Você morreu! Bem Vindo ao Lado Sombrio da Lua");
                    break;
                }

                turnoJogador(Character, enemies, input);
                if (enemies.hp <= 0) {
                    System.out.println("Você venceu o combate contra " + enemies.nome + "!");
                    System.out.println("Pressione Enter para continuar...\n");
                    input.nextLine();
                    break;
                }
            }

            rodada++;
        }
    }
    
    //lore do jogo
    private static void Lore(){
        Clean();
        System.out.println(" Há muito tempo, o mundo de Aurelis foi dividido entre dois povos: os Filhos do Sol e os Filhos da Lua. Suas civilizações, separadas por montanhas de fogo e mares gelados, viviam em constante guerra, lutando por crenças antigas que sustentavam a rivalidade entre eles. Os Filhos do Sol acreditavam que o Sol era a fonte da vida e poder, abençoando-os com sua energia. Já os Filhos da Lua reverenciavam a Lua como a guardiã dos mistérios e da sabedoria, sua luz prateada guiando seus passos no mundo. Ambos os povos estavam convencidos de que a outra tribo era a culpada por suas misérias e que sua destruição garantiria a supremacia. No entanto, o que nenhum deles sabia é que, no início dos tempos, eram todos uma única raça. Foram divididos por um inimigo comum, uma força sombria que operava nas sombras, manipulando-os como peças em um jogo cruel. O Vulto Eterno manipulou as mentes dos líderes da antiga civilização, plantando a semente da desconfiança entre os povos, até que as lutas fratricidas os separassem para sempre. A guerra entre os Filhos do Sol e os Filhos da Lua era, na verdade, uma farsa perpetuada por esse inimigo, que se escondia nas sombras e prosperava na divisão.");
    }
    
    //Funções de tutoriais
    private static void TutorialCustom(){
        Clean();
         System.out.println("Como você decidiu utilizar um personagem customizado, agora explicarei como funcionara:\n Escolhera seu nome, e terá 15 pontos para dividir entre seus respectivos atributos, força, destreza, constituiçao, agilidade\nconstituição, sua força será importante para armas pesadas, sua destreza para armas leves, agilidade para atacar mais rápido e\nconstituição influenciara na sua vida,voçe ira jogar 3d6 para descobrir sua vida e adicionará mais a sua constituição, depois\nescolherá sua arma e armadura, e então estará pronto para o combate.");
    }
    
    private static void TutorialCombat(){
        System.out.println("Você deve customizar seu personagem! Agora explicarei como funcionara:\n Escolhera seu nome e terá 15 pontos para dividir entre seus atributos, sendo estes: força, destreza, constituiçao, agilidade\nconstituição, sua força será importante para armas pesadas, sua destreza para armas leves, agilidade para atacar mais rápido e\n sua constituição influenciara na sua vida,voce ira jogar 3d6 para descobrir sua vida e adicionará mais a sua constituição, depois\nescolherá sua arma e armadura, e então estará pronto para o combate.");
    }
    
    //Função para "limpar" o console
    private static void Clean(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    public static void main(String[] args) throws InterruptedException{
        Scanner input = new Scanner(System.in);
        
        char choise;
        
        while(true){
            System.out.println("\t1- Jogar\n\t2- Plot\n\t3- Sair");
            choise = input.next().charAt(0);
            //Limpar buffer do teclado
            input.nextLine();
            
            switch(choise){
                case '1':
                   Start();
                break;
                
                case '2':
                    Lore();
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

    //Turno do Jogador
    private static void turnoJogador(Personagem Character, Inimigos enemies, Scanner input){
        System.out.println("Agora é sua vez, o que deseja fazer?");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");

        int escolha = input.nextInt();
        input.nextLine();

        switch (escolha) {

            case 1:
                int danoCausado = Math.max(0, (int)Character.arma - enemies.defesa);
                if (danoCausado > 0) {
                    enemies.hp -= (int)Character.arma;
                    System.out.println("Você causou " + Character.arma + " de dano em " + enemies.nome + "!");
                } else {
                    System.out.println(enemies.nome + " se defendeu completamente!");
                }
                break;

            case 2:
                Character.defesaDupla = true;
                System.out.println("Você está defendendo. Sua defesa dobrou por uma rodada.");
                break;

            default:
                System.out.println("Ação inválida. Tente novamente.");
        }

        if (Character.defesaDupla) {
            Character.defesaDupla = false;
        }
}
    
    //Turno do Adversário
    private static void turnoAdversario(Personagem Character, Inimigos enemies, Scanner input) {
        Random random = new Random();
        int escolha = random.nextInt(3);
        input.nextLine();
        
        switch (escolha) {

            case 0:
                int danoCausado = Math.max(0, enemies.dano - (int)Character.armadura);
                if (danoCausado > 0) {
                    Character.hp -= danoCausado;
                    System.out.println(enemies.nome + " causou " + danoCausado + " de dano em você!");
                } else {
                    System.out.println("Você se defendeu completamente contra o ataque de " + enemies.nome + "!");
                }
                break;

            case 1:
                enemies.defesaDupla = true;
                System.out.println(enemies.nome + " está defendendo. Sua defesa dobrou por uma rodada.");
                break;
        }

        if (enemies.defesaDupla) {
            enemies.defesaDupla = false;
        }
}
   
    //Adversário Aleatório
    private static Inimigos gerarAdversarioAleatorio(int nivel){
    
        Random random = new Random();
        int escolha = random.nextInt(3);
        int escolha2 = random.nextInt(2);
        int escolha3 = random.nextInt(1);
        
        if(nivel==0){
            
            return switch (escolha) {
                case 0 -> new Inimigos ("Menino Perdido", 40, 16, 3, 2);
                case 1 -> new Inimigos ("Lazuli", 30, 12, 2, 3);
                case 2 -> new Inimigos ("Moony", 50, 20, 4, 1);
                default -> new Inimigos ("Inimigo Aleatório", 25, 14, 3, 2);
            };
            
        }
        
        if(nivel==1){
            
            return switch (escolha2) {
                case 0 -> new Inimigos ("LunaLuz", 60, 16, 5, 4);
                case 1 -> new Inimigos ("MoonDancer", 70, 15, 14, 3);
                default -> new Inimigos ("Inimigo Aleatório", 25, 14, 3, 2);
            };
            
        }
        
        if(nivel==2){
            
            return switch (escolha3) {
                case 0 -> new Inimigos ("Vulto Eterno", 90, 40, 12, 10);
                default -> new Inimigos ("Vulto Eterno", 90, 40, 12, 10);
            };
            
        }
        return null;
        
    }  
    
    //Dado de 6 lados
    private static int rolarD6() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
