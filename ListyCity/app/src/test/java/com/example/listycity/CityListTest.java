package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the CityList class.
 */
class CityListTest {

    /**
     * Creates a mock CityList with one sample city.
     *
     * @return a CityList containing a single mock City
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * Creates a mock City object.
     *
     * @return a City object representing Edmonton, Alberta
     */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * Example test case to verify adding a city works correctly.
     */
    @Test
    void testAddCity() {
        CityList cityList = new CityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertTrue(cityList.getCities().contains(city));
    }
    /**
     * Verifies that adding a duplicate city throws an IllegalArgumentException.
     */
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * Verifies that the list of cities is returned in sorted order.
     */
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // Check if the first city in the sorted list matches the mock city
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // Add a new city that should come before the mock city alphabetically
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Verify that Charlottetown is now first and Edmonton is second
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     * Tests whether hasCity() correctly identifies existing cities.
     */
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(city)); // not in list yet
        cityList.add(city);
        assertTrue(cityList.hasCity(city)); // now it should be there
    }

    /**
     * Tests whether delete() actually removes the city from the list.
     */
    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    /**
     * Tests whether delete() throws exception when city does not exist.
     */
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Toronto", "Ontario");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     * Tests whether countCities() returns correct size.
     */
    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Halifax", "Nova Scotia"));
        assertEquals(2, cityList.countCities());
    }
}
