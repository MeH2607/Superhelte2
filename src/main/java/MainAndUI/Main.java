package MainAndUI;

import java.util.Scanner;

public class Main {

    //Controller.Controller skal styre programmet rundt, essentielt en dirrigent.
    // Den skal ikke forstå noget uden for programmets endepunkter,
    // så her laver vi en filehandler når der skal skrives til tekstfiler.

    public static void main(String[] args) {
    UserInterface ui = new UserInterface();

    ui.startProgram();

    }
}
