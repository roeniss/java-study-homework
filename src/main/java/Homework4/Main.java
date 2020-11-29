package Homework4;

import org.kohsuke.github.GHIssue;

import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    String token = System.getenv("token");
    GithubClient dashboard = new GithubClient(token);
    List<GHIssue> issues = dashboard.getIssues("whiteship/live-study");
    Map<String, List<GHIssue>> participatePerUser = dashboard.getComments(issues);
    dashboard.showStatistics(participatePerUser);
  }
}
