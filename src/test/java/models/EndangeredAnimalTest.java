package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndangeredAnimalTest {

    @Before
    public void setUp() throws Exception {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "D2000sep10");
    }


    @Test
    public void animal_instantiatesCorrectly_true() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("Gorilla",EndangeredAnimal.ILL,EndangeredAnimal.ADULT);
        assertEquals(true, testAnimal instanceof EndangeredAnimal);
    }
    @Test
    public void getName_animalInstantiatesWithName_Gorilla() {
        Animals testAnimal = new EndangeredAnimal("Gorilla",EndangeredAnimal.ILL,EndangeredAnimal.ADULT);
        assertEquals("Gorilla", testAnimal.getName());
    }

    @Test
    public void equals_returnsTrueIfNameIsTheSame() {
        EndangeredAnimal firstAnimal = new EndangeredAnimal("Gorilla",EndangeredAnimal.ILL,EndangeredAnimal.ADULT);
        EndangeredAnimal anotherAnimal = new EndangeredAnimal("Gorilla",EndangeredAnimal.ILL,EndangeredAnimal.ADULT);
        assertTrue(firstAnimal.equals(anotherAnimal));
    }
    @After
    public void tearDown() throws Exception {
        try (Connection con = DB.sql2o.open()) {
            String sqlAnimal = "DELETE FROM animals *;";
            con.createQuery(sqlAnimal).executeUpdate();
        }
    }





//    @Test
//    public void save_CorrectlyIntoTheDatabase() {
//        EndangeredAnimal animal = new EndangeredAnimal("Gorilla",EndangeredAnimal.ILL,EndangeredAnimal.ADULT);;
//        animal.save();
//        assertTrue(EndangeredAnimal.allEndangered().get(0).equals(animal));
//    }
}
