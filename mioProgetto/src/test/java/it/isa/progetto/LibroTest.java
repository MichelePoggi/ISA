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
public class LibroTest {   
    
    
    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final int id=5;
        final Libro libro = new Libro();

        //when
        libro.setId(id);

        //then
        final Field field = libro.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(libro), id);

    }

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();
        final int id=7;
        final Field field = libro.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(libro, id);

        //when
        final int result = libro.getId();

        //then
        assertEquals("field wasn't retrieved properly", result, id);
    }


    @Test
    public void testSetTitolo() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();

        //when
        libro.setTitolo("testsettitolo");

        //then
        final Field field = libro.getClass().getDeclaredField("titolo");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(libro), "testsettitolo");

    }

    @Test
    public void testGetTitolo() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();
        final Field field = libro.getClass().getDeclaredField("titolo");
        field.setAccessible(true);
        field.set(libro, "testgettitolo");

        //when
        final String result = libro.getTitolo();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgettitolo");
    }

    @Test
    public void testSetLettore() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();

        //when
        libro.setLettore("testsetlettore");

        //then
        final Field field = libro.getClass().getDeclaredField("lettore");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(libro), "testsetlettore");

    }

    @Test
    public void testGetLettore() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();
        final Field field = libro.getClass().getDeclaredField("lettore");
        field.setAccessible(true);
        field.set(libro, "testgetlettore");

        //when
        final String result = libro.getLettore();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgetlettore");
    }

    @Test
    public void testSetAudio() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();
        final String a = "testsetaudio";
        final byte[] b = a.getBytes();

        //when
        libro.setAudio(b);

        //then
        final Field field = libro.getClass().getDeclaredField("audio");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(libro), b);

    }

    @Test
    public void testGetAudio() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();
        final String a = "testgetaudio";
        final byte[] b = a.getBytes();
        final Field field = libro.getClass().getDeclaredField("audio");
        field.setAccessible(true);
        field.set(libro, b);

        //when
        final byte[] result = libro.getAudio();

        //then
        assertEquals("field wasn't retrieved properly", result, b);
    }

    @Test
    public void testSetAutore() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();

        //when
        libro.setAutore("testsetautore");

        //then
        final Field field = libro.getClass().getDeclaredField("autore");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(libro), "testsetautore");

    }

    @Test
    public void testGetAutore() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();
        final Field field = libro.getClass().getDeclaredField("autore");
        field.setAccessible(true);
        field.set(libro, "testgetautore");

        //when
        final String result = libro.getAutore();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgetautore");
    }

    @Test
    public void testSetHaAscoltato() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();
        Utente utente = new Utente();
        Integer integer = Integer.valueOf(6);
        HashMap<Utente, Integer> mappa = new HashMap<Utente, Integer>();
        HashMap<Utente, Integer> mappa2 = new HashMap<Utente, Integer>();
        mappa.put(utente, integer);
        mappa2.put(utente, integer);

        //when
        libro.setHaAscoltato(mappa);

        //then
        final Field field = libro.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(libro), mappa2);

    }

    @Test
    public void testGetHaAscoltato() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();
        Utente utente = new Utente();
        Integer integer =Integer.valueOf(6);
        HashMap<Utente, Integer> mappa = new HashMap<Utente, Integer>();
        HashMap<Utente, Integer> mappa2 = new HashMap<Utente, Integer>();
        mappa.put(utente, integer);
        mappa2.put(utente, integer);
        final Field field = libro.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        field.set(libro, mappa);

        //when
        final HashMap<Utente, Integer> result = libro.getHaAscoltato();

        //then
        assertEquals("field wasn't retrieved properly", result, mappa2);
    }

    @Test
    public void testSetHaAscoltato2() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();
        Utente utente = new Utente();
        Integer integer = Integer.valueOf(6);
        HashMap<Utente, Integer> mappa = new HashMap<Utente, Integer>();
        
        mappa.put(utente, integer);
       

        //when
        libro.setHaAscoltato(utente, integer);

        //then
        final Field field = libro.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(libro), mappa);

    }

    @Test
    public void testGetHaAscoltato2() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Libro libro = new Libro();
        Utente utente = new Utente();
        Integer integer = Integer.valueOf(6);
        HashMap<Utente, Integer> mappa = new HashMap<Utente, Integer>();
        
        mappa.put(utente, integer);
        
        final Field field = libro.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        field.set(libro, mappa);

        //when
        final Integer result = libro.getHaAscoltato(utente);

        //then
        assertEquals("field wasn't retrieved properly", result, integer);
    }

    @Test
    public void testEquals()
    {
        Libro libro1 = new Libro();
        Libro libro2 = new Libro();
        Libro libro3 = new Libro();
        libro1.setId(0);
        libro2.setId(0);
        libro3.setId(1);
        boolean uguali;
        boolean nonuguali;
        uguali = libro1.equals(libro2);
        nonuguali=libro1.equals(libro3);
        assertTrue(uguali);
        assertFalse(nonuguali);
    }
   

  

    

    

}
    
    
    
    
    
