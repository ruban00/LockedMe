package com.LockedMe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {

	static String filePath = " ";
	static String errorMessage = "An error has occured please contact admin : john@LockedMe.com";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner obj = new Scanner(System.in);
		int opt = 0;
		do {
			Menu();
			System.out.println("Choose an option");
			opt = obj.nextInt();
		
			switch (opt) {
			case 1:
				setFilePath();
				break;
			case 2:
				getFiles();
				break;
			case 3:
				addFiles();
				break;
			case 4:
				deleteAllFiles();
				break;
			case 5:
				searchFiles();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Incorrect option");
			}
		} while (opt > 0);

	}

	public static void Menu() {
		System.out.println(addBulletPoint("Set File Path"));
		System.out.println(addBulletPoint("Display All Files"));
		System.out.println(addBulletPoint("Add new file"));
		System.out.println(addBulletPoint("Delete a file"));
		System.out.println(addBulletPoint("Search a file"));
		System.out.println(addBulletPoint("Exit"));
	}

	public static void setFilePath() {
		Scanner sc = new Scanner(System.in);
		System.out.println("please set file path");
		filePath = sc.nextLine();
		
	}

	private static String addBulletPoint(String string) {
		// TODO Auto-generated method stub
		return ('\u2022' + "" + string);
	}

	public static void getFiles() {
		try {
			File folder = new File(filePath);
			File[] listOfFiles = folder.listFiles();
			if (listOfFiles.length == 0) {
				System.out.println("File does not exist");
			} else {
				for (var f : listOfFiles) {
					System.out.println(f.getName());
				}
			}
		} catch (Exception e) {
			System.out.println(errorMessage);
		}
	}

	public static void addFiles() {
		try {

			Scanner input = new Scanner(System.in);
			String fileName;
			System.out.println("Enter the name of the file");
			fileName = input.nextLine();
            
			File file = new File(filePath, fileName);
			if (file.createNewFile()) {
				System.out.println("File has been created Successfully");
			} else {
				System.out.println("file already exists");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	public static void deleteAllFiles() {
		Scanner object=new Scanner(System.in);
		try {
			String fileName;
			System.out.println("Enter the name of the file to delete");
			fileName = object.nextLine();
		
			File file = new File(filePath, fileName);
			if (file.exists()) {
				file.delete();
				System.out.println("File has been deleted successfully");
			} else {
				System.out.println("File does not exist");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	public static void searchFiles() {
		Scanner sh = new Scanner(System.in);
		try {
			String fileName;
			System.out.println("Enter the name of the file to searched");
			fileName = sh.nextLine();
			
			File folder = new File(filePath);
			File[] listOfFiles = folder.listFiles();
			LinkedList<String> fileNames = new LinkedList<String>();
			System.out.println(filePath);
			if (null!=listOfFiles) {
				for (var f : listOfFiles) {
					fileNames.add(f.getName());
				  fileNames.contains(filePath+"\\"+fileName);
				}
				if (fileNames.contains(fileName)) {
					System.out.println("File found");
				} else {
					System.out.println("File not found");
				}
			} else {
				System.out.println("File not found");
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		finally {

		}

	}

}
