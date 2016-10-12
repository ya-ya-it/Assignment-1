package assignment;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Daria Davydenko, #200335788
 * 
 * This program simulate simply calculator that allow user to enter 5 grades,
 * calculate and display a letter grade for each course, calculate average grade
 * and show average grade as a letter grade.
 * 
 */
public class Code_Davydenko_200335788 {

    public static void main(String[] args) {
        
        int grade1 = getGrade();
        int grade2 = getGrade();
        int grade3 = getGrade();
        int grade4 = getGrade();
        int grade5 = getGrade();
        double averageGrade = getAverageGrade(grade1, grade2, grade3, grade4, grade5);
        
        //round average grade to to 1 decimal place
        String pattern = "##0.0";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formatAverageGrade = decimalFormat.format(averageGrade);
        
        String letterGrade1 = getLetterGrade(grade1);
        String letterGrade2 = getLetterGrade(grade2);
        String letterGrade3 = getLetterGrade(grade3);
        String letterGrade4 = getLetterGrade(grade4);
        String letterGrade5 = getLetterGrade(grade5);
        String letterAverageGrade = getLetterGrade(averageGrade);
        
        System.out.printf("The mark for the first course was %d%%, "
                + "the letter grade is %s%n", grade1, letterGrade1);
        System.out.printf("The mark for the second course was %d%%, "
                + "the letter grade is %s%n", grade2, letterGrade2);
        System.out.printf("The mark for the third course was %d%%, "
                + "the letter grade is %s%n", grade3, letterGrade3);
        System.out.printf("The mark for the fourth course was %d%%, "
                + "the letter grade is %s%n", grade4, letterGrade4);
        System.out.printf("The mark for the fifth course was %d%%, "
                + "the letter grade is %s%n", grade5, letterGrade5);
        
        System.out.printf("The overall average mark is %s%%, which is "
                + "a letter grade of %s%n", formatAverageGrade, letterAverageGrade);
        
    }
    /**
     * This method display prompt to enter a grade and return the grade
     * @return grade
     */

    private static int getGrade() {
        System.out.print("\nPlease enter a grade: ");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextInt();
    }
    
    /**
     * 
     * This method compare grade with a letter and return grade in the letter
     * 80 – 100% = A
     * 70 – 79% = B
     * 60 – 69% = C
     * 50 – 59% = D
     * 0 – 49% = F
     * 
     * @param grade - get grade from a user
     * @return letter
     */
    private static String getLetterGrade(double grade) {
        String letterGrade;
        if (grade <=100 && grade >= 80){
            letterGrade = "A";
        }else if (grade <=79 && grade >= 70){
            letterGrade = "B";
        }else if (grade <=69 && grade >= 60){
            letterGrade = "C";
        }else if (grade <= 59 && grade >= 50){
            letterGrade = "D";
        }else if (grade <= 49 && grade >= 0){
            letterGrade = "F";
        }else {
            letterGrade = "Error! Grade can not be more than 100% and less than 0%";
        }
        return letterGrade;
    }
    /**
     * 
     * This method calculate the average grade
     * 
     * @param grade1
     * @param grade2
     * @param grade3
     * @param grade4
     * @param grade5
     * @return average grade
     */

    private static double getAverageGrade(int grade1, int grade2, 
            int grade3, int grade4, int grade5) {
        int quantityOfGrades = 5;
        return (grade1 + grade2 + grade3 + grade4 + grade5)/quantityOfGrades;
    }

}
