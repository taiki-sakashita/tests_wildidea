package com.example.demo.inputpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
public class InputPageController {
  // /inputにアクセスするとindex（入力画面）に遷移する
  @RequestMapping(value = "/input")
  private String toInputPage() {
    return "index";
  }

  // 確認画面に遷移する
  @RequestMapping(value = "/chkScreen")
  private String toFormChkPage(@RequestParam("number") String number, Model model) {
    String name = "テスト名";
    model.addAttribute("number", number);
    model.addAttribute("name", name);
    return "check";
  }
}
