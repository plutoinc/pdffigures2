package org.allenai.pdffigures2

// Copied org.allenai.common.Logging (https://github.com/allenai/common)

import org.slf4j.LoggerFactory

/** This trait is meant to be mixed into a class to provide logging and logging configuration.
 *
 * The enclosed methods provide a Scala-style logging signature where the
 * message is a block instead of a string.  This way the message string is
 * not constructed unless the message will be logged.
 */
trait Logging {
  val internalLogger = LoggerFactory.getLogger(this.getClass)

  object logger {
    // scalastyle:ignore
    def trace(message: => String): Unit =
      if (internalLogger.isTraceEnabled) {
        internalLogger.trace(message)
      }

    def debug(message: => String): Unit =
      if (internalLogger.isDebugEnabled) {
        internalLogger.debug(message)
      }

    def info(message: => String): Unit =
      if (internalLogger.isInfoEnabled) {
        internalLogger.info(message)
      }

    def warn(message: => String): Unit =
      if (internalLogger.isWarnEnabled) {
        internalLogger.warn(message)
      }

    def warn(message: => String, throwable: Throwable): Unit =
      if (internalLogger.isWarnEnabled) {
        internalLogger.warn(message, throwable)
      }

  }

}