package JRPG;

public class Inimigos {

    String nome;
    int hp;
    int ataque;
    int defesa;
    int agilidade;
    int armadura;
    // boolean defesaDupla;

    public Inimigos(String nome, int hp, int ataque, int defesa, int agilidade, int armadura){
        this.nome = nome;
        this.hp = hp;
        this.ataque = ataque;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.armadura = armadura;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getArmadura() {
        return armadura;
    }

    public void danoRecebido(int danoRecebido){
        hp -= danoRecebido;
    }

}
