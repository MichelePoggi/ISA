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
    public void contaAllSongTest()
    {
        MainPanelController mpc = new MainPanelController();
        try
        {
            int a = mpc.contaAllSong();
            DAOFactory dao = new DAOFactory();
            dao.beginTransaction();
            BranoDAO bd = dao.getBranoDAO();
            int b = bd.countAllBrani();
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
        List<Brano> brani = new ArrayList<Brano>();
        try{
                brani= mpc.findByString("money");
                Brano brano = new Brano();
            Brano brano2 = new Brano();
            File file = new File("src/test/java/it/isa/progetto/Files/05. Mone.mp3");
            byte[] bytes = Files.readAllBytes(file.toPath());
            brano.setId(5);
            brano.setTitolo("Money");
            brano.setAlbum("The Dark Side Of The Moon");
            brano.setArtista("Pink Floyd");
            brano.setCanzone(bytes);
            brano2=brani.get(0);
            assertEquals(brano.getId(), brano2.getId());
            assertEquals(brano.getTitolo(), brano2.getTitolo());
            assertEquals(brano.getAlbum(), brano2.getAlbum());
            assertEquals(brano.getArtista(), brano2.getArtista());
            boolean uguali=true;
            for (int i=0; i<(brano.getCanzone().length); i++)
            {
                if(brano.getCanzone()[i]!=brano2.getCanzone()[i])
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
        Brano brano = new Brano();
        Utente utente = new Utente();
        HashMap<Brano, Integer> map = new HashMap<Brano, Integer>();
        brano.setId(1);
        brano.setTitolo("prova");
        brano.setAlbum("prova");
        brano.setArtista("prova");
        utente.setId(1);
        Integer integer = Integer.valueOf(1);
        String etichetta1= mpc.makeButtonText(brano, utente);
        assertEquals(etichetta1, "Titolo: "+brano.getTitolo()+"\t Album: "+brano.getAlbum()+"\t Artista: "+brano.getArtista()+"\t Ascolti: 0");
        map.put(brano, integer);
        utente.setHaAscoltato(map);
        String etichetta2=mpc.makeButtonText(brano, utente);
        assertEquals(etichetta2, "Titolo: "+brano.getTitolo()+"\t Album: "+brano.getAlbum()+"\t Artista: "+brano.getArtista()+"\t Ascolti: "+utente.getHaAscoltato(brano).intValue());

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