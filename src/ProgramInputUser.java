import Exception.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.*;

public class ProgramInputUser {

    /**
     * menu() - вызов программы, а точнее его меню. Меню может вызываться в цикле. Условие завершения - возврат false
     * @return возвращает ложь, если пользователь вышел из программы, иначе истину
     * @throws IncorrectNumberOfDataEntered введено больше или меньше атрибутов пользователя
     * @throws IncorrectDataEntered в вводе атрибутов пользователя обнаружена ошибка
     * @throws IOException ошибка при открытии/закрытии файла с пользователями
     */
    public static Boolean menu() throws IncorrectNumberOfDataEntered, IncorrectDataEntered, IOException {
        Scanner cs = new Scanner(System.in);
        View.welcomeText();

        int num = cs.nextInt();

        switch (num) {
            case 1 -> {
                inputUser();
            }
            case 2 -> {
                return false;
            }
            default -> View.noThatNumber();
        }
        return true;
    }
    private static void inputUser() throws IncorrectNumberOfDataEntered, IncorrectDataEntered, IOException {
        final String dir = System.getProperty("user.dir") + "\\src\\";
        Scanner cs = new Scanner(System.in);

        View.inputUserText();
        String inputData = cs.nextLine();
        List<String> listData = new ArrayList<String>(Arrays.asList(inputData.split(" ")));

        if (listData.size() != 6) {
            throw new IncorrectNumberOfDataEntered("Введено меньше или больше данных чем требуется.", inputData);
        }

        String[] arrData = new String[6];
        for (String data : listData) {
            if(data.contains(".")) {
                defineFillData(arrData, data, inputData, 3);
            } else if (data.length() == 1) {
                defineFillData(arrData, data, inputData, 5);
            } else {
                boolean isOnlyDigits = true;
                for(int i = 0; i < data.length() && isOnlyDigits; i++) {
                    if(!Character.isDigit(data.charAt(i))) {
                        isOnlyDigits = false;
                    }
                }

                if (isOnlyDigits) {
                    defineFillData(arrData, data, inputData, 4);
                } else {
                    boolean flagException = true;
                    for (int i=0; i<3; i++) {
                        if(arrData[i] == null) {
                            arrData[i] = data;
                            i = 3;
                            flagException = false;
                        }
                    }
                    if (flagException) {
                        throw new IncorrectDataEntered("Ошибка ввода данных", inputData, data);
                    }
                }
            }
        }

        String fileName = arrData[0] + ".txt";

        System.out.println(dir + fileName);
        try(FileWriter writer = new FileWriter(dir + fileName, true))
        {
            writer.write("<" + arrData[0] + ">" +
                    "<" + arrData[1] + ">" +
                    "<" + arrData[2] + ">" +
                    "<" + arrData[3] + ">" +
                    "<" + arrData[4] + ">" +
                    "<" + arrData[5] + "> \n");
            //writer.flush();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    private static void defineFillData(String[] arrData, String data, String inputData, int index) throws IncorrectDataEntered {
        if(arrData[index] == null) {
            arrData[index] = data;
        } else {
            throw new IncorrectDataEntered("Ошибка ввода данных", inputData, data);
        }
    }
}