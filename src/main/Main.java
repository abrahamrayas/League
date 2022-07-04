package main;

import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
	
	public static void menu() {
		String[] options = {"1.- Execute League", "2.- Exit"};
		System.out.println("Menu");
		for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option: ");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner in = new Scanner(System.in);
			boolean isExit = false;
			while(!isExit) {
				try {
					menu();
					int option = in.nextInt();
					switch (option) {
						case 1:
							System.out.println("");
							System.out.print("Give me the games file name: ");
							String fileName = in.next();
							if (fileName != null && !fileName.isEmpty()) {
								System.out.println("");
								LeagueUtils.executeLeague(fileName);
								System.out.println("");
							}
							break;
						case 2:
							isExit = true;
							System.out.println("Thanks.");
							exit(0);
							break;
						default:
							System.out.println("");
				            System.out.println("The option was invalid!");
				            System.out.println("");
				    }
				} catch (Exception e) {
					System.out.println("");
					if (e.getMessage() == null) {
						System.out.println("Please enter an integer value.");
						System.out.println("");
						in.next();
					} else {
						System.out.println(e.getMessage());
						System.out.println("");
					}
				}
			}
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
	}

}
