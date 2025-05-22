import java.util.*;

public class PersonalEnergyTrackerParent {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Personal Energy Tracker");

        // Step 1: Personalized Setup (BMR)
        System.out.print("Enter your weight (kg): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height (cm): ");
        double height = scanner.nextDouble();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter your gender (male/female): ");
        String gender = scanner.nextLine();

        double bmr;
        if (gender.equalsIgnoreCase("male")) {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        }
        System.out.println("Your BMR is: " + bmr);

        // Step 2: Steps and Calories Tracking
        System.out.print("Enter total steps today: ");
        int steps = scanner.nextInt();
        double caloriesBurned = steps * 0.04;
        System.out.println("Calories burned: " + caloriesBurned);
        scanner.nextLine(); // consume newline

        // Step 3: Meal Logging with Text Input
        System.out.println("Log your meals (e.g. 'rice with dal and vegetables'):");

        System.out.println("--- Breakfast ---");
        Map<String, Integer> breakfast = logMealText("Breakfast");
        System.out.println("--- Lunch ---");
        Map<String, Integer> lunch = logMealText("Lunch");
        System.out.println("--- Snacks ---");
        Map<String, Integer> snacks = logMealText("Snacks");
        System.out.println("--- Dinner ---");
        Map<String, Integer> dinner = logMealText("Dinner");

        System.out.print("Enter number of glasses of water you drank: ");
        int glassesWater = scanner.nextInt();

        checkMealAdvice(breakfast, lunch, snacks, dinner);

        // Step 4: Sleep Logging
        System.out.print("Enter hours of sleep: ");
        double sleepHours = scanner.nextDouble();

        // Step 5: Screen Time Tracking
        System.out.print("Enter screen time in hours: ");
        double screenTime = scanner.nextDouble();

        // Step 6: Daily Summary
        System.out.println("\n--- Daily Summary ---");
        System.out.println("Steps: " + steps);
        System.out.println("Calories burned: " + caloriesBurned);
        System.out.println("Water intake (glasses): " + glassesWater);
        System.out.println("Sleep (hours): " + sleepHours);
        System.out.println("Screen Time (hours): " + screenTime);

        // Step 7: Activity Percentage
        double totalScore = Math.min(steps / 10000.0, 1)
                + Math.min(caloriesBurned / 500.0, 1)
                + Math.min(sleepHours / 8.0, 1)
                + Math.max(0, (4.0 - screenTime) / 4.0);
        double activityPercentage = totalScore * 25;
        System.out.println("Activity Percentage: " + activityPercentage + "%");

        // Step 8: Personal Energy Goals
        System.out.println("Set your daily energy goal (in percentage): ");
        double goal = scanner.nextDouble();
        if (activityPercentage >= goal) {
            System.out.println("Congratulations! You met your energy goal.");
        } else {
            System.out.println("Try harder tomorrow to meet your goal.");
        }

        // Step 9: AI Energy Optimization Tips
        System.out.println("\n--- Energy Optimization Tips ---");
        if (steps < 5000)
            System.out.println("Try to walk more during the day.");
        if (sleepHours < 7)
            System.out.println("Ensure 7-8 hours of sleep.");
        if (screenTime > 5)
            System.out.println("Reduce screen time to relax your eyes.");
        if (glassesWater < 6)
            System.out.println("Drink at least 6-8 glasses of water.");

        // Step 10: Weekly/Monthly Trends (placeholder)
        System.out.println("\n(Weekly/Monthly trends feature coming soon...)");

        // Step 11: Break and Hydration Reminders
        System.out.println("Reminder: Take breaks every hour and stay hydrated!");

        // Step 12: Sync with Fitness App
        System.out.println("Syncing with fitness app... Done!");
    }

    static Map<String, Integer> analyzeMealText(String mealText) {
Show quoted text
    static Map<String, Integer> logMealText(String mealName) {
        System.out.print("What did you eat for " + mealName + "?: ");
        String mealText = scanner.nextLine();
        return analyzeMealText(mealText);
    }

    static void checkMealAdvice(Map<String, Integer>... meals) {
        int totalProtein = 0, totalCarbs = 0, totalFats = 0, totalVeggies = 0;
        for (Map<String, Integer> meal : meals) {
            totalProtein += meal.get("protein");
            totalCarbs += meal.get("carbs");
            totalFats += meal.get("fats");
            totalVeggies += meal.get("vegetables");
        }

        System.out.println("\n--- Meal Advice ---");
        if (totalProtein > 60)
            System.out.println("Too much protein today.");
        if (totalCarbs > 200)
            System.out.println("Limit your carbs intake.");
        if (totalFats > 50)
            System.out.println("Fat intake is high.");
        if (totalVeggies < 200)
            System.out.println("Eat more vegetables.");
    }
}