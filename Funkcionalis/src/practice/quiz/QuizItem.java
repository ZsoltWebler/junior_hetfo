package practice.quiz;

import java.util.Objects;

public class QuizItem {

    private final String question;
    private final String answer;
    private final int score;
    private final String category;


    public QuizItem(String question, String answer, int score, String category) {
        this.question = question;
        this.answer = answer;
        this.score = score;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getScore() {
        return score;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizItem quizItem = (QuizItem) o;
        return score == quizItem.score && Objects.equals(question, quizItem.question) && Objects.equals(answer, quizItem.answer) && Objects.equals(category, quizItem.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer, score, category);
    }

    @Override
    public String toString() {
        return "QuizItem{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", score=" + score +
                ", category='" + category + '\'' +
                '}';
    }
}
