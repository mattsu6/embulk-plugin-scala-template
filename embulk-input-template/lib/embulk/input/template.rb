Embulk::JavaPlugin.register_input(
  "template", "org.embulk.input.template.TemplateInputPlugin",
  File.expand_path('../../../../classpath', __FILE__))
