package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable {
    /**
     * Name of the city.
     */
    private String city;
    /**
     * Name of the province where the city is located.
     */
    private String province;

    // Constructor
    /**
     * Constructs a new City object with the specified city and province names.
     *
     * @param city The name of the city
     * @param province The name of the province
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    // Getter for city name
    /**
     * Returns the name of the city.
     *
     * @return The city name
     */
    public String getCityName() {
        return this.city;
    }

    // Getter for province name
    /**
     * Returns the name of the province.
     *
     * @return The province name
     */
    public String getProvinceName() {
        return this.province;
    }


    /**
     * Compares this city to another city by name.
     * @param o the other city object
     * @return 0 if equal, negative if less, positive if greater
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Checks if two City objects are equal based on city and province.
     * @param o the object to compare
     * @return true if both city and province are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City cityObj = (City) o;
        return this.city.equals(cityObj.getCityName()) &&
                this.province.equals(cityObj.getProvinceName());
    }

    /**
     * Returns a hash code value for the city.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return this.city.hashCode() + this.province.hashCode();
    }
}
