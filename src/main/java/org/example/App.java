package org.example;

import org.example.kind.Animal;
import org.jfree.ui.RefineryUtilities;

public class App 
{
    public static void main( String[] args ) throws Exception {
        HumanFriends humanFriends = new HumanFriends();
        Animal animal1 = humanFriends.addAnimal("cat", "Marik", "30.07.2023");
        animal1.addCommand("sit");
    }
}
