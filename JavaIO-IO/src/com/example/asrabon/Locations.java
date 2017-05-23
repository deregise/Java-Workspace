package com.example.asrabon;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Sloan on 5/22/2017.
 */
public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new HashMap<>();
    private static Locations locationsInstance;

    public static void main(String[] args) throws IOException {
        Locations locations = Locations.getLocationsInstance();
        try (FileWriter locationFile = new FileWriter("Locations.txt");
            FileWriter directionsFile = new FileWriter("Directions.txt");
        ) {
            for(Location location: locations.values()) {
                locationFile.write(location.getLocationID() + "," + location.getDescritpion() + "\n");
                for(String direction : location.getExits().keySet()) {
                    directionsFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }

//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                fileWriter.write(location.getLocationID() + "," + location.getDescritpion() + "\n");
//            }
//        } finally {
//            System.out.println("In finally block");
//                if (fileWriter != null) {
//                    fileWriter.close();
//                }
//        }
    }

    public static Locations getLocationsInstance() {
        if(locationsInstance == null) {
            locationsInstance = new Locations();
        }
        return locationsInstance;
    }

    private Locations() {
        Scanner in = null;
        try {
            in = new Scanner(new FileReader("Locations.txt"));
            in.useDelimiter(",");
            while(in.hasNextLine()) {
                int loc = in.nextInt();
                in.skip(in.delimiter());
                String description = in.nextLine();
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                in.close();
            }
        }
//        Map<String, Integer> tempExits = null;
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("W", 2);
//        tempExits.put("E", 3);
//        tempExits.put("S", 4);
//        tempExits.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("N", 1);
//        tempExits.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("S", 1);
//        tempExits.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest", tempExits));
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}