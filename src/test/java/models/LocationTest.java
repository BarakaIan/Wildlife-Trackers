package models;

import org.junit.After;
import org.junit.Test;
import org.sql2o.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocationTest {

    private Location setUpLocation(){
        return new Location("Near the River");
    }

    @Test
    public void locationInstantiatesCorrectly() {
        Location testLocation = setUpLocation();
        assertTrue(testLocation instanceof Location);
    }

    @Test
    public void getNameReturnsLocationNameCorrectly() {
        Location testLocation = setUpLocation();
        assertEquals("Near the River", testLocation.getName());
    }

    @Test
    public void setIdSetsIdCorrectly_1() {
        Location testLocation = setUpLocation();
        testLocation.setId(1);
        assertEquals(1, testLocation.getId());
    }

    @Test
    public void equalsWorksCorrectly_true() {
        Location testLocation = setUpLocation();
        Location testSecondLocation = new Location("Near the River");
        assertTrue(testLocation.equals(testSecondLocation));
    }

    @After
    public void tearDown() throws Exception {
        try (Connection con = DB.sql2o.open()) {
            String sqlAnimal = "DELETE FROM animals *;";
            con.createQuery(sqlAnimal).executeUpdate();
        }
    }
}
