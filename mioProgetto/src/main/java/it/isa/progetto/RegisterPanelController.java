package it.isa.progetto;

public class RegisterPanelController {
    
    public void register(String username, String password) throws DuplicatedObjectException
    {
        Utente utente = new Utente();
        utente.setUsername(username);
        utente.setPassword(password);
        DAOFactory df = new DAOFactory();
        df.beginTransaction();
        UtenteDAO dao = df.getUtenteDAO();
        dao.create(username, password);
        df.commitTransaction();
        df.closeTransaction();
        

    }
}
