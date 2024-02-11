package it.isa.progetto;

import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.HashMap;


@TestInstance(Lifecycle.PER_CLASS)
public class UtenteTest {


    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final int id=9;
        final Utente utente = new Utente();

        //when
        utente.setId(id);

        //then
        final Field field = utente.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(utente), id);

    }

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();
        final int id=23;
        final Field field = utente.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(utente, id);

        //when
        final int result = utente.getId();

        //then
        assertEquals("field wasn't retrieved properly", result, id);
    }

    @Test
    public void testSetUsername() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();

        //when
        utente.setUsername("testsetusername");

        //then
        final Field field = utente.getClass().getDeclaredField("username");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(utente), "testsetusername");

    }

    @Test
    public void testGetUsername() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();
        final Field field = utente.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(utente, "testgetusername");

        //when
        final String result = utente.getUsername();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgetusername");
    }

    @Test
    public void testSetPassword() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();

        //when
        utente.setPassword("testsetpassword");

        //then
        final Field field = utente.getClass().getDeclaredField("password");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(utente), "testsetpassword");

    }

    @Test
    public void testGetPassword() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();
        final Field field = utente.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(utente, "testgetpassword");

        //when
        final String result = utente.getPassword();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgetpassword");
    }

    @Test
    public void testSetHaAscoltato() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();
        Brano brano = new Brano();
        Integer integer = Integer.valueOf(6);
        HashMap<Brano, Integer> mappa = new HashMap<Brano, Integer>();
        HashMap<Brano, Integer> mappa2 = new HashMap<Brano, Integer>();
        mappa.put(brano, integer);
        mappa2.put(brano, integer);




        //when
        utente.setHaAscoltato(mappa);

        //then
        final Field field = utente.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(utente), mappa2);

    }

    @Test
    public void testGetHaAscoltato() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();
        Brano brano = new Brano();
        Integer integer = Integer.valueOf(6);
        HashMap<Brano, Integer> mappa = new HashMap<Brano, Integer>();
        HashMap<Brano, Integer> mappa2 = new HashMap<Brano, Integer>();
        mappa.put(brano, integer);
        mappa2.put(brano, integer);
        final Field field = utente.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        field.set(utente, mappa);

        //when
        final HashMap<Brano, Integer> result = utente.getHaAscoltato();

        //then
        assertEquals("field wasn't retrieved properly", result, mappa2);
    }

    @Test
    public void testSetHaAscoltato2() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();
        Brano brano = new Brano();
        Integer ascolti = Integer.valueOf(6);
        
        HashMap<Brano, Integer> mappa2 = new HashMap<Brano, Integer>();
        mappa2.put(brano, ascolti);




        //when
        utente.setHaAscoltato(brano, ascolti);

        //then
        final Field field = utente.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(utente), mappa2);

    }

    @Test
    public void testGetHaAscoltato2() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();
        Brano brano = new Brano();
        Integer integer = Integer.valueOf(6);
        HashMap<Brano, Integer> mappa = new HashMap<Brano, Integer>();
        
        mappa.put(brano, integer);
        
        final Field field = utente.getClass().getDeclaredField("haAscoltato");
        field.setAccessible(true);
        field.set(utente, mappa);

        //when
        final Integer result = utente.getHaAscoltato(brano);

        //then
        assertEquals("field wasn't retrieved properly", result, integer);
    }
    
    
}
