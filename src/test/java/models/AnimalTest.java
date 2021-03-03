package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {



    @Before
    public void setUp() throws Exception {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "D2000sep10");
    }
//
//    @Test
//    public void Animals_instantiatesName_of_the_animal_true_String() {
//        Animals testAnimals = new Animals("Rhino");
//        assertEquals("Rhino", testAnimals.getAnimalName());
//    }
//
//
//    @Test
//    public void save_successfully_List() {
//        Animals testAnimals = new Animals("Lion");;
//        testAnimals.save();
//        assertTrue(Endangered.getAllEndangered().get(0).equals(testAnimals));
//    }


    @After
    public void tearDown() throws Exception {
        try (Connection con = DB.sql2o.open()) {
            String sqlAnimal = "DELETE FROM animals *;";
            con.createQuery(sqlAnimal).executeUpdate();
        }
    }

    private class Animals {
    }
}
