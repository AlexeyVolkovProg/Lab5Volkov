# Lab5Volkov
Реализовать консольное приложение, которое реализует управление коллекцией объектов в интерактивном режиме. В коллекции необходимо хранить объекты класса Product, описание которого приведено ниже.

Разработанная программа должна удовлетворять следующим требованиям:

Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.
Все требования к полям класса (указанные в виде комментариев) должны быть выполнены.
Для хранения необходимо использовать коллекцию типа java.util.Vector
При запуске приложения коллекция должна автоматически заполняться значениями из файла.
Имя файла должно передаваться программе с помощью: аргумент командной строки.
Данные должны храниться в файле в формате csv
Чтение данных из файла необходимо реализовать с помощью класса java.io.FileReader
Запись данных в файл необходимо реализовать с помощью класса java.io.BufferedWriter
Все классы в программе должны быть задокументированы в формате javadoc.
Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).
В интерактивном режиме программа должна поддерживать выполнение следующих команд:

help : вывести справку по доступным командам
info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)
show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении || реализована для консоли и скрипта
add {element} : добавить новый элемент в коллекцию || реализована для консоли и скрипта 
update id {element} : обновить значение элемента коллекции, id которого равен заданному || реализовано для консоли и скрипта
remove_by_id id : удалить элемент из коллекции по его id
clear : очистить коллекцию
save : сохранить коллекцию в файл
execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме || реализована , но рекурсия не предусмотрена
exit : завершить программу (без сохранения в файл)
remove_first : удалить первый элемент из коллекции
add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
shuffle : перемешать элементы коллекции в случайном порядке
group_counting_by_id : сгруппировать элементы коллекции по значению поля id, вывести количество элементов в каждой группе
count_greater_than_unit_of_measure unitOfMeasure : вывести количество элементов, значение поля unitOfMeasure которых больше заданного
print_descending : вывести элементы коллекции в порядке убывания
Формат ввода команд:

Все аргументы команды, являющиеся стандартными типами данных (примитивные типы, классы-оболочки, String, классы для хранения дат), должны вводиться в той же строке, что и имя команды.
Все составные типы данных (объекты классов, хранящиеся в коллекции) должны вводиться по одному полю в строку.
При вводе составных типов данных пользователю должно показываться приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")
Если поле является enum'ом, то вводится имя одной из его констант (при этом список констант должен быть предварительно выведен).
При некорректном пользовательском вводе (введена строка, не являющаяся именем константы в enum'е; введена строка вместо числа; введённое число не входит в указанные границы и т.п.) должно быть показано сообщение об ошибке и предложено повторить ввод поля.
Для ввода значений null использовать пустую строку.
Поля с комментарием "Значение этого поля должно генерироваться автоматически" не должны вводиться пользователем вручную при добавлении.
Описание хранимых в коллекции классов:

public class Product {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long price; //Значение поля должно быть больше 0
    private Long manufactureCost; //Поле может быть null
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Person owner; //Поле может быть null
}
public class Coordinates {
    private Long x; //Максимальное значение поля: 116, Поле не может быть null
    private int y; //Максимальное значение поля: 502
}
public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле не может быть null
    private String passportID; //Длина строки должна быть не меньше 8, Длина строки не должна быть больше 28, Значение этого поля должно быть уникальным, Поле не может быть null
}
public enum UnitOfMeasure {
    METERS,
    CENTIMETERS,
    SQUARE_METERS,
    PCS;
}
Отчёт по работе должен содержать:

Текст задания.
Диаграмма классов разработанной программы.
Исходный код программы.
Выводы по работе.
Вопросы к защите лабораторной работы:

Коллекции. Сортировка элементов коллекции. Интерфейсы java.util.Comparable и java.util.Comparator.
Категории коллекций - списки, множества. Интерфейс java.util.Map и его реализации.
Параметризованные типы. Создание параметризуемых классов. Wildcard-параметры.
Классы-оболочки. Назначение, область применения, преимущества и недостатки. Автоупаковка и автораспаковка.
Потоки ввода-вывода в Java. Байтовые и символьные потоки. "Цепочки" потоков (Stream Chains).
Работа с файлами в Java. Класс java.io.File.
Пакет java.nio - назначение, основные классы и интерфейсы.
Утилита javadoc. Особенности автоматического документирования кода в Java.
