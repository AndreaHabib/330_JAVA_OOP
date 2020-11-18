//Import scanner
import java.util.Scanner;

public class PokemonRunner {
    public static void main(String arg[]) {
        System.out.println("Welcome to the Pokemon game!");

        //instantiate Items
        Item HPitem = new HPitem();
        Item PPitem = new PPitem();

        //instantiate 2 pokemons
        Pokemon pikachu = new Pikachu();
        Pokemon bulbasaur = new Bulbasaur();

        //initialize empty default human and computer players
        //Note: required since the if statements require initialization before instantiating the objects
        Player human = new HumanPlayer();
        Player computer = new ComputerPlayer();

        System.out.println("Choose your pokemon!\n");
        System.out.println("1 for Pikachu or 2 for Bulbasaur");

        Scanner input = new Scanner(System.in);

        System.out.print("Pokemon: ");
        int pokemon = input.nextInt();

        System.out.println("\nChoose your item!\n");
        System.out.println("1 for Hit points potion or 2 for Power Points potion");
        System.out.print("Item: ");
        int item = input.nextInt();

        //user choice
        //if user chose 1, instantiate HumanPlayer with pikachu and computer with other pokemon and vice versa
        if(pokemon == 1 && item == 1 ) {
            human = new HumanPlayer(pikachu, HPitem);
            computer = new ComputerPlayer(bulbasaur, HPitem);
        }
        else if(pokemon == 2 && item == 1) {
            human = new HumanPlayer(bulbasaur, HPitem);
            computer = new ComputerPlayer(pikachu, HPitem);
        }
        else if(pokemon == 1 && item == 2) {
            human = new HumanPlayer(pikachu, PPitem);
            computer = new ComputerPlayer(bulbasaur, PPitem);
        }
        else if(pokemon == 2 && item == 2) {
            human = new HumanPlayer(bulbasaur, PPitem);
            computer = new ComputerPlayer(pikachu, PPitem);
        }
        else {
            //if not 1 or 2, then exit program
            System.out.println("Error!");
            System.exit(-1);
        }

        //show pokemon used by each player
        System.out.println("Human used " + human.getPokemon().getName() + "!");
        System.out.println("Computer used " + computer.getPokemon().getName() + "!\n");

        //using do while loop...
        do {

            //print out the stats for human and computer's pokemons
            System.out.println("Human");
            System.out.println(human);
            System.out.println("Computer");
            System.out.println(computer);

            if(!computer.getIsRun()) {
                //human attacks computer, then computer attacks human
                human.menu(computer.getPokemon());
            }
            if(!human.getIsRun()) {
                computer.menu(human.getPokemon());

            }

        }
        while(!human.isWin(computer)); //while this is true

    }
}
