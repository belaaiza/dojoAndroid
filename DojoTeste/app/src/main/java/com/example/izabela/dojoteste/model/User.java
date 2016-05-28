package com.example.izabela.dojoteste.model;

import com.example.izabela.dojoteste.exception.UserException;

/**
 * Created by izabela on 19/05/16.
 */
public class User{

    private String name;
    private Integer age;
    private Integer MAX_NAME_LENGTH = 50;

    public User(String name, String age) throws UserException{
        setName(name);
        setAge(age);
    }

    private void setName(String name) throws UserException{
        if(name != null && !name.isEmpty()){
            if(name.length() <= MAX_NAME_LENGTH){
                this.name = name;
            }
            else{
                throw new UserException("Digite um nome de até 50 caracteres");
            }
        }
        else{
            throw new UserException("O nome não pode ser vazio");
        }
    }

    private void setAge(String age) throws UserException{
        try{
            this.age = Integer.parseInt(age);

        }catch(NumberFormatException userException){

            throw new UserException("A idade não pode ser vazia");
        }
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }
}
