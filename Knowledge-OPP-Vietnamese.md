# Java OOP - Lập trình Hướng đối tượng trong Java

Lập trình hướng đối tượng (OOP) là một mô hình lập trình dựa trên khái niệm các "đối tượng", có thuộc tính và hành vi riêng, giao tiếp với nhau thông qua các thông điệp. OOP giúp quản lý code dễ dàng, bảo trì và nâng cấp hệ thống.

## Các Tính Chất/Nguyên Lý Chính trong OOP:

1. **Trừu tượng hóa (Abstraction):** 
- Là quá trình tách rời các chi tiết cụ thể đi và chỉ hiển thị thông tin cần thiết liên quan đến người dùng.
- Giúp đơn giản hóa mọi thứ, dễ sử dụng hơn.
- Trong Java được thực hiện qua interface, abstract class.

Code minh hoạ:
```java
public interface Shape {
    void draw();  
}
```
Cài đặt interface Shape trong lớp Circle
``` java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Vẽ hình tròn"); 
    }
}
```
Cài đặt interface Shape trong lớp Rectangle
``` java
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Vẽ hình chữ nhật");
    }
}
```
2. **Đóng gói (Encapsulation):** 
- Gói trạng thái (dữ liệu) và hành vi (phương thức) lại trong cùng một đối tượng.
- Cung cấp các phương thức truy cập getter, setter cho dữ liệu. 
- Che giấu chi tiết triển khai bên trong.
- Giúp bảo mật dữ liệu cũng như giảm sự phụ thuộc trực tiếp giữa các object.

Code minh hoạ:
``` java
public class EncapsulationExample {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int newData) {
            this.data = newData;
    }
}

```

3. **Kế thừa (Inheritance):** 
- Cho phép định nghĩa một lớp dựa trên các thuộc tính có sẵn của lớp cha.
- Giúp tái sử dụng và mở rộng code mà không cần viết lại.
Code minh hoạ:
``` java
public class Animal {
    void eat() {
        System.out.println("Động vật đang ăn");
    }
}

public class Dog extends Animal {
    void bark() {
        System.out.println("Chó sủa");
    }
}
```
4. **Đa hình (Polymorphism):** 
- Cho phép cùng một hành động có thể có nhiều cách thực hiện khác nhau.
- Thể hiện khi ghi đè các phương thức kế thừa từ lớp cha.
- Cung cấp khả năng mở rộng linh hoạt.

## Các Thành Phần Cơ Bản trong OOP trong Java:

1. **Lớp (Class):** Có thể coi là khuôn mẫu (template) để tạo ra các đối tượng.

2. **Đối tượng (Object):** Là thực thể được tạo ra từ lớp. Mỗi đối tượng là một thể hiện của lớp.

3. **Thuộc tính (Attribute):** Biến/trường dữ liệu để lưu trữ trạng thái của đối tượng.

4. **Phương thức (Method):** Xác định hành vi hay hoạt động của đối tượng.

Với các khái niệm nền tảng đó, OOP trong Java giúp lập trình viên có thể mô hình hóa các vấn đề thực tế thành các lớp, đối tượng có tính trừu tượng cao, dễ bảo trì, nâng cấp, mở rộng sau này.


