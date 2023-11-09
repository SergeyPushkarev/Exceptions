import Exception.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        boolean flag = true;
        while (flag) {
            try {
                flag = ProgramInputUser.menu();
            } catch (IncorrectDataEntered e) {
                System.out.println("Введены некорректные данные. Разделение на атрибуты пользователя неудачно.");
            } catch (IncorrectNumberOfDataEntered e) {
                System.out.println("Количество атрибутов меньше или больше требуемого. Нужно было ввести данные пользователя по инструкции разделяя пробелом.");
            } catch (IOException e) {
                e.getStackTrace();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}