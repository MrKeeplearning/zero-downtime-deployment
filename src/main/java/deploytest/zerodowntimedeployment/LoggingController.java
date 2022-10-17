package deploytest.zerodowntimedeployment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    // 프로젝트의 버전은 application.yml 에서 관리하며 @Value 어노테이션으로 가져옴.
    @Value("${logging-module.version}")
    private String version;

    // 루트로 접속하면 현재 프로젝트의 버전을 String 으로 보여주는 API
    @GetMapping("/")
    public String version() {
        return String.format("Project Version : %s", version);
    }

    // health-check 용으로 사용되는 API
    @GetMapping("/health")
    public String checkHealth() {
        return "healthy";
    }

}
