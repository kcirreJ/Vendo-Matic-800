package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachineItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static Double money = 0.00;

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private static String[] fileArray = new String[4];
	private static Map<String, VendingMachineItem> vendingMachineItemMap = new HashMap();

	static File vendingMachineStockFile = new File("C:\\Users\\arrow\\Desktop\\pair programming\\capstone\\vendingmachine.csv");

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void displayVendingMachineItems() {
		System.out.println("\n");
		for (Map.Entry<String, VendingMachineItem> item : vendingMachineItemMap.entrySet()) {
			if (item.getValue().getItemStock() == 0) {
				System.out.println(item.toString().replace("itemStock: 0","itemStock: SOLD OUT").replace(item.getKey().toString() + "=" + item.getKey().toString(), item.getKey()));
			} else { // print normally
				System.out.println(item.toString().replace(item.getKey() + "=" + item.getKey(), item.getKey()));
			}
		}
	}

	public void feedMoney(Integer money) {
		this.money += money;
	}

	public void subtractMoney(Double money) {
		this.money -= money;
	}

	public void run() {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			// Display choice output
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayVendingMachineItems();
			}

			// purchase choice menu
			if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS); // display purchase menu options

				while (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					// add money to the current money provided counter
					System.out.println("Amount to feed: ");
					try {Scanner userInput = new Scanner(System.in);
						feedMoney(Integer.parseInt(userInput.nextLine()));
					} catch (NumberFormatException e) {
						System.out.println("Money must be in whole dollar amounts");
					}
					System.out.println("Current Money Provided: $" + money);
					choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS); // reset back to purchase options
				}

				while (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					// shows products and allows customer to select one
					displayVendingMachineItems();
					System.out.println("Choose an item: ");
					try {Scanner userInput = new Scanner(System.in);
						VendingMachineItem selectedItem = vendingMachineItemMap.get(userInput.nextLine().toUpperCase(Locale.ROOT));
						if (selectedItem.getItemStock() == 0) {
							System.out.println("That item is currently sold out");
							choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS); // reset back to purchase options
						} else if (selectedItem.getPrice() > money) {
								System.out.println("You do not have enough money for this item");
								choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS); // reset back to purchase options
							} else {
							// dispense messages for chips, candy, drinks, gum
							if (selectedItem.toString().contains("A")) {
								subtractMoney(selectedItem.getPrice());
								selectedItem.depleteStock();
								// print receipt
								System.out.println(selectedItem.getName() + " | " + selectedItem.getPrice() + " | Current Money Provided: $" + money);
								System.out.println("Crunch Crunch, Yum!");
								choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
							} else if (selectedItem.toString().contains("B")) {
								subtractMoney(selectedItem.getPrice());
								selectedItem.depleteStock();
								// print receipt
								System.out.println(selectedItem.getName() + " | " + selectedItem.getPrice() + " | Current Money Provided: $" + money);
								System.out.println("Munch Munch, Yum!");
								choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
							} else if (selectedItem.toString().contains("C")) {
								subtractMoney(selectedItem.getPrice());
								selectedItem.depleteStock();
								// print receipt
								System.out.println(selectedItem.getName() + " | " + selectedItem.getPrice() + " | Current Money Provided: $" + money);
								System.out.println("Glug Glug, Yum!");
								choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
							} else {
								if (selectedItem.toString().contains("D")) {
									subtractMoney(selectedItem.getPrice());
									selectedItem.depleteStock();
									// print receipt
									System.out.println(selectedItem.getName() + " | " + selectedItem.getPrice() + " | Current Money Provided: $" + money);
									System.out.println("Chew Chew, Yum!");
									choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
								}
							}

						}
					} catch (NullPointerException e) {
						System.out.println("Selection must be in the form of an existing slot identifier");
					}
				}

				while (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					System.out.println("Your change is: $" + money);
					money = 0.00;
					break;
				}

				}

			// exit choice output
			if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}

			}

		}

	public static void main(String[] args) {
		try (Scanner stockVendingMachine = new Scanner(vendingMachineStockFile)) {
			String oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem A1 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),0);
			vendingMachineItemMap.put("A1", A1);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem A2 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemMap.put("A2", A2);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem A3 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemMap.put("A3", A3);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem A4 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemMap.put("A4", A4);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem B1 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemMap.put("B1", B1);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem B2 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemMap.put("B2", B2);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem B3 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemMap.put("B3", B3);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem B4 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemMap.put("B4", B4);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem C1 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemMap.put("C1", C1);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem C2 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemMap.put("C2", C2);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem C3 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemMap.put("C3", C3);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem C4 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemMap.put("C4", C4);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem D1 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemMap.put("D1", D1);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem D2 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemMap.put("D2", D2);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem D3 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemMap.put("D3", D3);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem D4 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemMap.put("D4", D4);
		} catch (FileNotFoundException e) {
			System.out.println("File was not found: " + vendingMachineStockFile.getAbsolutePath());
		}

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();


	}
}
