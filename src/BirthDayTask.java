import java.util.HashMap;
import java.util.Map;

public class BirthDayTask {

    private final static Map<String, AbstractIngr> MEAL_MAP = new HashMap<>();
    private final static Map<String, AbstractIngr> CATALOGUE_1 = new HashMap<>();
    private final static Map<String, Double> CATALOGUE_2 = new HashMap<>();

    private static int totalCostCount() {
        int totalCost = 0;
        for (AbstractIngr ingr : CATALOGUE_1.values()) {
            int countIngrAllMeals = 0;
            for (Map.Entry<String, AbstractIngr> entry : MEAL_MAP.entrySet()) {
                int count = entry.getValue().countPerMeal * entry.getValue().countFriends;
                System.out.println(entry.getKey() + " " + count);
                countIngrAllMeals = countIngrAllMeals + count;
            }
            int packsCount = countIngrAllMeals / ingr.count_per_pack;
            int ingrCost = ingr.price_per_pack * packsCount;
            totalCost = totalCost + ingrCost;
        }
        return totalCost;
    }

    private static void totalCalories() {
        double count_pr = 0;
        double count_f = 0;
        double count_ch = 0;
        double count_fv = 0;

        for (Map.Entry<String, AbstractIngr> entry : MEAL_MAP.entrySet()) {
            AbstractIngr ingrid = entry.getValue();
            int countIngr = ingrid.countPerMeal * ingrid.countFriends;
            String mealType = ingrid.title;
            count_pr = count_pr + Math.round(countIngr * (CATALOGUE_2.get(mealType + "_pr")));
            count_f = count_f + Math.round(countIngr * (CATALOGUE_2.get(mealType + "_f")));
            count_ch = count_ch + Math.round(countIngr * (CATALOGUE_2.get(mealType + "_ch")));
            count_fv = count_fv + Math.round(countIngr * (CATALOGUE_2.get(mealType + "_fv")));
            ingrid.pr = count_pr;
            ingrid.f = count_f;
            ingrid.ch = count_ch;
            ingrid.fv = count_fv;
        }

        for (Map.Entry<String, AbstractIngr> entry : MEAL_MAP.entrySet()) {
            AbstractIngr ingrid = entry.getValue();
            System.out.println(entry.getKey() + " " + ingrid.pr + " " + ingrid.f + " " + ingrid.ch + " " + ingrid.fv);
        }
    }

    private static void input() {
        AbstractIngr butterForSandwich = new Butter();
        butterForSandwich.title = "butter";
        butterForSandwich.countPerMeal = 10;
        butterForSandwich.unitMeasure = "g";
        butterForSandwich.countFriends = 7;
        MEAL_MAP.put("sandwich", butterForSandwich);

        AbstractIngr breadForSandwich = new ToastBread();
        breadForSandwich.title = "bread";
        breadForSandwich.countPerMeal = 2;
        breadForSandwich.unitMeasure = "ctn";
        breadForSandwich.countFriends = 7;
        MEAL_MAP.put("sandwich", breadForSandwich);

        AbstractIngr sausageForSandwich = new Sausage();
        sausageForSandwich.title = "sausage";
        sausageForSandwich.countPerMeal = 7;
        sausageForSandwich.unitMeasure = "g";
        sausageForSandwich.countFriends = 7;
        MEAL_MAP.put("sandwich", sausageForSandwich);

        AbstractIngr eggsForOmlet = new Egg();
        eggsForOmlet.title = "eggs";
        eggsForOmlet.countPerMeal = 4;
        eggsForOmlet.unitMeasure = "ctn";
        eggsForOmlet.countFriends = 9;
        MEAL_MAP.put("omlet", eggsForOmlet);

        AbstractIngr milkForOmlet = new Milk();
        milkForOmlet.title = "milk";
        milkForOmlet.countPerMeal = 120;
        milkForOmlet.unitMeasure = "ml";
        milkForOmlet.countFriends = 9;
        MEAL_MAP.put("omlet", milkForOmlet);

        AbstractIngr butterInCatalogue1 = new Butter();
        butterInCatalogue1.title = "butter";
        butterInCatalogue1.price_per_pack = 70;
        butterInCatalogue1.count_per_pack = 50;
        butterInCatalogue1.unitMeasure = "g";
        CATALOGUE_1.put("butter", butterInCatalogue1);

        AbstractIngr breadInCatalogue1 = new ToastBread();
        breadInCatalogue1.title = "bread";
        breadInCatalogue1.price_per_pack = 50;
        breadInCatalogue1.count_per_pack = 5;
        breadInCatalogue1.unitMeasure = "ctn";
        CATALOGUE_1.put("bread", breadInCatalogue1);

        AbstractIngr sausageIncatalogue1 = new Sausage();
        sausageIncatalogue1.title = "sausage";
        sausageIncatalogue1.price_per_pack = 700;
        sausageIncatalogue1.count_per_pack = 30;
        sausageIncatalogue1.unitMeasure = "g";
        CATALOGUE_1.put("sausage", sausageIncatalogue1);

        AbstractIngr eggInCatalogue1 = new Egg();
        eggInCatalogue1.title = "eggs";
        eggInCatalogue1.price_per_pack = 70;
        eggInCatalogue1.count_per_pack = 50;
        eggInCatalogue1.unitMeasure = "ctn";
        CATALOGUE_1.put("eggs", eggInCatalogue1);

        AbstractIngr milkInCatalogue1 = new Milk();
        milkInCatalogue1.title = "milk";
        milkInCatalogue1.price_per_pack = 40;
        milkInCatalogue1.count_per_pack = 400;
        milkInCatalogue1.unitMeasure = "ml";
        CATALOGUE_1.put("milk", milkInCatalogue1);

        CATALOGUE_2.put("butter_pr", 0.4);
        CATALOGUE_2.put("butter_f", 0.5);
        CATALOGUE_2.put("butter_ch", 0.7);
        CATALOGUE_2.put("butter_fv", 0.14);

        CATALOGUE_2.put("bread_pr", 0.3);
        CATALOGUE_2.put("bread_f", 0.4);
        CATALOGUE_2.put("bread_ch", 0.5);
        CATALOGUE_2.put("bread_fv", 0.15);

        CATALOGUE_2.put("sausage_pr", 0.3);
        CATALOGUE_2.put("sausage_f", 0.4);
        CATALOGUE_2.put("sausage_ch", 0.5);
        CATALOGUE_2.put("sausage_fv", 0.51);

        CATALOGUE_2.put("eggs_pr", 0.3);
        CATALOGUE_2.put("eggs_f", 0.3);
        CATALOGUE_2.put("eggs_ch", 0.7);
        CATALOGUE_2.put("eggs_fv", 0.16);

        CATALOGUE_2.put("milk_pr", 0.3);
        CATALOGUE_2.put("milk_f", 0.3);
        CATALOGUE_2.put("milk_ch", 0.7);
        CATALOGUE_2.put("milk_fv", 0.16);
    }

    public static void main(String[] args) {
        input();
        System.out.println(totalCostCount());
        totalCalories();
    }


    abstract static class AbstractIngr {
        String title;
        int countPerMeal;
        String unitMeasure;
        int countFriends;

        int count_per_pack;
        int price_per_pack;

        double pr;
        double f;
        double ch;
        double fv;
    }

    private static class Butter extends AbstractIngr {
    }

    private static class ToastBread extends AbstractIngr {
    }

    private static class Sausage extends AbstractIngr {
    }

    private static class Egg extends AbstractIngr {
    }

    private static class Milk extends AbstractIngr {
    }

}
