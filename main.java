
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Personagem personagem = new Personagem();
        System.out.println("Bem-vindo ao jogo! Crie seu personagem.");

        System.out.print("Digite o nome do seu personagem: ");
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
        } while (Personagem.pontos>=0);
       
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

    }
}
