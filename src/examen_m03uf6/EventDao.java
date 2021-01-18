/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_m03uf6;

import java.util.List;

/**
 *
 * @author davidcc99
 */
public interface EventDao {
	
    // Retorna true si es crea l'event correctament
	boolean create(Event event) throws Exception;

	//Retorna true si es crea l'event correctament i data es la data actual, system false 1
	boolean create(String nom, String descripcio) throws Exception;
	
	//Retorna true si es crea l'event correctament
	List<Event> readAll() throws Exception;

	// Retorna true si s'actualitza l'event correctament
	boolean update(Event event) throws Exception;
	
	//Retorna true si lo encuentra 
	boolean find(int id) throws Exception;

	// Retorna true si s'elimina l'event correctament
	boolean delete(Event event) throws Exception;
	
	// Retorna true si s'elimina l'event correctament
	boolean delete(int id) throws Exception;
	
	// Retorna una lista de eventos de sistema: system == true 1
	List<Event> readAllSystemEvents() throws Exception;

}
