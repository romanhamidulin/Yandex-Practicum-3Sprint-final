package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> businessLunches = new HashMap<>();
    Random random = new Random();

    void addNewDish(String dishType, String dishName) {

        if (checkDish(dishType, dishName)) {
            System.out.println("Данное блюдо уже добавлено в меню ресторана!");
        } else if (checkType(dishType)) {
            ArrayList<String> lunches = businessLunches.get(dishType);
            lunches.add(dishName);
            System.out.println("Блюдо " + dishName + " успешно добавлено в тип " + dishType);
        } else {
            ArrayList<String> newLunches = new ArrayList<String>();
            newLunches.add(dishName);
            businessLunches.put(dishType, newLunches);
            System.out.println("Блюдо " + dishName + " успешно добавлено в тип " + dishType);
        }
    }

    boolean checkType(String type) {
        return businessLunches.containsKey(type);
    }

    boolean checkDish(String dishType, String dishName) {
        ArrayList<String> lunches = businessLunches.get(dishType);

        if (lunches != null && lunches.contains(dishName)) {
            return true;
        }

        return false;
    }

    void generateDishCombo(int numberOfCombo, ArrayList<String> dishesTypes) {
        for (int i = 0; i < numberOfCombo; i++) {
            System.out.println("Комбо " + (i + 1) + ":");
            ArrayList<String> newCombo = new ArrayList<>();
            for (String type : dishesTypes) {
                int dishNumber = random.nextInt(businessLunches.get(type).size());
                String dish = businessLunches.get(type).get(dishNumber);
                newCombo.add(dish);
            }
            System.out.println(String.join(", ", newCombo).concat("\n"));
        }
    }
}
