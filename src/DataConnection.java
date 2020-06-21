import java.io.IOException;

/**
 * Интерфейс, определяющий основной функционал для получения и сохранения данных
 * Конкретные реализации этого интерфейса могут получать данные из любых источников,
 * к примеру, файла, базы данных или сетевого соединения
 */
interface DataConnection {

    Data loadData(String year) throws Exception;

    void saveData(Data data) throws IOException;
}