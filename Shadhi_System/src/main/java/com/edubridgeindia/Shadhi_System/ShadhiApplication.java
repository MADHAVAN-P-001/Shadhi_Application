package com.edubridgeindia.Shadhi_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Profile {
	String name;
	int age;
	String gender;
	String location;

	public Profile(String name, int age, String gender, String location) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getCity() {
		return location;
	}

	public String toString() {
		return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Location: " + location;
	}

	public void setName(String newName) {
		// TODO Auto-generated method stub

	}

	public void setAge(int newAge) {
		// TODO Auto-generated method stub

	}

	public void setGender(String newGender) {
		// TODO Auto-generated method stub

	}

	public void setCity(String newCity) {
		// TODO Auto-generated method stub

	}

}

public class ShadhiApplication {
	public static List<Profile> profiles = new ArrayList<>();
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int choice;

		do {
			displayMenu();
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				AddProfile();
				break;
			case 2:
				updateProfile();
				break;
			case 3:
				viewProfiles();
				break;
			case 4:
				recommendProfile();
				break;
			case 5:
				deleteProfile();
				break;
			case 6:
				searchProfile();
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (choice != 0);
	}

	public static void displayMenu() {
		System.out.println("Matrimony Application Menu:");
		System.out.println("1. New Profile");
		System.out.println("2. Update Profile");
		System.out.println("3. View Profiles");
		System.out.println("4. Recommended Profile");
		System.out.println("5. Delete Profile");
		System.out.println("6. Search Profile");
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
	}

	public static void AddProfile() {
		System.out.print("Enter Name: ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.print("Enter Age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Gender: ");
		String gender = scanner.nextLine();
		System.out.print("Enter Location: ");
		String location = scanner.nextLine();

		Profile profile = new Profile(name, age, gender, location);
		profiles.add(profile);

		System.out.println("Profile added successfully!");
	}

	private static void updateProfile() {
		System.out.print("Enter the name of the profile you want to update: ");
		String nameToUpdate = scanner.next();

		boolean profileFound = false;
		for (Profile profile : profiles) {
			if (profile.getName().equalsIgnoreCase(nameToUpdate)) {
				profileFound = true;
				System.out.println("Profile found. What would you like to update?");
				System.out.println("1. Update Name");
				System.out.println("2. Update Age");
				System.out.println("3. Update Gender");
				System.out.println("4. Update City");
				System.out.print("Enter your choice (1-4): ");
				int updateChoice = scanner.nextInt();

				switch (updateChoice) {
				case 1:
					System.out.print("Enter the new name: ");
					String newName = scanner.next();
					profile.setName(newName);
					System.out.println("Name updated successfully!");
					break;
				case 2:
					System.out.print("Enter the new age: ");
					int newAge = scanner.nextInt();
					profile.setAge(newAge);
					System.out.println("Age updated successfully!");
					break;
				case 3:
					System.out.print("Enter the new gender: ");
					String newGender = scanner.next();
					profile.setGender(newGender);
					System.out.println("Gender updated successfully!");
					break;
				case 4:
					System.out.print("Enter the new city: ");
					String newCity = scanner.next();
					profile.setCity(newCity);
					System.out.println("City updated successfully!");
					break;
				default:
					System.out.println("Invalid update choice.");
					break;
				}

				break;
			}
		}

		if (!profileFound) {
			System.out.println("Profile not found.");
		}
	}

	private static void viewProfiles() {
		System.out.println("List of Profiles:");
		for (Profile profile : profiles) {
			System.out.println(profile);
		}
	}

	private static void recommendProfile() {
		System.out.println("Recommended Profiles:");
		int maxAgeDifference = 5;
		String preferredGender = "Female";
		String preferredCity = "cuddalore";

		for (Profile profile : profiles) {
			int ageDifference = Math.abs(profile.getAge() - maxAgeDifference);
			if (ageDifference <= maxAgeDifference && profile.getGender().equalsIgnoreCase(preferredGender)
					&& profile.getCity().equalsIgnoreCase(preferredCity)) {
				System.out.println(profile);
			}
		}
	}

	private static void deleteProfile() {
		System.out.print("Enter the name of the profile you want to delete: ");
		String nameToDelete = scanner.next();

		boolean profileFound = false;
		for (Profile profile : profiles) {
			if (profile.getName().equalsIgnoreCase(nameToDelete)) {
				profiles.remove(profile);
				System.out.println("Profile deleted successfully!");
				profileFound = true;
				break;
			}
		}

		if (!profileFound) {
			System.out.println("Profile not found.");
		}
	}

	private static void searchProfile() {
		System.out.println("Search Profiles:");
		System.out.println("1. Search by Name");
		System.out.println("2. Search by Age");
		System.out.println("3. Search by Gender");
		System.out.println("4. Search by City");
		System.out.print("Enter your search criteria (1-4): ");
		int searchCriteria = scanner.nextInt();

		switch (searchCriteria) {
		case 1:
			System.out.print("Enter the name to search: ");
			String nameToSearch = scanner.next();
			searchByName(nameToSearch);
			break;
		case 2:
			System.out.print("Enter the age to search: ");
			int ageToSearch = scanner.nextInt();
			searchByAge(ageToSearch);
			break;
		case 3:
			System.out.print("Enter the gender to search: ");
			String genderToSearch = scanner.next();
			searchByGender(genderToSearch);
			break;
		case 4:
			System.out.print("Enter the city to search: ");
			String cityToSearch = scanner.next();
			searchByCity(cityToSearch);
			break;
		default:
			System.out.println("Invalid search criteria. Please try again.");
		}
	}

	private static void searchByName(String nameToSearch) {
		System.out.println("Profiles matching the name '" + nameToSearch + "':");
		for (Profile profile : profiles) {
			if (profile.getName().equalsIgnoreCase(nameToSearch)) {
				System.out.println(profile);
			}
		}
	}

	private static void searchByAge(int ageToSearch) {
		System.out.println("Profiles matching the age " + ageToSearch + ":");
		for (Profile profile : profiles) {
			if (profile.getAge() == ageToSearch) {
				System.out.println(profile);
			}
		}
	}

	private static void searchByGender(String genderToSearch) {
		System.out.println("Profiles matching the gender '" + genderToSearch + "':");
		for (Profile profile : profiles) {
			if (profile.getGender().equalsIgnoreCase(genderToSearch)) {
				System.out.println(profile);
			}
		}
	}

	private static void searchByCity(String cityToSearch) {
		System.out.println("Profiles matching the city '" + cityToSearch + "':");
		for (Profile profile : profiles) {
			if (profile.getCity().equalsIgnoreCase(cityToSearch)) {
				System.out.println(profile);
			}
		}
	}

}
