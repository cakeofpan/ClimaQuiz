package Code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalProject { // quiz class
    Scanner scan = new Scanner(System.in);
    private int score;
    private int highScore;
    private ArrayList<Question> questions;
    public static int userTopic;

    public FinalProject(ArrayList<Question> questions) {
        score = 0;
        highScore = 0;
        this.questions = questions;
    }

    String[] options;

    public void introduction() {
        System.out.println("Welcome to the Climate Change Quiz!"); // welcome message
        System.out.print("Enter Your Name: ");
        String userName = scan.nextLine();
        System.out.println("Hello " + userName + ", please select which topic you would like to be quizzed on");
        System.out.println("Enter 1 for Ecosystems");
        System.out.println("Enter 2 for OceanAcidification");
        System.out.println("Enter 3 for GlobalWarming");
        userTopic = scan.nextInt();
        scan.nextLine();  // consume the newline

        if (userTopic == 1) { // Sport Selected is Basketball
            System.out.println("Your Topic Choice: Ecosystems");
            System.out.println("Press 1 for Easy Difficulty");
            System.out.println("Press 2 for Medium Difficulty");
            System.out.println("Press 3 for Hard Difficulty");
            int userDifficulty = scan.nextInt();
            scan.nextLine();  // consume the newline

            if (userDifficulty == 1) {
                System.out.println("Your Choice of Difficulty: Easy");
                System.out.println("The name of your question file is: EcosystemsEasy");
            } else if (userDifficulty == 2) {
                System.out.println("Your Choice of Difficulty: Medium");
                System.out.println("The name of your question file is: EcosystemsMedium");
            } else if (userDifficulty == 3) {
                System.out.println("Your Choice of Difficulty: Hard");
                System.out.println("The name of your question file is: EcosystemsHard");
            } else {
                System.out.println("Invalid Selection! Please Enter 1, 2, or 3.");
                introduction();
            }
        } else if (userTopic == 2) { // Sport Selected is Soccer
            System.out.println("Your Topic Choice: Ocean Acidification");
            System.out.println("Press 1 for Easy Difficulty");
            System.out.println("Press 2 for Medium Difficulty");
            System.out.println("Press 3 for Hard Difficulty");
            int userDifficulty2 = scan.nextInt();
            scan.nextLine();  // consume the newline

            if (userDifficulty2 == 1) {
                System.out.println("Your Choice of Difficulty: Easy");
                System.out.println("The name of your question file is: OceanAcidificationEasy");
            } else if (userDifficulty2 == 2) {
                System.out.println("Your Choice of Difficulty: Medium");
                System.out.println("The name of your question file is: OceanAcidificationMedium");
            } else if (userDifficulty2 == 3) {
                System.out.println("Your Choice of Difficulty: Hard");
                System.out.println("The name of your question file is: OceanAcidificationHard");
            } else {
                System.out.println("Invalid Selection! Please Enter 1, 2, or 3.");
                introduction();
            }
        } else if (userTopic == 3) { // Sport Selected is Football
            System.out.println("Your Topic Choice: Global Warming");
            System.out.println("Press 1 for Easy Difficulty");
            System.out.println("Press 2 for Medium Difficulty");
            System.out.println("Press 3 for Hard Difficulty");
            int userDifficulty3 = scan.nextInt();
            scan.nextLine();  // consume the newline

            if (userDifficulty3 == 1) {
                System.out.println("Your Choice of Difficulty: Easy");
                System.out.println("The name of your question file is: GlobalWarmingEasy");
            } else if (userDifficulty3 == 2) {
                System.out.println("Your Choice of Difficulty: Medium");
                System.out.println("The name of your question file is: GlobalWarmingMedium");
            } else if (userDifficulty3 == 3) {
                System.out.println("Your Choice of Difficulty: Hard");
                System.out.println("The name of your question file is: GlobalWarmingHard");
            } else {
                System.out.println("Invalid Selection! Please Enter 1, 2, or 3.");
                introduction();
            }
        } else {
            System.out.println("Invalid Selection! Please Enter 1, 2, or 3.");
            introduction();
        }
    }

    public void start() {
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            Timer timer = new Timer();
            timer.start();

            System.out.print("Your Choice (1,2,3,4): ");
            int userChoice = scan.nextInt();
            scan.nextLine();  // consume the newline

            if (timer.isTimeDone) {
                System.out.println("Time's up! You didn't answer in time. The correct answer is: " + options[question.getAnswerIndex()]);
            } else {
                if (userChoice >= 1 && userChoice <= 4) {
                    int choiceIndex = userChoice - 1;

                    if (choiceIndex == question.getAnswerIndex()) {
                        System.out.println("Correct!");
                        score++;
                    } else {
                        System.out.println("Incorrect! The correct answer is: " + options[question.getAnswerIndex()]);
                    }
                } else {
                    System.out.println("Invalid choice! The correct answer is: " + options[question.getAnswerIndex()]);
                }
            }
        }
        System.out.println("Quiz Completed! Your score is: " + score + "/" + questions.size());

        if (score > highScore) { // checks for a new high score
            highScore = score;
            System.out.println("Congratulations! New High Score: " + highScore);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an instance of FinalProject to run the introduction
        FinalProject quiz = new FinalProject(new ArrayList<>());
        quiz.introduction();

        // Prompt user to enter the filename of the questions file
        System.out.print("Enter the name of the text file containing the questions: ");
        String filename = scanner.nextLine();
        if (userTopic == 1){
            filename = "FinalProject/src/Ecosystems/" + filename + ".txt";
        }
        else if (userTopic == 2){
            filename = "FinalProject/src/OceanAcidification/" + filename + ".txt";
        }
        else if (userTopic ==3) {
            filename = "FinalProject/src/GlobalWarming/" + filename + ".txt";
        }

        // Load questions from the specified file
        ArrayList<Question> questions = loadQuestionsFromFile(filename);
        if (questions != null && !questions.isEmpty()) {
            quiz = new FinalProject(questions);
            quiz.start();
        } else {
            System.out.println("Failed to load questions from the file.");
        }

        scanner.close();
    }

    private static ArrayList<Question> loadQuestionsFromFile(String filename) {
        ArrayList<Question> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String questionText = parts[0];
                String[] options = parts[1].split(",");
                int answerIndex = Integer.parseInt(parts[2]) - 1; // Adjust for zero-based index
                questions.add(new Question(questionText, options, answerIndex));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading the file. Please make sure the file exists and is in the correct format.");
        }
        return questions;
    }
}