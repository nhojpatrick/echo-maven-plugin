package echo.parameter;

import java.io.File;

public class PluginParametersBuilder {
    private String message;
    private String fromFile;
    private File toFile;
    private boolean appended;
    private boolean force;
    private OutputLevelType level = OutputLevelType.INFO;
    private String encoding;
    private String lineSeparator;
    private boolean characterOutput;

    public PluginParametersBuilder setMessage(String message, String fromFile) {
        this.message = message;
        this.fromFile = fromFile;
        return this;
    }

    public PluginParametersBuilder setFile(File toFile, boolean appended, boolean force) {
        this.toFile = toFile;
        this.appended = appended;
        this.force = force;
        return this;
    }


    public PluginParametersBuilder setLevel(String level) {
        this.level = OutputLevelType.fromString(level);
        return this;
    }

    public PluginParametersBuilder setFormatting(String encoding, String lineSeparator) {
        this.encoding = encoding;
        this.lineSeparator = lineSeparator;
        return this;
    }

    public PluginParameters createPluginParameters() {
        return new PluginParameters(message, fromFile, toFile, appended, force, level, encoding, lineSeparator, characterOutput);
    }


    public PluginParametersBuilder setDebug(boolean characterOutput) {
        this.characterOutput = characterOutput;
        return this;
    }
}
