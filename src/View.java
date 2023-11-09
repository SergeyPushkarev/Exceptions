public class View {

    public static void welcomeText() {
        System.out.println("Меню программы. Выберите действие: \n" +
                "1. Добавить пользователя \n" +
                "2. Выход \n");
    }
    public static void inputUserText() {
        System.out.println("Введите следующие данные в произвольном порядке согласно шаблону через пробел: \n" +
                "1. Фамилия. Только буквы.\n" +
                "2. Имя. Только буквы.\n" +
                "3. Отчество. Только буквы.\n" +
                "4. Дата рождения. строка формата {dd.mm.yyyy}.\n" +
                "5. Номер телефона. Только цифры.\n" +
                "6. Пол. Одна буква f (female) или m (male).\n"
        );
    }


    public static void noThatNumber() {
        System.out.println("Такого числа нет в списке, выберите число из предложенного в меню");
    }
}
