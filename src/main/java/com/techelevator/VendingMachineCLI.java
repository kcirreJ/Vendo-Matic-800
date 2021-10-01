package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachineItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private static String[] fileArray = new String[4];
	private static List<VendingMachineItem> vendingMachineItemList = new ArrayList<>();

	static File vendingMachineStockFile = new File("C:\\Users\\arrow\\Desktop\\pair programming\\capstone\\vendingmachine.csv");

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				for (VendingMachineItem item : vendingMachineItemList) {
					if (item.getItemStock() == 0) {
						System.out.println(item.toString().replace("itemStock: 0","itemStock: SOLD OUT"));
					} else {
						System.out.println(item);
					}
				}

			}
			if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			}
			if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}
			}

		}

	public static void main(String[] args) {
		try (Scanner stockVendingMachine = new Scanner(vendingMachineStockFile)) {
			String oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem A1 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemList.add(A1);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem A2 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemList.add(A2);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem A3 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemList.add(A3);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem A4 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemList.add(A4);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem B1 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemList.add(B1);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem B2 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemList.add(B2);
			oneLineOfFile = stockVendingMachine.nextLine();
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem B3 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemList.add(B3);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem B4 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemList.add(B4);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem C1 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemList.add(C1);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem C2 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemList.add(C2);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem C3 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemList.add(C3);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem C4 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemList.add(C4);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem D1 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemList.add(D1);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem D2 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemList.add(D2);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem D3 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);oneLineOfFile = stockVendingMachine.nextLine();
			vendingMachineItemList.add(D3);
			fileArray = oneLineOfFile.split("\\|");
			VendingMachineItem D4 = new VendingMachineItem(fileArray[0],fileArray[1],Double.parseDouble(fileArray[2]),5);
			vendingMachineItemList.add(D4);
		} catch (FileNotFoundException e) {
			System.out.println("File was not found: " + vendingMachineStockFile.getAbsolutePath());
		}

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}
}
