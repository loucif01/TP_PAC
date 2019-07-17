package Saisi;


import app.ControleurFils;
import javafx.scene.layout.VBox;

public class Controle extends ControleurFils {
    private Abstraction abstraction;
    Presentation presentation;
    Principale.Controle pere;

    public Abstraction getAbstraction() {
        return abstraction;
    }

    public Controle(Principale.Controle controle) {
        pere = controle;

        abstraction = new Abstraction();
    }

    public void updateAbstraction(int temp) {
        abstraction.setLocalTemp(temp);
        notifyPere();
    }

    public void update(int temp) {
        presentation.changeTemp(Integer.toString(temp));
    }

    public void notifyPere() {
        pere.updateFromSaisi();
    }

    public void creePresentation(VBox vBox) {
        presentation = new Presentation(vBox);
        presentation.setControle(this);
    }

}
