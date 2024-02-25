package it.isa.progetto;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;



public class MainPanelControllerTest{

    @Test
    public void contaAllBooksTest()
    {
        MainPanelController mpc = new MainPanelController();
        try
        {
            int a = mpc.contaAllBooks();
            DAOFactory dao = new DAOFactory();
            dao.beginTransaction();
            LibroDAO bd = dao.getLibroDAO();
            int b = bd.countAllLibri();
            dao.commitTransaction();
            dao.closeTransaction();
            assertEquals(a, b);
        }

        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    @Test
    public void findByStringTest()
    {
        MainPanelController mpc = new MainPanelController();
        List<Libro> libri = new ArrayList<Libro>();
        try{
                libri= mpc.findByString("Il Dottore Nero");
                Libro libro = new Libro();
            Libro libro2 = new Libro();
            File file = new File("src/test/java/it/isa/progetto/Files/Il_Dottore_Nero.mp3");
            byte[] bytes = Files.readAllBytes(file.toPath());
            libro.setId(28);
            libro.setTitolo("Il Dottore Nero");
            libro.setLettore("La Via Della Voce");
            libro.setAutore("A.C.Doyle");
            libro.setAudio(bytes);
            libro2=libri.get(0);
            assertEquals(libro.getId(), libro2.getId());
            assertEquals(libro.getTitolo(), libro2.getTitolo());
            assertEquals(libro.getLettore(), libro2.getLettore());
            assertEquals(libro.getAutore(), libro2.getAutore());
            boolean uguali=true;
            for (int i=0; i<(libro.getAudio().length); i++)
            {
                if(libro.getAudio()[i]!=libro2.getAudio()[i])
                uguali=false;
            }
            assertTrue(uguali);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
    }

    

    

    

    @Test 
    public void makeButtonTextTest()
    {
        MainPanelController mpc = new MainPanelController();
        Libro libro = new Libro();
        Utente utente = new Utente();
        HashMap<Libro, Integer> map = new HashMap<Libro, Integer>();
        libro.setId(1);
        libro.setTitolo("prova");
        libro.setLettore("prova");
        libro.setAutore("prova");
        utente.setId(1);
        Integer integer = Integer.valueOf(1);
        String etichetta1= mpc.makeButtonText(libro, utente);
        assertEquals(etichetta1, "Titolo: "+libro.getTitolo()+"\t Lettore: "+libro.getLettore()+"\t Autore: "+libro.getAutore()+"\t Ascolti: 0");
        map.put(libro, integer);
        utente.setHaAscoltato(map);
        String etichetta2=mpc.makeButtonText(libro, utente);
        assertEquals(etichetta2, "Titolo: "+libro.getTitolo()+"\t Lettore: "+libro.getLettore()+"\t Autore: "+libro.getAutore()+"\t Ascolti: "+utente.getHaAscoltato(libro).intValue());

    }

    @Test
    public void playTestException()
    {
        MainPanelController mpc = new MainPanelController();
        Utente utente = new Utente();
        mpc.play("0", utente);

    }

    @Test
    public void aggiornaUtenteTestException()
    {
        MainPanelController mpc = new MainPanelController();
        Utente utente = new Utente();
        mpc.aggiornaUtente(utente);
    }

}