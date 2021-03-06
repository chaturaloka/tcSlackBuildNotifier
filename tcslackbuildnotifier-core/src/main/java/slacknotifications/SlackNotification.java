package slacknotifications;

import org.apache.http.NameValuePair;
import org.apache.http.auth.Credentials;
import slacknotifications.teamcity.BuildState;
import slacknotifications.teamcity.payload.content.PostMessageResponse;
import slacknotifications.teamcity.payload.content.SlackNotificationPayloadContent;

import java.io.IOException;
import java.util.List;

public interface SlackNotification {

    void setProxy(SlackNotificationProxyConfig proxyConfig);

    void setProxy(String proxyHost, Integer proxyPort, Credentials credentials);

    void post() throws IOException;

    Integer getStatus();

    String getProxyHost();

    int getProxyPort();

    String getChannel();

    void setChannel(String channel);

    String getTeamName();

    void setTeamName(String teamName);

    String getToken();

    void setToken(String token);

    String getBotName();

    void setBotName(String botName);

    String getIconUrl();

    void setIconUrl(String iconUrl);

    String getParameterisedUrl();

    String parametersAsQueryString();

    void addParam(String key, String value);

    void addParams(List<NameValuePair> paramsList);

    String getParam(String key);

    String getFilename();

    void setFilename(String filename);

    String getContent();

    Boolean isEnabled();

    void setEnabled(Boolean enabled);

    void setEnabled(String enabled);

    Boolean isErrored();

    void setErrored(Boolean errored);

    String getErrorReason();

    void setErrorReason(String errorReason);

    BuildState getBuildStates();

    void setBuildStates(BuildState states);

    String getProxyUsername();

    void setProxyUsername(String proxyUsername);

    String getProxyPassword();

    void setProxyPassword(String proxyPassword);

    SlackNotificationPayloadContent getPayload();

    void setPayload(SlackNotificationPayloadContent payloadContent);

    PostMessageResponse getResponse();

    void setShowBuildAgent(Boolean showBuildAgent);

    void setShowElapsedBuildTime(Boolean showElapsedBuildTime);

    void setShowCommits(boolean showCommits);

    void setShowCommitters(boolean showCommitters);

    void setShowTriggeredBy(boolean showTriggeredBy);

    void setMaxCommitsToDisplay(int maxCommitsToDisplay);

    void setMentionChannelEnabled(boolean mentionChannelEnabled);

    void setMentionSlackUserEnabled(boolean mentionSlackUserEnabled);

    void setMentionHereEnabled(boolean mentionHereEnabled);

    void setShowFailureReason(boolean showFailureReason);

    void setShowFunnyQuote(boolean showFunnyQuote);

    String getFunnyQuoteIconUrl();

    void setFunnyQuoteIconUrl(String iconUrl);

    void setMentionWhoTriggeredEnabled(boolean mentionWhoTriggeredEnabled);
}