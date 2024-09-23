public class Inimigos {

    String nome;
    int hp;
    int dano;
    int defesa;
    int agilidade;
    // boolean defesaDupla;

    public Inimigos(String nome, int hp, int dano, int defesa, int agilidade){
        this.nome = nome;
        this.hp = hp;
        this.dano = dano;
        this.defesa = defesa;
        this.agilidade = agilidade;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getDano() {
        return dano;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    
}
