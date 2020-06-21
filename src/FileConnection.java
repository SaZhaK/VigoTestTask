import java.io.*;

public class FileConnection implements DataConnection {

    private static final String SAVE_FILE_NAME = "statistika.txt";
    private final String inputFileName;
    private int number = 0;

    public FileConnection(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    // getter и setter на случай, если нужно будет врчуную выставить определённый номер
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Мне показалось, что использованная изначально конструкция для получения информации
     * с помощью FileInputStream слишком перегружена и не оптимальна,
     * как с точки зрения расходуемой памяти, так и с точки зрения затрачиваемого времени
     * К тому же, я предположил, что чтение фалйа побайтово в данном случае не критично, и
     * FileInputStream можно заменить на BufferedReader без потери функциональности
     */
    @Override
    public Data loadData(String year) throws Exception {
        File file = new File(inputFileName);

        int sum = 0;
        int linesCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] elements = line.split(" ");

                // Возможно, данные строки также можно упросить,
                // однако, не видя структуры входного файла, сделать это мне не представляется возможным
                if (elements[2].contains(year)) {
                    sum += Integer.parseInt(elements[3]);
                }

                ++linesCount;
            }
        } catch (Exception e) {
            throw e;
        }

        double qq = sum > 0 ? (sum * 1. / linesCount) : 0;

        return new Data(year, sum, (int) qq);
    }

    @Override
    public void saveData(Data data) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(SAVE_FILE_NAME, true))) {
            String res = number + " " + data.getYear() + " " + data.getQq();
            pw.println(res);
            ++number;
        } catch (IOException e) {
            throw e;
        }
    }
}