Embulk::JavaPlugin.register_filter(
  "template", "org.embulk.filter.template.TemplateFilterPlugin",
  File.expand_path('../../../../classpath', __FILE__))
