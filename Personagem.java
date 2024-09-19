public class Personagem { //classe de customização do personagem

    //atributos do personagem
    int forca = 0;
    int destreza = 0;
    int constituicao = 0;
    int agilidade = 0;
    //ponto de Vida: hp;
    int hp = 0;
    String nome;
    //arma e Armadura
    double arma;
    double armadura;
    boolean defesaDupla;
    
    public void Forca(int pontoForca){
        forca += pontoForca;
        pontos -= forca;
    }
    
    public void Destreza(int pontoDestreza){
        destreza += pontoDestreza;
        pontos -= destreza;
    }
    
    public void Constituicao(int pontoConstituicao){
        constituicao += pontoConstituicao;
        pontos -= constituicao;
    }
    
    public void Agilidade(int pontoAgilidade){
        agilidade += pontoAgilidade;
        pontos -= agilidade;
    }

    public void HP (int pontoConstituicao){
        //rolagem de dados e variável de controle
        Random random = new Random();
        int dadoDe6Lados = random.nextInt(5) + 1;
        
        for(int control = 0; control < 3; control++){
            hp += dadoDe6Lados;
        }
        System.out.println("HP nos dados: "+hp);
        hp += pontoConstituicao;
        System.out.println("HP total: "+hp);
    }
}

