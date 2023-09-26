package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.City;

public class Cities {
    private List<City> cityList;

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
}
