package models;

import jdk.vm.ci.code.Location;
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

    private Sightings setUpSightings() {
        Animal testAnimal = new EndangeredSpecie("Honey Badger", "Young", "healthy");
        Location testLocation = new Location("Near the River");
        testAnimal.setId(1);
       testLocation.setId(1);
       return new Sightings(testLocation.getId(),testAnimal.getId());
    }


    @Test
    public void sightingsInstantiatesProperly() {
        Sightings testSighting = setUpSightings();
        assertTrue(testSighting instanceof Sightings);
    }

    @Test
    public void getLocationIdCorrectly_1() {
        Sightings testSighting = setUpSightings();
        assertEquals(1, testSighting.getLocationId());
    }

    @Test
    public void getRangerIdCorrectly_1() {
        Sightings testSighting = setUpSightings();
        assertEquals(1, testSighting.getRangersId());
    }

    @Test
    public void getAnimalIdCorrectly_1() {
        Sightings testSighting = setUpSightings();
        assertEquals(1, testSighting.getAnimalId());
    }

    @Test
    public void setIdSetsIdCorrectly_1() {
        Sightings testSighting = setUpSightings();
        testSighting.setId(1);
        assertEquals(1, testSighting.getId());
    }

    @After
    public void tearDown() throws Exception {
        try (Connection con = DB.sql2o.open()) {
            String sqlAnimal = "DELETE FROM animals *;";
            con.createQuery(sqlAnimal).executeUpdate();
        }
    }

//    @Test
//    public void equalsWorksCorrectly_true() {
//        Sightings testSighting = setUpSightings();
//        Animal testAnimal =  new EndangeredSpecie("Honey Badger", "Young", "healthy");
//        Rangers testRanger =  new Rangers("Kelly Egesa","kelly.egesa@gmail.com", 158920);
//        Location testLocation = new Location("Near the River");
//        testAnimal.setId(1);
//        testRanger.setId(1);
//        testLocation.setId(1);
//        Sightings testSecondSighting = setUpSightings();
//        assertTrue(testSighting.equals(testSecondSighting));
//    }
//
//    private class Rangers {
//        public int getId() {
//        }
//    }
}

