/**
 * Я посчитал целесообразным разнести логику работы программы и процесс взаимодействия с файлами по разным классам,
 * тем самым ослабив между ними свзяь
 * К тому же, я создал отдельный класс Data, предназначенный для хранения полученной из файла информации и работы с ней
 */
public class MyApp {
    private static final int START_YEAR = 1990;
    private static final int END_YEAR = 2020;

    public static void main(String[] args) {
        System.out.println("app v.1.13");
        try {
            DataConnection fc = DataConnectionFactory.create("1.txt");

            for (int curYear = START_YEAR; curYear < END_YEAR; curYear++) {

                Data data = fc.loadData(String.valueOf(curYear));

                if (data.getQq() > 0) {
                    System.out.println(curYear + " " + data.getQq());
                }

                fc.saveData(data);
            }

            System.out.println("Finished successfully");
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
}