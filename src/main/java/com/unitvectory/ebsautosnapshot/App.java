package com.unitvectory.ebsautosnapshot;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

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

			// Parse the command line arguments
			CommandLine line = parser.parse(options, args);

			// TODO: Load in the config and execute the logic here
		} catch (ParseException exp) {
			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
		} catch (Exception e) {
			log.error("Failed", e);
		}
	}
}
