/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_m03uf6;

import examen_m03uf6.Connexio.ConnexioSQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davidcc99
 */
public class EventDaoImpl extends ConnexioSQL implements EventDao {

    static EventDaoImpl e = new EventDaoImpl();
    ResultSet rs;
    List<Event> llistaDeEvents = new ArrayList<>();
    static List<Event> llistaDeEventsFinal;

    static Event e1;
    static Event e2;
    static Event e3;

    static Event eModificat;

    public static void main(String[] args) throws Exception {
        
        llistaDeEventsFinal = e.readAll();
        for (Iterator it = llistaDeEventsFinal.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
        
        e1 = new Event("Proba1", "Desc1", new Date(07 - 01 - 2021), true);
        e2 = new Event("Proba2", "Desc2", new Date(17 - 01 - 2021), true);
        e3 = new Event("Proba3", "Desc3", new Date(27 - 01 - 2021), false);

        //eModificat = new Event("Proba4", "Desc4", new Date(30 - 01 - 2021), true);

        Boolean insert = e.create(e1);
        Boolean insert2 = e.create(e2);
        //Boolean insert3 = e.create(e3);

        //System.out.println("Resultats inserts;" + insert + ", " + insert2);

        Boolean update = e.update(eModificat);
        
        //System.out.println("Udpate; " + update);
        
        Boolean delete = e.delete(2);
        //System.out.println("Delete; " + delete);
        
        /*llistaDeEventsFinal = e.readAll();
        for (Iterator it = llistaDeEventsFinal.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }*/
        
        //Boolean find = e.find(8);
        //System.out.println("Find; " + find);

        //Boolean createF = e.create("prueba1", "descripcio1");
        //System.out.println("Create; " + createF);

        llistaDeEventsFinal = e.readAllSystemEvents();
        for (Iterator it = llistaDeEventsFinal.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }

    @Override
    public boolean create(Event event) throws Exception {
        PreparedStatement ps = null;
        Connection conn = getConnexio();
        Boolean create = false;

        String insert = "INSERT INTO event_examen (nom, descripcio, data_event, system_event)"
                + "VALUES(?,?,?,?)";

        try {
            ps = conn.prepareStatement(insert);

            ps.setString(1, event.getNom());
            ps.setString(2, event.getDescripcio());
            ps.setDate(3, event.getData_event());
            ps.setBoolean(4, event.isSystem());
            ps.execute();
            
            create = true;

        } catch (SQLException ex) {
            Logger.getLogger(EventDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return create;
    }

    @Override
    public List<Event> readAll() throws Exception {
        Statement st = null;
        Connection conn = getConnexio();

        String query = "SELECT * FROM event_examen";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);

            Event event;

            while (rs.next()) {
                event = new Event(rs.getString("nom"), rs.getString("descripcio"),
                        rs.getDate("data_event"), rs.getBoolean("system_event"));
                event.setId(rs.getInt("id"));
                llistaDeEvents.add(event);
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        return llistaDeEvents;
    }

    @Override
    public boolean update(Event event) throws Exception {
        PreparedStatement ps = null;
        Connection conn = getConnexio();
        Boolean upd = false;

        String update = "UPDATE event_examen SET nom=?, descripcio=? WHERE id=?";

        try {
            ps = conn.prepareStatement(update);
            ps.setString(1, event.getNom());
            ps.setString(2, event.getDescripcio());
            ps.setInt(3, 1);
            ps.execute();
            
            upd = true;

        } catch (SQLException ex) {
            Logger.getLogger(EventDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return upd;

    }

    @Override
    public boolean delete(Event event) throws Exception {
        PreparedStatement ps = null;
        Connection conn = getConnexio();
        Boolean del = false;

        String delete = "DELETE FROM event_examen WHERE id=?";

        try {
            ps = conn.prepareStatement(delete);
            ps.setInt(1, 1);
            ps.execute();
            
            del = true;

        } catch (SQLException ex) {
            Logger.getLogger(EventDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return del;
    }
    

	@Override
	public boolean find(int id) throws Exception {
		Statement st = null;
        Connection conn = getConnexio();
        Boolean fin = false;

        String f1 = "SELECT * FROM event_examen WHERE id=" + id;

        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(f1);
            while (rs.next())
            {
            	fin = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fin;
	}
	

	@Override
	public boolean delete(int id) throws Exception {
		PreparedStatement ps = null;
        Connection conn = getConnexio();
        Boolean del = false;

        String delete = "DELETE FROM event_examen WHERE id=" + id;

        try {
            ps = conn.prepareStatement(delete);
            ps.execute();
            
            del = true;

        } catch (SQLException ex) {
            Logger.getLogger(EventDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return del;
	}

	@Override
	public List<Event> readAllSystemEvents() throws Exception {
		Statement st = null;
        Connection conn = getConnexio();

        String query = "SELECT * FROM event_examen WHERE system_event = true";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);

            Event event;

            while (rs.next()) {
                event = new Event(rs.getString("nom"), rs.getString("descripcio"),
                        rs.getDate("data_event"), rs.getBoolean("system_event"));
                event.setId(rs.getInt("id"));
                llistaDeEvents.add(event);
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        return llistaDeEvents;
    }

	@Override
	public boolean create(String nom, String descripcio) throws Exception {
        Connection conn = getConnexio();
        Boolean create = false;
        
        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int anio = fecha.get(Calendar.YEAR);

        llistaDeEvents = e.readAll();
        int id = (llistaDeEvents.size() + 1);
        
        String insert = "INSERT INTO event_examen (nom, descripcio, data_event, system_event)"
                + "VALUES(" +nom+ ","+ descripcio +","+ anio +"-"+ mes + "-" + dia +",false)";

        try {
            Statement statement = conn.createStatement();
            int result = statement.executeUpdate(insert);
            
            if(result > 0) {
            	create = true;
            }
            else {
            	create = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return create;
	}

}
