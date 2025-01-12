package GuiHw;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//CalculatedNoOfDays.java 											Author: Ber�an G�lce Yurtseven ID: 21997330
//																	e-mail: gulceyurtseven@gmail.com
//String al�nan tarihlerin aras�ndaki g�n fark�n� hesaplar
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class CalculatedNoOfDays {
    public int calculate(String day , String day2) throws RuntimeException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
        try {
        	java.util.Date d1 = simpleDateFormat.parse(day);//Date class � haz�r class olarak kulland�m
            java.util.Date d2 = simpleDateFormat.parse(day2);
            long zaman_farki  = d2.getTime() - d1.getTime();
            int day1 = (int) ((zaman_farki / (1000 * 60 * 60 * 24)) % 365);
            return day1;

            } 
        	catch (ParseException ex) {//exception
                throw new RuntimeException(ex);
            }
        }    
    }