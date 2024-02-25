package it.isa.progetto;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class LibroDAO {
    
private Connection conn;

LibroDAO(Connection conn)
{
    this.conn=conn;
}

public Libro findById(int id) throws MissingObjectException
{
    PreparedStatement ps;
    Libro libro = new Libro();

    try{
        String sql="SELECT *"
                +" FROM Libro"
                +" WHERE ID= ?";

        ps=conn.prepareStatement(sql);
        int i=1;
        ps.setInt(i++, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            libro.setId(rs.getInt("Id"));
            libro.setTitolo(rs.getString("Titolo"));
            libro.setLettore(rs.getString("Lettore"));
            libro.setAutore(rs.getString("Autore"));
            Blob blob = rs.getBlob("File");
            int blobLength = (int) blob.length();
            byte[] blobAsBytes = blob.getBytes(1, blobLength);
            blob.free();
            libro.setAudio(blobAsBytes);
            rs.close();
            ps.close();
            
        }
        else 
        {
            rs.close();
            ps.close();
            throw new MissingObjectException("libro non trovato");
        }

    }

    

    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }

    return libro;
}


public List<Libro> findByString(String stringa) throws MissingObjectException
{
    PreparedStatement ps;
    List <Libro> libri = new ArrayList<Libro>();
    Libro libro;

    try{
        String sql="SELECT *"
                +" FROM Libro"
                +" WHERE ( INSTR(Titolo,?)>0"
                +" OR  INSTR(Lettore,?)>0"
                +" OR  INSTR(Autore,?)>0"
                +" OR  INSTR(Lettore,?)>0 )"
                +" ORDER BY ID DESC";

        ps=conn.prepareStatement(sql);
        int i=1;
        ps.setString(i++, stringa);
        ps.setString(i++, stringa);
        ps.setString(i++, stringa);
        ps.setString(i++, stringa);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            do
            {
            libro = new Libro();
            libro.setId(rs.getInt("Id"));
            libro.setTitolo(rs.getString("Titolo"));
            libro.setLettore(rs.getString("Lettore"));
            libro.setAutore(rs.getString("Autore"));
            
            libri.add(libro);
            }
            while(rs.next());

            rs.close();
            ps.close();
            
        }
        else 
        {
            rs.close();
            ps.close();
            throw new MissingObjectException("libro non trovato");
        }

    }

    

    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }

    return libri;
}


public List<Libro> findAllLibri() 
{
    Statement st;
    List <Libro> libri = new ArrayList<Libro>();
    Libro libro;

    try{
        String sql="SELECT *"
                +" FROM Libro"
                +" ORDER BY ID DESC";

        st= conn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        
        
            while(rs.next())
            {
            libro = new Libro();
            libro.setId(rs.getInt("Id"));
            libro.setTitolo(rs.getString("Titolo"));
            libro.setLettore(rs.getString("Lettore"));
            libro.setAutore(rs.getString("Autore"));
            
            libri.add(libro);
            }
            

            rs.close();
            st.close();
            
        }
    

    

    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }

    return libri;
}

public int countAllLibri() throws MissingObjectException
{
    Statement st;
    int i=0;

    try{
        String sql="SELECT COUNT(*) as N"
                +" FROM Libro";

        st= conn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        
        
            while(rs.next())
            {
            i=rs.getInt("N");
            }
            

            rs.close();
            st.close();
            
        }
    

    

    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }

    return i;
}











}
