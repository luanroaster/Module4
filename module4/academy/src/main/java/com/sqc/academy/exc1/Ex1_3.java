package com.sqc.academy.exc1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex1_3 {
    @GetMapping("/calculator")
    public ResponseEntity<String> caculator(
            @RequestParam(value = "firstN", defaultValue = "") String firstNumber,
            @RequestParam(value = "secondN", defaultValue = "") String secondNumber,
            @RequestParam(value = "operaorr", defaultValue = "") String operator) {

        if (firstNumber.isEmpty()) {
            return ResponseEntity.badRequest().body("So dau tien khong de trong");
        } else if (secondNumber.isEmpty()) {
            return ResponseEntity.badRequest().body("So thu 2 khong de trong");
        } else if (!isDouble(firstNumber)) {
            return ResponseEntity.badRequest().body("So dau tien phai la so");
        } else if (!isDouble(secondNumber)) {
            return ResponseEntity.badRequest().body("So thu 2 phai la so");
        }

        double firstN = Double.parseDouble(firstNumber);
        double secondN = Double.parseDouble(secondNumber);
        double result;

        switch (operator) {
            case "+":
                result = firstN + secondN;
                break;
            case "-":
                result = firstN - secondN;
                break;
            case "*":
                result = firstN * secondN;
                break;
            case  "/":
                if (secondN== 0) {
                    return ResponseEntity.badRequest().body("Khong duoc chia cho so 0");
                }
                result = firstN / secondN;
                break;
            default:
                return ResponseEntity.badRequest().body("khong hop le");
        }
        return ResponseEntity.ok("Result: " + result);
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
