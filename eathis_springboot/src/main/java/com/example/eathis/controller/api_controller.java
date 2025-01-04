package com.example.eathis.controller; //컴파일용 안내
import com.example.eathis.view.view;
import com.example.eathis.model.model;

//여기서 사용자 응답받아서 반환할거
public class api_controller {
    private view my_view;
    private model my_model;


    public api_controller(view v, model m) {
        my_view = v;
        my_model = m;
    }

    public void start(){
        my_view.start();
    }
}
