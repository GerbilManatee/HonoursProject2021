/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repositories.Repository;

/**
 *
 * @author hulle_000
 */
public class RepositoryTest {
    
    public RepositoryTest() {
    }
    
    @Test
    public void testConstruction() {
        Repository repository = new Repository("test.txt");
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
