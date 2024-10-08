import java.util.Random;

public class Personagem {
    // Atributos do personagem
    int forca = 0;
    int destreza = 0;
    int constituicao = 0;
    int agilidade = 0;
    // Pontos de vida: hp
    int hp;
    String nome;
    // Arma e armadura
    int arma;
    double armadura;
    // Armas arma = new Armas();
    // Armadura armadura = new Armadura();
    int pontos = 15; // Limite de pontos para distribuir nos atributos fase inicial
    int minPontos = 0;
    int ataque = 0;
    int dano = 0;
    double defesa = 0;
    boolean defesaDupla;
    public int maxHp = 10;

    // Métodos para adicionar atributos e distribuição de ponto
    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
        pontos -= forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
        pontos -= destreza;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
        pontos -= constituicao;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
        pontos -= agilidade;
    }

    public void setHP(int pontoConstituicao) {
        Random random = new Random();
        int dadoDe6Lados = random.nextInt(5) + 1;
        int hp = 0;

        for (int control = 0; control < 3; control++) {
            hp += dadoDe6Lados;
        }
        hp += pontoConstituicao;
        this.hp = hp;

        System.out.println("Hp no set: " + hp);

    }

    public int getHP() {
        return hp;
    }

    // Método para nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // metodos para ataque
    public void setAtaque(Armas armas) {
        // this.arma = armas;
        dano = armas.dano;
    }

    public int getAtaque() {
        return dano;
    }

    // metodos para defesa
    public void setDefesa(Armadura armadura) {
        // this.armadura = armadura;
        defesa = armadura.defesa;
    }

    public double getDefesa() {
        return defesa;
    }

    public double getdefesaDupla() {
        return defesa;
    }

    // calculo de dano recebido
    public void danoRecebido(double danoRecebido) {
        hp -= danoRecebido;
    }

    public void setdefesaDupla(Armadura armadura) {
        // this.armadura = armadura;
        defesa = armadura.defesaDupla;
    }

    public void defesaDupla() {
        this.defesaDupla = true;
        defesa = defesa*2;
        System.out.println("Você está em modo de defesa. Sua defesa foi duplicada.");
    }

    public void usarPocao() {

        int cura = 7; // Exemplo de valor de cura
        hp += cura;
        if (hp > maxHp) {
            hp = maxHp; // Garante que a vida não ultrapasse o máximo
        }
        System.out.println("Você recuperou " + cura + " de vida!");
    }

    double teste = getDefesa();

    // public void Personagem(double teste) {

    // }

}
