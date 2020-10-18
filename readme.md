###Requirements 


####Chạy project với biến môi trường
GOOGLE_APPLICATION_CREDENTIALS=/home/proxyht/MyDict/google_key.json


####Sử dụng JavaFX riêng biệt 11.0.2

Thêm dòng sau vào VM Options

--module-path /path/to/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml --add-exports javafx.graphics/com.sun.javafx.sg.prism=ALL-UNNAMED

(thay thế đường dẫn phù hợp)

#### Cài đặt mysql version 8.0
File .sql được đính kèm trong bài nộp

#### Cài đặt gói thư viện mysqlconnector

Cài đặt gói thư viện đã có sẵn ở src/mysql-connector-java-8.0.21.jar 
