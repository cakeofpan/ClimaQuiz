package Code;
public class Question {

    private String question; //declaring variables
    private String[] options; //all the different answer options
    private int answerIndex; //the index of the correct answer shown in options

    public Question(String question, String[] options, int answerIndex) { //constructor
        this.question = question; //initializing variables
        this.options = options;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() { //getter
        return question;
    }

    public String[] getOptions() { //getter
        return options;
    }

    public int getAnswerIndex() { //getter
        return answerIndex;
    }
}