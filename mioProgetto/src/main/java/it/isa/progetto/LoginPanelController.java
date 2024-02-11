package it.isa.progetto;

public class LoginPanelController {

    public Utente login(String username, String password) throws WrongPasswordException, MissingObjectException
    {
        Utente utente = new Utente();
        DAOFactory df = new DAOFactory();
        df.beginTransaction();
        UtenteDAO dao = df.getUtenteDAO();
        utente = dao.findByUsername(username);
        df.commitTransaction();
        df.closeTransaction();
        if(!(utente.getPassword().equals(password)) )
        throw new WrongPasswordException("Password errata!");
        else return utente;

        
    }
    

}
