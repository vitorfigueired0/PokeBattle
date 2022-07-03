package pokebatlle;
import java.util.Random;

public class Pokemon {
    //atributos----------------
    private String pokemonName;
    private int pokemonLife;
    private int pokemonDamage;
    private int pokemonCure;
    //-------------------------

    public Pokemon(String pokemonName, int pokemonLife, int pokemonDamage, int pokemonCure){
        this.pokemonName = pokemonName;
        this.pokemonLife = pokemonLife;
        this.pokemonDamage = pokemonDamage;
        this.pokemonCure = pokemonCure;
    }
    public Pokemon(String pokemonName, int pokemonLife, int pokemonDamage){
        this.pokemonName = pokemonName;
        this.pokemonLife = pokemonLife;
        this.pokemonDamage = pokemonDamage;
    }

    //métodos----------------------------
    public String getPokemonName(){
        return pokemonName;
    }
    public int getPokemonLife(){
        return pokemonLife;
    }
    public int getPokemonDamage(){
        return pokemonDamage;
    }
    public int getPokemonCure(){
        return pokemonCure;
    }
    public void reciveDamage(int pokemonLife, int pokemonDamage){
        int result = pokemonLife - pokemonDamage;
        this.pokemonLife = result;
    }
    public void selfCure(int pokemonLife, int pokemonCure){
        int result = pokemonLife + pokemonCure;
        this.pokemonLife = result;
    }

}

