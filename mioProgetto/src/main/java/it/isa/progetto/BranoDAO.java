package it.isa.progetto;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class BranoDAO {
    
private Connection conn;

BranoDAO(Connection conn)
{
    this.conn=conn;
}

public Brano findById(int id) throws MissingObjectException
{
    PreparedStatement ps;
    Brano brano = new Brano();

    try{
        String sql="SELECT *"
                +" FROM Brano"
                +" WHERE ID= ?";

        ps=conn.prepareStatement(sql);
        int i=1;
        ps.setInt(i++, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            brano.setId(rs.getInt("Id"));
            brano.setTitolo(rs.getString("Titolo"));
            brano.setAlbum(rs.getString("Album"));
            brano.setArtista(rs.getString("Artista"));
            Blob blob = rs.getBlob("File");
            int blobLength = (int) blob.length();
            byte[] blobAsBytes = blob.getBytes(1, blobLength);
            blob.free();
            brano.setCanzone(blobAsBytes);
            rs.close();
            ps.close();
            
        }
        else 
        {
            rs.close();
            ps.close();
            throw new MissingObjectException("brano non trovato");
        }

    }

    

    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }

    return brano;
}


public List<Brano> findByString(String stringa) throws MissingObjectException
{
    PreparedStatement ps;
    List <Brano> brani = new ArrayList<Brano>();
    Brano brano;

    try{
        String sql="SELECT *"
                +" FROM Brano"
                +" WHERE ( INSTR(Titolo,?)>0"
                +" OR  INSTR(Album,?)>0"
                +" OR  INSTR(Artista,?)>0"
                +" OR  INSTR(Album,?)>0 )"
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
            brano = new Brano();
            brano.setId(rs.getInt("Id"));
            brano.setTitolo(rs.getString("Titolo"));
            brano.setAlbum(rs.getString("Album"));
            brano.setArtista(rs.getString("Artista"));
            
            brani.add(brano);
            }
            while(rs.next());

            rs.close();
            ps.close();
            
        }
        else 
        {
            rs.close();
            ps.close();
            throw new MissingObjectException("brano non trovato");
        }

    }

    

    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }

    return brani;
}


public List<Brano> findAllBrani() 
{
    Statement st;
    List <Brano> brani = new ArrayList<Brano>();
    Brano brano;

    try{
        String sql="SELECT *"
                +" FROM Brano"
                +" ORDER BY ID DESC";

        st= conn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        
        
            while(rs.next())
            {
            brano = new Brano();
            brano.setId(rs.getInt("Id"));
            brano.setTitolo(rs.getString("Titolo"));
            brano.setAlbum(rs.getString("Album"));
            brano.setArtista(rs.getString("Artista"));
            
            brani.add(brano);
            }
            

            rs.close();
            st.close();
            
        }
    

    

    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }

    return brani;
}

public int countAllBrani() throws MissingObjectException
{
    Statement st;
    int i=0;

    try{
        String sql="SELECT COUNT(*) as N"
                +" FROM Brano";

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
