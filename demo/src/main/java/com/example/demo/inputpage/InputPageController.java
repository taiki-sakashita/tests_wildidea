package com.example.demo.inputpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class InputPageController {

  @ModelAttribute
  public CheckForm setUpForm() {
    return new CheckForm();
  }

  // /inputにアクセスするとindex（入力画面）に遷移する
  @RequestMapping(value = "/input")
  private String toInputPage() {
    return "index";
  }

  // 確認画面に遷移する
  @RequestMapping(value = "/chkScreen")
  private String result(@Validated CheckForm checkForm, BindingResult bindingResult, Model model) {

    // アノテーションによるチェック処理結果がエラーの場合、入力画面に遷移する
    if (bindingResult.hasErrors()) {
      return "index";
    }

    String number = checkForm.getNumber();
    String name = "テスト名";
    model.addAttribute("number", number);
    model.addAttribute("name", name);
    return "check";
  }
}
