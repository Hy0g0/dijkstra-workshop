package main;

public class City{

    private int ID;
    private String name;
    private double lon;
    private double lat;

    public City(int ID, String name, double lon, double lat) {
        this.ID = ID;
        this.name = name;
        this.lon = lon;
        this.lat = lat;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public double getDistance(City otherCity) {
        double earthRadius = 6371; // Radius of the Earth in kilometers

        double lat1 = Math.toRadians(this.lat);
        double lon1 = Math.toRadians(this.lon);
        double lat2 = Math.toRadians(otherCity.getLat());
        double lon2 = Math.toRadians(otherCity.getLon());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                 + Math.cos(lat1) * Math.cos(lat2)
                 * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c; // Distance in kilometers
    }

    @Override
    public String toString() {
        return "City{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}