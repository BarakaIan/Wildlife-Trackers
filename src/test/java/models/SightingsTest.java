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
    public void sighting_instantiatesCorrectly_true(){
        Sightings newSight = new Sightings(1,"near the river","paul");
        assertTrue(newSight instanceof Sightings);
    }

    @Test
    public void getLocation_sightingInstantiatesWithLocation(){
        Sightings newSight = new Sightings(1,"near the river","paul");
        assertEquals("near the river",newSight.getLocation());
    }
    @Test
    public void getRangerName_sightingInstantiatesWithRangerName(){
        Sightings newSight = new Sightings(1,"near the river","paul");
        assertEquals("paul",newSight.getRangerName());
    }

//    @Test
//    public void save_CorrectlyIntoTheDatabase() {
//        Sightings newSight = new Sightings(12,"near the river","ian");
//        newSight.save();
//        assertTrue(Sightings.all().get(0).equals(newSight));
//    }

//    @After
//    public void tearDown() throws Exception {
//        try (Connection con = DB.sql2o.open()) {
//            String sqlAnimal = "DELETE FROM animals *;";
//            con.createQuery(sqlAnimal).executeUpdate();
//        }
//    }

//
}

