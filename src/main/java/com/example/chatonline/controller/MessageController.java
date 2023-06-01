package com.example.chatonline.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    private final StringBuilder sb = new StringBuilder();

    private boolean isUser = true;

    @PostMapping("/send")
    public String send(@RequestParam("message") String message, Model model, Model model1) {

        if (isUser) {
            sb.append("""
                    <div class="col-md-10 offset-md-0 d-md-flex justify-content-md-end my-2"
                                     style="background: var(--bs-blue);border-radius: 24px;margin-left: 54px;">
                                    <div class="row">
                    """);
            sb.append("""
                    <div class="col"><p class="font-monospace" style="font-style: italic;">
                    """);
            sb.append(message);
            sb.append("""
                    </p></div>
                    """);
            sb.append("""
                    </div>
                    </div>
                    """);
            sb.append("""
                    <div class="col d-md-flex justify-content-md-center align-items-md-center my-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="-32 0 512 512" width="1em" height="1em"
                                         fill="currentColor" style="font-size: 36px;width: 35px;">
                                        <!--! Font Awesome Free 6.1.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free (Icons: CC BY 4.0, Fonts: SIL OFL 1.1, Code: MIT License) Copyright 2022 Fonticons, Inc. -->
                                        <path d="M224 256c70.7 0 128-57.31 128-128s-57.3-128-128-128C153.3 0 96 57.31 96 128S153.3 256 224 256zM274.7 304H173.3C77.61 304 0 381.6 0 477.3c0 19.14 15.52 34.67 34.66 34.67h378.7C432.5 512 448 496.5 448 477.3C448 381.6 370.4 304 274.7 304z"></path>
                                    </svg>
                                </div>
                    """);
        } else {
            sb.append("""
                    <div class="col-md-1 offset-md-0 d-md-flex justify-content-md-center align-items-md-center">
                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="-32 0 512 512" width="1em" height="1em"
                                         fill="currentColor" style="font-size: 39px;width: 35px;">
                                        <!--! Font Awesome Free 6.1.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free (Icons: CC BY 4.0, Fonts: SIL OFL 1.1, Code: MIT License) Copyright 2022 Fonticons, Inc. -->
                                        <path d="M272 304h-96C78.8 304 0 382.8 0 480c0 17.67 14.33 32 32 32h384c17.67 0 32-14.33 32-32C448 382.8 369.2 304 272 304zM48.99 464C56.89 400.9 110.8 352 176 352h96c65.16 0 119.1 48.95 127 112H48.99zM224 256c70.69 0 128-57.31 128-128c0-70.69-57.31-128-128-128S96 57.31 96 128C96 198.7 153.3 256 224 256zM224 48c44.11 0 80 35.89 80 80c0 44.11-35.89 80-80 80S144 172.1 144 128C144 83.89 179.9 48 224 48z"></path>
                                    </svg>
                                </div>
                                <div class="col">
                                    <div class="row d-md-flex"
                                         style="padding-left: 36px;padding-right: 36px;border-radius: 24px;background: var(--bs-blue);margin-right: 54px;">
                                        <div class="col d-md-flex justify-content-md-start align-items-md-center">
                                            <p class="font-monospace"
                                               style="font-style: italic;">""");
            sb.append(message);
            sb.append("""
                    </p>
                                        </div>
                                    </div>
                                </div>
                    """);
        }
        isUser = isUser(!isUser);
        String updateHtml = sb.toString();
        model.addAttribute("updateHtml", updateHtml);
        model1.addAttribute("updateHtml1", "");
        return "index";
    }

    @ModelAttribute("isUser")
    private boolean isUser(boolean bool) {
        return bool;
    }
}
