import model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ParseException {
        List<Student> student = new ArrayList<>();

        // Tạo danh sách sinh viên
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        student.add(new Student(1, "705301001", "Đặng Thị Lan Anh", dateFormat.parse("30/12/2002"), 1, 4.5));
        student.add(new Student(2, "705301002", "Trần Xuân Sơn", dateFormat.parse("23/09/2002"), 0, 3.8));
        student.add(new Student(3, "705301003", "Lê Đức Mạnh", dateFormat.parse("10/06/2002"), 1, 4.6));
        student.add(new Student(4, "705301004", "Bùi Thị Mai Hương", dateFormat.parse("22/08/2002"), 1, 3.5));
        student.add(new Student(5, "705301005", "Đặng Thị Thu Hương", dateFormat.parse("13/01/2002"), 1, 3.2));
        student.add(new Student(6, "705301006", "Nguyễn Khánh Hùng", dateFormat.parse("04/06/2001"), 0, 4.1));
        student.add(new Student(7, "705301007", "Trần Viết Cao Cường", dateFormat.parse("16/02/2001"), 0, 3.1));
        student.add(new Student(8, "705301008", "Đặng Viết Bình", dateFormat.parse("30/12/2001"), 0, 3.2));
        student.add(new Student(9, "705301009", "Hoàng Thị Hà Giang", dateFormat.parse("03/08/2002"), 1, 4.9));
        student.add(new Student(10, "705301010", "An Thị Hồng Ngát", dateFormat.parse("09/01/2002"), 1, 3.0));
        student.add(new Student(11, "705301011", "Nguyễn Thị Phương Chi", dateFormat.parse("30/09/2002"), 1, 2.7));
        student.add(new Student(12, "705301012", "Bùi Quốc Bảo", dateFormat.parse("25/01/2002"), 0, 3.9));


        // In danh sách sinh viên ra màn hình
        student.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Total");
            System.out.println("2. Arrange");
            System.out.println("3. Medium Score");
            System.out.println("4. Add new full name");
            System.out.println("5. Unique name list");
            System.out.println("6. Date of birth");
            System.out.println("7. Exit");
            System.out.print("Chọn chỉ mục để thực hiện: ");
            int choice = scanner.nextInt();


            switch (choice) {
                case 1: // Total
                    System.out.println("Tổng số sinh viên: " + student.size());
                    System.out.println("Tổng số sinh viên nam: " + student.stream()
                            .filter(student1 -> student1.getSex() == 0)
                            .count());
                    System.out.println("Tổng số sinh viên nữ: " + student.stream()
                            .filter(student2 -> student2.getSex() == 1)
                            .count());
                    break;

                case 2: // Arrange

                    List<Student> sortedByName = student.stream()
                            .sorted(Comparator.comparing(Student::getName))
                            .collect(Collectors.toList());
                    System.out.println("Sắp xếp theo tên sinh viên, thứ tự ABC tăng dần:");
                    sortedByName.forEach(System.out::println);


                    List<Student> sortedByAvgPoint = student.stream()
                            .sorted(Comparator.comparing(Student::getAvgPoint).reversed())
                            .collect(Collectors.toList());
                    System.out.println("\nSắp xếp theo điểm tốt nghiệp, từ cao xuống thấp:");
                    sortedByAvgPoint.forEach(System.out::println);


                    List<Student> sortedByDateOfBirth = student.stream()
                            .sorted(Comparator.comparing(Student::getDateOfBirth))
                            .collect(Collectors.toList());
                    System.out.println("\nSắp xếp theo ngày sinh, người nhiều tuổi nhất xếp trên đầu:");
                    sortedByDateOfBirth.forEach(System.out::println);


                    List<Student> sortedBySexAndName = student.stream()
                            .sorted(Comparator.comparing(Student::getSex, Comparator.reverseOrder()) // Nữ (1) lên trước nam (0)
                                    .thenComparing(Student::getName)) // Trong từng nhóm, sắp xếp theo tên thứ tự ABC
                            .collect(Collectors.toList());
                    System.out.println("\nSắp xếp theo giới tính, nữ lên trước, nam ở dưới. Trong từng nhóm lại sắp xếp theo tên thứ tự ABC:");
                    sortedBySexAndName.forEach(System.out::println);


                    break;

                case 3: // Medium Score
                    System.out.printf("Điểm trung bình chung cả lớp: %.2f%n", student.stream()
                            .mapToDouble(Student::getAvgPoint)
                            .average()
                            .orElse(0.0));

                    System.out.printf("Điểm trung bình chung của các bạn nữ: %.2f%n", student.stream()
                            .filter(student1 -> student1.getSex() == 1)
                            .mapToDouble(Student::getAvgPoint)
                            .average()
                            .orElse(0.0));

                    System.out.printf("Điểm trung bình chung của các bạn nam: %.2f%n", student.stream()
                            .filter(student2 -> student2.getSex() == 0)
                            .mapToDouble(Student::getAvgPoint)
                            .average()
                            .orElse(0.0));
                    break;

                case 4: //Add new full name
                    // Sử dụng Stream API để tạo danh sách chỉ chứa họ và tên của các sinh viên
                    List<String> namesList = student.stream()
                            .map(Student::getName)
                            .collect(Collectors.toList());

                    // In danh sách họ và tên ra màn hình
                    System.out.println("Danh sách họ và tên của các sinh viên:");
                    namesList.forEach(System.out::println);
                    break;
                case 5:
                    // Sử dụng Stream API để tạo danh sách chỉ chứa tên của các sinh viên và loại bỏ tên trùng lặp
                    Set<String> uniqueNames = student.stream()
                            .map(student1 -> {
                                // Tách tên cuối cùng (tên không bao gồm họ và tên đệm)
                                String fullName = student1.getName();
                                String[] parts = fullName.split(" ");
                                return parts[parts.length - 1]; // Lấy phần tử cuối cùng (tên)
                            })
                            .map(String::trim) // Loại bỏ khoảng trắng thừa
                            .distinct() // Loại bỏ các tên trùng lặp
                            .collect(Collectors.toSet()); // Thu thập kết quả vào Set để loại bỏ trùng lặp

                    // In danh sách tên ra màn hình
                    System.out.println("Danh sách tên sinh viên (không trùng lặp):");
                    uniqueNames.forEach(name -> System.out.println(name));
                    break;
                case 6:
                    // Sử dụng Stream API để tạo danh sách chỉ chứa ngày sinh (không bao gồm tháng và năm), sắp xếp và in ra màn hình
                    List<Integer> sortedDays = student.stream()
                            .map(student1 -> {
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(student1.getDateOfBirth());
                                return cal.get(Calendar.DAY_OF_MONTH); // Lấy chỉ ngày từ ngày sinh
                            })
                            .sorted() // Sắp xếp ngày từ nhỏ đến lớn
                            .collect(Collectors.toList()); // Thu thập kết quả vào danh sách

                    // In danh sách ngày ra màn hình
                    System.out.println("Danh sách ngày sinh sinh viên (sắp xếp từ nhỏ đến lớn):");
                    sortedDays.forEach(day -> System.out.println(day));
                    break;
                case 7: // Thoát
                    running = false;
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }
        scanner.close();
    }
}