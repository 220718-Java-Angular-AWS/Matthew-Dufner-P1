package com.revature.consoleui;

import com.revature.daos.UserOptions;
import com.revature.pojos.User;
import com.revature.services.ConsoleService;
import com.revature.services.UserServices;

import java.util.Scanner;

public class UpdateUserMenu extends View{
    private UserServices service;
    public UpdateUserMenu(){
        viewName = "UpdateUser";
        consoleService = ConsoleService.getConsoleService();
        service = new UserServices();
    }

    @Override
    public void renderView(){
        Scanner sc = new Scanner(System.in);

        boolean userAdmin = false;
        UserOptions eLook = new UserOptions();
        User updateUser = new User();
        User adminUser = new User();

        System.out.println("========= Update User =========");
        System.out.println("Enter Current Email: ");
        String cEmail = sc.nextLine();

        adminUser = eLook.read(eLook.readEM(cEmail));
        if (adminUser.isUserAdmin()) {

            System.out.println("Enter email of user to change: ");
            String uEmail = sc.nextLine();
            System.out.println("Enter First Name: ");
            String firstName = sc.nextLine();
            System.out.println("Enter Last Name: ");
            String lastName = sc.nextLine();
            System.out.println("Enter Email: ");
            String email = sc.nextLine();
            System.out.println("Enter Password: ");
            String userPass = sc.nextLine();
            System.out.println("Change User Admin Status (Add/Revoke) : ");
            String ADString = sc.nextLine();
            while (!ADString.equalsIgnoreCase("add") && !ADString.equalsIgnoreCase("revoke") ){
                System.out.println("Invalid Input use 'Add' or 'Revoke' to change Admin Status:  ");
                ADString = sc.nextLine();
            }
           if (ADString.equalsIgnoreCase("add")){
               userAdmin = true;

           }else if (ADString.equalsIgnoreCase("revoke")){
               userAdmin = false;

           }
            updateUser = eLook.read(eLook.readEM(uEmail));
            int id = updateUser.getUserID();
            updateUser = new User(id, firstName, lastName, userPass, userAdmin, uEmail);
            service.updateUser(updateUser);
        }else{
            System.out.println("Enter First Name: ");
            String firstName = sc.nextLine();
            System.out.println("Enter Last Name: ");
            String lastName = sc.nextLine();
            System.out.println("Enter Email: ");
            String email = sc.nextLine();
            System.out.println("Enter Password: ");
            String userPass = sc.nextLine();
            updateUser = new User(eLook.readEM(cEmail), firstName, lastName, userPass, email);
            service.updateUser(updateUser);
        }

        consoleService.navigate("MainMenu");
    }

}
