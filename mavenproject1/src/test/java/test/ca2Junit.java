/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mapper.PersonMapper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tobbe
 */
public class ca2Junit {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    PersonMapper pm = new PersonMapper(emf);
    
    public ca2Junit() {
    }

    @Test
    public void createPerson(){
        
    }
    
    
    
    @Test
    public void testGetALlZipCodes(){
        List<Integer> zip = pm.getAllZipCodes();
        int actual = zip.size();
        int expected = 1352;
        assertEquals(actual, expected);
    }
}
