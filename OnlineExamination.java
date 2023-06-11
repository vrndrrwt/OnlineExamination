
import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

 

class User {

    private String username;

    private String password;

 

    public User(String username, String password) {

        this.username = username;

        this.password = password;

    }

 

    public String getUsername() {

        return username;

    }

 

    public String getPassword() {

        return password;

    }

}

 

class Question {

    private String question;

    private List<String> options;

    private int correctOption;

 

    public Question(String question, List<String> options, int correctOption) {

        this.question = question;

        this.options = options;

        this.correctOption = correctOption;

    }

 

    public String getQuestion() {

        return question;

    }

 

    public List<String> getOptions() {

        return options;

    }

 

    public int getCorrectOption() {

        return correctOption;

    }

}

 

class Exam {

    private List<Question> questions;

    private int score;

 

    public Exam(List<Question> questions) {

        this.questions = questions;

        score = 0;

    }

 

    public void takeExam() {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {

            Question question = questions.get(i);

            System.out.println("Question " + (i + 1) + ": " + question.getQuestion());

            List<String> options = question.getOptions();

            for (int j = 0; j < options.size(); j++) {

                System.out.println((j + 1) + ". " + options.get(j));

            }

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

 

            if (choice == question.getCorrectOption()) {

                score++;

            }

        }

        scanner.close();

    }

 

    public int getScore() {

        return score;

    }

}

 

public class OnlineExamSystem {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("vrndr", "password1"));

        users.add(new User("sngrwt", "password2"));

 

        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is the capital of France?",

                List.of("London", "Paris", "Berlin", "Rome"), 2));

        questions.add(new Question("Who painted the Mona Lisa?",

                List.of("Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo"), 1));

        // Add more questions

 

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");

        String username = scanner.nextLine();

        System.out.print("Enter your password: ");

        String password = scanner.nextLine();

 

        User currentUser = null;

        for (User user : users) {

            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

                currentUser = user;

                break;

            }

        }

 

        if (currentUser == null) {

            System.out.println("Invalid username or password. Exiting...");

        } else {

            Exam exam = new Exam(questions);

            exam.takeExam();

            int score = exam.getScore();

            System.out.println("Your score: " + score + "/" + 2);

        }

    }

}

 

 







