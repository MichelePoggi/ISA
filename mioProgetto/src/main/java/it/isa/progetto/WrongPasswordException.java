package it.isa.progetto;

public class WrongPasswordException extends Exception{
    
    WrongPasswordException(String message)
    {
        super(message);
    }
}
