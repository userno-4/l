roman decimal
import java.util.Scanner;

public class romanDecimalConvert{
	
	static int val(char c){
		if (c=='I') return 1;
		if (c=='V') return 5;
		if (c=='X') return 10;
		if (c=='L') return 50;
		if (c=='C') return 100;
		if (c=='D') return 500;
		if (c=='M') return 1000;
		return 0;
	};
	
	static int romanToDecimal(String r){
		int total = 0;
		for(int i=0; i<r.length(); i++){
			int current = val(r.charAt(i));
			if (i+1 < r.length()){
				int next = val(r.charAt(i+1));
				if(current < next){
					total -= current;
				}else{
					total += current;
				}
			}else{
				total += current;
			}
		}
		return total;
	}
	
	static String decimalToRoman(int n){
		int[] decimals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		String result = "";
		for(int i=0;i<decimals.length;i++){
			while(n >= decimals[i]){
				result += romans[i];
				n -= decimals[i];
			}
		}
		return result;
	}
	
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Roman value: ");
		String roman = sc.next().toUpperCase();
		System.out.println(roman + " = " + romanToDecimal(roman));
		
		System.out.print("Enter Decimal value: ");
		int decimal = sc.nextInt();
		System.out.println(decimal + " = " + decimalToRoman(decimal));
	}
}

publicationdemo
import java.util.Scanner;

class publication{
	String title;
	double price;
	
	public void getData(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Title: ");
		title = sc.nextLine();
		
		System.out.print("Price: ");
		price = sc.nextDouble();
	}
	
	public void print(){
		System.out.print("Title: " + title + ", Price: $");
	}
}

interface book{
	void getData();
	void print();
}
	
interface magazine{
	void getData();
	void print();
}

class textbook extends publication implements book{
	int accNo;
	
	public void getData(){
		super.getData();
		Scanner sc = new Scanner(System.in);
		System.out.print("Accession No: ");
		accNo = sc.nextInt();
	}
	public void print(){
		super.print();
		System.out.print("Accession No: "+ accNo + " [Book] ");
	}
}

class journal extends publication implements magazine{
	int volumeNo;
	
	public void getData(){
		super.getData();
		Scanner sc = new Scanner(System.in);
		System.out.print("Volume No: ");
		volumeNo = sc.nextInt();
	}
	public void print(){
		super.print();
		System.out.print("Accession No: "+ volumeNo + " [MAGAZINE] ");
	}
}

public class publicationDemo{
	public static void main(String[]args){
		textbook b = new textbook();
		journal m = new journal();
		
		System.out.println("--- BOOK ---");
		b.getData();
		System.out.println("--- MAGAZINE ---");
		m.getData();

		System.out.println("--- OUTPUT ---");
		b.print();
		m.print();
	}
}

cardemo
abstract class Car {
    protected double price;
    protected int year;

    public Car(double price, int year) {
        this.price = price;
        this.year = year;
    }
    abstract double calculateSalePrice();
}

class ClassicCar extends Car {
    public ClassicCar(double price, int year) {
        super(price, year);
    }
    public double calculateSalePrice() {
        return 10.0 * price;
    }
}

class SportCar extends Car {
    public SportCar(double price, int year) {
        super(price, year);
    }
    public double calculateSalePrice() {
        if (year >= 2015)
            return price * 1.75;
        else if (year >= 2005)
            return price * 1.50;
        else
            return price * 1.25;
    }
}

class CarExhibition {
    private Car[] cars = new Car[100];
    private int count = 0;

    void addSportCar(double price, int year) {
        cars[count++] = new SportCar(price, year);
    }
    void addClassicCar(double price, int year) {
        cars[count++] = new ClassicCar(price, year);
    }

    int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += cars[i].calculateSalePrice();
        }
        return total;
    }
}

public class neww {  
    public static void main(String[] args) {
        CarExhibition ex = new CarExhibition();
        ex.addSportCar(10000, 2020);    // 10000 * 1.75 = 17500
        ex.addClassicCar(10000, 1980);  // 10000 * 10 = 100000
        System.out.println("Total: " + ex.getTotalPrice());  // Total: 117500
    }
}

