package it.isa.progetto;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class LoginPanelControllerTest {

    @Test
    public void loginTest()
    {
        LoginPanelController lpc = new LoginPanelController();
        RegisterPanelController rpc = new RegisterPanelController();
        try{
        rpc.register("prova", "prova");
        Utente utente = lpc.login("prova", "prova");
        DAOFactory df = new DAOFactory();
        df.beginTransaction();
        UtenteDAO dao = df.getUtenteDAO();
        dao.deleteUtente(dao.findByUsername("prova"));
        df.commitTransaction();
        df.closeTransaction();
        
        assertEquals(utente.getUsername(), "prova");
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void loginTestException()
    {
        LoginPanelController lpc = new LoginPanelController();
        RegisterPanelController rpc = new RegisterPanelController();
        try{
        rpc.register("prova", "prova");
        assertThrows(WrongPasswordException.class, () -> {lpc.login("prova", "provo"); });
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        finally
        {
            DAOFactory df = new DAOFactory();
            df.beginTransaction();
            UtenteDAO dao = df.getUtenteDAO();
            try{
                dao.deleteUtente(dao.findByUsername("prova"));
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            finally{
            df.commitTransaction();
            df.closeTransaction();
            }
        }
    }
    
}
