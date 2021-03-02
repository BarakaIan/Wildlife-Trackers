package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndangeredSpecieTest {
    private EndangeredSpecie setUpAnimal(){
        return new EndangeredSpecie("Honey Badger", "Young", "healthy");
    }
//
//    @Before
//    public void setUp() throws Exception {
//        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "D2000sep10");
//    }

    @Test
    public void endangeredSpecie_instantiatesProperly() {
        EndangeredSpecie testEndangeredSpecie = setUpAnimal();
        assertTrue(testEndangeredSpecie instanceof EndangeredSpecie);
    }

    @Test
    public void getNameReturnsNameProperly_HoneyBadger() {
        EndangeredSpecie testEndangeredSpecie = setUpAnimal();
        assertEquals("Honey Badger", testEndangeredSpecie.getName());
    }

    @Test
    public void getAgeReturnsAgeProperly_Young() {
        EndangeredSpecie testEndangeredSpecie= setUpAnimal();
        assertEquals("Young", testEndangeredSpecie.getAge());
    }

    @Test
    public void setIdSetsIdProperly() {
        EndangeredSpecie testEndangeredSpecie= setUpAnimal();
        testEndangeredSpecie.setId(1);
        assertEquals(1, testEndangeredSpecie.getId());
    }

    @Test
    public void equalsWorksCorrectly_true() {
        EndangeredSpecie testEndangeredSpecie = setUpAnimal();
        EndangeredSpecie testSecondEndangeredSpecie = new EndangeredSpecie("Honey Badger", "Young", "healthy");
        assertTrue(testEndangeredSpecie.equals(testSecondEndangeredSpecie));
    }

    @Test(expected = IllegalArgumentException.class)
    public void endangeredSpecieThrowsErrorWhenAWrongPropertyIsSet() {
        EndangeredSpecie testEndangeredSpecie = new EndangeredSpecie("Honey Badger", "Young", "heal");
    }

    @Test
    public void healthCannotBeSetToTheWrongProperty() {
        String argumentExceptionMessage = null;
        try{
            EndangeredSpecie testEndangeredSpecie = new EndangeredSpecie("Honey Badger", "Young", "heal");
        } catch(IllegalArgumentException ex){
            argumentExceptionMessage = ex.getMessage();
        }
        assertTrue(argumentExceptionMessage.equals("Bad parameter for health"));
    }

//    @After
//    public void tearDown() throws Exception {
//        try (Connection con = DB.sql2o.open()) {
//            String sqlAnimal = "DELETE FROM animals *;";
//            con.createQuery(sqlAnimal).executeUpdate();
//        }
//    }
}
