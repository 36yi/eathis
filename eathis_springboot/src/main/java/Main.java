import com.example.eathis.view.view;
import com.example.eathis.model.model;
import com.example.eathis.controller.api_controller;


public class Main {
    public static void main(String[] args) {
        model m = new model();
        view v = new view(m);
        api_controller c = new api_controller(v,m);

        c.start();
    }
}
