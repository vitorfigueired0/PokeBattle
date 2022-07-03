package pokebatlle;
public class Pokemon {
    //atributos----------------
    private String name;
    private int life;
    private int damage;
    private int cure;
    private String type;
    //-------------------------

    public Pokemon(String name, int life, int damage, int cure, String type){
        this.name = name;
        this.life = life;
        this.damage = damage;
        this.cure = cure;
        this.type = type;
    }
    public Pokemon(String name, int life, int damage, String type){
        this.name = name;
        this.life = life;
        this.damage = damage;
        this.type = type;
    }

    //métodos----------------------------
    public String getName(){
        return name;
    }
    public int getLife(){
        return life;
    }
    public int getDamage(){
        return damage;
    }
    public int getCure(){
        return cure;
    }
    public String getType(){
        return type;
    }
    public void reciveDamage(int life, int damage){
        this.life = life - damage ;
    }
    public void selfCure(int life, int cure){
        this.life = life + cure;
    }

}

