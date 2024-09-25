public class Inimigos {

    String nome;
    int hp;
    int ataque;
    int defesa;
    int agilidade;
    int armadura;
    int maxHp = hp;
    // boolean defesaDupla;

    public Inimigos(String nome, int hp, int ataque, int defesa, int agilidade, int armadura, int maxHp){
        this.nome = nome;
        this.hp = hp;
        this.ataque = ataque;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.armadura = armadura;
        this.maxHp = maxHp;
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
    public void recuperarHP(int quantidadeCura) {
        int cura = 7;
        hp += cura;
        if (hp > maxHp) {
            hp = maxHp;  // Garante que a vida não ultrapasse o máximo
    }
        System.out.println(nome + " recuperou " + quantidadeCura + " de vida!");
    }
}
