package it.uniroma3.dia.db1.jdbc;

import it.uniroma3.dia.db1.jdbc.factory.StudentFactory;
import it.uniroma3.dia.db1.jdbc.model.Student;
import it.uniroma3.dia.db1.jdbc.persistence.DatabaseUtils;
import it.uniroma3.dia.db1.jdbc.persistence.StudentRepository;

import java.util.List;

public class UniversityShell {
	
	//Metodo main
	public static void main(String[] args) throws Exception {
		//Metodo che crea le tabelle
		DatabaseUtils.createTables();
		//Metodo che cancella tutti i studenti
		deleteAllStudents(); 	
		//Metodo che stampa gli studenti su console
		generateAndPrint(1100);
	}
	
	public static void deleteAllStudents() throws Exception {
		StudentRepository sp = new StudentRepository();
		List<Student> students = sp.findAll();
		
 		for (Student sc : students) {
			sp.delete(sc);
		}
	}
	
	
	public static void generateAndPrint(int n) throws Exception{
		StudentRepository sp = new StudentRepository();
		List<Student> students = StudentFactory.getInstance().getRandomStudents(n);
		
		for(Student s: students){
			sp.persist(s);			
		}
		
 		for (Student sc : sp.findAll()) {
			System.out.println(sc);
		}
	}
}
