package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingsTest {
    @Before
    public void setUp() throws Exception {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "D2000sep10");
    }



    @Test
    public void Sighting_location_true_string(){
        Sightings testSightings = new Sightings("Zone B", "Kamala", "tiger");
        assertEquals("Zone B", testSightings.getLocation());
    }
    @Test
    public void save_successfully_List() {
        Sightings testSightings = new Sightings("Zone A", "Kamala", "Zebra");;
        testSightings.save();
        assertTrue(Endangered.getAllEndangered().get(0).equals(testSightings));
    }

    @After
    public void tearDown() throws Exception {
        try (Connection con = DB.sql2o.open()) {
            String sqlAnimal = "DELETE FROM animals *;";
            con.createQuery(sqlAnimal).executeUpdate();
        }
    }
}

