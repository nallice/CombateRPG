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
    int arma;
    double armadura;
    // Armas arma = new Armas();
    // Armadura armadura = new Armadura();
    static int pontos = 15; // Limite de pontos para distribuir nos atributos fase inicial
    int ataque=0;
    int dano=0;
    double defesa=0;
    int defesaDupla=0;
    boolean defendendo;

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
    // Método para nome
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    //metodos para ataque
    public void setAtaque(Armas armas){
        // this.arma = armas;
        dano = armas.dano;
    }
    public int getAtaque(){
        return dano;
    }
    // metodos para defesa
    public void setDefesa(Armadura armadura){
        // this.armadura = armadura;
        defesa = armadura.defesa;       
    }
    public double getDefesa(){
        return defesa;
    }
    // calculo de dano recebido
    public void danoRecebido(double danoRecebido){
        hp -= danoRecebido;
    }

double teste = getDefesa();

    
    public Personagem(double teste){
        

    }


 }

