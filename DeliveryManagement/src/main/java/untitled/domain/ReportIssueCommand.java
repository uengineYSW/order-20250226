package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReportIssueCommand {

    private Long id;
    private String issueReport;
}
