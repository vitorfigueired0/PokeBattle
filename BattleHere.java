package pokebatlle;
import java.util.Scanner;
public class BattleHere {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Pokemons pokemon = new Pokemons();
        Pokemons pokeBoss = new Pokemons();

        System.out.print("Boas vindas treinador, insira seu nome: ");
        String trainerName = inp.nextLine().trim();
        System.out.println();
        System.out.printf("Muito bem %s, para iniciar, você precisa escolher um pokemon%n", trainerName);
        int pokeChoice;
        String certain;
        pokeBoss.setPokemonName("Rayquaza");
        pokeBoss.setPokemonDamage(55);
        pokeBoss.setPokemonLife(270);
        do {
            do {
                System.out.println();
                System.out.println("Essas são suas opções:");
                System.out.println("[1] Charmander");
                System.out.println("[2] Squirtle");
                System.out.println("[3] Bulbasaur");
                System.out.println();
                System.out.print("Sua escolha: ");
                pokeChoice = inp.nextInt();
            } while (pokeChoice < 1 || pokeChoice > 3);

            System.out.println();
            System.out.print("Você escolheu: ");
            if (pokeChoice == 1) {
                pokemon.setPokemonName("Charmander");
                pokemon.setPokemonLife(190);
                pokemon.setPokemonDamage(65);
                pokemon.setPokemonCure(70);
            } else if (pokeChoice == 2) {
                pokemon.setPokemonName("Squirtle");
                pokemon.setPokemonLife(220);
                pokemon.setPokemonDamage(55);
                pokemon.setPokemonCure(75);
            } else {
                pokemon.setPokemonName("Bulbasaur");
                pokemon.setPokemonLife(230);
                pokemon.setPokemonDamage(60);
                pokemon.setPokemonCure(80);
            }
            System.out.printf("%s%n", pokemon.getPokemonName());
            System.out.println("Esses são os atributos dele: ");
            System.out.printf("Vida: %d%n", pokemon.getPokemonLife());
            System.out.printf("Dano: %d%n", pokemon.getPokemonDamage());
            System.out.printf("Cura: %d%n", pokemon.getPokemonCure());
            System.out.print("Deseja prosseguir ou trocar de pokemon? (ok / trocar): ");
            certain = inp.next().toLowerCase().trim();
        } while (certain.equals("trocar"));
        System.out.println("Muito bem, você ira enfrentar o Boss Rayquaza em uma batalha");
        System.out.println();
        System.out.println("A WILD RAYQUAZA APPEARED!!!");
        System.out.printf("%s, EU ESCOLHO VOCÊ%n", pokemon.getPokemonName());
        while (pokemon.getPokemonLife() > 0 && pokeBoss.getPokemonLife() > 0) {
            System.out.println();
            System.out.printf("Vida atual %s: %d%n", pokemon.getPokemonName(), pokemon.getPokemonLife());
            System.out.printf("Vida atual %s: %d%n", pokeBoss.getPokemonName(), pokeBoss.getPokemonLife());
            System.out.println();
            System.out.println("Seu turno, escolha uma ação: ");
            System.out.println("[A] Atacar");
            System.out.println("[C] Curar");
            String actionChoice = inp.next().toUpperCase().trim();
            if (actionChoice.equals("A")) {
                pokemon.dealDamage();
                System.out.printf("%s causou %d de dano em %s%n", pokemon.getPokemonName(), pokemon.getPokemonDamage(), pokeBoss.getPokemonName());
            } else if (actionChoice.equals("C")) {
                pokemon.selfCure();
                System.out.printf("Voce curou %d pontos%n", pokemon.getPokemonCure());
            } else {
                System.out.println("Opção inválida, você peredeu seu turno...");
            }
            System.out.printf("É a vez do boss, ele ataca %s e causa %d de dano%n", pokemon.getPokemonName(), pokeBoss.getPokemonDamage());
            pokeBoss.dealDamage();
        }
        System.out.println();
        if (pokemon.getPokemonLife() > pokeBoss.getPokemonLife()) {
            System.out.println("Você venceu, parabéns!");
        } else {
            System.out.println("O Rayquaza te amassou, sinto muito :(");
        }
    }
}