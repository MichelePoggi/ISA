package it.isa.progetto;

import org.junit.jupiter.api.TestInstance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.junit.Test;
import org.junit.jupiter.api.TestInstance.Lifecycle;




@TestInstance(Lifecycle.PER_CLASS)
public class BranoTest {   
    
    
    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final int id=5;
        final Brano brano = new Brano();

        //when
        brano.setId(id);

        //then
        final Field field = brano.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), id);

    }

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final int id=7;
        final Field field = brano.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(brano, id);

        //when
        final int result = brano.getId();

        //then
        assertEquals("field wasn't retrieved properly", result, id);
    }


    @Test
    public void testSetTitolo() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();

        //when
        brano.setTitolo("testsettitolo");

        //then
        final Field field = brano.getClass().getDeclaredField("titolo");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), "testsettitolo");

    }

    @Test
    public void testGetTitolo() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final Field field = brano.getClass().getDeclaredField("titolo");
        field.setAccessible(true);
        field.set(brano, "testgettitolo");

        //when
        final String result = brano.getTitolo();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgettitolo");
    }

    @Test
    public void testSetAlbum() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();

        //when
        brano.setAlbum("testsetalbum");

        //then
        final Field field = brano.getClass().getDeclaredField("album");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), "testsetalbum");

    }

    @Test
    public void testGetAlbum() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final Field field = brano.getClass().getDeclaredField("album");
        field.setAccessible(true);
        field.set(brano, "testgetalbum");

        //when
        final String result = brano.getAlbum();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgetalbum");
    }

    @Test
    public void testSetCanzone() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final String a = "testsetcanzone";
        final byte[] b = a.getBytes();

        //when
        brano.setCanzone(b);

        //then
        final Field field = brano.getClass().getDeclaredField("canzone");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), b);

    }

    @Test
    public void testGetCanzone() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final String a = "testgetcanzone";
        final byte[] b = a.getBytes();
        final Field field = brano.getClass().getDeclaredField("canzone");
        field.setAccessible(true);
        field.set(brano, b);

        //when
        final byte[] result = brano.getCanzone();

        //then
        assertEquals("field wasn't retrieved properly", result, b);
    }

    @Test
    public void testSetArtista() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();

        //when
        brano.setArtista("testsetartista");

        //then
        final Field field = brano.getClass().getDeclaredField("artista");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), "testsetartista");

    }

    @Test
    public void testGetArtista() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final Field field = brano.getClass().getDeclaredField("artista");
        field.setAccessible(true);
        field.set(brano, "testgetartista");

        //when
        final String result = brano.getArtista();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgetartista");
    }

    @Test
    public void testSetHaAscoltato() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        Utente utente = new Utente();
        Integer integer = Integer.valueOf(6);
        HashMap<Utente, Integer> mappa = new HashMap<Utente, Integer>();
        HashMap<Utente, Integer> mappa2 = new HashMap<Utente, Integer>();
        mappa.put(utente, integer);
        mappa2.put(utente, integer);

        //when
        brano.setHaAscoltato(mappa);

        //then
        final Field field = brano.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), mappa2);

    }

    @Test
    public void testGetHaAscoltato() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        Utente utente = new Utente();
        Integer integer =Integer.valueOf(6);
        HashMap<Utente, Integer> mappa = new HashMap<Utente, Integer>();
        HashMap<Utente, Integer> mappa2 = new HashMap<Utente, Integer>();
        mappa.put(utente, integer);
        mappa2.put(utente, integer);
        final Field field = brano.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        field.set(brano, mappa);

        //when
        final HashMap<Utente, Integer> result = brano.getHaAscoltato();

        //then
        assertEquals("field wasn't retrieved properly", result, mappa2);
    }

    @Test
    public void testSetHaAscoltato2() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        Utente utente = new Utente();
        Integer integer = Integer.valueOf(6);
        HashMap<Utente, Integer> mappa = new HashMap<Utente, Integer>();
        
        mappa.put(utente, integer);
       

        //when
        brano.setHaAscoltato(utente, integer);

        //then
        final Field field = brano.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), mappa);

    }

    @Test
    public void testGetHaAscoltato2() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        Utente utente = new Utente();
        Integer integer = Integer.valueOf(6);
        HashMap<Utente, Integer> mappa = new HashMap<Utente, Integer>();
        
        mappa.put(utente, integer);
        
        final Field field = brano.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        field.set(brano, mappa);

        //when
        final Integer result = brano.getHaAscoltato(utente);

        //then
        assertEquals("field wasn't retrieved properly", result, integer);
    }

    @Test
    public void testEquals()
    {
        Brano brano1 = new Brano();
        Brano brano2 = new Brano();
        Brano brano3 = new Brano();
        brano1.setId(0);
        brano2.setId(0);
        brano3.setId(1);
        boolean uguali;
        boolean nonuguali;
        uguali = brano1.equals(brano2);
        nonuguali=brano1.equals(brano3);
        assertTrue(uguali);
        assertFalse(nonuguali);
    }
   

  

    

    

}
    
    
    
    
    
