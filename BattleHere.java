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
                    pokemon = new Pokemon("Charmander", 215, 75, 75, "Fogo");
                } else if (pokeChoice == 2) {
                    pokemon = new Pokemon("Squirtle", 220, 65, 70, "Água");
                } else {
                    pokemon = new Pokemon("Bulbasaur", 230, 70, 80, "Planta");
                }
                System.out.printf("%s%n", pokemon.getName());
                System.out.println("Esses são os atributos dele: ");
                System.out.printf("Vida: %d%n", pokemon.getLife());
                System.out.printf("Dano: %d%n", pokemon.getDamage());
                System.out.printf("Cura: %d%n", pokemon.getCure());
                System.out.printf("Tipo: %s%n", pokemon.getType());
                if (pokemon.getType().equals("Fogo")){
                    System.out.println("Esse tipo é forte contra Planta e fraco contra Água");
                }
                else if (pokemon.getType().equals("Água")){
                    System.out.println("Esse tipo é forte contra Fogo e fraco contra Planta");
                }
                else {
                    System.out.println("Esse tipo é forte contra Água e fraco conta Fogo");
                }
                System.out.print("Deseja prosseguir ou trocar de pokemon? (ok / trocar): ");
                certain = inp.next().toLowerCase().trim();
            } while (certain.equals("trocar"));
            do {
                System.out.println();
                System.out.println("Agora, escolha um Boss para desafiar: ");
                System.out.println("[1] Arcanine");
                System.out.println("[2] Gyrados");
                System.out.println("[3] Victreebel");
                System.out.println();
                System.out.print("Sua escolha: ");
                pokeChoice = inp.nextInt();
            }while (pokeChoice < 1 || pokeChoice > 3);
            if(pokeChoice == 1){
                boss = new Pokemon("Arcanine", 315, 85, "Fogo");
            }
            else if(pokeChoice == 2){
                boss = new Pokemon("Gyrados", 320, 80, "Água");
            }
            else{
                boss = new Pokemon("Victreebel", 330, 75, "Planta");
            }
            //Batalha
            System.out.println();
            System.out.printf("Muito bem, você ira enfrentar o Boss %s em uma batalha", boss.getName());
            System.out.println();
            System.out.printf("A WILD %s APPEARED!!!%n", boss.getName().toUpperCase());
            System.out.printf("%s, EU ESCOLHO VOCÊ%n", pokemon.getName());
            while (pokemon.getLife() > 0 && boss.getLife() > 0) {
                System.out.println();
                System.out.printf("Vida atual %s: %d%n", pokemon.getName(), pokemon.getLife());
                System.out.printf("Vida atual %s: %d%n", boss.getName(), boss.getLife());
                System.out.println();
                System.out.println("Seu turno, escolha uma ação: ");
                System.out.println("[A] Atacar");
                System.out.println("[C] Curar");
                String actionChoice = inp.next().toUpperCase().trim();
                if (actionChoice.equals("A")) {
                    int roundDamage = randint.nextInt(pokemon.getDamage());
                    if (pokemon.getType().equals("Fogo")){
                        if (boss.getType().equals(pokemon.getType())){
                            boss.reciveDamage(boss.getLife(), roundDamage);
                        }
                        else if (boss.getType().equals("Água")){
                            roundDamage /= 2;
                            boss.reciveDamage(boss.getLife(), roundDamage);
                        }
                        else {
                            roundDamage *= 2;
                            boss.reciveDamage(boss.getLife(), roundDamage);
                        }
                    }
                    else if (pokemon.getType().equals("Água")) {
                        if (boss.getType().equals(pokemon.getType())) {
                            boss.reciveDamage(boss.getLife(), roundDamage);
                        } else if (boss.getType().equals("Planta")) {
                            roundDamage /= 2;
                            boss.reciveDamage(boss.getLife(), roundDamage);
                        } else {
                            roundDamage *= 2;
                            boss.reciveDamage(boss.getLife(), roundDamage);
                        }
                    }
                    else {
                        if (boss.getType().equals(pokemon.getType())) {
                            boss.reciveDamage(boss.getLife(), roundDamage);
                        } else if (boss.getType().equals("Fogo")) {
                            roundDamage /= 2;
                            boss.reciveDamage(boss.getLife(), roundDamage);
                        } else {
                            roundDamage *= 2;
                            boss.reciveDamage(boss.getLife(), roundDamage);
                        }
                    }
                    System.out.printf("%s atacou %s e causou %d de dano%n",pokemon.getName(), boss.getName(), roundDamage);
                }
                else if (actionChoice.equals("C")) {
                    int cure = randint.nextInt(pokemon.getCure());
                    pokemon.selfCure(pokemon.getLife(), cure);
                    System.out.printf("Voce curou %d pontos%n", cure);
                } else {
                    System.out.println("Opção inválida, você peredeu seu turno...");
                }

                if (boss.getLife() > 0) {
                    int roundDamage = randint.nextInt(boss.getDamage());
                    if(boss.getType().equals("Fogo")){
                        if (boss.getType().equals(pokemon.getType())){
                            pokemon.reciveDamage(pokemon.getLife(), roundDamage);
                            System.out.printf("É o turno do boss, ele ataca %s e causa %d de dano%n", pokemon.getName(), roundDamage);
                        }
                        else if (pokemon.getType().equals("Água")){
                            roundDamage /= 2;
                            pokemon.reciveDamage(pokemon.getLife(), roundDamage);
                            System.out.printf("É o turno do boss, ele ataca %s e causa %d de dano%n", pokemon.getName(), roundDamage);
                        }
                        else {
                            roundDamage *= 2;
                            pokemon.reciveDamage(pokemon.getLife(), roundDamage);
                            System.out.printf("É o turno do boss, ele ataca %s e causa %d de dano%n", pokemon.getName(), roundDamage);
                        }
                    }
                    else if (boss.getType().equals("Água")){
                        if (boss.getType().equals(pokemon.getType())){
                            pokemon.reciveDamage(pokemon.getLife(), roundDamage);
                            System.out.printf("É o turno do boss, ele ataca %s e causa %d de dano%n", pokemon.getName(), roundDamage);
                        }
                        else if (pokemon.getType().equals("Planta")){
                            roundDamage /= 2;
                            pokemon.reciveDamage(pokemon.getLife(), roundDamage);
                            System.out.printf("É o turno do boss, ele ataca %s e causa %d de dano%n", pokemon.getName(), roundDamage);
                        }
                        else {
                            roundDamage *= 2;
                            pokemon.reciveDamage(pokemon.getLife(), roundDamage);
                            System.out.printf("É o turno do boss, ele ataca %s e causa %d de dano%n", pokemon.getName(), roundDamage);
                        }
                    }
                    else {
                        if (boss.getType().equals(pokemon.getType())){
                            pokemon.reciveDamage(pokemon.getLife(), roundDamage);
                            System.out.printf("É o turno do boss, ele ataca %s e causa %d de dano%n", pokemon.getName(), roundDamage);
                        }
                        else if (pokemon.getType().equals("Fogo")){
                            roundDamage /= 2;
                            pokemon.reciveDamage(pokemon.getLife(), roundDamage);
                            System.out.printf("É o turno do boss, ele ataca %s e causa %d de dano%n", pokemon.getName(), roundDamage);
                        }
                        else {
                            roundDamage *= 2;
                            pokemon.reciveDamage(pokemon.getLife(), roundDamage);
                            System.out.printf("É o turno do boss, ele ataca %s e causa %d de dano%n", pokemon.getName(), roundDamage);
                        }
                    }
                }
            }
            System.out.println();
            if (pokemon.getLife() > boss.getLife()) {
                System.out.printf("%s desmaiou%n", boss.getName());
                System.out.println("Você venceu, parabéns!");
            } else {
                System.out.printf("%s desmaiou%n", pokemon.getName());
                System.out.println("O Rayquaza te amassou, sinto muito :(");
            }
            System.out.print("Deseja jogar novamente?(s/n): ");
            restart = inp.next().toLowerCase().trim();
        }
        System.out.println();
        System.out.println("Obrigado pela batalha treinador :D");
    }
}