import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Main {
    public static String Genser(String othestvo){
        if (!othestvo.endsWith("ов") && !othestvo.endsWith("ев") && !othestvo.endsWith("вич") && !othestvo.endsWith("лы") && !othestvo.endsWith("ич")) {
            return !othestvo.endsWith("евна") && !othestvo.endsWith("ична") && !othestvo.endsWith("овна") ? "М/Ж" : "Ж";
        }
        return "M";
    }

    public static String date(String burn){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        Date dateOne = null;
        long dateTwo = System.currentTimeMillis();

        try {
            dateOne = format.parse(burn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Количество дней между датами в миллисекундах
        long difference = dateTwo - dateOne.getTime();

        // Перевод количества дней между датами из миллисекунд в дни
        int days =  (int)(difference / (24 * 60 * 60 * 1000))+1; // миллисекунды / (24ч * 60мин * 60сек * 1000мс * 365 дней)
        // Вывод разницы между датами в днях на экран
        int years = (int)(days/365.25);
        String rez=" лет";
        if (years % 100!=11 && years % 10 ==1) rez=" год";
        else if ((years % 10 >1 && years % 10 < 5) && (years<10 || years>20)) rez=" года";
        rez=Integer.toString(years)+rez;
        return rez;
    }
    public static String name_end(String name){
        String[] names= name.split(" ");
        name=names[0]+' '+names[1].charAt(0)+'.'+names[2].charAt(0)+'.';
        return (name + "  " + Genser(names[2]) + "  ");
    }
    public static void main(String[] args) {
        Gui_swing app = new Gui_swing();
        app.setVisible(true);

        /*
        System.out.print("Введите своё имя в формате (Фамилия Имя Отчество): ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.print("Введите дату рождения в формате (дд.мм.гггг): ");
        String burn=in.nextLine();
        System.out.print(name_end(name));
        System.out.println(date(burn));
        in.close();
        */
    }
}