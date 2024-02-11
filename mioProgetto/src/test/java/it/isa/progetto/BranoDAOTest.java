package it.isa.progetto;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class BranoDAOTest {

    @Test
    public void findByIdExistingTest()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");

            
            Brano brano = new Brano();
            
            Brano brano2 = new Brano();
            File file = new File("src/test/java/it/isa/progetto/Files/05. Mone.mp3");
            byte[] bytes = Files.readAllBytes(file.toPath());
            brano.setId(5);
            brano.setTitolo("Money");
            brano.setAlbum("The Dark Side Of The Moon");
            brano.setArtista("Pink Floyd");
            brano.setCanzone(bytes);

            BranoDAO dao = new BranoDAO(con);
            brano2=dao.findById(brano.getId());
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

        catch(Exception e)
        {
            System.out.println(e.getMessage()+" eccezione");
        }
    }

    @Test
    public void findByIdNotExistingTest()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");

                BranoDAO dao = new BranoDAO(con);
                
                assertThrows(MissingObjectException.class, () -> {dao.findById(0);});

        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findByStringExistingTest()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");

                List<Brano> brani = new ArrayList<Brano>();
                BranoDAO dao = new BranoDAO(con);
                brani=dao.findByString("money");
            Brano brano = new Brano();
            Brano brano2 = new Brano();
            
            brano.setId(5);
            brano.setTitolo("Money");
            brano.setAlbum("The Dark Side Of The Moon");
            brano.setArtista("Pink Floyd");
           
            brano2=brani.get(0);
            assertEquals(brano.getId(), brano2.getId());
            assertEquals(brano.getTitolo(), brano2.getTitolo());
            assertEquals(brano.getAlbum(), brano2.getAlbum());
            assertEquals(brano.getArtista(), brano2.getArtista());
            
            brani=dao.findByString("");

                
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void findByStringNotExistingTest()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");

                
                BranoDAO dao = new BranoDAO(con);
                
                assertThrows(MissingObjectException.class, () -> {dao.findByString("xxxxxxxxxxxxxxx");});
                
                
                
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void findAllBraniTest()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");

            Statement st = con.createStatement();

            String sql = "SELECT COUNT(*)"
                        +" FROM Brano";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int numero = rs.getInt(1);
            BranoDAO dao = new BranoDAO(con);
            List<Brano> brani= new ArrayList<>();
            brani = dao.findAllBrani();
            assertEquals(brani.size(), numero);

                
                
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


@Test
public void findAllBraniSQLExceptionTest()
{
    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
            BranoDAO dao = new BranoDAO(con);
            con.close();
            dao.findAllBrani();
            
        }

        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
}

@Test
public void countAllBraniTest()
{
    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
            BranoDAO dao = new BranoDAO(con);
            int a = dao.countAllBrani();
            int c = ((dao.findAllBrani()).size());
            Statement st;
            String sql= "SELECT COUNT(*) as N"
                        +" FROM Brano";

            st=con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int b=rs.getInt("N");
            rs.close();
            con.close();
            assertEquals(a, b, c);
        }

        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }


    
}

@Test
public void countAllBraniSQLExceptionTest()
{
    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
            BranoDAO dao = new BranoDAO(con);
            con.close();
            dao.countAllBrani();

    }

    catch(Exception ex)
    {
        System.out.println(ex.getMessage());
    }

}



@Test
public void FindByIdSQLExceptionTest()
{
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
        BranoDAO dao = new BranoDAO(con);
        con.close();
        dao.findById(1);
    }

    catch(Exception ex)
    {
        System.out.println(ex.getMessage());
    }

}

@Test
public void FindByStringSQLExceptionTest()
{
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO2", "root", "Internazionale99!");
        BranoDAO dao = new BranoDAO(con);
        con.close();
        dao.findByString("dark");
    }

    catch(Exception ex)
    {
        System.out.println(ex.getMessage());
    }

}



}