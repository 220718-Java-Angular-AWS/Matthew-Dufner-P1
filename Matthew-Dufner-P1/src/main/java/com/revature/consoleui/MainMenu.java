package com.revature.consoleui;

import com.revature.services.ConsoleService;
import java.util.Scanner;

public class MainMenu extends View{
    public MainMenu(){
        viewName = "MainMenu";
        consoleService = ConsoleService.getConsoleService();
    }

    @Override
    public void renderView(){
        System.out.println("========= Main Menu =========");
        System.out.println("N) New User \nU) Update User \nD) Delete User \nG) Get User \nA) Get All Users " +
                "\n\nQ) Quit");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        switch(input){
            case "N":
                System.out.println("Navigating...");
                consoleService.navigate("NewUser");
                break;
            case "U":
                consoleService.navigate("UpdateUser");
                break;
            case "D":
                consoleService.navigate("DeleteUser");
                break;
            case "G":
                consoleService.navigate("GetUser");
                break;
            case "A":
                consoleService.navigate("GetAllUsers");
                break;
            case "Q":
                consoleService.quit();
                break;
        }
        System.out.println("Nav Complete?");
    }
}
