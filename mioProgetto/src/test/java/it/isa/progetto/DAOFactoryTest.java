package it.isa.progetto;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class DAOFactoryTest {

    @Test
    public void beginTransactionTest()
    {
        DAOFactory dao = new DAOFactory();
        dao.beginTransaction();
        BranoDAO bd= dao.getBranoDAO();
        UtenteDAO ud = dao.getUtenteDAO();
        try{
        Brano brano = bd.findById(1);
        Utente utente = ud.findById(111);
        dao.commitTransaction();
        dao.closeTransaction();
        assertEquals(brano.getId(), 1);
        assertEquals(utente.getId(), 111);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void rollbackTransactionTest()
    {
       DAOFactory dao = new DAOFactory();
       dao.beginTransaction();
       UtenteDAO ud = dao.getUtenteDAO();
       try{
       ud.create("prova", "prova");
       dao.rollbackTransaction();
       dao.closeTransaction();
       dao = new DAOFactory();
       dao.beginTransaction();
        
       assertThrows(MissingObjectException.class, () -> {
        DAOFactory daoo = new DAOFactory();
        daoo.beginTransaction();
        UtenteDAO udd = daoo.getUtenteDAO();
        udd.findByUsername("prova");
    });
       }

       catch(Exception ex)
       {
        System.out.println(ex.getMessage());
       }

    }

    @Test
    public void commitExceptionTest()
    {
        DAOFactory dao = new DAOFactory();
        try{
        dao.commitTransaction();
        
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    @Test
    public void rollbackExceptionTest()
    {
        DAOFactory dao = new DAOFactory();
        try{
        dao.rollbackTransaction();
        
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    @Test
    public void closeExceptionTest()
    {
        DAOFactory dao = new DAOFactory();
        try{
        dao.closeTransaction();
        
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    
}
