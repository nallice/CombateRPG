

public class Armadura {
    int defesaConstante = 0;
    double defesa = 0;
   
    public double Basic(int constituicao){ 
        defesaConstante = 11;
        defesa = defesaConstante + constituicao*1.5;
        return defesa;
    }
    
    public double Standard (int constituicao){
        defesaConstante = 12;
        defesa = defesaConstante + constituicao*1.5;
        return defesa;
    }
    
    public double SomeWhereOverTheRainbow (int constituicao){ 
        defesaConstante = 17;
        defesa = defesaConstante + constituicao*1.5;
        return defesa;
    }
    
    public double HereComesTheSun (int constituicao){ 
        defesaConstante = 18;
        defesa = defesaConstante + constituicao*1.5;
        return defesa;
    }
    
}
