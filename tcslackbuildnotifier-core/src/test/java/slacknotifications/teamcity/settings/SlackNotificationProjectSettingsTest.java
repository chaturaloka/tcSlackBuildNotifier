package slacknotifications.teamcity.settings;


import jetbrains.buildServer.serverSide.settings.ProjectSettingsManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class SlackNotificationProjectSettingsTest {
    private ProjectSettingsManager psm = mock(ProjectSettingsManager.class);


    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestFactory() {
        SlackNotificationProjectSettingsFactory psf = new SlackNotificationProjectSettingsFactory(psm);
        psf.createProjectSettings("project1");
    }

    @Test
    public void TestSettings() {

    }

}
