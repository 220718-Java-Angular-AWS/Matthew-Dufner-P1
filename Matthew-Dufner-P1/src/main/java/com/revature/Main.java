package com.revature;

import com.revature.daos.UserOptions;
import com.revature.pojos.User;
import com.revature.services.DatabaseServices;

import java.sql.Connection;

public class Main {
    public static void main(String[] args){
        Connection connection = DatabaseServices.getConnection();


        User matt = new User();
        User luke = new User();

        /*matt.setFirstName("Matthew");
        matt.setLastName("Dufner");
        matt.setEmail("mattdufner44@gmail.com");
        matt.setUserPass("Crazetbitch-44");*/

        /*luke.setFirstName("Luke");
        luke.setLastName("Harris");
        luke.setEmail("ahsomegfhds@aol.com");
        luke.setUserPass("12321ew2");*/

        UserOptions user = new UserOptions();


        System.out.print(user.read(3) + "\n");
        System.out.println("Done!");
    }
}
