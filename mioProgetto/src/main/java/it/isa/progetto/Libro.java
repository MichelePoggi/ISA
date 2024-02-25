package it.isa.progetto;

import java.util.HashMap;

public class Libro {

    private int id;
    private String titolo;
    private String lettore;
    private byte[] audio = new byte[32768];
    private String autore;
    private HashMap<Utente, Integer> haAscoltato = new HashMap<Utente, Integer>();
    


    public void setId(int id)
    {
        this.id=id;
    }

    public int getId()
    {
        return this.id;
    }

    public void setTitolo(String titolo)
    {
        this.titolo=titolo;
    }

    public String getTitolo()
    {
        return this.titolo;
    }

    public void setLettore(String lettore)
    {
        this.lettore=lettore;
    }

    public String getLettore()
    {
        return this.lettore;
    }

    public void setAudio(byte[] audio)
    {
        this.audio=audio;
    }

    public byte[] getAudio()
    {
        return this.audio;
    }

    public void setAutore(String autore)
    {
        this.autore=autore;
    }

    public String getAutore()
    {
        return this.autore;
    }

    

    public void setHaAscoltato(HashMap<Utente, Integer> haAscoltato)
    {
        this.haAscoltato=haAscoltato;
    }

    public HashMap<Utente, Integer> getHaAscoltato()
    {
        return this.haAscoltato;
    }

    public Integer getHaAscoltato(Utente utente)
    {
        return this.haAscoltato.get(utente);
    }

    public void setHaAscoltato(Utente utente, Integer ascolti)
    {
        this.haAscoltato.put(utente, ascolti);
    }

    @Override
    public int hashCode()
    {
        int hash = 17;
        hash= this.id;
        return hash;
    }


    @Override
    public boolean equals(Object o)
    {
        if (((Libro)o).getId()==this.id)
        return true;
        else return false;

    }

    
    

    
}
