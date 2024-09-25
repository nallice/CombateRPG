import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Personagem personagem = new Personagem();
        VerificacaoInput verificacaoInput = new VerificacaoInput();
        char choice;

        while (true) {
            System.out.println("\t1- Jogar\n\t2- Plot\n\t3- Sair");
            choice = input.next().charAt(0);
            // Limpar buffer do teclado
            input.nextLine();

            switch (choice) {
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
            input.close();
        }

    }

    private static void Customizacao(Personagem personagem) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao jogo! Crie seu personagem.");
        TutorialCustom();
        System.out.print("\nDigite o nome do seu personagem: \n");
        String nome = scanner.nextLine();
        personagem.setNome(nome);
        System.out.println(
                "Distribua seus pontos de atributo. Você tem " + personagem.pontos + " pontos para distribuir.");

        int value = personagem.pontos;

        boolean verify = true;

        while (verify) {
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

            if (personagem.pontos < 0) {
                System.out.println(personagem.pontos);
                System.out.println("Você ultrapassou o limite de pontos disponível. Tente novamente!");

            } else {
                verify = false;
            }
        }

        /* while (Personagem.pontos>=0); */
        // Escolher a arma
        Armas armas = new Armas();
        System.out.println("Escolha sua arma:");
        System.out.println("1. Warm Hug (leve)\n2. SunnyDay (pesada)\n");
        int escolhaArma = VerificacaoInput.LerNumero("->", 2);
        if (escolhaArma == 1) {
            personagem.arma = armas.WarmHug(personagem.destreza);
        } else if (escolhaArma == 2) {
            personagem.arma = armas.SunnyDay(personagem.forca);
        }

        // Escolher a armadura
        Armadura armadura = new Armadura();
        System.out.println("Escolha sua armadura:");
        System.out.println("1. SunGoesDown\n2. SunFlower\n");
        int escolhaArmadura = VerificacaoInput.LerNumero("->", 2);
        if (escolhaArmadura == 1) {
            personagem.armadura = armadura.SunGoesDown(personagem.constituicao);
        } else if (escolhaArmadura == 2) {
            personagem.armadura = armadura.SunFlower(personagem.constituicao);
        }

        personagem.setHP(personagem.getConstituicao());

        System.out.println("Seu personagem está pronto!");
        System.out.println("Nome: " + personagem.getNome());
        System.out.println("Força: " + personagem.getForca());
        System.out.println("Destreza: " + personagem.getDestreza());
        System.out.println("Constituição: " + personagem.getConstituicao());
        System.out.println("Agilidade: " + personagem.getAgilidade());
        System.out.format("HP: %d ", personagem.getHP());
        System.out.println("Arma selecionada - Dano: " + personagem.arma);
        System.out.println("Armadura selecionada - Defesa: " + personagem.armadura);


        Clean();

        // Premiacao1();

    }

    private static void Combate(Personagem personagem) {

        while (true) {
            SistemaBatalhas.verificacaoBatalha1(personagem);
            SistemaBatalhas.verificacaoBatalha2(personagem);
            SistemaBatalhas.verificacaoBatalha3(personagem);

            Texto.Lose();

        }
    }

    private static void Clean() {
        System.out.println(
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }

    // Funções de tutoriais
    private static void TutorialCustom() {
        Clean();
        System.out.println(
                "Você deve customizar seu personagem! Agora explicarei como funcionara: \nEscolhera seu nome e terá 15 pontos para dividir entre seus atributos, sendo estes: força, destreza, constituiçao, agilidade,\nconstituição, sua força será importante para armas pesadas, sua destreza para armas leves, agilidade para atacar mais rápido \ne sua constituição influenciara na sua vida,voce ira jogar 3d6 para descobrir sua vida e adicionará mais a sua constituição, depois \nescolherá sua arma e armadura, e então estará pronto para o combate.");
    }

    public static void Premiacao2() {
        Scanner premio = new Scanner(System.in);
        Personagem personagem = new Personagem();

        Armadura armadura = new Armadura();
        System.out.println("Escolha sua nova armadura:");
        System.out.println("1. SomeWhereOverTheRainbow\n2. SunRoof\n3.HereComesTheSun");
        int escolhaArmadura = premio.nextInt();
        if (escolhaArmadura == 1) {
            personagem.armadura = armadura.SunGoesDown(personagem.constituicao);
        } else if (escolhaArmadura == 2) {
            personagem.armadura = armadura.SunFlower(personagem.constituicao);
        } else if (escolhaArmadura == 3) {
            personagem.armadura = armadura.HereComesTheSun(personagem.constituicao);
        }
        int newHP = personagem.getHP() + personagem.getConstituicao();
        personagem.hp = newHP;
        System.out.println("Seu novo HP é: %d " + newHP);
        System.out.println("Você recebeu 10 pontos para acrescentar aos seus atributos");
        int novosPontos = 10;

        boolean verify = true;
        while (verify) {
            System.out.println("Pontos disponíveis: \n" + novosPontos);
            System.out.println("Sua força atual é: " + personagem.getForca());
            System.out.println("Quanto voce gostaria de adicionar a ela? ");
            int novaForca = premio.nextInt();
            personagem.setForca(personagem.forca += novaForca);
            premio.nextLine();

            System.out.println("Sua destreza atual é: " + personagem.getDestreza());
            System.out.println("Quanto voce gostaria de adicionar a ela? ");
            int novaDestreza = premio.nextInt();
            personagem.setDestreza(personagem.destreza += novaDestreza);
            premio.nextLine();

            System.out.println("Sua constituiçao atual é: " + personagem.getConstituicao());
            System.out.println("Quanto voce gostaria de adicionar a ela? ");
            int novaConstituicao = premio.nextInt();
            personagem.setConstituicao(personagem.constituicao += novaConstituicao);
            premio.nextLine();

            System.out.println("Sua agilidade atual é: " + personagem.getAgilidade());
            System.out.println("Quanto voce gostaria de adicionar a ela? ");
            int novaAgilidade = premio.nextInt();
            personagem.setAgilidade(personagem.agilidade += novaAgilidade);
            premio.nextLine();

            System.out.printf("Novos valores de atributos:\nForca: \n Destreza: \n Constituição: \nAgilidade: \n"
                    + personagem.forca, +personagem.destreza, +personagem.constituicao, +personagem.agilidade);
        }

    }

    public static void Premiacao1() {
        Scanner premio = new Scanner(System.in);
        Personagem personagem = new Personagem();
        Armas arma = new Armas();

        System.out.println("Escolha sua nova arma:");
        System.out.println("1. SunBath \n2. TanningSword\n3. MorningStar");
        int escolhaArma = premio.nextInt();
        if (escolhaArma == 1) {
            personagem.arma = arma.SunBath(personagem.forca);
        } else if (escolhaArma == 2) {
            personagem.arma = arma.SunnyDay(personagem.forca);
        } else if (escolhaArma == 3) {
            personagem.arma = arma.MorningStar(personagem.forca);
        }
        int newHP = personagem.getHP() + personagem.getConstituicao();
        personagem.hp = newHP;
        System.out.println("Seu novo HP é: " + newHP);

        System.out.println("Você recebeu 5 pontos para acrescentar aos seus atributos");
        int novosPontos = 5;
        boolean verify = true;
        while (verify) {
            System.out.println("Pontos disponíveis: \n" + novosPontos);
            System.out.println("Sua força atual é: " + personagem.getForca());
            System.out.println("Quanto voce gostaria de adicionar a ela? ");
            int novaForca = premio.nextInt();
            personagem.setForca(personagem.forca += novaForca);
            premio.nextLine();

            System.out.println("Sua destreza atual é: " + personagem.getDestreza());
            System.out.println("Quanto voce gostaria de adicionar a ela? ");
            int novaDestreza = premio.nextInt();
            personagem.setDestreza(personagem.destreza += novaDestreza);
            premio.nextLine();

            System.out.println("Sua constituiçao atual é: " + personagem.getConstituicao());
            System.out.println("Quanto voce gostaria de adicionar a ela? ");
            int novaConstituicao = premio.nextInt();
            personagem.setConstituicao(personagem.constituicao += novaConstituicao);
            premio.nextLine();

            System.out.println("Sua agilidade atual é: " + personagem.getAgilidade());
            System.out.println("Quanto voce gostaria de adicionar a ela? ");
            int novaAgilidade = premio.nextInt();
            personagem.setAgilidade(personagem.agilidade += novaAgilidade);
            premio.nextLine();

            System.out.printf("Novos valores de atributos:\nForca: \n Destreza: \n Constituição: \nAgilidade: \n"
                    + personagem.forca, +personagem.destreza, +personagem.constituicao, +personagem.agilidade);
        }

    }

    public static void Start() throws InterruptedException {
        Clean();
        System.out.println("\tVamos customizar seu pequeno herói. Pressione 'P' para começar.");

        Scanner input = new Scanner(System.in);
        char choice;

        while (true) {
            choice = input.next().charAt(0);
            input.nextLine();

            switch (choice) {
                case 'P', 'p':
                    Personagem personagem = new Personagem();
                    Customizacao(personagem);
                    Combate(personagem);
                    break;
                default:
                    System.out.println("Tecla inválida");

            }
            
        }

    }
}
