package com.unitvectory.ebsautosnapshot;

import java.io.File;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.amazonaws.util.json.JSONObject;
import com.unitvectory.ebsautosnapshot.model.EbsAutoSnapshotConfig;

/**
 * The main application.
 *
 * @author Jared Hatfield
 *
 */
public class App {

	/**
	 * the log
	 */
	private static Logger log = Logger.getLogger(App.class);

	/**
	 * The main application.
	 *
	 * @param args
	 *            the args
	 */
	public static void main(String[] args) {
		// create the parser
		org.apache.commons.cli.CommandLineParser parser = new BasicParser();
		try {
			// The required options
			Options options = new Options();
			@SuppressWarnings("static-access")
			Option configOption = OptionBuilder.withArgName("config").hasArg()
					.withDescription("path to config file").isRequired()
					.create("config");
			options.addOption(configOption);

			// Parse the command line arguments
			CommandLine line = parser.parse(options, args);
			String configPath = line.getOptionValue("config");

			// Load the file
			File configFile = new File(configPath);
			if (!configFile.exists()) {
				throw new Exception("File does not exist.");
			}

			String json = FileUtils.readFileToString(configFile);
			JSONObject jsonObject = new JSONObject(json);
			EbsAutoSnapshotConfig config = new EbsAutoSnapshotConfig(jsonObject);

			// Run the application
			EbsSnapshotManager ebsSnapshotManager = new EbsSnapshotManager(
					config);
			ebsSnapshotManager.run();
		} catch (ParseException exp) {
			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
		} catch (Exception e) {
			log.error("Failed", e);
		}
	}
}
