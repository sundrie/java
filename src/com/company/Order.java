package com.company;

// Le nom du fichier (.java) doit être identique à celui de cette class
public class Order {

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

    // Affiche le menu choisi par l'utilisateur
    // le nbMenu (paramètre de fonction) correspond au chiffre du menu
    public void displaySelectedMenu(int nbMenu){
        if (nbMenu == 1){
            System.out.println("Vous avez choisi le  menu "+ menu1);
        } else if (nbMenu == 2){
            System.out.println("Vous avez choisi le  menu "+ menu2);
        } else if (nbMenu == 3){
            System.out.println("Vous avez choisi le  menu "+ menu3);
        } else{
            System.out.println("Votre saisie n'est pas correcte. Veuillez réessayer");
        }
        // System.out.println("Vous avez choisi le menu "+nbMenu);

    }
}
