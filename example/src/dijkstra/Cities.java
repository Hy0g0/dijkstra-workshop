package dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import dijkstra.City;


public class Cities {
    private ArrayList<City> cityList;

    public Cities() {
        this.cityList = new ArrayList<>();
    }

    public void addCity(City city) {
        cityList.add(city);
    }

    public List<City> getAllCities() {
        return cityList;
    }

    public City getCity(int id){
        return cityList.get(id);
    }

    public void loadCitiesFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // Flag to skip the first line
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip the first line
                }

                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String[] coordinates = parts[2].split(", ");
                    double lat = Double.parseDouble(coordinates[0]);
                    double lon = Double.parseDouble(coordinates[1]);
                    City city = new City(id, name, lat, lon);
                    addCity(city);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getDistanceInOrder(){
        City prevCity = this.getCity(0);
        double totaldist = 0;
        for (City city : cityList) {
            if (prevCity != null){
                totaldist += city.getDistance(prevCity);
                prevCity = city;
            }
        }

        return totaldist;
    }

    public double OrderButBetter(){
        ArrayList<City> unvisited = new ArrayList<>(cityList);
        ArrayList<City> order = new ArrayList<City>();
        City city = unvisited.get(0);
        order.add(city);
        double totaldist = 0;
        unvisited.remove(city);
        while(!unvisited.isEmpty()) {
            double bestdist = city.getDistance(unvisited.get(0));
            City bestcity = unvisited.get(0);
            for (City city2 : unvisited) {
            double newdist = city.getDistance(city2);
            if (newdist < bestdist){
                 bestdist = newdist;
                 bestcity = city2;
                }
        }
       totaldist += bestdist;
       city = bestcity;
       order.add(city);
       unvisited.remove(city);
    }
    //System.out.println(order.toString());
    return totaldist;
}


public double dijkstra(){
    ArrayList<City> unvisited = new ArrayList<>(cityList); // Create a copy of the cityList to track unvisited cities
    Map<City, Double> distanceMap = new HashMap<>();
    
    // Initialize distanceMap with a large initial value (infinity)
    for (City city : cityList) {
        distanceMap.put(city, Double.MAX_VALUE);
    }
    
    // Set the distance of the starting city to 0
    distanceMap.put(cityList.get(0), 0.0);
    
    while (!unvisited.isEmpty()) {
        City city = Collections.min(distanceMap.values());

        
        // Uncomment the following loop to update distances to neighbors
        for (City city2 : unvisited) {
                double alt = distanceMap.get(u) + u.getDistance(city2);
                if (alt < distanceMap.get(city2)) {
                    distanceMap.put(city2, alt);
                }
        }
        
        unvisited.remove(city);
    }
    
    return 0.0;
}

}