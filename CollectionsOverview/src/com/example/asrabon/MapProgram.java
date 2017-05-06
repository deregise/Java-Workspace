package com.example.asrabon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sloan on 5/5/2017.
 */
public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "A compiled high level, object-oriented, platform independent language");
        languages.put("Python", "An interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "An algorithmic language");
        System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        System.out.println(languages.get("Java"));
        if(languages.containsKey("Java")) {
            System.out.println("Java is already in the map.");
        } else {
            System.out.println(languages.put("Java", "This course is about java"));
        }
        System.out.println(languages.get("Java"));


//        languages.remove("Lisp");
        if(languages.remove("Algol", "A family of algorithmic languages")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key/value pair not found.");
        }

        if(languages.replace("Lisp", "This will not work" , "A functional programming language with imperative features")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaced");
        }

        System.out.println(languages.replace("Scala", "This will not be added to the hash map."));

        System.out.println("==================================================");

        for(String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }

}