animalhierarchy
abstract class Animal{
	protected int legs;
	
	protected Animal(int legs){
		this.legs = legs;
	}
	
	public void walk(){
		System.out.println("This animal walk using "+ legs + " legs.");
	}
	public abstract void eat();
}

class Spider extends Animal{
	public Spider(){
		super(8);
	}
	public void eat(){
		System.out.println("Spiders eat insects.");
	}
}

interface Pet{
	String getName();
	void setName(String name);
	void play();
}

class Cat extends Animal implements Pet{
	private String name;
	
	public Cat(String name){
		super(4);
		this.name = name;
	}
	public Cat(){
		this("");
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public void play(){
		System.out.println("The cat is play with a ball.");
	}
	public void eat(){
		System.out.println("the cat is eating fish.");
	}
}

class Fish extends Animal implements Pet{
	private String name;
	public Fish(){
		super(0);
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public void play(){
		System.out.println("The fish is swimming.");
	}
	public void eat(){
		System.out.println("the fish is eating flakes.");
	}
	public void walk(){
		System.out.println("Fishs cant walk they hav no legs");
	}
}

public class animalHierarchy{
	public static void main(String[]args){
		Fish d = new Fish();
		d.setName("Nemo");
		
		Cat c = new Cat("Fluffy");
		
		Animal a = new Fish();
		((Fish)a).setName("Goldie");
		
		Animal e = new Spider();
		
		Pet p = new Cat();
		((Cat)p).setName("Whisker");
		
		d.eat(); d.walk(); d.play();
        c.eat(); c.walk(); c.play();
        a.eat(); a.walk();
        e.eat(); e.walk();
        p.play();
		
	}
}

seatreservation
import java.util.Scanner;

public class seatReservation{
	public static void main(String[]args){
		String[][] s = new String[5][8];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i< 5 ; i++){
			for(int j=0; j<8;j++){
				s[i][j] = (i+1)+" "+(j+1);
			}
		}
		
		while(true){
			for(int i=0; i< 5 ; i++){
				for(int j=0; j<8;j++){
					System.out.print(s[i][j]+"\t");
				}
				System.out.println();
			}
			System.out.println("Enter row number and column number:");
			int r = sc.nextInt();
			int c = sc.nextInt();
			if(r==0 && c==0){
				System.out.println("Invalid input");
				break;
			}
			if(r<1 ||r>5 || c<1 || c>8){
				System.out.println("ERROR: Invalid seat!");
			}else if(s[r-1][c-1] == "X"){
				System.out.println("OK - Already reserved!");
			}else{
				s[r-1][c-1] = "X";
				System.out.println("Seat successfully reserved!");
			}
		}
	}
}

cricketapplication

abstract class Player {
    protected int id;
    protected String name;
    protected String country;
    protected int[] scores;
    
    Player(int id, String name, String country, int[] scores) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.scores = scores;
    }
    
    public int getPlayerID() { return id; }
    public String getName() { return name; }
    public String getCountry() { return country; }
    
    abstract void addScore(int score);
    abstract void printDetails();
}

class Batsman extends Player {
    int runs;
    
    Batsman(int id, String name, String country, int[] scores) {
        super(id, name, country, scores);
        for (int x : scores)
            runs += x;
    }
    
    public int getRuns() { return runs; }
    
    @Override
    void addScore(int score) {
        if (score >= 0 && score <= 100) {
            int[] newScores = new int[scores.length + 1];
            for (int i = 0; i < scores.length; i++)
                newScores[i] = scores[i];
            newScores[scores.length] = score;
            scores = newScores;
            runs += score;
            System.out.println("Score " + score + " added to " + name);
        } else {
            System.out.println("Invalid score! Must be between 0 and 100");
        }
    }
    
    @Override
    void printDetails() {
        System.out.println("--- Batsman ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Country: " + country);
        System.out.print("Scores: ");
        for (int s : scores) System.out.print(s + " ");
        System.out.println("\nTotal Runs: " + runs);
        System.out.println();
    }
}

class Bowler extends Player {
    int wickets;
    
