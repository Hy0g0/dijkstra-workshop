# Dijkstra Workshop

In this workshop, we will use Dijkstra's algorithm and other related algorithms to find the best way to visit all the cities.

## Before Starting

You can use any programming language of your choice as long as you are comfortable with it.

## First Step:

Start by creating three new classes: `City`, `Cities`, and `Main`. Your `Main` class will use the `Cities` class to work, and `Cities` will represent the list of all cities you have.

#### City Class

The `City` class should contain three private properties:

- `ID`: City ID
- `Name`: City name
- `Lon`: Longitude of the city
- `Lat`: Latitude of the city

It should have a constructor that takes these three values as parameters.

#### Cities Class

The `Cities` class should have the following functionalities:

- `add_city(city)`: Adds a city to the list
- `remove_city(city)`: Removes a city from the
- `load_from_file(path)`: Loads the city from a file and add it to the list

## Second step

in the City class add a new functio call `getDistance()` that calculates the distance between this city and an other one gave in parameters using lon and lat.

## Third step

in the Cities class add a new function call `DistanceInOrder()` that calculates the distance between all the cities in the list in order to find the value of the total distance.