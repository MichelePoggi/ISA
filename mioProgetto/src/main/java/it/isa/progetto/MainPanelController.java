package it.isa.progetto;

import java.io.File;

import java.io.FileOutputStream;

import java.io.OutputStream;

import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;





public class MainPanelController {

    public int contaAllBooks() throws MissingObjectException
    {
        DAOFactory dao = new DAOFactory();
        dao.beginTransaction();
        LibroDAO libroDao = dao.getLibroDAO();
        int count = libroDao.countAllLibri();
        dao.commitTransaction();
        dao.closeTransaction();
        return count;
    }

    public List<Libro> findAllLibri() 
    {
        DAOFactory dao = new DAOFactory();
        List<Libro> libri = new ArrayList<Libro>();
        dao.beginTransaction();
        LibroDAO libroDao = dao.getLibroDAO();
        libri  = libroDao.findAllLibri();
        dao.commitTransaction();
        dao.closeTransaction();
        return libri;
    }

    public List<Libro> findByString(String stringa) throws MissingObjectException
    {
        DAOFactory dao = new DAOFactory();
        List<Libro> libri = new ArrayList<Libro>();
        dao.beginTransaction();
        LibroDAO libroDao = dao.getLibroDAO();
        libri  = libroDao.findByString(stringa);
        dao.commitTransaction();
        dao.closeTransaction();
        return libri;
    }

    public String makeButtonText(Libro libro, Utente utente)
    {
        if(utente.getHaAscoltato().containsKey(libro))
        return ("Titolo: "+libro.getTitolo()+"\t Lettore: "+libro.getLettore()+"\t Autore: "+libro.getAutore()+"\t Ascolti: "+utente.getHaAscoltato(libro).intValue());
        else
        return ("Titolo: "+libro.getTitolo()+"\t Lettore: "+libro.getLettore()+"\t Autore: "+libro.getAutore()+"\t Ascolti: 0");
    }

    public void play(String id, Utente utente) 
    {
        
        final String FILEPATH = "songs/l.mp3";
        final File file = new File(FILEPATH);
        Libro libro;
        DAOFactory dao = new DAOFactory();
        dao.beginTransaction();
        LibroDAO libroDao = dao.getLibroDAO();
        UtenteDAO uDao = dao.getUtenteDAO();
        try{
        libro=libroDao.findById(Integer.parseInt(id));
        uDao.creaAscolto(libro, utente);
        dao.commitTransaction();
        dao.closeTransaction();
        OutputStream os = new FileOutputStream(file);
        os.write(libro.getAudio());
        os.close();
        
        Desktop.getDesktop().open(new File("songs/l.mp3"));
        }
        catch(Exception ex)
        {
           System.out.println(ex.getMessage());
        }



    }

    

    public Utente aggiornaUtente(Utente utente)
    {
        DAOFactory df = new DAOFactory();
        df.beginTransaction();
        UtenteDAO uDao = df.getUtenteDAO();
        Utente utenten= new Utente();
        try{
        utenten= uDao.findById(utente.getId());
        df.commitTransaction();
        df.closeTransaction();
        return utenten;
        }
        catch(MissingObjectException ex)
        {
            System.out.println(ex.getMessage());
        }
        return utenten;

    }
    
}
