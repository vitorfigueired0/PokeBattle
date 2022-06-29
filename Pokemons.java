package pokebatlle;

public class Pokemons {
    //atributos----------------
    private String pokemonName;
    private int pokemonLife;
    private int pokemonDamage;
    private int pokemonCure;
    //-------------------------

    //métodos----------------------------
    public void setPokemonName(String pokemonName){
        this.pokemonName = pokemonName;
    }
    public String getPokemonName(){
        return pokemonName;
    }
    public void setPokemonLife(int pokemonLife){
        this.pokemonLife = pokemonLife;
    }
    public int getPokemonLife(){
        return pokemonLife;
    }
    public void setPokemonDamage(int pokemonDamage){
        this.pokemonDamage = pokemonDamage;
    }
    public int getPokemonDamage(){
        return pokemonDamage;
    }
    public void setPokemonCure(int pokemonCure){
        this.pokemonCure = pokemonCure;
    }
    public int getPokemonCure(){
        return pokemonCure;
    }
    public int dealDamage(){
        return pokemonLife -= pokemonDamage ;
    }
    public int selfCure(){
        return pokemonLife += pokemonCure;
    }
}

