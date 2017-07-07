package com.example.sandipghosh.mainbraintech;

/**
 * Created by sandipghosh on 07/07/17.
 */

public class User {

    public static boolean emailValid(String email){
        String EMAIL_REGEX = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        if (email.matches(EMAIL_REGEX)){
            return true;
        }else {
            return false;
        }
    }

    public static boolean mobileValid(String mobile) {

        if(mobile.length()==10) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean passwordValid(String password){
        if (password.length()>=6){
            return true;
        } else {
            return false;
        }
    }

    public static boolean userValid(String name){
        if (name.length()>0){
            return true;
        } else {
            return false;
        }
    }
}
