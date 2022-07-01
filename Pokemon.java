package pokebatlle;

public class Pokemons {
    //atributos----------------
    private String pokemonName;
    private int pokemonLife;
    private int pokemonDamage;
    private int pokemonCure;
    //-------------------------

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
    public void dealDamage(int pokemonLife, int pokemonCure){
        pokemonLife -= pokemonDamage;
    }
    public void selfCure(int pokemonLife, int pokemonCure){
        this += pokemonCure;
    }
}

