package Principale;

import app.ControleurPere;
import app.Tempurature;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Controle extends ControleurPere {

    Presentation presentation;
    Abstraction abstraction;

    Palette.Controle pallete;
    Saisi.Controle saisi;
    FormeTableau.Controle formeTableau;

    public Controle() {
        abstraction = new Abstraction();

        pallete = new Palette.Controle(this);
        saisi = new Saisi.Controle(this);
        formeTableau = new FormeTableau.Controle(this);
    }

    @Override
    public void creePresentation(Stage primaryStage){
        presentation = new Presentation(primaryStage);
        pallete.creePresentation(presentation.pallettePresentation);
        saisi.creePresentation(presentation.saisiPresentation);
    }

    public void updateFromSaisi(){
        int newTemp = saisi.getAbstraction().getLocalTemp();
        updateAbstraction(newTemp);
    }

    public void updateAbstraction(int newTemp) {
        abstraction.getHistory().add(newTemp);
        System.out.println(abstraction.getHistory().toString());
        updatePresentation(newTemp);

        formeTableau.update(newTemp);
    }

    public void updateFromPalette(int i) {
        int oldTemp = saisi.getAbstraction().getLocalTemp();
        saisi.update(oldTemp + i);
    }

    public void updateFromPaletteRAZ() {
        saisi.update(0);
    }

    public void updatePresentation(int newTemp) {
        presentation.getSeries().getData().add(new XYChart.Data(
                abstraction.getHistory().size(),
                newTemp
        ));
    }

    public void afficherFormeTableau() {
        formeTableau.creePresentation();
    }
}
