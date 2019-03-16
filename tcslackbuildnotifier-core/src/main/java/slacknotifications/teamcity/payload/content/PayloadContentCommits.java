package slacknotifications.teamcity.payload.content;

import jetbrains.buildServer.serverSide.SRunningBuild;
import jetbrains.buildServer.users.SUser;
import jetbrains.buildServer.vcs.SVcsModification;
import slacknotifications.teamcity.Loggers;
import slacknotifications.teamcity.SlackNotificator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class PayloadContentCommits {
    private List<Commit> commits;

    PayloadContentCommits() {
        commits = new ArrayList<Commit>();
    }

    void populateCommits(SRunningBuild sRunningBuild) {
        List<SVcsModification> changes = sRunningBuild.getContainingChanges();

        for (SVcsModification change : changes) {
            Collection<SUser> committers = change.getCommitters();
            String slackUserId = null;
            if (!committers.isEmpty()) {
                SUser committer = committers.iterator().next();
                slackUserId = committer.getPropertyValue(SlackNotificator.USERID_KEY);
                Loggers.ACTIVITIES.debug("Resolved committer " + change.getUserName() + " to Slack User " + slackUserId);
            }
            commits.add(new Commit(change.getVersion(), change.getDescription(), change.getUserName(), slackUserId));
        }
    }

    List<Commit> getCommits() {
        return commits;
    }

    void setCommits(List<Commit> commits) {
        this.commits = commits;
    }
}
