import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate data1 = LocalDate.parse("2022-07-20");
        LocalDateTime data2 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant data3 = Instant.parse("2022-07-20T01:30:26Z");

        LocalDate pastWeekDate = data1.minusDays(7);
        LocalDate nextWeekDate = data1.plusDays(7);

        LocalDateTime pastWeekLocalDate = data2.minusDays(7);
        LocalDateTime nextWeekLocalDate = data2.plusDays(7);

        Instant pastWeekInstant = data3.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = data3.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekDate = " + pastWeekDate);
        System.out.println("nextWeekDate = " + nextWeekDate);
        System.out.println();

        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
        System.out.println();

        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);

        Duration t1 = Duration.between(pastWeekDate.atStartOfDay(), data1.atStartOfDay());
        Duration t2 = Duration.between(pastWeekLocalDate, data2);
        Duration t3 = Duration.between(pastWeekInstant, data3);
        Duration t4 = Duration.between(data3, pastWeekInstant);
        System.out.println();

        System.out.println("t1 dias = " + t1.toDays());
        System.out.println("t2 dias = " + t2.toDays());
        System.out.println("t3 dias = " + t3.toDays());
        System.out.println("t4 dias = " + t4.toDays());
    }
}