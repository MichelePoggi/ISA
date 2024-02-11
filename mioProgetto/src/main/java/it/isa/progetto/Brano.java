package it.isa.progetto;

import java.util.HashMap;

public class Brano {

    private int id;
    private String titolo;
    private String album;
    private byte[] canzone = new byte[32768];
    private String artista;
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

    public void setAlbum(String album)
    {
        this.album=album;
    }

    public String getAlbum()
    {
        return this.album;
    }

    public void setCanzone(byte[] canzone)
    {
        this.canzone=canzone;
    }

    public byte[] getCanzone()
    {
        return this.canzone;
    }

    public void setArtista(String artista)
    {
        this.artista=artista;
    }

    public String getArtista()
    {
        return this.artista;
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
        if (((Brano)o).getId()==this.id)
        return true;
        else return false;

    }

    
    

    
}
