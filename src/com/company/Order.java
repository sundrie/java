package com.company;

// Le nom du fichier (.java) doit être identique à celui de cette class
public class Order {

    // Cette fonction va afficher les menus dans le Terminal
    public void displayAvailableMenu(){
        System.out.println("Choix Menu");
        String menu1 = "Poulet";
        String menu2 = "Boeuf";
        String menu3 = "Vegan";
        // Le + est pour concaténer
        System.out.println("1 - " + menu1);
        System.out.println("2 - " + menu2);
        System.out.println("3 - " + menu3);
        System.out.println("Que souhaitez vous comme menu ?");
    }

    // Affiche le menu choisi par l'utilisateur
    // le nbMenu (paramètre de fonction) correspond au chiffre du menu
    public void displaySelectedMenu(int nbMenu){
        System.out.println("Vous avez choisi le menu "+nbMenu);
    }
}
