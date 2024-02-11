package it.isa.progetto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;


import org.junit.Test;






public class UtenteDAOTest {

   
    
    @Test 
    public void testCreateNonEsistente()
    {

        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");

            
            
        
        Utente utente1 = new Utente();
        Utente utente2 = new Utente();
        Brano brano = new Brano();
        brano.setId(1);

       UtenteDAO dao = new UtenteDAO(con);
      
        
       utente1=dao.create("prova", "prova");
       utente2.setUsername("prova");
       utente2.setPassword("prova");
       int id=utente1.getId();
       utente2.setId(id);
       utente1 = dao.findById(id);

       
       dao.creaAscolto(brano, utente1);
        dao.creaAscolto(brano, utente1);
        
       utente1 = dao.findById(id);
        HashMap<Brano, Integer> mappa = new HashMap<Brano, Integer>();
        Integer integer = Integer.valueOf(2);
        mappa.put(brano, integer);
        utente2.setHaAscoltato(mappa);
       

        
        assertEquals(utente1.getId(), utente2.getId());
        assertEquals(utente1.getUsername(), utente2.getUsername());
        assertEquals(utente1.getPassword(), utente2.getPassword());
        assertEquals(utente1.getHaAscoltato(), utente2.getHaAscoltato());
        
        

        dao.deleteUtente(utente1);
        
    }

    catch(Exception ex)
    {
        System.out.println(ex.getMessage());
    }


        

    
 }



 @Test 
    public void testCreateEsistente()
    {
        

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
            UtenteDAO dao = new UtenteDAO(con);
        
       dao.create("prova", "prova");
       assertThrows(DuplicatedObjectException.class, () -> {dao.create("prova", "prova");});
       
       

       

        


        

    }
    catch(Exception e){ System.out.println(e.getMessage());}  

    finally
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
            UtenteDAO dao = new UtenteDAO(con);
           
            Utente utente1 = new Utente();
            utente1 = dao.findByUsername("prova");
            dao.deleteUtente(utente1);
        }
       catch(Exception e)
       {
        System.out.println(e.getMessage());
       }
    }
 }

 @Test 
    public void testCreateEsistenteSQLException()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
        UtenteDAO dao = new UtenteDAO(con);
        con.close();
        
       
        
        dao.create("prova", "prova");
        
       }
       catch(Exception e)
       {
        System.out.println(e.getMessage());
       }


    }

    @Test 
    public void testCreaAscoltiSQLException()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
        UtenteDAO dao = new UtenteDAO(con);
        con.close();
        Utente utente = new Utente();
        Brano brano = new Brano();
        
       
        
        dao.creaAscolto(brano, utente);
        
       }
       catch(Exception e)
       {
        System.out.println(e.getMessage());
       }


    }

@Test

public void testFindByIDNotFoundException()
{
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");

        UtenteDAO dao = new UtenteDAO(con);
        
        assertThrows(MissingObjectException.class, () -> {dao.findById(0);});
        
    }

    catch(Exception e){
        System.out.println(e.getMessage());
    }

}
 @Test
public void testFindByUsernameNotFoundException()
{
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
            UtenteDAO dao = new UtenteDAO(con);
        
        
        assertThrows(MissingObjectException.class, () -> {dao.findByUsername("0");});
        
       
    }

    catch(Exception e){
        System.out.println(e.getMessage());
    }
}

@Test 
    public void testFindByIdSQLException()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
        UtenteDAO dao = new UtenteDAO(con);
        con.close();
        
       
        
        dao.findById(2);
        
       }
       catch(Exception e)
       {
        System.out.println(e.getMessage());
       }


    }


@Test
public void testDeleteUtenteNotFoundException()
{
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
            UtenteDAO dao = new UtenteDAO(con);
        Utente utente = new Utente();
        utente.setUsername("0");

        assertThrows(MissingObjectException.class, () -> {dao.deleteUtente(utente);});
       
    }

    catch(Exception e){
        System.out.println(e.getMessage());
    }
}

@Test 
    public void testDeleteUtenteSQLException()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
        UtenteDAO dao = new UtenteDAO(con);
        con.close();
        
       
        
        dao.deleteUtente(new Utente());
        
       }
       catch(Exception e)
       {
        System.out.println(e.getMessage());
       }


    }

    @Test 
    public void testFindByUsernameSQLException()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
        UtenteDAO dao = new UtenteDAO(con);
        con.close();
        
       
        
        dao.findByUsername("prova");
        
       }
       catch(Exception e)
       {
        System.out.println(e.getMessage());
       }


    }









 

 
    }


