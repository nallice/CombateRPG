import java.util.Random;

public class Personagem {
    int nivelJogador;
    // Atributos do personagem
    int forca = 0;
    int destreza = 0;
    int constituicao = 0;
    int agilidade = 0;
    // Pontos de vida: hp
    int hp = 10;
    String nome;
    // Arma e armadura
    double arma;
    double armadura;
    boolean defesaDupla;
    int pontos = 15; // Limite de pontos para distribuir nos atributos

    // Métodos para adicionar atributos
    public void Forca(int pontoForca) {
        forca += pontoForca;
        pontos -= pontoForca;
    }

    public void Destreza(int pontoDestreza) {
        destreza += pontoDestreza;
        pontos -= pontoDestreza;
    }

    public void Constituicao(int pontoConstituicao) {
        constituicao += pontoConstituicao;
        pontos -= pontoConstituicao;
    }

    public void Agilidade(int pontoAgilidade) {
        agilidade += pontoAgilidade;
        pontos -= pontoAgilidade;
    }

    public void HP (int pontoConstituicao){
        //Rolagem de dados e variável de controle
        Random random = new Random();
        int dadoDe6Lados = random.nextInt(5) + 1;
        
        for(int control = 0; control < 3; control++){
            hp += dadoDe6Lados;
        }
        System.out.println("HP nos dados: "+hp);
        hp += pontoConstituicao;
        System.out.println("HP total: "+hp);
    }
    
    //Pegar oo Valor da Agilidade
    public int getAgilidade() {
        return agilidade;
    }
    
    //Pegar o Valor da Vida
    public int getHP() {
        return hp;
    }
    public void Informacoes(){
        System.out.println("\n\nAqui está as informações de seu personagem: \n");
        System.out.println("Nome: "+nome+"\nPontos de Vida(HP): "+hp+ "\nForça: "+forca+"\nDestreza: "+destreza+"\nConstituição: "+constituicao+"\nAgilidade: "+agilidade+"\nDano Arma nivel 1: "+arma+"\nArmadura nivel 1: "+armadura);
    }
}
