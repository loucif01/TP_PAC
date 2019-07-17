package Palette;

import app.ControleurFils;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controle extends ControleurFils {

    Presentation presentation;
    Principale.Controle pere;

    public Controle(Principale.Controle controle){
        pere = controle;
    }

    public void creePresentation(HBox hbox){
        presentation = new Presentation(hbox);
        presentation.setControle(this);
    }

    public void changeValueBy(int i) {
        pere.updateFromPalette(i);
    }

    public void remiseZero() {
        pere.updateFromPaletteRAZ();
    }

    public void afficherFormeTableau() {
        pere.afficherFormeTableau();
    }
}