    Bowler(int id, String name, String country, int[] scores) {
        super(id, name, country, scores);
        for (int x : scores)
            wickets += x;
    }
    
    public int getWickets() { return wickets; }
    
    @Override
    void addScore(int score) {
        if (score >= 0 && score <= 10) {
            int[] newScores = new int[scores.length + 1];
            for (int i = 0; i < scores.length; i++)
                newScores[i] = scores[i];
            newScores[scores.length] = score;
            scores = newScores;
            wickets += score;
            System.out.println("Wicket " + score + " added to " + name);
        } else {
            System.out.println("Invalid wickets! Must be between 0 and 10");
        }
    }
    
    @Override
    void printDetails() {
        System.out.println("--- Bowler ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Country: " + country);
        System.out.print("Wickets per match: ");
        for (int s : scores) System.out.print(s + " ");
        System.out.println("\nTotal Wickets: " + wickets);
        System.out.println();
    }
}

public class cricketApplication {
    public static void main(String[] args) {
        // Batsmen array
        Batsman[] batsmen = new Batsman[5];
        batsmen[0] = new Batsman(1, "Sachin Tendulkar", "India", 
            new int[]{42, 0, 61, 15, 0, 100, 23, 64, 41, 0, 26});
        batsmen[1] = new Batsman(2, "Virat Kohli", "India", 
            new int[]{0, 25, 10, 60, 11, 0, 40, 11, 0, 2, 0});
        batsmen[2] = new Batsman(3, "MS Dhoni", "India", 
            new int[]{6, 22, 48, 0, 11, 69, 0, 21, 19, 0, 42});
        batsmen[3] = new Batsman(4, "Ricky Ponting", "Australia", 
            new int[]{11, 0, 28, 0, 64, 18, 45, 26, 0, 11, 0});
        batsmen[4] = new Batsman(5, "Brian Lara", "West Indies", 
            new int[]{0, 13, 21, 47, 0, 69, 17, 0, 12, 0, 40});
        
        // Bowlers array (wickets as integers)
        Bowler[] bowlers = new Bowler[5];
        bowlers[0] = new Bowler(1, "Muttiah Muralitharan", "Sri Lanka", 
            new int[]{0, 10, 6, 0, 0, 4, 6});
        bowlers[1] = new Bowler(2, "Shane Warne", "Australia", 
            new int[]{6, 1, 2, 4, 10, 6});
        bowlers[2] = new Bowler(3, "Wasindu Hasaranga", "Sri Lanka", 
            new int[]{0, 1, 6, 4, 0, 0});
        bowlers[3] = new Bowler(4, "Glenn McGrath", "Australia", 
            new int[]{4, 6, 10, 1, 6, 0});
        bowlers[4] = new Bowler(5, "Dale Steyn", "South Africa", 
            new int[]{0, 4, 2, 6, 10, 8});
        
        // e) Print all details
        System.out.println("========== ALL BATSMEN ==========");
        for (Batsman b : batsmen) b.printDetails();
        
        System.out.println("========== ALL BOWLERS ==========");
        for (Bowler b : bowlers) b.printDetails();
        
        // f) Add Score 14 to Batsman 1
        System.out.println("========== ADDING SCORE 14 TO SACHIN ==========");
        batsmen[0].addScore(14);
        batsmen[0].printDetails();
        
        // f) Batsman with highest runs
        Batsman topBatsman = batsmen[0];
        for (Batsman b : batsmen) {
            if (b.getRuns() > topBatsman.getRuns())
                topBatsman = b;
        }
        System.out.println("========== BATSMAN WITH HIGHEST RUNS ==========");
        topBatsman.printDetails();
        
        // f) Bowler with highest wickets
        Bowler topBowler = bowlers[0];
        for (Bowler b : bowlers) {
            if (b.getWickets() > topBowler.getWickets())
                topBowler = b;
        }
        System.out.println("========== BOWLER WITH HIGHEST WICKETS ==========");
        topBowler.printDetails();
        
        // f) Players from Australia
        System.out.println("========== PLAYERS FROM AUSTRALIA ==========");
        for (Batsman b : batsmen) {
            if (b.getCountry().equals("Australia"))
                b.printDetails();
        }
        for (Bowler b : bowlers) {
            if (b.getCountry().equals("Australia"))
                b.printDetails();
        }
    }
}

