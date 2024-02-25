package it.isa.progetto;

import java.util.HashMap;

public class Utente {

    private int id;
    private String username;
    private String password;
    private HashMap<Libro, Integer> haAscoltato = new HashMap<Libro, Integer>();
    

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id=id;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username=username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }

    public void setHaAscoltato(HashMap<Libro, Integer> haAscoltato)
    {
        this.haAscoltato=haAscoltato;
    }

    public HashMap<Libro, Integer> getHaAscoltato()
    {
        return this.haAscoltato;
    }

    public Integer getHaAscoltato(Libro libro)
    {
        return this.haAscoltato.get(libro);
    }

    public void setHaAscoltato(Libro libro, Integer ascolti)
    {
        this.haAscoltato.put(libro, ascolti);
    }

   
    


    
}
