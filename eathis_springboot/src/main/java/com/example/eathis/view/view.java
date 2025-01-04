package com.example.eathis.view;

import java.util.Scanner;
import com.example.eathis.model.model;
//여기서 사용자한테 보여주는 내용들인데 이게 프론트인지는 모르겠음
public class view {
    private model my_model;
    public view(model m){
        my_model = m;
    }
    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Start");
        System.out.print("ID 입력: ");
        String id = scanner.nextLine();
        System.out.print("비번 입력: ");
        String password = scanner.nextLine();
        my_model.setAccount(id, password);

    }
}
