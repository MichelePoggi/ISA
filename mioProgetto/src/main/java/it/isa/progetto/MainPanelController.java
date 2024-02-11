package it.isa.progetto;

import java.io.File;

import java.io.FileOutputStream;

import java.io.OutputStream;

import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;





public class MainPanelController {

    public int contaAllSong() throws MissingObjectException
    {
        DAOFactory dao = new DAOFactory();
        dao.beginTransaction();
        BranoDAO branoDao = dao.getBranoDAO();
        int count = branoDao.countAllBrani();
        dao.commitTransaction();
        dao.closeTransaction();
        return count;
    }

    public List<Brano> findAllBrani() 
    {
        DAOFactory dao = new DAOFactory();
        List<Brano> brani = new ArrayList<Brano>();
        dao.beginTransaction();
        BranoDAO branoDao = dao.getBranoDAO();
        brani  = branoDao.findAllBrani();
        dao.commitTransaction();
        dao.closeTransaction();
        return brani;
    }

    public List<Brano> findByString(String stringa) throws MissingObjectException
    {
        DAOFactory dao = new DAOFactory();
        List<Brano> brani = new ArrayList<Brano>();
        dao.beginTransaction();
        BranoDAO branoDao = dao.getBranoDAO();
        brani  = branoDao.findByString(stringa);
        dao.commitTransaction();
        dao.closeTransaction();
        return brani;
    }

    public String makeButtonText(Brano brano, Utente utente)
    {
        if(utente.getHaAscoltato().containsKey(brano))
        return ("Titolo: "+brano.getTitolo()+"\t Album: "+brano.getAlbum()+"\t Artista: "+brano.getArtista()+"\t Ascolti: "+utente.getHaAscoltato(brano).intValue());
        else
        return ("Titolo: "+brano.getTitolo()+"\t Album: "+brano.getAlbum()+"\t Artista: "+brano.getArtista()+"\t Ascolti: 0");
    }

    public void play(String id, Utente utente) 
    {
        
        final String FILEPATH = "songs/l.mp3";
        final File file = new File(FILEPATH);
        Brano brano;
        DAOFactory dao = new DAOFactory();
        dao.beginTransaction();
        BranoDAO branoDao = dao.getBranoDAO();
        UtenteDAO uDao = dao.getUtenteDAO();
        try{
        brano=branoDao.findById(Integer.parseInt(id));
        uDao.creaAscolto(brano, utente);
        dao.commitTransaction();
        dao.closeTransaction();
        OutputStream os = new FileOutputStream(file);
        os.write(brano.getCanzone());
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
