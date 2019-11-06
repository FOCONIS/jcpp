package org.anarres.cpp;
/**
 * LogLevel for DefaultPreprocessorListener
 *
 * @author Roland Praml, FOCONIS AG
 *
 */
public enum PreprocessorLogLevel {
	/**
	 * Does not log warnings, logs errors as error.
	 */
	OFF,
	/**
	 * Logs warning as warning, logs error as error.
	 */
	WARN,
	/**
	 * Logs warning as warning, fails on error.
	 */
	FAIL;
}
