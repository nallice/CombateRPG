package JRPG;

import java.util.Random;

public class Armas {
    Random random = new Random();
    //dano constante
    int danoConstante = 0;
    //dano total
    int dano = 0;
    //arma leve
    int dado6Lados = random.nextInt(5) + 1;  
    int dado4Lados = random.nextInt(3) + 1;
    //arma pesada
    int dado12Lados = random.nextInt(11) + 1;
    
    //dano armas leves
    public int WarmHug(int destreza){
        danoConstante += 6;
        dano += dado6Lados + dado6Lados + dado4Lados + danoConstante;
        
        return dano;
    }
    
    public int SunBath (int destreza){
        danoConstante += 6;
        dano += dado6Lados + dado6Lados + dado4Lados + danoConstante;
        
        return dano;
    }
    
    //armas pesadas
    public int SunnyDay(int forca){
        danoConstante += 8;
        dano += danoConstante + dado12Lados + forca*1.5;
        
        return dano;
    }
    
    public int MorningStar (int forca){
        danoConstante += 10;
        dano += danoConstante + dado12Lados + forca*1.5;
        
        return dano;
    }
}
