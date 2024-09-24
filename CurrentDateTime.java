import java.time.LocalDate;
import java.time.LocalDateTime;

class CurrentDateTime {
	public static void currentDateTime() {
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);

		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println(currentTime);
	}

	public static void main(String[] args) {
		CurrentDateTime.currentDateTime();
	}
}
