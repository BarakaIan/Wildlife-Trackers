package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
    private Animal setUpAnimal(){
        return new Animal("Honey Badger", "Young");
    }


    @Before
    public void setUp() throws Exception {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "D2000sep10");
    }

    @Test
    public void animalInstantiatesCorrectly() {
        Animal testAnimal = setUpAnimal();
        assertTrue(testAnimal instanceof Animal);
    }

    @Test
    public void getNameReturnsNameProperly() {
        Animal testAnimal = setUpAnimal();
        assertEquals("Honey Badger", testAnimal.getName());
    }

    @Test
    public void getAgeReturnsAgeProperly() {
        Animal testAnimal = setUpAnimal();
        assertEquals("Young", testAnimal.getAge());
    }

    @Test
    public void setIdSetsIdProperly() {
        Animal testAnimal = setUpAnimal();
        testAnimal.setId(1);
        assertEquals(1, testAnimal.getId());
    }

    @Test
    public void testEquals() {
        Animal testAnimal = setUpAnimal();
        Animal testSecondAnimal = new Animal("Honey Badger", "Young");
        assertTrue(testAnimal.equals(testSecondAnimal));
    }

    @Test(expected = IllegalArgumentException.class)
    public void animalThrowsErrorWhenAgeIsSetToWrongProperty() {
        Animal testSecondAnimal = new Animal("Honey Badger", "not old");
    }

    @Test
    public void ageCannotBeSetToTheWrongProperty() {
        String argumentExceptionMessage = null;
        try{
            Animal testSecondAnimal = new Animal("Honey Badger", "not old");
        } catch(IllegalArgumentException ex){
            argumentExceptionMessage = ex.getMessage();
        }
        assertTrue(argumentExceptionMessage.equals("Bad parameter for age"));
    }

    @After
    public void tearDown() throws Exception {
        try (Connection con = DB.sql2o.open()) {
            String sqlAnimal = "DELETE FROM animals *;";
            con.createQuery(sqlAnimal).executeUpdate();
        }
    }
}
