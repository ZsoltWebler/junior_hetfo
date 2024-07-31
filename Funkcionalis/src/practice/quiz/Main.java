package practice.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<QuizItem> quizItems = readModel();
        System.out.println(getQuestionsByCategory("tortenelem",quizItems));
        System.out.println();
        System.out.println(getRandomQuizItems(2,quizItems));
        System.out.println();
        System.out.println(quizItemsGroupedByCategory(quizItems));
        System.out.println();
        System.out.println(maxScoreByCategory(quizItems));


    }

    private static String maxScoreByCategory(List<QuizItem> quizItems){
        return quizItems.stream()
                .collect(Collectors.groupingBy(QuizItem::getCategory,Collectors.summingInt(QuizItem::getScore)))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow();
    }


    private static List<String> getQuestionsByCategory(String category, List<QuizItem> quizItems){
        return quizItems.stream()
                .filter(quizItem -> quizItem.getCategory().equals(category))
                .map(QuizItem::getQuestion)
                .toList();
    }

    private static Map<String, List<QuizItem>> quizItemsGroupedByCategory(List<QuizItem> quizItems){
        return quizItems.stream()
                .collect(Collectors.groupingBy(QuizItem::getCategory));
    }


    private static List<QuizItem> getRandomQuizItems(int numberOfQuizItems, List<QuizItem> quizItems){

        if(numberOfQuizItems>=quizItems.size()){
            throw new IllegalArgumentException();
        }

        Set<QuizItem> randomQuiz = new HashSet<>();
        Random random = new Random();


        while(randomQuiz.size()<numberOfQuizItems){
            int randomIndex = random.nextInt(quizItems.size());

            randomQuiz.add(quizItems.get(randomIndex));
        }


        return new ArrayList<>(randomQuiz);

    }

    private static List<QuizItem> readModel() {

        List<QuizItem> quizItems = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Funkcionalis\\src\\practice\\quiz\\kerdesek.txt"));

            while (scanner.hasNextLine()){

                String question = scanner.nextLine();
                String[] values = scanner.nextLine().split(" ");

                quizItems.add(new QuizItem(question,values[0],Integer.parseInt(values[1]),values[2]));

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return quizItems;
    }
}