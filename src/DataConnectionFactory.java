/** Основа шаблона проектирования Factory Pattern
 *  Статический метод create() возвращает экземпляр класса FileConnection, однако, при расширении системы в дальнейшем,
 *  возможно будет добавить выбор необходимой реализации (соединение с базой данных и т.д.)
 */
public class DataConnectionFactory {
    public static FileConnection create(String year) {
        return new FileConnection(year);
    }
}