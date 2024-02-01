import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int userChoice) {
        return userChoice == correctOptionIndex;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int score;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (QuizQuestion question : questions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();
            if (question.isCorrect(userChoice)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }
        System.out.println("\nQuiz completed!");
        System.out.println("Your score: " + score + " out of " + questions.size());
    }
}

class Main {
    public static void main(String[] args) {
        
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?",
                Arrays.asList("London", "Paris", "Rome", "Berlin"), 2));
        questions.add(new QuizQuestion("Which planet is known as the Red Planet?",
                Arrays.asList("Mars", "Jupiter", "Venus", "Saturn"), 1));
        questions.add(new QuizQuestion("Who painted the Mona Lisa?",
                Arrays.asList("Pablo Picasso", "Leonardo da Vinci", "Vincent van Gogh", "Michelangelo"), 2));

        
        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}
