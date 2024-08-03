public class StringOperations {
    public static void main(String[] args) {
        {
            //Khai báo chuỗi text
            String text = "The Spring Framework provides a comprehensive programming and configuration model for modern Java-based enterprise applications - on any kind of deployment platform. A key element of Spring is infrastructural support at the application level: Spring focuses on the \"plumbing\" of enterprise applications so that teams can focus on application-level business logic, without unnecessary ties to specific deployment environments.";

            //In chuỗi text ra màn hình
            System.out.println("Chuỗi text gốc:\n" + text);

            //In ra chuỗi con của text, tính từ vị trí 10 đến 20
            String subString = text.substring(10, 20);
            System.out.println("\nChuỗi con từ vị trí 10 đến 20:\n" + subString);

            //Tìm và in ra vị trí chữ "Spring" đầu tiên trong chuỗi text
            int firstSpring = text.indexOf("Spring");
            System.out.println("\nVị trí chữ 'Spring' đầu tiên: " + firstSpring);

            //Tìm và in ra vị trí chữ "Spring" cuối cùng trong chuỗi text
            int lastSpring = text.lastIndexOf("Spring");
            System.out.println("\nVị trí chữ 'Spring' cuối cùng: " + lastSpring);

            //Kiểm tra và in kết quả xem các chuỗi con có nằm trong chuỗi text không
            String[] subStringToCheck = {"enterprise", "enterprise application", "enterprises"};
            for (String s : subStringToCheck) {
                if (text.contains(s)) {
                    System.out.println("\nChuỗi \"" + s + "\" có nằm trong chuỗi text");
                } else {
                    System.out.println("\nChuỗi \"" + s + "\" không nằm trong chuỗi text");
                }
            }

            //Thay thế chuỗi kí tự "String Framework" trong chuỗi ký tự text bằng "String platform", in ra màn hình kết quả thay thế
            String replacedText = text.replace("Spring Framework", "Spring platform");
            System.out.println("\nChuỗi sau khi thay thế 'Spring Framework' bằng 'Spring platform':\n" + replacedText);

            //Biến tất cả chữ trong chuỗi text thành chữ in hoa
            String upperCaseText = text.toUpperCase();
            System.out.println("\nChuỗi in hoa:\n" + upperCaseText);

            //Biến tất cả chữ trong chuỗi thành chữ in thuờng
            String lowerCasetext = text.toLowerCase();
            System.out.println("\nChuỗi in thuường:\n" + lowerCasetext);

            //Kiểm tra chuỗi text có bắt đầu bởi chuỗi ký tự sau không
            String[] startStringrToCheck = {"the", "The Spring"};
            for (String s : startStringrToCheck) {
                if (text.startsWith(s)) {
                    System.out.println("\nChuỗi text bắt đầu bằng:" + s);
                } else {
                    System.out.println("\nChuỗi text không bắt đầu bằng:" + s);
                }
            }

            //Cắt chuỗi text thành các chuỗi phân cách nhau bởi "Spring"
            String[] splitText = text.split("Spring");
            System.out.println("\nChuỗi sau khi cắt bởi 'Spring':");
            for (String part : splitText) {
                System.out.println(part);
            }
        }
    }
}

