import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DatetimeOperations {
    public static void main(String[] args){
        //In ra ngày giờ hiện tại
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Ngày giờ hiện tại: " + now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        //In ra ngày giờ sau ngày giờ hiện tại 2 tháng
        LocalDateTime twoMonthsLater = now.plusMonths(2);
        System.out.println("\nNgày giờ sau 2 tháng: " + twoMonthsLater.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        //In ra ngày giờ trước ngày giờ hiện tại 1 tháng
        LocalDateTime oneMonthEarlier = now.minusMonths(1);
        System.out.println("\nNgày giờ trước 1 tháng: " + oneMonthEarlier.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        // Tính và in ra thời gian cuối cùng trong ngày hiện tại
        LocalDateTime endOfDay = now.with(LocalTime.MAX);
        System.out.println("\nThời gian cuối cùng trong ngày hiện tại: " + endOfDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        //Tính và in ra thời gian đầu tiên trong ngày hiện tại
        LocalDateTime startOfDay = now.with(LocalTime.MIN);
        System.out.println("\nThời gian đầu tiên trong ngày hiện tại: " + startOfDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
}
