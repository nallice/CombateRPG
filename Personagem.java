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
   static int pontos = 15; // Limite de pontos para distribuir nos atributos fase inicial

    // Métodos para adicionar atributos e distribuição de ponto
    public int getForca() {
        return forca;
    }
    public void setForca(int forca) {
        this.forca = forca;
        pontos-=forca;
    }
    public int getDestreza() {
        return destreza;
    }
    public void setDestreza(int destreza) {
        this.destreza = destreza;
        pontos-=destreza;
    }
    public int getConstituicao() {
        return constituicao;
    }
    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
        pontos-=constituicao;
    }
    public int getAgilidade() {
        return agilidade;
    }
    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
        pontos-=agilidade;  
    }
    public void setHP(int pontoConstituicao) {
        Random random = new Random();
        int dadoDe6Lados = random.nextInt(5) + 1;

        for (int control = 0; control < 3; control++) {
            hp += dadoDe6Lados;
        }
        // System.out.println("HP nos dados: " + hp);
        hp += pontoConstituicao;
        // System.out.println("HP total: " + hp);
    }
    public int getHP(){
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

