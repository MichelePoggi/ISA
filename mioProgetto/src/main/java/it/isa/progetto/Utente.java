package it.isa.progetto;

import java.util.HashMap;

public class Utente {

    private int id;
    private String username;
    private String password;
    private HashMap<Brano, Integer> haAscoltato = new HashMap<Brano, Integer>();
    

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

    public void setHaAscoltato(HashMap<Brano, Integer> haAscoltato)
    {
        this.haAscoltato=haAscoltato;
    }

    public HashMap<Brano, Integer> getHaAscoltato()
    {
        return this.haAscoltato;
    }

    public Integer getHaAscoltato(Brano brano)
    {
        return this.haAscoltato.get(brano);
    }

    public void setHaAscoltato(Brano brano, Integer ascolti)
    {
        this.haAscoltato.put(brano, ascolti);
    }

   
    


    
}
