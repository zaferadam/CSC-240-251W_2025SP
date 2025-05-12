package runtime;

import classes.FoodList;
import classes.Food;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Driver {

	private FoodList shopMenu;
	private boolean running;
	private int selection;
	private static final Scanner scan = new Scanner(System.in); // Static Scanner for input

	public Driver() {
		shopMenu = new FoodList();
	}

	public void run() {
		running = true;
		shopMenu = scanFoodList("foods.txt");
		while (running) {
			// Display menu
			System.out.println("-----------------------------");
			System.out.println("Welcome to Parkland Meal Planning System");
			System.out.println("-----------------------------");
			System.out.println("Enter any of the following:");
			System.out.println("     1) List all foods in the linked list");
			System.out.println("     2) Create a meal by manually selecting three foods");
			System.out.println("     3) Create a meal by randomly selecting three foods");
			System.out.println("     4) Remove foods from the list that are high in calorie");
			System.out.println("     5) Quit");

			try {
				selection = scan.nextInt(); // Get user menu choice
				scan.nextLine(); // Consume newline
			} catch (Exception e) {
				System.out.println("Invalid input! Please enter a number.");
				scan.nextLine(); // Clear buffer
				continue;
			}

			// Handle menu options
			switch (selection) {
			case 1:
				String headerFormat = "%-20s %-15s %15s %15s\n";
				String header = String.format(headerFormat, "Name", "Food Group", "Calories", "Daily Value(%)");
				System.out.println("==========================================================================");
				System.out.print(header);
				System.out.println("==========================================================================");
				System.out.println(shopMenu);
				break;

			case 2:
				System.out.println("Manual Meal");
				int items = 0;
				String names = "";
				double calCount = 0;
				double dailyPercent = 0;
				while (items < 3) {
					System.out.print("Enter food name: ");
					String input = scan.nextLine();
					Food inputFood = shopMenu.findFoodName(input);
					if (shopMenu.isInList(inputFood)) {
						names+=inputFood.getName() + " ";
						calCount+=inputFood.getCalories();
						dailyPercent+=inputFood.getDailyPercent()*100;
						items++;
					} else {
						System.out.println("Food " + input + " not in database, try again");
					}
				}
				System.out.println("===============================");
				System.out.println("Your selected meal");
				System.out.println("Foods: " + names);
				System.out.println("Total calorie count: " + calCount);
				System.out.println("Total daily percentage: " + dailyPercent + "%");
				break;

			case 3:
				System.out.println("Random Meal");
				items = 0;
				names = "";
				calCount = 0;
				dailyPercent = 0;
				int max = shopMenu.length();
				while (items < 3) {
					int randIndex = ThreadLocalRandom.current().nextInt(0, max);
					Food inputFood = shopMenu.findFoodIndex(randIndex);
					names+=inputFood.getName() + " ";
					calCount+=inputFood.getCalories();
					dailyPercent+=inputFood.getDailyPercent()*100;
					items++;
				}
				System.out.println("===============================");
				System.out.println("Your selected meal");
				System.out.println("Foods: " + names);
				System.out.println("Total calorie count: " + calCount);
				System.out.println("Total daily percentage: " + dailyPercent + "%");
				break;

			case 4:
				System.out.print("Enter calorie limit: ");
				String input = scan.nextLine();
				double calLimit;
				FoodList toBeRemoved = new FoodList();
				try{
					calLimit = Double.parseDouble(input);
					for (int i=0; i<shopMenu.length(); i++) {
						Food current = shopMenu.findFoodIndex(i);
						if (current.getCalories()>calLimit) {
							toBeRemoved.add(current);
						}
					}
					for (int i=0; i<toBeRemoved.length(); i++) {
						Food current = toBeRemoved.findFoodIndex(i);
						shopMenu.remove(current);
					}
					headerFormat = "%-20s %-15s %15s %15s\n";
					header = String.format(headerFormat, "Name", "Food Group", "Calories", "Daily Value(%)");
					System.out.println("==========================================================================");
					System.out.print(header);
					System.out.println("==========================================================================");
					System.out.println(shopMenu);
				} catch (NumberFormatException e) {
					System.out.println("Invalid entry, calorie limit must be a number");
				}
				break;
			
			case 5:
				running = false;
				break;

			default:
				System.out.println("Invalid Selection"); // Invalid menu option
				break;
			}
		}
	}

	public FoodList scanFoodList(String fileName) {
		FoodList scannedList = new FoodList();
		try (Scanner fileScanner = new Scanner(new File(fileName))) {
			int valid = 0, invalid = 0;
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] parts = line.split(" ");
				if (parts.length < 4) {
					invalid++;
					continue;
				}

				String name = parts[0];
				String type = parts[1];
				try {
					double calories = Double.parseDouble(parts[2]);
					double daily = Double.parseDouble(parts[3]);
					Food food = new Food(name, type, calories, daily);
					scannedList.add(food);
					valid++;
				} catch (NumberFormatException e) {
					System.out.println("Invalid value in line: " + line);
					invalid++;
				}
			}
			System.out.println("File: " + fileName + " imported successfully with " + scannedList.length() + " valid and " + invalid
					+ " invalid entries");
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		}
		return scannedList;
	}
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.run();
	}
}
