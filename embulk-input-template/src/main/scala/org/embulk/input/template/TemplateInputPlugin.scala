package org.embulk.input.template

import com.google.common.base.Optional
import org.embulk.config._
import org.embulk.spi._
object TemplateInputPlugin {

  trait PluginTask extends Task {
    // configuration option 1 (required integer)
    @Config("option1") def getOption1: Int

    // configuration option 2 (optional string, null is not allowed)
    @Config("option2")
    @ConfigDefault("\"myvalue\"") def getOption2: String

    // configuration option 3 (optional string, null is allowed)
    @Config("option3")
    @ConfigDefault("null") def getOption3: Optional[String]

    // if you get schema from config
    @Config("columns") def getColumns: SchemaConfig
  }

}

class TemplateInputPlugin extends InputPlugin {

  override def transaction(config: ConfigSource, control: InputPlugin.Control): ConfigDiff = {
    val task = config.loadConfig(classOf[TemplateInputPlugin.PluginTask])
    val schema = task.getColumns.toSchema
    val taskCount = 1 // number of run() method calls
    resume(task.dump, schema, taskCount, control)
  }

  override def resume(taskSource: TaskSource, schema: Schema, taskCount: Int, control: InputPlugin.Control): ConfigDiff = {
    control.run(taskSource, schema, taskCount)
    Exec.newConfigDiff
  }

  override def cleanup(taskSource: TaskSource, schema: Schema, taskCount: Int, successTaskReports: java.util.List[TaskReport]) = {

  }

  override def run(taskSource: TaskSource, schema: Schema, taskIndex: Int, output: PageOutput): TaskReport = {
    val task = taskSource.loadTask(classOf[TemplateInputPlugin.PluginTask])
    // Write your code here :)
    throw new UnsupportedOperationException("TemplateInputPlugin.run method is not implemented yet!!!!")
  }

  override def guess(config: ConfigSource): ConfigDiff = {
    Exec.newConfigDiff
  }
}