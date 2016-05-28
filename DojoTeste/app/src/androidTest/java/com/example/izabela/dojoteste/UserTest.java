package com.example.izabela.dojoteste;

import android.util.Log;

import com.example.izabela.dojoteste.exception.UserException;
import com.example.izabela.dojoteste.model.User;

import junit.framework.TestCase;

/**
 * Created by izabela on 19/05/16.
 */
public class UserTest extends TestCase{

    public void testNullName() {
        boolean isTestValid = false;

        try{
            User user = new User(null, 10);
            isTestValid = true;
        }
        catch(UserException userException){
            isTestValid = false;
        }

        assertFalse(isTestValid);
    }

    public void testEmptyName() {
        boolean isTestValid = false;

        try{
            User user = new User("",12);
            isTestValid = true;
        }catch(UserException ex){
            isTestValid = false;
        }

        assertFalse(isTestValid);
    }

    public void testSizeName(){
        boolean isTestValid = false;

        try{
            User user = new  User("Maria Eduarda Carvalho Freitas Cardoso da Silva ABCDEFG", 18);
            isTestValid = true;
        }catch(UserException ex){
            isTestValid = false;
        }
        assertFalse(isTestValid);
    }



}
