package com.testbdd.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class testJPA {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("oracleDB");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getWord("abricot");
		ENTITY_MANAGER_FACTORY.close();
	}
	

	public static void getWord(String word) {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	
    	// the lowercase c refers to the object
    	// :custID is a parameterized query thats value is set below
    	String query = "SELECT c FROM Dictionnaire c WHERE c.word = :word";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Dictionnaire> tq = em.createQuery(query, Dictionnaire.class);
    	tq.setParameter("word", word);
    	

 	
    	Dictionnaire cust = null;
    	try {
    		// Get matching customer object and output
    		cust = tq.getSingleResult();
    		System.out.println(cust.getWord() + " " + cust.getFletter() + " " + cust.getLength());
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
	
	 
	// public static void getWords() {
	    	//EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	    	//String strQuery = "SELECT d FROM DICTIONARY d WHERE d.id IS NOT NULL";
	    	
	    	//TypedQuery<Dictionnaire> tq = em.createQuery(strQuery, Dictionnaire.class);  
	    	//List<Dictionnaire> words;
	    	
	    	//try {
	    	//	words = tq.getResultList();
	    	//	words.forEach(word->System.out.println(word.getWord() + " " + word.getFletter() + " " + word.getLength()));
	    //	}
	    	
	    //	catch(NoResultException ex) {
	    //		ex.printStackTrace();
	    //	}
	    //	finally {
	    //		em.close();
	    //	}
	    	
	// } 

 
}

