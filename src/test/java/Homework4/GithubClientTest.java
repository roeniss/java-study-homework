package Homework4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHFileNotFoundException;
import org.kohsuke.github.GHIssue;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GithubClientTest {
  GithubClient dashboard;

  @BeforeEach
  void setUp() {
    String token = System.getenv("token");
    this.dashboard = new GithubClient(token);
  }

  @Test
  void getIssues() {
    String repoName = "whiteship/live-study";

    List<GHIssue> issues = this.dashboard.getIssues(repoName);

    assertThat(issues.size(), is(18));
    assertThat(issues.get(18 - 4).getTitle(), is("4주차 과제: 제어문"));
  }

  @Test
  void getIssues_failWhenNoExistentRepo() {
    String repoName = "roeniss/no-existent-repo";

    assertThrows(GHFileNotFoundException.class, () -> this.dashboard.getIssues(repoName));
  }

  @Test
  void getCommentData() {
    String repoName = "whiteship/live-study";
    List<GHIssue> issues = this.dashboard.getIssues(repoName);
    Map<String, List<GHIssue>> comments = this.dashboard.getComments(issues);
    for (Map.Entry<String, List<GHIssue>> userWithIssues : comments.entrySet()) {
      List<GHIssue> issueUserCommentedOn = userWithIssues.getValue();
      assertTrue(issues.containsAll(issueUserCommentedOn));
      assertThat(
          issueUserCommentedOn.size(),
          allOf(greaterThanOrEqualTo(0), lessThanOrEqualTo(issues.size())));
    }
  }

  @Test
  void showStatistics() {
    String repoName = "whiteship/live-study";
    List<GHIssue> issues = this.dashboard.getIssues(repoName);
    Map<String, List<GHIssue>> comments = this.dashboard.getComments(issues);
    assertThat(comments.size(), not(0));
    this.dashboard.showStatistics(comments);
  }
}
