# Travelling salesman Workshop

In this workshop, we will use algorithms to find the best way to visit all the cities.

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

in the Cities class add a new function call `getDistanceInOrder()` that calculates the distance between all the cities in the list in order to find the value of the total distance.

Great Job ! Now you have your first result and from here we will try to determine a better distance by upgrading our algorythms

## Fourth step

Now we will upgrade our previous algorithm and not only use the order of our array.

Your objectif is by starting from the city `0` Always find the nearest city to reduce by far our traject.

Create a function in the class `Cities` called `OrderButBetter()` and test it.

See how much better it is already !

## Fifth step

Now, we will implement the Dijkstra's algorithm to find the shortest path to travel. We will always start from `0`, which is Muret in our array.

![Muret](ressources/Muret.jpg)

### Dijkstra's Algorithm
