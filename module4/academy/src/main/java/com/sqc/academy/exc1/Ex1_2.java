package com.sqc.academy.exc1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Ex1_2 {
    //Khởi tạo dữ liệu từ điển với các cặp từ tiếng Anh và bản dịch tiếng Việt
    private final Map<String, String> dictionaryMap = Map.ofEntries(
            Map.entry("hello","xin chào"),
            Map.entry("bye","tạm biệt"),
            Map.entry("apple","quả táo"),
            Map.entry("run","đi"),
            Map.entry("smile","cười"),
            Map.entry("no","không"),
            Map.entry("Yes","cos"),
            Map.entry("happy","Hạnh Phúc"),
            Map.entry("love","Yêu"),
            Map.entry("summer","mùa hè")

    );
    // API GET để tra từ điển
    @GetMapping("/dictionary")
    public ResponseEntity<String> dictionary(@RequestParam(defaultValue ="")String word){
        //Xu lý từ nhập vào: loại bỏ khoảng tragnws dư thừa và chuyển chữ hoa thành chu thuong
        String translation = dictionaryMap.get(word.trim().toLowerCase());

        // Nếu tìm thay bản dich trong từ điển, trả về kết qu với mã trạng thái 200
        if(translation != null){
            return ResponseEntity.ok(translation);
        }
        //Neu khong tim thay, trả về thông báo lô
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy từ này.");
    }
}
