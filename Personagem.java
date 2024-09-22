import java.util.Random;

public class Personagem {
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
    int pontos = 10; // Limite de pontos para distribuir nos atributos

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

    public int HP(int pontoConstituicao) {
        Random random = new Random();
        int dadoDe6Lados = random.nextInt(5) + 1;

        for (int control = 0; control < 3; control++) {
            hp += dadoDe6Lados;
        }
        // System.out.println("HP nos dados: " + hp);
        hp += pontoConstituicao;
        // System.out.println("HP total: " + hp);

        return hp;
    }

    // Método para definir o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para retornar o nome
    public String getNome() {
        return nome;
    }
}

