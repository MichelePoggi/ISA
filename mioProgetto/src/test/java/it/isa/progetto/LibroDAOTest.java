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


public class LibroDAOTest {

    @Test
    public void findByIdExistingTest()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ISA?user=root&password= &useSSL=false");

            
            Libro libro = new Libro();
            
            Libro libro2 = new Libro();
            File file = new File("src/test/java/it/isa/progetto/Files/Il_Dottore_Nero.mp3");
            byte[] bytes = Files.readAllBytes(file.toPath());
            libro.setId(28);
            libro.setTitolo("Il Dottore Nero");
            libro.setLettore("La Via Della Voce");
            libro.setAutore("A.C.Doyle");
            libro.setAudio(bytes);

            LibroDAO dao = new LibroDAO(con);
            libro2=dao.findById(libro.getId());
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
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ISA?user=root&password= &useSSL=false");

                LibroDAO dao = new LibroDAO(con);
                
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
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ISA?user=root&password= &useSSL=false");

                List<Libro> libri = new ArrayList<Libro>();
                LibroDAO dao = new LibroDAO(con);
                libri=dao.findByString("Il Dottore Nero");
            Libro libro = new Libro();
            Libro libro2 = new Libro();
            
            libro.setId(28);
            libro.setTitolo("Il Dottore Nero");
            libro.setLettore("La Via Della Voce");
            libro.setAutore("A.C.Doyle");
           
            libro2=libri.get(0);
            assertEquals(libro.getId(), libro2.getId());
            assertEquals(libro.getTitolo(), libro2.getTitolo());
            assertEquals(libro.getLettore(), libro2.getLettore());
            assertEquals(libro.getAutore(), libro2.getAutore());
            
            libri=dao.findByString("");

                
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
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ISA?user=root&password= &useSSL=false");

                
                LibroDAO dao = new LibroDAO(con);
                
                assertThrows(MissingObjectException.class, () -> {dao.findByString("xxxxxxxxxxxxxxx");});
                
                
                
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void findAllLibriTest()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ISA?user=root&password= &useSSL=false");

            Statement st = con.createStatement();

            String sql = "SELECT COUNT(*)"
                        +" FROM Libro";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int numero = rs.getInt(1);
            LibroDAO dao = new LibroDAO(con);
            List<Libro> libri= new ArrayList<>();
            libri = dao.findAllLibri();
            assertEquals(libri.size(), numero);

                
                
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


@Test
public void findAllLibriSQLExceptionTest()
{
    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ISA?user=root&password= &useSSL=false");
            LibroDAO dao = new LibroDAO(con);
            con.close();
            dao.findAllLibri();
            
        }

        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
}

@Test
public void countAllLibriiTest()
{
    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ISA?user=root&password= &useSSL=false");
            LibroDAO dao = new LibroDAO(con);
            int a = dao.countAllLibri();
            int c = ((dao.findAllLibri()).size());
            Statement st;
            String sql= "SELECT COUNT(*) as N"
                        +" FROM Libro";

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
public void countAllLibriiSQLExceptionTest()
{
    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ISA?user=root&password= &useSSL=false");
            LibroDAO dao = new LibroDAO(con);
            con.close();
            dao.countAllLibri();

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
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ISA?user=root&password= &useSSL=false");
        LibroDAO dao = new LibroDAO(con);
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
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ISA?user=root&password= &useSSL=false"); 
        LibroDAO dao = new LibroDAO(con);
        con.close();
        dao.findByString("Dottore");
    }

    catch(Exception ex)
    {
        System.out.println(ex.getMessage());
    }

}



}