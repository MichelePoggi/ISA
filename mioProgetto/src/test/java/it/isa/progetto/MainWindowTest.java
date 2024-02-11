package it.isa.progetto;

import java.io.File;


import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.core.matcher.JTextComponentMatcher;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.Test;

public class MainWindowTest extends AbstractUiTest {

    private JButtonFixture login;
    private JButtonFixture indietro1;
    private JButtonFixture registrati;
    private JButtonFixture indietro2;
    private JButtonFixture conferma2;
    private JButtonFixture conferma1;
    private JButtonFixture ok;
    private JButtonFixture song;
    private JButtonFixture invio1;
   
    private JButtonFixture logout;



    private JTextComponentFixture username2;
    private JTextComponentFixture password2;
    private JTextComponentFixture username1;
    private JTextComponentFixture password1;
    private JTextComponentFixture cerca1;
    

    @Override
    protected void onSetUp() {
        this.login = this.frame.button(JButtonMatcher.withText("Login"));
        this.registrati = this.frame.button(JButtonMatcher.withText("Registrati"));
        
       
    }

    @Test
    public void testWithDifferingComponentMatchers() {
        // use JTextComponentMatcher.any() as there is only one text input
        
        this.registrati.requireVisible().requireEnabled().click();
        this.indietro2 = this.frame.button(JButtonMatcher.withName("Indietro2"));
        this.indietro2.requireVisible().requireEnabled().click();
        this.login.requireVisible().requireEnabled().click();
        this.indietro1 = this.frame.button(JButtonMatcher.withName("Indietro1"));
        this.indietro1.requireVisible().requireEnabled().click();
        this.registrati.requireVisible().requireEnabled().click();
        this.username2=this.frame.textBox(JTextComponentMatcher.withName("Username2"));
        this.password2=this.frame.textBox(JTextComponentMatcher.withName("Password2"));
        this.conferma2 = this.frame.button(JButtonMatcher.withName("Conferma2"));

        this.username2.enterText("test");
        this.password2.enterText("test");
        this.conferma2.requireVisible().requireEnabled().click();
        this.ok = this.frame.button(JButtonMatcher.withText("OK"));
        this.ok.requireVisible().requireEnabled().click();
        this.registrati.requireVisible().requireEnabled().click();
        this.username2.deleteText();
        this.password2.deleteText();
        this.username2.enterText("test");
        this.password2.enterText("test");
        this.conferma2.requireVisible().requireEnabled().click();
        this.ok = this.frame.button(JButtonMatcher.withText("OK"));
        this.ok.requireVisible().requireEnabled().click();
        this.indietro2.requireVisible().requireEnabled().click();
        this.login.requireVisible().requireEnabled().click();
        this.username1=this.frame.textBox(JTextComponentMatcher.withName("Username1"));
        this.password1=this.frame.textBox(JTextComponentMatcher.withName("Password1"));
        this.conferma1 = this.frame.button(JButtonMatcher.withName("Conferma1"));
        this.username1.enterText("test1");
        this.password1.enterText("test1");
        this.conferma1.requireVisible().requireEnabled().click();
        this.ok = this.frame.button(JButtonMatcher.withText("OK"));
        this.ok.requireVisible().requireEnabled().click();
        this.username1.deleteText();
        this.password1.deleteText();
        this.username1.enterText("test");
        this.password1.enterText("test1");
        this.conferma1.requireVisible().requireEnabled().click();
        this.ok = this.frame.button(JButtonMatcher.withText("OK"));
        this.ok.requireVisible().requireEnabled().click();
        this.username1.deleteText();
        this.password1.deleteText();
        this.username1.enterText("test");
        this.password1.enterText("test");
        this.conferma1.requireVisible().requireEnabled().click();
        this.ok = this.frame.button(JButtonMatcher.withText("OK"));
        this.ok.requireVisible().requireEnabled().click();
        this.song = this.frame.button(JButtonMatcher .withName("1").andShowing());
        this.song.requireVisible().requireEnabled().click();
        this.song = this.frame.button(JButtonMatcher .withName("1").andShowing());
        this.song.requireVisible().requireEnabled().click();
        this.cerca1=this.frame.textBox(JTextComponentMatcher.withName("Cerca1").andShowing());
        this.invio1 = this.frame.button(JButtonMatcher .withName("Invio1").andShowing());
        this.cerca1.enterText("hhhhhhhhh");
        this.invio1.requireVisible().requireEnabled().click();
        this.ok = this.frame.button(JButtonMatcher.withText("OK"));
        this.ok.requireVisible().requireEnabled().click();
        this.cerca1.deleteText();
        this.cerca1.enterText("money");
        this.invio1.requireVisible().requireEnabled().click();
        this.song = this.frame.button(JButtonMatcher .withName("5").andShowing());
        this.song.requireVisible().requireEnabled().click();
        this.logout = this.frame.button(JButtonMatcher .withName("Logout").andShowing());
        this.logout.requireVisible().requireEnabled().click();
        this.login.requireVisible().requireEnabled().click();
        this.username1=this.frame.textBox(JTextComponentMatcher.withName("Username1"));
        this.password1=this.frame.textBox(JTextComponentMatcher.withName("Password1"));
        this.conferma1 = this.frame.button(JButtonMatcher.withName("Conferma1"));
        this.username1.deleteText();
        this.password1.deleteText();
        this.username1.enterText("test");
        this.password1.enterText("test");
        this.conferma1.requireVisible().requireEnabled().click();
        this.ok = this.frame.button(JButtonMatcher.withText("OK"));
        this.ok.requireVisible().requireEnabled().click();
        
        this.logout = this.frame.button(JButtonMatcher .withName("Logout").andShowing());
        this.logout.requireVisible().requireEnabled().click();
        
        this.frame.close();




       


       
        // use value assigned in MainWindow class via JTextArea.setName("Center-Area") to identify component here
        

        
       
        
    }

    @Override
    protected void onTearDown() {
        this.login = null;
        this.indietro1=null;
        this.registrati=null;
        this.indietro2=null;
        this.password2=null;
        this.username2=null;
        this.conferma2=null;
        this.conferma1=null;
        this.password1=null;
        this.username1=null;
        this.ok=null;
        this.cerca1=null;
        this.invio1=null;
        this.song=null;
        
        this.logout=null;

        try{
            Utente utente = new Utente();
      
        DAOFactory df = new DAOFactory();
        df.beginTransaction();
        UtenteDAO dao = df.getUtenteDAO();
        utente=dao.findByUsername("test");
        dao.deleteUtente(utente);
        df.commitTransaction();
        df.closeTransaction();
    }

    catch(Exception ex)
    {
        System.out.println(ex.getMessage());
    }


        File file = new File("songs/l.mp3");
        file.delete();
        
    }
}
