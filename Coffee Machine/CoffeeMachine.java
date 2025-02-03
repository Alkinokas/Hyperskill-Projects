package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int cupsMade = 0;

    public static void main(String[] args) {

        ask();
    }

    public static void ask (){

        int mlOfWater = 400;
        int mlOfMilk = 540;
        int gOfCoffee = 120;
        int numberOfCups = 9;
        int moneyInMachine = 550;
        int flag = 0;

        int[] machineSupplies = {mlOfWater, mlOfMilk, gOfCoffee, numberOfCups, moneyInMachine, flag};

        Scanner scanner = new Scanner(System.in);

        while (machineSupplies[5] == 0){
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String userInput = scanner.nextLine();
            options(userInput, machineSupplies);
        }
    }

    public static void options (String userInput, int[] array) {

        if (cupsMade >= 10){
            System.out.println("I need cleaning!");
            if (!userInput.equalsIgnoreCase("clean")){
                return;
            }
        }
        switch (userInput) {
            case "buy":
                buy(array);
                break;
            case "fill":
                fill(array);
                break;
            case "take":
                take(array);
                break;
            case "clean":
                clean();
                break;
            case "remaining":
                remaining(array);
                break;
            case "exit":
                exit(array);
                break;
            default:
                System.out.println("Wrong input! Try again!");
        }
    }

    public static void buy (int[] array){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                "back - to main menu:");
        String coffeeChoice = scanner.next();

        switch(coffeeChoice){
            case "1":
                Coffee.calculate(array, Integer.parseInt(coffeeChoice));
                break;
            case "2":
                Coffee.calculate(array, Integer.parseInt(coffeeChoice));
                break;

            case "3":
                Coffee.calculate(array, Integer.parseInt(coffeeChoice));
                break;
            case "back":
                break;

            default:
                System.out.println("Wrong choice! Try again!");
        }
    }

    public static void fill (int[] array){
        // asks to specify ml of water
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        int mlOfWaterAdded = scanner.nextInt();
        array[0] += mlOfWaterAdded;

        // asks to specify ml of milk
        System.out.println("Write how many ml of milk you want to add:");
        int mlOfMilkAdded = scanner.nextInt();
        array[1] += mlOfMilkAdded;

        // asks to specify grams of coffee
        System.out.println("Write how many grams of coffee beans you want to add:");
        int gOfCoffeeAdded = scanner.nextInt();
        array[2] += gOfCoffeeAdded;

        // asks to specify cups addition
        System.out.println("Write how many disposable cups you want to add:");
        int numberOfCupsAdded = scanner.nextInt();
        array[3] += numberOfCupsAdded;
    }

    public static void take (int[] array){
        System.out.printf("I gave you $%d\n", array[4]);
        array[4] = 0;
    }

    public static void clean (){
        System.out.println("I have been cleaned!");
        cupsMade = 0;
    }

    public static void remaining (int[] array){
        System.out.printf("\nThe coffee machine has:\n%d ml of water\n%d ml of milk\n%d g of coffee beans\n" +
                        "%d disposable cups\n$%d of money\n\n", array[0], array[1], array[2],
                array[3], array[4]);
    }

    public static void exit (int[] array){
        array[5] = 1;
    }
}

class Coffee {
    static final int [] ESPRESSO = {250, 0, 16, 1}; // water, milk, beans, cups
    static final int [] LATTE = {350, 75, 20, 1}; // water, milk, beans, cups
    static final int [] CAPPUCCINO = {200, 100, 12, 1}; // water, milk, beans, cups

    public static void calculate (int [] array, int choice){
        switch(choice) {
            case 1:
                if (array[0] < ESPRESSO[0]) {
                    System.out.println("Sorry, not enough water!");
                } else if (array[2] < ESPRESSO[2]) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (array[3] < ESPRESSO[3]) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    array[0] -= 250;
                    array[2] -= 16;
                    array[3] -= 1;
                    array[4] += 4;
                    CoffeeMachine.cupsMade++;
                }
                break;
            case 2:
                if (array[0] < LATTE[0]) {
                    System.out.println("Sorry, not enough water!");
                } else if (array[1] < LATTE[1]) {
                    System.out.println("Sorry, not enough milk!");
                } else if (array[2] < LATTE[2]) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (array[3] < LATTE[3]) {
                    System.out.println("Sorry not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    array[0] -= 350;
                    array[1] -= 75;
                    array[2] -= 20;
                    array[3] -= 1;
                    array[4] += 7;
                    CoffeeMachine.cupsMade++;
                }
                break;
            case 3:
                if (array[0] < CAPPUCCINO[0]) {
                    System.out.println("Sorry, not enough water!");
                } else if (array[1] < CAPPUCCINO[1]) {
                    System.out.println("Sorry, not enough milk!");
                } else if (array[2] < CAPPUCCINO[2]) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (array[3] < CAPPUCCINO[3]) {
                    System.out.println("Sorry not enough milk!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    array[0] -= 200;
                    array[1] -= 100;
                    array[2] -= 12;
                    array[3] -= 1;
                    array[4] += 6;
                    CoffeeMachine.cupsMade++;
                }
                break;
        }
    }
}
