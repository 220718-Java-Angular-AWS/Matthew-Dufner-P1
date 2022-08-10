package com.revature.consoleui;

import com.revature.daos.UserOptions;
import com.revature.pojos.User;
import com.revature.services.ConsoleService;
import com.revature.services.ConnectionManager;
import com.revature.services.UserServices;

import java.util.Scanner;

public class NewUserMenu extends View{
    private UserServices service;
    public NewUserMenu() {
        viewName = "NewUser";
        consoleService = ConsoleService.getConsoleService();
        service = new UserServices();
    }

    @Override
    public void renderView(){
        Scanner sc = new Scanner(System.in);

        System.out.println("========= New User =========");
        System.out.println("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter password: ");
        String userPass = sc.nextLine();

        User newUser = new User(firstName, lastName, email, userPass);
        UserOptions Uopts = new UserOptions(ConnectionManager.getConnection());
        service.saveUser(newUser);

        consoleService.navigate("MainMenu");
    }
}
