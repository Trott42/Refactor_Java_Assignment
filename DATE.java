package refactoringDate;
import java.util.Scanner;

public class DATE {

  private String month;
  private int day;
  private int year; //a four digit number.

  public DATE() {
    month = "January";
    day = 1;
    year = 1000;
  }

  public DATE(int monthInt, int day, int year) {
    setDate(monthInt, day, year);
  }

  public DATE(String monthString, int day, int year) {
    setDate(monthString, day, year);
  }

  public DATE(int year) {
    setDate(1, 1, year);
  }

  public DATE(DATE aDate) {
    if (aDate == null)//Not a real date.
    {
      System.out.println("Fatal Error.");
      System.exit(0);
    }
    month = aDate.month;
    day = aDate.day;
    year = aDate.year;
  }

  public void setDate(int monthInt, int day, int year) {
    if (dateOK(monthInt, day, year)) {
      this.month = monthString(monthInt);
      this.day = day;
      this.year = year;
    } else {
      System.out.println("Fatal Error");
      System.exit(0);
    }
  }

  public void setDate(String monthString, int day, int year) {
    if (dateOK(monthString, day, year)) {
      this.month = monthString;
      this.day = day;
      this.year = year;
    } else {
      System.out.println("Fatal Error");
      System.exit(0);
    }
  }

  public void setDate(int year) {
    setDate(1, 1, year);
  }

  public void setYear(int year) {
    if ((year < 1000) || (year > 9999)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else {
      this.year = year;
    }
  }

  public void setMonth(int monthNumber) {
    if ((monthNumber <= 0) || (monthNumber > 12)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else {
      month = monthString(monthNumber);
    }
  }

  public void setDay(int day) {
    if ((day <= 0) || (day > 31)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else {
      this.day = day;
    }
  }

  public int getMonth() {
    return switch (month) {
      case "January" -> 1;
      case "February" -> 2;
      case "March" -> 3;
      case "April" -> 4;
      case "May" -> 5;
      case "June" -> 6;
      case "July" -> 7;
      case "August" -> 8;
      case "September" -> 9;
      case "October" -> 10;
      case "November" -> 11;
      case "December" -> 12;
      default -> {
        System.out.println("Fatal Error");
        System.exit(0);
        yield 0;
      }

    };
  }

  public int getDay() {
    return day;
  }

  public int getYear() {
    return year;
  }

  public String toString() {
    return (month + " " + day + ", " + year);
  }

  public boolean equals(DATE otherDate) {
    return ((month.equals(otherDate.month))
        && (day == otherDate.day) && (year == otherDate.year));
  }

  public boolean precedes(DATE otherDate) {
    return ((year < otherDate.year) ||
        (year == otherDate.year && getMonth() < otherDate.getMonth()) ||
        (year == otherDate.year && month.equals(otherDate.month)
            && day < otherDate.day));
  }

  public void readInput() {
    var tryAgain = true;
    var keyboard = new Scanner(System.in);
    while (tryAgain) {
      System.out.println("Enter month, day, and year.");
      System.out.println("Do not use a comma.");
      String monthInput = keyboard.next();
      var dayInput = keyboard.nextInt();
      var yearInput = keyboard.nextInt();
      if (dateOK(monthInput, dayInput, yearInput)) {
        setDate(monthInput, dayInput, yearInput);
        tryAgain = false;
      } else {
        System.out.println("Illegal date. Reenter input.");
      }
    }
  }

  private boolean dateOK(int monthInt, int dayInt, int yearInt) {
    return ((monthInt >= 1) && (monthInt <= 12) &&
        (dayInt >= 1) && (dayInt <= 31) &&
        (yearInt >= 1000) && (yearInt <= 9999));
  }

  private boolean dateOK(String monthString, int dayInt, int yearInt) {
    return (monthOK(monthString) &&
        (dayInt >= 1) && (dayInt <= 31) &&
        (yearInt >= 1000) && (yearInt <= 9999));
  }

  private boolean monthOK(String month) {
    return switch (month) {
    		case "january", "feburary", "March", "April","May", "June", "July", "August", "September", "October", "November", "December" -> true;
    		default-> false;
    };
}
    /*switch (monthNumber) {
      case "January" -> System.out.println(1);
      case "February" -> System.out.println(2);
      case "March" -> System.out.println(3);
      case "April" -> System.out.println(4);
      case "May" -> System.out.println(5);
      case "June" -> System.out.println(6);
      case "July" -> System.out.println(7);
      case "August" -> System.out.println(8);
      case "September" -> System.out.println(9);
      case "October" -> System.out.println(10);
      case "November" -> System.out.println(11);
      case "December" -> System.out.println(12);
      default;
        System.out.println("Fatal Error");
        System.exit(0);
    }

   return "Error";

     */
    private String monthString(int monthNumber) {
    return switch (monthNumber) {
      case 1 -> "January";
      case 2 -> "February";
      case 3 -> "March";
      case 4 -> "April";
      case 5 -> "May";
      case 6 -> "June";
      case 7 -> "July";
      case 8 -> "August";
      case 9 -> "September";
      case 10 -> "October";
      case 11 -> "November";
      case 12 -> "December";
      default -> {
        System.out.println("Fatal Error");
        System.exit(0);
        yield "Error";
      }

    };
  }
}
