import java.util.ArrayList;
import java.util.Collections;

public class StringListOperations {
    public static void main(String[] args){
        //Khai báo danh sách gồm các chuỗi kí tự
        ArrayList<String> fruits = new ArrayList<>();
        Collections.addAll(fruits, "orange" ,"banana", "watermelon", "grape", "starfruit", "mango");

        //In ra màn hình danh sách trên
        System.out.println("Danh sách ban đầu: " + fruits);

        //Thêm 1 chuỗi kí tự "lemon" vào danh sách trên, in ra màn hình danh sách
        fruits.add("lemon");
        System.out.println("\nSau khi thêm 'lemon': " + fruits);

        //Thêm 2 chuỗi kí tự "pineapple", "coconut" vào danh sách trên, in ra màn hình danh sách
        Collections.addAll(fruits, "pineapple", "coconut");
        System.out.println("\nSau khi thêm 'pineapple' và 'coconut': " + fruits );

        //Thêm 1 chuỗi kí tự "plum vào vị trí đầu tiên trong danh sách trên, in ra màn hình danh sách
        fruits.add(0, "plum");
        System.out.println("\nSau khi thêm 'plum' vào đầu danh sách: " + fruits);

        //Kiểm tra trong danh sách có chuỗi kí tự sau không
        String[] checkStrings = {"apricot", "star fruit", "banana", "mango"};
        for (String s: checkStrings){
            if(fruits.contains(s)) {
                System.out.println("có " + s);
            }else{
                System.out.println("Không có " + s);
            }
        }

        //Kiểm tra nếu cả "banana" và "mango" đều có trong danh sách
        if(fruits.contains("banana") && fruits.contains("mango")){
            System.out.println("Có 'banana' và 'mango'");
        }else{
            System.out.println("không có 'banana' và 'mango'");
        }

        //In ra màn hình chuỗi ở vị trí thứ 5 trong danh sách
        System.out.println("\nChuỗi ở vị trí thứ 5: " + fruits.get(4));

        //Tìm và in ra vị trí chuỗi "lemon" trong danh sách
        int indexOfLemon = fruits.indexOf("lemon");
        System.out.println("\nVị trí của 'lemon': " + indexOfLemon);

        //Xóa khỏi "grape" khỏi danh sách, in danh sách kết quả
        fruits.remove("grape");
        System.out.println("\nSau khi xóa 'grape: '" + fruits);

        //Thay đổi chuỗi thứ 3 trong danh sách thành "kiwi", in ra kết quả
        fruits.set(2, "kiwi");
        System.out.println("\nSau khi thay đổi chuỗi thứ 3 thành 'kiwi': " + fruits);

        //Sắp xếp danh sách theo thứ tự ABC tăng dần, in ra kết quả
        Collections.sort(fruits);
        System.out.println("\nDanh sách sắp xếp theo thứ tự ABC tăng dần: " + fruits);

        //Sắp xếp danh sách theo thứ tự ABC giảm dần, in ra kết quả
        Collections.sort(fruits, Collections.reverseOrder());
        System.out.println("\nDanh sách sắp xếp theo thứ tự ABC giảm dần: " + fruits);

        //Sắp xếp danh sách theo thứ tự ABC tăng dần, sau đó in ra 3 chuỗi kí tự đầu tiên
        Collections.sort(fruits);
        System.out.println("\n3 chuỗi kí tự đầu tiên khi sắp xếp: " + fruits.subList(0,3));
    }
}