student reg
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private String course;
    private double marks;
    private static String collegeName = "National College";
    
    Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    
    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
    
    public static String getCollegeName() {
        return collegeName;
    }
    public static void setCollegeName(String collegeName) {
        Student.collegeName = collegeName;
    }
    
    public void displayInfor() {
        System.out.println("Student ID:\t " + id);
        System.out.println("Student name:\t " + name);
        System.out.println("Student Course:\t " + course);
        System.out.println("Student Marks:\t " + marks);
        System.out.println("College:\t " + collegeName);
        System.out.println("---------------------------");
    }
}

public class practise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many Students? (Max 5):\t ");
        int n = sc.nextInt();
        
        if (n < 1 || n > 5) {
            System.out.println("Invalid number! Must be between 1 and 5.");
            sc.close();
            return;  // Return ONLY when invalid
        }
        
        Student[] std = new Student[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Course: ");
            String course = sc.nextLine();
            System.out.print("Marks: ");
            double marks = sc.nextDouble();
            
            std[i] = new Student(id, name, course, marks);
        }
        
        System.out.println("\n=== All Registered Students ===");
        for (Student s : std) {
            s.displayInfor();
        }
        
        sc.close();
    }
}

bill system
import java.util.*;

class Customer {
    private final int id;
    private String name;
    String address;
    
    Customer(int id, String name, String address) {
        this.id = id;
        setName(name);
        this.address = address;
    }
    
    void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name required!");
        }
        this.name = name;
    }
    
    int getId() { return id; }
    
    void display() {
        System.out.println("Customer ID:\t" + id);
        System.out.println("Customer Name:\t" + name);
        System.out.println("Address:\t" + address);
    }
}

abstract class UtilityAccount {
    Customer c;
    double units;
    double bill;
    
    UtilityAccount(Customer c, double units) {
        this.c = c;
        if (units < 0) {
            throw new IllegalArgumentException("Units can't be negative!");
        }
        this.units = units;
    }
    
    abstract void calBill(); 
    abstract void genBill();
}

class EleAcc extends UtilityAccount {
    EleAcc(Customer c, double units) {
        super(c, units);
        calBill();
    }
    
    void calBill() {
        bill = units * 6;
        if (units > 300) bill += bill * 0.10;
    }
    
    void genBill() {
        System.out.println("\n⚡ ELECTRICITY BILL for Customer " + c.getId());
        System.out.println("Units: " + units);
        System.out.println("Rate: $6/unit");
        if (units > 300) System.out.println("10% surcharge applied");
        System.out.printf("Total: $%.2f\n", bill);
    }
}

class WaterAcc extends UtilityAccount {
    WaterAcc(Customer c, double units) {
        super(c, units);
        calBill();
    }
    
    void calBill() {
        bill = units * 2;
        if (units > 500) bill += 150;  //  Fixed $150, not 10%
    }
    
    void genBill() {
        System.out.println("\n WATER BILL for Customer " + c.getId());
        System.out.println("Units: " + units);
        System.out.println("Rate: $2/unit");
        if (units > 500) System.out.println("$150 fixed charge added");
        System.out.printf("Total: $%.2f\n", bill);
    }
}

public class BillSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<UtilityAccount> list = new ArrayList<>();
        
        System.out.print("How many Customers: ");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nCustomer " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();  
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            
            Customer c = new Customer(id, name, address);
            
            System.out.print("Electricity units: ");
            double e = sc.nextDouble();
            System.out.print("Water units: ");
            double w = sc.nextDouble();
            
            list.add(new EleAcc(c, e));
            list.add(new WaterAcc(c, w));
        }
        
        System.out.println("\n========== ALL BILLS ==========");
        for (UtilityAccount acc : list) {
            acc.genBill();
        }
        
        double total = 0;
        for (UtilityAccount acc : list) {
            total += acc.bill;
        }
        System.out.printf("\n TOTAL REVENUE: $%.2f\n", total);
    }
}