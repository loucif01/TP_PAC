package FormeTableau;


import java.util.ArrayList;
import java.util.List;

public class Abstraction {

    private List<Integer> history;

    Abstraction(){
        history = new ArrayList<>();
    }

    public List<Integer> getHistory() {
        return history;
    }

    public void setHistory(List<Integer> history) {
        this.history = history;
    }
}
