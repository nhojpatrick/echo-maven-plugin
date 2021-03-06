package echo.output;

import org.apache.maven.plugin.logging.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * @author bjorn
 * @since 2013-10-19
 */
public class MavenPluginLogTest {
    private final Log logMock = mock(Log.class);
    private MavenPluginLog mavenLogger;

    @BeforeEach
    public void setUp() {
        mavenLogger = new MavenPluginLog(logMock);
    }

    @Test
    public void infoShouldOutputInfoLevel() {
        mavenLogger.info("Gurka");

        verify(logMock).info("Gurka");
        verifyNoMoreInteractions(logMock);
    }

    @Test
    public void debugExceptionLevelShouldLogToDebugIfEnabled() {
        when(logMock.isDebugEnabled()).thenReturn(true);

        mavenLogger.debug(new OutOfMemoryError("Ta daa!"));

        verify(logMock).isDebugEnabled();
        verify(logMock).debug(any(OutOfMemoryError.class));
        verifyNoMoreInteractions(logMock);
    }

    @Test
    public void debugExceptionLevelShouldNotLogToDebugIfDisabled() {
        mavenLogger.debug(new OutOfMemoryError("Ta daa!"));

        when(logMock.isDebugEnabled()).thenReturn(false);
        verify(logMock).isDebugEnabled();
        verifyNoMoreInteractions(logMock);
    }

    @Test
    public void debugMessageLevelShouldLogToDebugIfEnabled() {
        when(logMock.isDebugEnabled()).thenReturn(true);

        mavenLogger.debug("Ta daa!");

        verify(logMock).isDebugEnabled();
        verify(logMock).debug("Ta daa!");
        verifyNoMoreInteractions(logMock);
    }

    @Test
    public void debugMessageLevelShouldNotLogToDebugIfDisabled() {
        mavenLogger.debug("Ta daa!");

        when(logMock.isDebugEnabled()).thenReturn(false);
        verify(logMock).isDebugEnabled();
        verifyNoMoreInteractions(logMock);
    }
}
