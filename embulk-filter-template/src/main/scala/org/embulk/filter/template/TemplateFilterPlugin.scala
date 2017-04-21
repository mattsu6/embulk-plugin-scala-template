package org.embulk.filter.template

import com.google.common.base.Optional
import org.embulk.config._
import org.embulk.spi.{FilterPlugin, PageOutput, Schema}

object TemplateFilterPlugin {

  trait PluginTask extends Task {
    // configuration option 1 (required integer)
    @Config("option1") def getOption1: Int

    // configuration option 2 (optional string, null is not allowed)
    @Config("option2")
    @ConfigDefault("\"myvalue\"") def getOption2: String

    // configuration option 3 (optional string, null is allowed)
    @Config("option3")
    @ConfigDefault("null") def getOption3: Optional[String]
  }

}

class TemplateFilterPlugin extends FilterPlugin {
  def transaction(config: ConfigSource, inputSchema: Schema, control: FilterPlugin.Control) {
    val task = config.loadConfig(classOf[TemplateFilterPlugin.PluginTask])
    val outputSchema = inputSchema
    control.run(task.dump, outputSchema)
  }

  def open(taskSource: TaskSource, inputSchema: Schema, outputSchema: Schema, output: PageOutput): PageOutput = {
    val task = taskSource.loadTask(classOf[TemplateFilterPlugin.PluginTask])
    // Write your code here :)
    throw new UnsupportedOperationException("TemplateFilterPlugin.open method is not implemented yet!!!!")
  }
}