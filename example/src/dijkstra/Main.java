package dijkstra;

import dijkstra.Cities;

public class Main {
    public static void main(String[] args) {
        Cities cities = new Cities();
        cities.loadCitiesFromCSV("../../city-list/occitanie-cities-top-1000.csv"); // Provide the path to your CSV file

        // System.out.println("List of Cities:");
        // for (City city : cities.getAllCities()) {
        //     System.out.println(city);
        // }

        // City cit = cities.getCity(1);
        // City cit2 = cities.getCity(2);
        //System.out.printf("%.2f",cit.getDistance(cit2));
        System.out.println(cities.getDistanceInOrder());
        System.out.println(cities.OrderButBetter());
        System.out.println(cities.dijkstra());
        // Float dist = cities.get(1)
    }
}
