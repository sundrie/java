package com.company;

// On charge la class Scanner pour qu'elle soit utilisée
import java.util.Scanner;

// Le nom du fichier (.java) doit être identique à celui de cette class
public class Order {

    // System.in permets de récupérer la saisie utilisateur
    Scanner sc = new Scanner(System.in);

    // S'occupe de demander le menu à l'utilisateur
    public void runMenu() {
        // vu que nous sommes déjà dans la class Order this permet d'utiliser l'objet directement sans devoir créer une nouvelle variable avec new Order()
        this.displayAvailableMenu();
        // Même principe qu'au dessus
        // La méthode nextInt() permets de demander à l'utilisateur un entier
        int nb = sc.nextInt();
        // Et là on appelle la méthode displaySelectedMenu() et on donne en argument la valeur de la variable saisie par  l'utilisateur
        this.displaySelectedMenu(nb);

        // On fait un switch car selon le menu les accompagnements changent
        switch (nb) {
            // Pour le menu Poulet
            case 1 :
                // On appelle la méthode pour choisir son accompagnement
                this.displayAvailableSide(true);
                // Pas besoin de recréer une nouvelle variable autant reprendre celle crée plus haut
                nb = sc.nextInt();
                // Et on affiche ce qui a été choisi
                this.displaySelectedSide(nb, true);
                // On appelle la méthode pour choisir sa boisson
                this.displayAvailableDrink();
                nb = sc.nextInt();
                // Et on affiche ce qui a été choisi
                this.displaySelectedDrink(nb);
                break;
            // Pour le menu Boeuf
            case 2:
                this.displayAvailableSide(true);
                nb = sc.nextInt();
                this.displaySelectedSide(nb, true);
                break;
            // Pour le menu Vegan
            case 3:
                this.displayAvailableSide(false);
                nb = sc.nextInt();
                this.displaySelectedSide(nb, false);
                this.displayAvailableDrink();
                nb = sc.nextInt();
                this.displaySelectedDrink(nb);
                break;
        }
    }

    // Si plusieurs menus sont à faire
    public void runMenus() {
        System.out.println("Bonjour combien de menu il vous faut ?");
        int nbCommandes = sc.nextInt();
        // Pour éviter le troll de ce qui mettrait 0 commandes pour bloquer le programme
        if (nbCommandes > 0) {
            int i = 1;
            // leftTodo c'est juste pour indiquer combien de commandes il reste à faire
            int leftTodo = 0;
            while (i <= nbCommandes) {
                this.runMenu();
                leftTodo = nbCommandes - i;

                if (leftTodo == 0){
                    System.out.println("Commande n° " + i + " faite c'est terminé !");
                } else {
                    System.out.println("Commande n° " + i + " faite encore " + leftTodo + " à traiter");
                }
                i++;
            }
        } else {
            System.out.println("Dans ce cas au revoir");
        }

    }

    // Les variables des différents menu, je les déclare ici pour que displaySelectedMenu() puisse les utiliser
    String menu1 = "Poulet";
    String menu2 = "Boeuf";
    String menu3 = "Vegan";

    // Cette fonction va afficher les menus dans le Terminal
    public void displayAvailableMenu(){
        System.out.println("Choix Menu");
        // Le + est pour concaténer
        System.out.println("1 - " + menu1);
        System.out.println("2 - " + menu2);
        System.out.println("3 - " + menu3);
        System.out.println("Que souhaitez vous comme menu ?");
    }

    public void displayAvailableSide(boolean allSideEnable){
        System.out.println("Choix de l'accompagnement");
        if (allSideEnable) {
            System.out.println("1 - légumes frais");
            System.out.println("2 - frites");
            System.out.println("3 - riz");
        } else {
            System.out.println("1 - riz");
            System.out.println("2 - pas de riz");
        }
        System.out.println("Quel accompagnement avec votre menu ?");
    }

    public void displayAvailableDrink(){
        System.out.println("Et enfin votre boisson ?");
        System.out.println("1 - eau plate");
        System.out.println("2 - eau gazeuse");
        System.out.println("3 - Nuka Cola");
        System.out.println("Quel boisson avec votre menu ?");
    }

    // Affiche le menu choisi par l'utilisateur
    // le nbMenu (paramètre de fonction) correspond au chiffre du menu
    public void displaySelectedMenu(int nbMenu){

        // En utilisant if else if et else
//        if (nbMenu == 1){
//            System.out.println("Vous avez choisi le  menu "+ menu1);
//        } else if (nbMenu == 2){
//            System.out.println("Vous avez choisi le  menu "+ menu2);
//        } else if (nbMenu == 3){
//            System.out.println("Vous avez choisi le  menu "+ menu3);
//        } else{
//            System.out.println("Votre saisie n'est pas correcte. Veuillez réessayer");
//        }

        // En utilisant un switch
        switch (nbMenu){
            case 1 :
                System.out.println("Vous avez choisi le  menu "+ menu1);
                break; // break sert à arrêter le switch donc la boucle
            case 2 :
                System.out.println("Vous avez choisi le  menu "+ menu2);
                break;
            case 3 :
                System.out.println("Vous avez choisi le  menu "+ menu3);
                break;
            default : // default c'est pour si aucun case n'a fonctionné (équivalent de else) donc indispensable pour un retour utilisateur
                System.out.println("Votre saisie n'est pas correcte. Veuillez réessayer");
                break;
        }

    }

    // Affiche les accompagnements choisis
    // nbSide comme nbMenu permets de choisir l'accompagnement
    // allSidesEnable lui indique selon le menu si il est possible de choisir entre tous les accompagnements
    // si true = vegetables, frites and rice
    // si false = rice or not
    public void displaySelectedSide(int nbSide, boolean allSidesEnable) {

        if (allSidesEnable) {
            switch (nbSide){
                case 1:
                    System.out.println("Vous avez choisi comme accompagnement légumes frais");
                    break;
                case 2:
                    System.out.println("Vous avez choisi comme accompagnement frites");
                    break;
                case 3:
                    System.out.println("Vous avez choisi comme accompagnement riz");
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi d'accompagnement...");
                    break;
            }
        } else {
            switch (nbSide){
                case 1:
                    System.out.println("Vous avez choisi comme accompagnement riz");
                    break;
                case 2:
                    System.out.println("Vous avez choisi comme accompagnement pas de riz");
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi d'accompagnement...");
                    break;
            }
        }
    }

    // Affiche les boissons choisies
    // nbDrink correspond au chiffre de la boisson choisie
    public void displaySelectedDrink(int nbDrink) {
        switch (nbDrink) {
            case 1:
                System.out.println("Vous avez choisi en boisson de l'eau plate");
                break;
            case 2:
                System.out.println("Vous avez choisi en boisson de l'eau gazeuse");
                break;
            case 3:
                System.out.println("Vous avez choisi en boisson du Nuka Cola");
                break;
            default:
                System.out.println("Vous n'avez pas choisi de boisson...");
                break;
        }

    }
}
