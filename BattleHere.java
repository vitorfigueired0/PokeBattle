package pokebatlle;
import java.util.Scanner;
import java.util.Random;
public class BattleHere {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Random randint = new Random();
        Pokemon pokemon;
        Pokemon boss;

        System.out.print("Boas vindas treinador, insira seu nome: ");
        String trainerName = inp.nextLine().trim();
        System.out.println();
        System.out.printf("Muito bem %s, para iniciar, você precisa escolher um pokemon%n", trainerName);
        int pokeChoice;
        String certain;
        String restart = "s";
        while (restart.equals("s")) {
            //Seleção do pokemon
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
                    pokemon = new Pokemon("Charmander", 215, 65, 75);
                } else if (pokeChoice == 2) {
                    pokemon = new Pokemon("Squirtle", 220, 55, 70);
                } else {
                    pokemon = new Pokemon("Bulbasaur", 230, 60, 80);
                }
                System.out.printf("%s%n", pokemon.getPokemonName());
                System.out.println("Esses são os atributos dele: ");
                System.out.printf("Vida: %d%n", pokemon.getPokemonLife());
                System.out.printf("Dano: %d%n", pokemon.getPokemonDamage());
                System.out.printf("Cura: %d%n", pokemon.getPokemonCure());
                System.out.print("Deseja prosseguir ou trocar de pokemon? (ok / trocar): ");
                certain = inp.next().toLowerCase().trim();
            } while (certain.equals("trocar"));
            //Batalha
            boss = new Pokemon("Rayquaza", 300, 85);
            System.out.println("Muito bem, você ira enfrentar o Boss Rayquaza em uma batalha");
            System.out.println();
            System.out.println("A WILD RAYQUAZA APPEARED!!!");
            System.out.printf("%s, EU ESCOLHO VOCÊ%n", pokemon.getPokemonName());
            while (pokemon.getPokemonLife() > 0 && boss.getPokemonLife() > 0) {
                System.out.println();
                System.out.printf("Vida atual %s: %d%n", pokemon.getPokemonName(), pokemon.getPokemonLife());
                System.out.printf("Vida atual %s: %d%n", boss.getPokemonName(), boss.getPokemonLife());
                System.out.println();
                System.out.println("Seu turno, escolha uma ação: ");
                System.out.println("[A] Atacar");
                System.out.println("[C] Curar");
                String actionChoice = inp.next().toUpperCase().trim();
                if (actionChoice.equals("A")) {
                    int roundDamage = randint.nextInt(pokemon.getPokemonDamage());
                    boss.reciveDamage(boss.getPokemonLife(), roundDamage);
                    System.out.printf("%s causou %d de dano em %s%n", pokemon.getPokemonName(), roundDamage, boss.getPokemonName());
                } else if (actionChoice.equals("C")) {
                    int cure = randint.nextInt(pokemon.getPokemonCure());
                    pokemon.selfCure(pokemon.getPokemonLife(), cure);
                    System.out.printf("Voce curou %d pontos%n", cure);
                } else {
                    System.out.println("Opção inválida, você peredeu seu turno...");
                }

                if (boss.getPokemonLife() > 0) {
                    int roundDamage = randint.nextInt(boss.getPokemonDamage());
                    pokemon.reciveDamage(pokemon.getPokemonLife(), roundDamage);
                    System.out.printf("É o turno do boss, ele ataca %s e causa %d de dano%n", pokemon.getPokemonName(), roundDamage);
                }
            }
            System.out.println();
            if (pokemon.getPokemonLife() > boss.getPokemonLife()) {
                System.out.printf("%s desmaiou%n", boss.getPokemonName());
                System.out.println("Você venceu, parabéns!");
            } else {
                System.out.printf("%s desmaiou%n", pokemon.getPokemonName());
                System.out.println("O Rayquaza te amassou, sinto muito :(");
            }
            System.out.print("Deseja jogar novamente?(s/n): ");
            restart = inp.next().toLowerCase().trim();
        }
        System.out.println();
        System.out.println("Obrigado pela batalha treinador :D");
    }
}