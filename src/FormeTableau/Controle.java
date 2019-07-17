package FormeTableau;

import app.ControleurFils;
import javafx.scene.layout.HBox;

public class Controle extends ControleurFils {

    Abstraction abstraction;
    Presentation presentation;
    Principale.Controle pere;

    public Controle(Principale.Controle controle){
        pere = controle;
        abstraction = new Abstraction();
    }

    public void creePresentation(){
        presentation = new Presentation(this);
    }


    public void update(int newTemp) {
        abstraction.getHistory().add(newTemp);
        if (presentation != null) presentation.fillTable();
    }
}
