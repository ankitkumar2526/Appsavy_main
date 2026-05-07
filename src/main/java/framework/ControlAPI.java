package framework;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

public class ControlAPI {

    public static APIResponse post(APIRequestContext request, ControlRequest body) {

        return request.post(
                "http://13.235.20.106/devconfigai/AppsavyAI/UpdateControlsWrapper",
                RequestOptions.create().setData(body)
                .setHeader("Content-Type", "application/json")
        );
    }
}